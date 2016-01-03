import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;

import downward.Down;
import gui.editor.Gui;
import world.Plan;
import world.World;
import world.commands.Command;



public class driver {
	
	static World world;
	
	static LinkedList<Command> commands =new LinkedList<>();
	public static void main(String[] args) throws Exception {
		loadWorld();
		findPlan();
		gameloop();

	}

	private static void loadWorld() {
		
		world = new World(Paths.get("levels/prob13.xml"));
		
		new Gui(world, true,false);
		

		
		
	}
	
	private static void findPlan(){
//		commands.add(new Move(Direction.right));
//		commands.add(new Move(Direction.right));
//		commands.add(new Move(Direction.right));
//		commands.add(new NoOp());
		
		try {
			Plan plan=Down.run(Paths.get("pddl/domain.pddl"), Paths.get("pddl/prob13.pddl"));
			commands=new LinkedList<>(plan.getCommands());
			if(commands.isEmpty()){
				System.out.println("no plan");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void gameloop() throws Exception {
		while(world.getPlayer()!=null && !world.isGoal()){
			playerinput();
			world.update();

		}
		System.out.println("Done");
	}



	private static void playerinput() throws Exception {
//		System.out.println("input command:");
//		try {
//			System.out.println("command "+System.in.read());
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		try {
		    Thread.sleep(1000);                 //2000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		if(!commands.isEmpty()){
			if(!commands.poll().Do(world)){
				throw new Exception("illigal action");
			}
		}
	}

}
