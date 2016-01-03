package pddl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import pddl.Converter.PDDL;
import pddl.Litereal.litType;
import pddl.Predicate.Ptype;
import world.World;
import world.objects.Boot;
import world.objects.Button;
import world.objects.Gate;
import world.objects.Ground;
import world.objects.Ladder;
import world.objects.PhysObject;
import world.objects.Player;
import world.objects.Remote;
import world.objects.Robot;
import world.objects.Stone;

public class PddlProblem {


	String name;
	static String domain;
	static HashSet<Litereal> consObjects = new HashSet<>();


	public static ArrayList<Litereal> objects = new ArrayList<>();
	static HashMap<String, Litereal> hObjects = new HashMap<>();
	ArrayList<Predicate> predicates = new ArrayList<>();
	HashSet<Predicate> hpredicates = new HashSet<>();
	Predicate goal;

	public PddlProblem(String name, World world) {
		this.name=name+"-Astro";
		domain="Astro";

		objs(world);
		init(world);
		goal = pre(Ptype.at, "player-01", world.getGoal().getPosition().getName());

	}


	public PddlProblem(World world) {

		domain="Astro";

		objs(world);

		init(world);
		goal = pre(Ptype.at, "player-01", world.getGoal().getPosition().getName());
	}	



	public PddlProblem() {
		domain="Astro";
	}
	public ArrayList<String> getLines() {

		return getLines(PDDL.ManualGate);
	}

	public ArrayList<String> getLines(PDDL gate){
		ArrayList<String> lines = new ArrayList<>();

		lines.add("(define (problem "+name+")");
		lines.add("  (:domain "+domain+")");
		lines.add("  (:objects");
		for (Litereal string : objects) {
			lines.add("    "+string +" - "+string.type);
		}
		lines.add("  )");

		lines.add("  (:init");
		lines.add("    (= (total-cost) 0)");
		for (Predicate string : predicates) {
			if(!(gate == PDDL.AxiomGate && string.type==Ptype.closed)){
				lines.add("    "+string);
			}
		}
		lines.add("  )");

		lines.add("  (:goal");
		lines.add("    (and");
		lines.add("      "+goal);
		lines.add("    )");
		lines.add("  )");


		lines.add("(:metric minimize (total-cost))");

		lines.add(")");
		return lines;
	}






	public static Set<Predicate> getEffect(final PddlProblem before, final PddlProblem after) {
		Set<Predicate> negativeEffects = new HashSet<>(before.predicates);
		negativeEffects.removeAll(after.predicates);
		ArrayList<Predicate> tmp = new ArrayList<>(negativeEffects.size());
		negativeEffects.forEach(pre -> tmp.add(new Predicate(pre)));
		negativeEffects.clear();
		negativeEffects.addAll(tmp);
		for (Predicate predicate : negativeEffects) {
			predicate.negate();
		}

		Set<Predicate> positiveEffects = new HashSet<>(after.predicates);
		positiveEffects.removeAll(before.predicates);


		negativeEffects.addAll(positiveEffects);
		Set<Predicate> result = new HashSet<>();
		negativeEffects.forEach(pre -> result.add(new Predicate(pre)));

		return result;

		//		Set<Predicate> symmetricDiff = new HashSet<>(predicates);
		//	    symmetricDiff.addAll(previousState.predicates);
		//	    Set<Predicate> tmp = new HashSet<>(predicates);
		//	    tmp.retainAll(previousState.predicates);
		//	    symmetricDiff.removeAll(tmp);
		//	    return symmetricDiff;
	}


	private static void constObjs() {
		consObjects.add(new Litereal("right",litType.direction));
		consObjects.add(new Litereal("left",litType.direction));
		consObjects.add(new Litereal("up",litType.direction));
		consObjects.add(new Litereal("down",litType.direction));
		consObjects.add(new Litereal("green",litType.colour));
		consObjects.add(new Litereal("brown",litType.colour));
		consObjects.add(new Litereal("blue",litType.colour));
		consObjects.add(new Litereal("red",litType.colour));
		consObjects.add(new Litereal("purple",litType.colour));
		consObjects.add(new Litereal("yellow",litType.colour));

		for (Litereal litereal : consObjects) {
			hObjects.put(litereal.toString(), litereal);
		}


	}


	public static void objs(World world){
		if(!objects.isEmpty()){
			return;
		}

		constObjs();

		if(world.getPlayer()!=null){
			objects.add(new Litereal("player-01", litType.player));
		}


		for (int j = 0; j < world.height; j++) {
			for (int i = 0; i < world.width; i++) {
				objects.add(new Litereal("pos-"+(i<10?"0":"")+i+"-"+(j<10?"0":"")+j, litType.location));
			}
		}

		int tmp =0;
		for (Stone s : world.getStones()) {

			objects.add(new Litereal("stone"+tmp,litType.stone));
			s.name="stone"+tmp;
			tmp++;
		}

		tmp =0;
		for (Robot s : world.getRobots()) {

			objects.add(new Litereal("robot"+tmp,litType.robot));
			s.name="robot"+tmp;
			tmp++;
		}

		tmp =0;
		for ( PhysObject s : world.getPickUps()) {
			if(s instanceof Remote){

				objects.add(new Litereal("remote"+tmp,litType.remote));
				s.name="remote"+tmp;
				tmp++;
			}
		}


		for (Litereal litereal : objects) {
			hObjects.put(litereal.toString(), litereal);
		}


	}
	public Predicate pre(Ptype type, String... litereals) {

		if(hObjects.isEmpty()){
			System.out.println("pre: missing Objects");

		}
		Litereal[] lits = new Litereal[litereals.length];
		for (int i = 0; i < litereals.length; i++) {
			lits[i]=hObjects.get(litereals[i]);
			if(hObjects.get(litereals[i])==null){
				System.out.println("pre: "+hObjects.keySet());
				System.out.println("pre: "+Arrays.toString(litereals));
				System.out.println("pre: "+litereals[i]);
				System.out.println("pre:..................");
				System.exit(-1);
			}
		}

		return new Predicate(type, lits);

	}


