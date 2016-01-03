package test;

import static org.junit.Assert.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pddl.Converter;
import pddl.Hypothesis;
import pddl.PddlProblem;
import pddl.Predicate;
import pddl.Hypothesis.PlanType;
import world.World;
import world.commands.Command;
import world.commands.Move;
import world.objects.PhysObject.Direction;

@FixMethodOrder(MethodSorters.DEFAULT)
public class PddlTest {

	@Test
	public void learn(){
		Path path = Paths.get("levels/level01.xml");
		World world = new World(path);
		PddlProblem prob1 = new PddlProblem(world);
		
		Hypothesis hypo = new Hypothesis(prob1);
		Command a =new Move(Direction.right, new String[] {"player-01", "pos-01-03","pos-02-03"});
		a.Do(world);
		world.update();
		PddlProblem prob2 = new PddlProblem(world);
		
		hypo.addKnowledge(a, prob1, prob2);
		
		Set<Predicate> effects =PddlProblem.getEffect(prob1, prob2);
		assertEquals("[(not (clear pos-02-03)), (not (at player-01 pos-01-03)), (clear pos-01-03), (at player-01 pos-02-03)]", effects.toString());
		System.out.println(effects);
		
		ArrayList<Predicate> p=hypo.possiblePrediacates(new String[] {"player-01", "pos-01-03","pos-02-03" ,"pos-02-04" ,"right"});
		System.out.println(p);
		System.out.println(hypo.FilterpossiblePrediacates(p));
	}
	
	
	@Test
	public void readProblem() throws IOException{
		Path path = Paths.get("levels/level01.xml");
		World world = new World(path);
		PddlProblem prob1 = new PddlProblem(world);
		
		Files.write(Paths.get("pddl1.txt"),prob1.getLines());

		
		Files.write(Paths.get("pddl2.txt"),Converter.toPDDL(world, "Astro"));
		
		//should be equal
	}
	
	@Test
	public void createPddl() throws IOException{
		Path path = Paths.get("levels/level01.xml");
		World world = new World(path);
		
		PddlProblem.objs(world);

		assertEquals(PddlProblem.objects.size(),91);
		
	}
	
	@Test
	public void createDomain() throws IOException{
		Path pProblem = Paths.get("learning/problem.pddl");
		Path pDomain = Paths.get("learning/domain.pddl");
		
		Path path = Paths.get("levels/level01.xml");
		World world = new World(path);
		

		
		Converter.toPDDL(world, pProblem);
		
		PddlProblem before = new PddlProblem(world);
		
		Hypothesis hypo = new Hypothesis(before);
		
		
		Command a =new Move(Direction.right, new String[] {"player-01", "pos-01-03","pos-02-03", "right"});
		a.Do(world);
		world.update();
		PddlProblem after = new PddlProblem(world);
		
		hypo.addKnowledge(a, before, after);
		Set<Predicate> effects =PddlProblem.getEffect(before, after);
		System.out.println(effects);
		
		System.out.println(hypo.getAction(a).effects);
		
		before=after;
		
		Command a2 =new Move(Direction.down, new String[] {"player-01", "pos-02-03","pos-02-04", "down"});
		a2.Do(world);
		world.update();
		
		after = new PddlProblem(world);
		
		hypo.addKnowledge(a2, before);
		assertTrue(PddlProblem.getEffect(before, after).isEmpty());

		System.out.println(hypo.getAction(a2).candidatesPressent);
		
		
		hypo.toPDDL(pDomain);
		

	
		
		
	}
	
