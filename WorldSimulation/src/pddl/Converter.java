package pddl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import world.World;
import world.objects.Boot;
import world.objects.Button;
import world.objects.Gate;
import world.objects.Goal;
import world.objects.Ground;
import world.objects.Ladder;
import world.objects.PhysObject;
import world.objects.Player;
import world.objects.Remote;
import world.objects.Robot;
import world.objects.Stone;



public class Converter {

	@Deprecated
	public static ArrayList<String> toPDDL(World world, String name) {
		return toPDDL(world, name, PDDL.ManualGate);
	}
	@Deprecated
	public static ArrayList<String> toPDDL(World world, String name, PDDL gate) {
		if(world.getPlayer()==null || world.getGoal()==null){
			System.err.println(name);
			System.err.println("ERROR: player "+world.getPlayer()+" : goal "+world.getGoal());
			System.exit(-1);
		}

		ArrayList<String> lines= new ArrayList<>();
		StringBuilder builder= new StringBuilder();
		Character[][] worldArray=world.toArray();
		for (int j = 0; j < world.height; j++) {
			builder.append(";");
			for (int i = 0; i < world.width;i++) {
				builder.append(worldArray[i][j]);
			}
			lines.add(builder.toString());
			builder.setLength(0);
		}
		lines.add("\n");
		lines.add("(define (problem "+name+"-Astro)");
		lines.add(" (:domain Astro)");

		lines.addAll(objs(world));


		lines.addAll(init(world,gate));

		lines.addAll(goals(world));

		lines.add(" (:metric minimize (total-cost))");
		lines.add(")");
		return lines;
	}
	public enum PDDL { AxiomGate, ManualGate}
	
	@Deprecated
	public static void toPDDL(World world, Path path) throws IOException {
		toPDDL(world, path, PDDL.ManualGate);
	}
	@Deprecated
	public static void toPDDL(World world, Path path, PDDL gate) throws IOException {
		String name = path.getFileName().toString();
		name = name.substring(0, name.length() - 5);

		Files.write(path, Converter.toPDDL(world, name, gate));
	}
	
	private static ArrayList<String> objs(World world){
		ArrayList<String> lines= new ArrayList<>();
		lines.add(" (:objects");

		//objects

		lines.add("  player-01 - player");


		for (int j = 0; j < world.height; j++) {
			for (int i = 0; i < world.width; i++) {
				lines.add("  pos-"+(i<10?"0":"")+i+"-"+(j<10?"0":"")+j+" - location");

			}
		}

		int tmp =0;
		for (Stone s : world.getStones()) {
			lines.add("  stone"+tmp+" - stone");
			s.name="stone"+tmp;
			tmp++;
			
					
		}

		tmp =0;
		for (Robot s : world.getRobots()) {
			lines.add("  robot"+tmp+" - robot");
			s.name="robot"+tmp;
			tmp++;
		}
		
		tmp =0;
		for ( PhysObject s : world.getPickUps()) {
			if(s instanceof Remote){
				lines.add("  remote"+tmp+" - remote");
				s.name="remote"+tmp;
				tmp++;
			}
		}

		lines.add(" )");
		return lines;
	}