	public void init(World world){


		Player player= world.getPlayer();
		if(player!=null){
			if(player.getPosition()!=null){
				predicates.add(pre(Ptype.at, player.getName(), player.getPosition().getName()));
//				System.out.println("pddl "+pre(Ptype.at, player.getName(), player.getPosition().getName()));
				for (Remote remote : player.remotes) {
					predicates.add(pre(Ptype.has, remote.getName()));
				}
			}
			if(player.moving){
				predicates.add(pre(Ptype.moving, player.getName(), player.facing.toString()));
			}
		}
		//ladders
		for (Ladder ladder : world.getLadders()) {
			predicates.add(pre(Ptype.ladder, ladder.getPosition().getName()));
		}

		//stones

		for ( Stone s : world.getStones()) {
			predicates.add(pre(Ptype.at, s.getName(), s.getPosition().getName()));
			if(s.moving){
				predicates.add(pre(Ptype.moving, s.getName(), s.facing.toString()));
			}
		}
		//robots
		for (Robot r : world.getRobots()) {
			predicates.add(pre(Ptype.at, r.getName(), r.getPosition().getName()));

			predicates.add(pre(Ptype.facing, r.getName(), r.facing.toString()));
			if(r.moving){
				predicates.add(pre(Ptype.moving, r.getName(), r.facing.toString()));
			}

		}


		//ground
		for (Ground ground : world.getGround()) {
			predicates.add(pre(Ptype.ground, ground.getColor().toString(),ground.getPosition().getName()));


		}

		//teleports
		for (PhysObject point : world.getTeleports()) {
			predicates.add(pre(Ptype.teleport, point.getPosition().getName()));
		}

		//gates
		for (Button point : world.getButtons()) {
			predicates.add(pre(Ptype.button, point.getColor(), point.getPosition().getName()));
		}

		//buttons
		for (Gate point : world.getGates()) {
			predicates.add(pre(Ptype.gate, point.getColor().toString(), point.getPosition().getName()));

			if(!point.isSolid()){
				predicates.add(pre(Ptype.closed, point.getPosition().getName()));
			}
			if(world.isClearMoveable(point.getPosition())){
				predicates.add(pre(Ptype.clear, point.getPosition().getName()));
			}

		}
		//pickups
		for (PhysObject point : world.getPickUps()) {
			if(point instanceof Remote){
				predicates.add(pre(Ptype.controller,point.getName(),  point.getPosition().getName()));
			}else if(point instanceof Boot){
				predicates.add(pre(Ptype.boot, ((Boot)point).getColor().toString(), point.getPosition().getName()));
			}

		}

		//relative positions
		for (int x = 0; x <world.width; x++) {
			for (int y = 0; y < world.height; y++) {

				if(world.isClear(x,y)){
					predicates.add(pre(Ptype.clear, "pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y));
				}
				if(x!=0){
					predicates.add(pre(Ptype.relativDir, "pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y,"pos-"+(x-1<10?"0":"")+(x-1)+"-"+(y<10?"0":"")+y,"left"));

				}
				if(x!=world.width-1){
					predicates.add(pre(Ptype.relativDir, "pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y,"pos-"+(x+1<10?"0":"")+(x+1)+"-"+(y<10?"0":"")+y,"right"));
				}

				if(y!=0){
					predicates.add(pre(Ptype.relativDir, "pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y,"pos-"+(x<10?"0":"")+x+"-"+(y-1<10?"0":"")+(y-1),"up"));
				}
				if(y!=world.height-1){
					predicates.add(pre(Ptype.relativDir, "pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y,"pos-"+(x<10?"0":"")+x+"-"+(y+1<10?"0":"")+(y+1),"down"));
				}else{
					predicates.add(pre(Ptype.boarder, "pos-"+(x<10?"0":"")+x+"-"+(y<10?"0":"")+y));
				}
			}
		}


		for (Predicate predicate : predicates) {
			hpredicates.add(predicate);

			//			for (Litereal litereal : predicate.objects) {
			//				ArrayList<Predicate> list = objectsToPredicates.get(litereal.toString());
			//				if(list==null){
			//					list= new ArrayList<>();
			//					objectsToPredicates.put(litereal.toString(), list);
			//				}
			//				list.add(predicate);
			//			}
		}
	}


	public boolean isPresent(Predicate predicate) {
		if(hpredicates.contains(predicate)){
			return true;
		}
		if(predicate.negate){

			if(!hpredicates.contains(new Predicate(predicate, true))){

				return true;
			}
		}



		return false;
	}
	public static void clear(){
		hObjects.clear();
		objects.clear();

	}

	public void toPDDL(Path path) throws IOException {
		toPDDL(path, PDDL.ManualGate);
	}

	public void toPDDL(Path path, PDDL gate) throws IOException {
		String name = path.getFileName().toString();
		name = name.substring(0, name.length() - 5);

		Files.write(path, getLines(gate));
	}
	public static void toPDDL(Path path, World world) throws IOException {
		
		toPDDL(path, PDDL.ManualGate, world);
	}
	public static void toPDDL(Path path, PDDL gate, World world) throws IOException {
		
		String name = path.getFileName().toString();
		name = name.substring(0, name.length() - 5);
		PddlProblem problem = new PddlProblem(name,world);
		Files.write(path, problem.getLines(gate));
	}

}
