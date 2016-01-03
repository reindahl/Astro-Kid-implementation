package world;

import java.util.ArrayList;

import world.commands.Activate;
import world.commands.Climb;
import world.commands.Command;
import world.commands.NoOp;
import world.commands.Push;
import world.commands.Walk;
import world.objects.PhysObject.Direction;

public class Plan {

	ArrayList<String> actions = new ArrayList<>();
	ArrayList<Command> commands = new ArrayList<>();
	String time;
	
	double totalTime;

	public Plan(ArrayList<String> lines) {
		setPlan(lines);
	}
	
	public Plan(ArrayList<String> lines, double totalTime) {
		setPlan(lines);
		this.totalTime=totalTime;

	}
	


	public Plan(double totalTime) {
		this.totalTime=totalTime;
	}

	public void setPlan(ArrayList<String> lines){
		for (String string : lines) {
			if(string.endsWith("(1)")){
				actions.add(string);
				
			}else if(string.startsWith("Total time")){
				time=string;
			}
		}
		for (int i = 0; i < actions.size(); i++) {
			String[] split= actions.get(i).split(" ");
			String[] param= new String[split.length-2];
			for (int j = 0; j < param.length; j++) {
				param[j]=split[j+1];
			}
			if(actions.get(i).startsWith("walk")){

				Direction dir = dir(split[split.length-2]);
				actions.set(i, "walk "+dir);
//				System.out.println("plan: "+Arrays.toString(param));
				commands.add(new Walk(dir, param));
			}else if(actions.get(i).startsWith("noop")){
				actions.set(i, "noOp");
				commands.add(new NoOp());
			}else if(actions.get(i).startsWith("push")){

				Direction dir = dir(split[split.length-2]);
				actions.set(i, "push "+dir);
				commands.add(new Push(dir));
				
				//FIXME: tmp fix
				commands.add(new NoOp());
			}else if(actions.get(i).startsWith("climbdown")){;
				commands.add(new Climb(Direction.down,param));
			}else if(actions.get(i).startsWith("climbup")){

				commands.add(new Climb(Direction.up, param));
			}else if(actions.get(i).startsWith("activaterobot")){
				int x, y;
				String pos=split[1];
				String[] p=pos.split("-");
				x=Integer.parseInt(p[1]);
				y=Integer.parseInt(p[2]);
				actions.set(i, "activateRobot "+x+","+y);
				commands.add(new Activate(x,y,param));
			}else if(actions.get(i).startsWith("slide") || actions.get(i).startsWith("fall")){
				actions.set(i, "noOp");
				commands.add(new NoOp());
			}else{
				System.out.println(actions.get(i));
			}
		}
	}

	public Direction dir(String dir){
		switch (dir) {
		case "left":
			return Direction.left;
		case "right":
			return Direction.right;
		case "up":
			return Direction.up;
		case "down":
			return Direction.down;
		default:
			return null;
		}
	}
	
	public ArrayList<String> getActions(){
		return actions;
	}
	public ArrayList<Command> getCommands(){
		return commands;
	}
	public String getTime(){
		return time;
	}
	public double getTotalTime(){
		return totalTime;
	}
	public String toString(){
		return commands.toString();
	}
}