	private static ArrayList<String> init(World world, PDDL gate){
		ArrayList<String> lines= new ArrayList<>();
		lines.add(" (:init");
		int tmp=0;
		lines.add("  (= (total-cost) 0)");
		Player player= world.getPlayer();
		lines.add("  (at player-01 "+"pos-"+(player.getX()<10?"0":"")+player.getX()+"-"+(player.getY()<10?"0":"")+player.getY()+")");

		//ladders
		for (Ladder ladder : world.getLadders()) {
			lines.add("  (ladder pos-"+(ladder.getX()<10?"0":"")+ladder.getX()+"-"+(ladder.getY()<10?"0":"")+ladder.getY()+")");
		}

		//stones
		tmp=0;
		for ( Stone s : world.getStones()) {
			lines.add("  (at stone"+tmp+" pos-"+(s.getX()<10?"0":"")+s.getX()+"-"+(s.getY()<10?"0":"")+s.getY()+")");
			tmp++;
		}
		//robots
		tmp=0;
		for (Robot r : world.getRobots()) {
			lines.add("  (at robot"+tmp+" pos-"+(r.getX()<10?"0":"")+r.getX()+"-"+(r.getY()<10?"0":"")+r.getY()+")");
			lines.add("  (facing robot"+tmp+" "+r.getFacing()+")");
			tmp++;
		}


		//ground
		for (Ground ground : world.getGround()) {
			lines.add("  (ground "+ground.getColor()+" pos-"+(ground.getX()<10?"0":"")+ground.getX()+"-"+(ground.getY()<10?"0":"")+ground.getY()+")");

		}

		//teleports
		for (PhysObject point : world.getTeleports()) {
			lines.add("  (teleport pos-"+(point.getX()<10?"0":"")+point.getX()+"-"+(point.getY()<10?"0":"")+point.getY()+")");
		}

		//gates
		for (Button point : world.getButtons()) {
			lines.add("  (button "+point.getColor()+" pos-"+(point.getX()<10?"0":"")+point.getX()+"-"+(point.getY()<10?"0":"")+point.getY()+")");
//			lines.add("  (clear pos-"+(point.getX()<10?"0":"")+point.getX()+"-"+(point.getY()<10?"0":"")+point.getY()+")");
		}

		//buttons
		for (Gate point : world.getGates()) {
			lines.add("  (gate "+point.getColor()+" pos-"+(point.getX()<10?"0":"")+point.getX()+"-"+(point.getY()<10?"0":"")+point.getY()+")");
			if(gate == PDDL.ManualGate){
				lines.add("  (closed pos-"+(point.getX()<10?"0":"")+point.getX()+"-"+(point.getY()<10?"0":"")+point.getY()+")");	
			}
			lines.add("  (clear pos-"+(point.getX()<10?"0":"")+point.getX()+"-"+(point.getY()<10?"0":"")+point.getY()+")");
		}
		//pickups
		tmp=0;
		for (PhysObject point : world.getPickUps()) {
			if(point instanceof Remote){
				lines.add("  (controller remote"+tmp+" pos-"+(point.getX()<10?"0":"")+point.getX()+"-"+(point.getY()<10?"0":"")+point.getY()+")");
				tmp++;
			}else if(point instanceof Boot){
				lines.add("  (boot "+((Boot)point).getColor()+" pos-"+(point.getX()<10?"0":"")+point.getX()+"-"+(point.getY()<10?"0":"")+point.getY()+")");
			}
			
		}

		//relative positions
		for (int x = 0; x <world.width; x++) {
			for (int y = 0; y < world.height; y++) {

				if(world.isClear(x,y)){
					lines.add("  (clear pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y+")");
				}
				if(x!=0){
					lines.add("  (relativ-dir pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y+" pos-"+(x-1<10?"0":"")+(x-1)+"-"+(y<10?"0":"")+y+" left)");
				}
				if(x!=world.width-1){
					lines.add("  (relativ-dir pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y+" pos-"+(x+1<10?"0":"")+(x+1)+"-"+(y<10?"0":"")+y+" right)");
				}

				if(y!=0){
					lines.add("  (relativ-dir pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y+" pos-"+(x<10?"0":"")+x+"-"+(y-1<10?"0":"")+(y-1)+" up)");
				}
				if(y!=world.height-1){
					lines.add("  (relativ-dir pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y+" pos-"+(x<10?"0":"")+x+"-"+(y+1<10?"0":"")+(y+1)+" down)");
				}else{
					lines.add("  (boarder pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y+")");
				}
			}
		}


		lines.add(" )");
		return lines;
	}

	private static ArrayList<String> goals(World world){
		ArrayList<String> lines= new ArrayList<>();
		lines.add(" (:goal (and");
		Goal goal=world.getGoal();
		lines.add("   (at player-01 "+"pos-"+(goal.getX()<10?"0":"")+goal.getX()+"-"+(goal.getY()<10?"0":"")+goal.getY()+")");
		lines.add("  )");
		lines.add(" )");
		return lines;
	}
}