	@Test
	public void failling() throws IOException{
		Path pProblem = Paths.get("learning/problem.pddl");
		Path pDomain = Paths.get("learning/domain.pddl");
		
		Path path = Paths.get("levels/prob01.xml");
		World world = new World(path);
		

		
		Converter.toPDDL(world, pProblem);
		
		PddlProblem before = new PddlProblem(world);
		
		Hypothesis hypo = new Hypothesis(before);
		
//		Command a0 =new Move(Direction.right, new String[] {"player-01", "pos-01-01","pos-03-01", "right"});
//
//		hypo.addKnowledge(a0, before);
//		assertEquals(0, hypo.getAction(a0).effects.size());
		
		Command a1 =new Move(Direction.right, new String[] {"player-01", "pos-01-03","pos-02-03", "right"});

		hypo.addKnowledge(a1, before);
		assertEquals(0, hypo.getAction(a1).effects.size());
		
		
		Command a2 =new Move(Direction.right, new String[] {"player-01", "pos-02-03","pos-02-01", "right"});

		hypo.addKnowledge(a2, before);
		assertEquals(0, hypo.getAction(a2).effects.size());

		Command a3 =new Move(Direction.right, new String[] {"player-01", "pos-02-01","pos-03-02", "right"});

		hypo.addKnowledge(a3, before);
		assertEquals(0, hypo.getAction(a3).effects.size());
		
		
		Command a4 =new Move(Direction.right, new String[] {"player-01", "pos-02-03","pos-03-03", "right"});

		hypo.addKnowledge(a4, before);
		assertEquals(0, hypo.getAction(a4).effects.size());
		
		Command a5 =new Move(Direction.right, new String[] {"player-01", "pos-01-01","pos-01-02", "right"});

		hypo.addKnowledge(a5, before);
		assertEquals(0, hypo.getAction(a5).effects.size());
		
		
		Command a6 =new Move(Direction.right, new String[] {"player-01", "pos-01-01","pos-02-01", "right"});
		a6.Do(world);
		world.update();
		PddlProblem prob2 = new PddlProblem(world);
		
		hypo.addKnowledge(a6, before, prob2);
		
		
		hypo.toPDDL(pDomain);
		

	
		
		
	}
	
	@Test
	public void success() throws IOException{
		Path pProblem = Paths.get("learning/problem.pddl");
		Path pDomain = Paths.get("learning/domain.pddl");
		
		Path path = Paths.get("levels/prob02.xml");
		World world = new World(path);
		

		
		Converter.toPDDL(world, pProblem);
		
		PddlProblem before = new PddlProblem(world);
		
		Hypothesis hypo = new Hypothesis(before, PlanType.pessimistic);
		
		
		Command a1 =new Move(Direction.left, new String[] {"player-01", "pos-03-01","pos-02-01", "left"});
		a1.Do(world);
		world.update();
		PddlProblem after = new PddlProblem(world);
		
		hypo.addKnowledge(a1, before, after);
		before = after;
		
		Command a2 =new Move(Direction.right, new String[] {"player-01", "pos-02-01","pos-03-01", "right"});
		a2.Do(world);
		world.update();
		after = new PddlProblem(world);
		
		hypo.addKnowledge(a2, before, after);
		
		
		Command a3 =new Move(Direction.right, new String[] {"player-01", "pos-03-01","pos-04-01", "right"});
		a3.Do(world);
		world.update();
		after = new PddlProblem(world);
		
		hypo.addKnowledge(a3, before, after);
		
		hypo.toPDDL(pDomain);
		

	
		
		
	}
	
	
	@Test
	public void getParams() throws IOException{

		
		Path path = Paths.get("levels/prob02.xml");
		World world = new World(path);

		Command a1 =new Move(Direction.left);

		assertEquals("[player-01, pos-03-01, pos-02-01, left]", Arrays.toString(a1.getSuccessParameters(world)));
		a1.Do(world);
		world.update();

		
		Command a2 =new Move(Direction.right);

		assertEquals("[player-01, pos-02-01, pos-03-01, right]", Arrays.toString(a2.getSuccessParameters(world)));
		a2.Do(world);
		world.update();
	
		
		Command a3 =new Move(Direction.right);

		assertEquals("[player-01, pos-03-01, pos-04-01, right]", Arrays.toString(a3.getSuccessParameters(world)));
		a3.Do(world);
		world.update();

		
	}
	@Test
	public void intro() throws IOException{

		
		Path path = Paths.get("levels/level01intro.xml");
		World world = new World(path);

		ArrayList<Command> commands= new ArrayList<>();
		commands.add(new Move(Direction.right));
		commands.add(new Move(Direction.right));
		commands.add(new Move(Direction.right));
		commands.add(new Move(Direction.up));
		commands.add(new Move(Direction.up));
		commands.add(new Move(Direction.right));
		commands.add(new Move(Direction.right));
		commands.add(new Move(Direction.right));
		
		
		PddlProblem before = new PddlProblem(world);
		PddlProblem after;
		Hypothesis hypo = new Hypothesis(before,PlanType.pessimistic);
		
		Path pDomain = Paths.get("learning/domain.pddl");
		
		for (Command command : commands) {
			command.parameters=command.getSuccessParameters(world);
			command.Do(world);
			world.update();
			after = new PddlProblem(world);
			hypo.addKnowledge(command, before,after);
			
			before=after;
		}
		
		hypo.toPDDL(pDomain);

		
	}
}

