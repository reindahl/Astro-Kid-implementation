package pddl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import pddl.Litereal.litType;
import pddl.Predicate.Ptype;
import world.commands.Activate;
import world.commands.Climb;
import world.commands.Command;
import world.commands.Push;
import world.commands.Walk;
import world.objects.PhysObject.Direction;

public class Hypothesis {
	public enum PlanType {optimistic, pessimistic};

	PlanType plantype=PlanType.pessimistic; 

	ArrayList<Action> actions= new ArrayList<>();
	//Action noOp;
	Action climbU;
	Action climbD;
	Action walk;
	Action push;
	Action activate;
	
	static boolean filter =true; 
	public HashSet<Ptype> usedPredicates = new HashSet<>();

	public HashSet<Predicate> usedGroundPredicates = new HashSet<>();

	public Hypothesis(PddlProblem problem, PlanType planType){
		inititalise(problem, planType);
	}

	public Hypothesis(PddlProblem problem){
		inititalise(problem,PlanType.optimistic);
	}
	
	/**
	 * prepares the hypothesis to work on a specific problem
	 * @param problem
	 */
	public void setProblem(PddlProblem problem){
		
		
//		usedGroundPredicates.clear();
		for (Predicate predicate : problem.predicates) {
			usedPredicates.add(predicate.type);
			
			usedGroundPredicates.add(predicate);
			usedGroundPredicates.add(new Predicate(predicate, true));

		}
	}
	private void inititalise(PddlProblem problem, PlanType planType){
		this.plantype=planType;
		// initialise

		setProblem(problem);


		climbD = new Action("ClimbDown",new litType[] {litType.player,litType.location,litType.location},this);
		climbU = new Action("ClimbUp",new litType[] {litType.player,litType.location,litType.location},this);
		walk = new Action("Walk",new litType[] {litType.player,litType.location,litType.location,litType.location,litType.location,litType.direction},this);
		push = new Action("Push",new litType[] {litType.player,litType.object,litType.location,litType.location,litType.location,litType.location,litType.location,litType.location,litType.direction},this);
		activate = new Action("activateRobot", new litType[]{litType.location, litType.robot, litType.remote, litType.direction}, this);
		
		actions.add(walk);
		actions.add(climbD);
		actions.add(climbU);
		actions.add(push);
		actions.add(activate);
		


	}

	/**
	 * action action failed
	 * @param action
	 * @param before
	 */
	public void addKnowledge(Command command, PddlProblem before){
		Action action = getAction(command);

		ArrayList<Litereal> params= new ArrayList<>();
		for (String para : command.getParameters()) {
			if(PddlProblem.hObjects.get(para)==null){
				System.out.println("unknown param: " + para);
			}
			params.add(PddlProblem.hObjects.get(para));
		}
		action.addKnowledge(params, before);
	}
	/**
	 * action action success
	 * @param action
	 * @param before
	 * @param after
	 */
	public void addKnowledge(Command command, PddlProblem before, PddlProblem after){

		ArrayList<Litereal> params= new ArrayList<>();
		for (String para : command.getParameters()) {
			params.add(PddlProblem.hObjects.get(para));
		}
		Set<Predicate> effects =PddlProblem.getEffect(before, after);

		for (Predicate predicate : effects) {
			if(!usedGroundPredicates.contains(predicate)){
				usedGroundPredicates.add(predicate);
				usedGroundPredicates.add(new Predicate(predicate, true));
				
				if(!usedPredicates.contains(predicate.type)){
					usedPredicates.add(predicate.type);
				}

			}
		}

		Action action = getAction(command);
		if(action!=null){
			action.addKnowledge(params, before, effects);
		}
	}

	public Action getAction(Command command) {
		if (command instanceof Walk) {
				return walk;
		}else if (command instanceof Climb) {
			if(((Climb) command).dir ==Direction.up){
				return climbU;
			}else if(((Climb) command).dir ==Direction.down){
				return climbD;
			}
		}else if(command instanceof Push){
			return push;
		}else if (command instanceof Activate){
			return activate;
		}
		return null;
	}


	public ArrayList<Predicate> FilterpossiblePrediacates(ArrayList<Predicate> predicates){
		ArrayList<Predicate> filtered = new ArrayList<>();
		if(filter){
			for (Predicate predicate : predicates) {
				
				if(usedGroundPredicates.contains(predicate)){
					filtered.add(predicate);
				}
			}
			return filtered;
		}else{
			return predicates;
		}
		
	}

	public ArrayList<Predicate> possiblePrediacates(String[] strings){
		ArrayList<Litereal> param = new ArrayList<>();

		for (String string : strings) {
			param.add(PddlProblem.hObjects.get(string));
		}

		return possiblePrediacates(param);
	}
	public ArrayList<Predicate> possiblePrediacates(Collection<Litereal> param){
		ArrayList<Predicate> result = new ArrayList<>();
//		System.out.println("hypo: "+param);
		for (Ptype type : usedPredicates) {
			result.addAll(Predicate.generateGroundings(type,param));
		}

		return result;
	}

	public void toPDDL(Path pDomain) {
		toPDDL(pDomain, 0);
		
	}
	
	public void toPDDL(Path pDomain, int relaxDegree) {
		ArrayList<String> lines = new ArrayList<>();

		try {
			lines.addAll(Files.readAllLines(Paths.get("learning/domain1.txt")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		for (Action action : actions) {
			lines.addAll(action.toPDDL(relaxDegree));

		}



		try {
			lines.addAll(Files.readAllLines(Paths.get("learning/domain2.txt")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			Files.write(pDomain, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

}
