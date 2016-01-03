package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;

import pddl.Action;
import pddl.Hypothesis;
import pddl.Litereal;
import pddl.Litereal.litType;
import pddl.PddlProblem;
import pddl.Predicate;
import pddl.Predicate.Ptype;
import world.World;
import world.commands.Command;
import world.commands.Move;
import world.objects.PhysObject.Direction;

public class LearningTest {


	@Test
	public void create(){

		Path path = Paths.get("levels/prob01.xml");
		World world = new World(path);

		PddlProblem before = new PddlProblem(world);

		Hypothesis hypo = new Hypothesis(before);

		assertEquals("[(not (relativ-dir pos-01-01 pos-00-01 left)), (boarder pos-00-03), (not (relativ-dir pos-02-00 pos-02-01 down)), (not (boarder pos-01-03)), (relativ-dir pos-06-03 pos-07-03 right), (not (relativ-dir pos-01-02 pos-02-02 right)), (relativ-dir pos-05-00 pos-05-01 down), (not (relativ-dir pos-03-02 pos-02-02 left)), (not (relativ-dir pos-04-01 pos-04-02 down)), (not (relativ-dir pos-05-03 pos-06-03 right)), (not (relativ-dir pos-06-01 pos-07-01 right)), (not (relativ-dir pos-03-00 pos-04-00 right)), (relativ-dir pos-03-00 pos-04-00 right), (not (clear pos-00-01)), (relativ-dir pos-04-00 pos-03-00 left), (not (relativ-dir pos-06-02 pos-06-03 down)), (not (relativ-dir pos-02-01 pos-02-00 up)), (not (relativ-dir pos-05-03 pos-04-03 left)), (clear pos-02-03), (not (clear pos-07-03)), (not (relativ-dir pos-07-00 pos-07-01 down)), (relativ-dir pos-02-01 pos-03-01 right), (not (relativ-dir pos-04-03 pos-04-02 up)), (relativ-dir pos-02-01 pos-02-00 up), (not (clear pos-02-00)), (not (relativ-dir pos-06-01 pos-05-01 left)), (not (relativ-dir pos-02-00 pos-01-00 left)), (not (relativ-dir pos-02-02 pos-03-02 right)), (relativ-dir pos-03-01 pos-02-01 left), (relativ-dir pos-07-02 pos-06-02 left), (relativ-dir pos-07-03 pos-07-02 up), (not (relativ-dir pos-03-02 pos-03-01 up)), (relativ-dir pos-04-02 pos-05-02 right), (boarder pos-07-03), (not (relativ-dir pos-00-02 pos-01-02 right)), (clear pos-05-01), (relativ-dir pos-03-03 pos-04-03 right), (not (relativ-dir pos-05-00 pos-05-01 down)), (not (relativ-dir pos-06-03 pos-07-03 right)), (boarder pos-04-03), (relativ-dir pos-02-02 pos-01-02 left), (relativ-dir pos-04-01 pos-03-01 left), (relativ-dir pos-04-02 pos-04-03 down), (not (boarder pos-03-03)), (relativ-dir pos-06-03 pos-06-02 up), (not (relativ-dir pos-01-02 pos-01-03 down)), (relativ-dir pos-03-02 pos-03-01 up), (relativ-dir pos-06-02 pos-06-01 up), (not (relativ-dir pos-07-03 pos-06-03 left)), (not (relativ-dir pos-02-03 pos-01-03 left)), (not (clear pos-06-00)), (not (clear pos-00-00)), (not (relativ-dir pos-02-00 pos-03-00 right)), (not (relativ-dir pos-05-02 pos-05-01 up)), (not (relativ-dir pos-07-01 pos-07-02 down)), (not (relativ-dir pos-01-03 pos-01-02 up)), (relativ-dir pos-05-00 pos-06-00 right), (not (ground brown pos-03-02)), (relativ-dir pos-04-01 pos-04-02 down), (clear pos-05-00), (not (clear pos-07-02)), (relativ-dir pos-07-03 pos-06-03 left), (not (clear pos-05-03)), (clear pos-06-03), (relativ-dir pos-01-00 pos-01-01 down), (ground brown pos-04-02), (relativ-dir pos-02-03 pos-01-03 left), (relativ-dir pos-01-02 pos-02-02 right), (relativ-dir pos-02-03 pos-02-02 up), (not (relativ-dir pos-05-00 pos-04-00 left)), (ground brown pos-03-02), (relativ-dir pos-07-01 pos-06-01 left), (relativ-dir pos-03-01 pos-03-02 down), (relativ-dir pos-01-00 pos-02-00 right), (relativ-dir pos-03-03 pos-02-03 left), (not (relativ-dir pos-00-01 pos-00-00 up)), (not (relativ-dir pos-05-01 pos-05-00 up)), (not (relativ-dir pos-00-01 pos-01-01 right)), (not (boarder pos-06-03)), (clear pos-06-00), (relativ-dir pos-06-00 pos-06-01 down), (not (relativ-dir pos-06-01 pos-06-02 down)), (not (relativ-dir pos-05-02 pos-04-02 left)), (not (at player-01 pos-01-01)), (relativ-dir pos-06-00 pos-07-00 right), (not (relativ-dir pos-06-02 pos-06-01 up)), (relativ-dir pos-05-02 pos-05-03 down), (not (relativ-dir pos-06-02 pos-05-02 left)), (clear pos-03-03), (not (relativ-dir pos-03-03 pos-02-03 left)), (relativ-dir pos-05-00 pos-04-00 left), (clear pos-01-00), (relativ-dir pos-04-01 pos-05-01 right), (relativ-dir pos-03-01 pos-03-00 up), (not (relativ-dir pos-04-02 pos-04-03 down)), (not (relativ-dir pos-03-03 pos-04-03 right)), (relativ-dir pos-00-03 pos-01-03 right), (not (clear pos-07-01)), (clear pos-06-01), (relativ-dir pos-05-02 pos-05-01 up), (relativ-dir pos-01-02 pos-00-02 left), (not (ground brown pos-04-02)), (relativ-dir pos-02-02 pos-03-02 right), (not (relativ-dir pos-04-00 pos-03-00 left)), (not (relativ-dir pos-06-00 pos-07-00 right)), (relativ-dir pos-06-03 pos-05-03 left), (at player-01 pos-01-01), (relativ-dir pos-02-00 pos-02-01 down), (not (relativ-dir pos-04-00 pos-05-00 right)), (not (ground brown pos-05-02)), (not (relativ-dir pos-00-02 pos-00-01 up)), (clear pos-02-00), (relativ-dir pos-02-02 pos-02-01 up), (clear pos-07-02), (not (relativ-dir pos-01-01 pos-02-01 right)), (not (relativ-dir pos-05-01 pos-05-02 down)), (not (clear pos-03-03)), (not (relativ-dir pos-04-03 pos-05-03 right)), (relativ-dir pos-00-00 pos-01-00 right), (not (relativ-dir pos-07-02 pos-06-02 left)), (not (clear pos-07-00)), (relativ-dir pos-05-03 pos-05-02 up), (not (clear pos-01-00)), (not (relativ-dir pos-04-03 pos-03-03 left)), (relativ-dir pos-02-00 pos-01-00 left), (not (relativ-dir pos-03-02 pos-03-03 down)), (not (relativ-dir pos-06-03 pos-06-02 up)), (relativ-dir pos-05-01 pos-06-01 right), (not (relativ-dir pos-00-03 pos-00-02 up)), (relativ-dir pos-01-03 pos-02-03 right), (not (relativ-dir pos-00-00 pos-00-01 down)), (relativ-dir pos-00-01 pos-00-02 down), (not (clear pos-02-01)), (boarder pos-03-03), (clear pos-02-01), (clear pos-07-03), (not (relativ-dir pos-03-00 pos-02-00 left)), (not (relativ-dir pos-05-00 pos-06-00 right)), (not (boarder pos-05-03)), (relativ-dir pos-06-01 pos-06-00 up), (relativ-dir pos-03-02 pos-04-02 right), (not (relativ-dir pos-03-03 pos-03-02 up)), (not (relativ-dir pos-00-01 pos-00-02 down)), (relativ-dir pos-05-02 pos-04-02 left), (clear pos-00-01), (not (relativ-dir pos-04-02 pos-04-01 up)), (not (relativ-dir pos-02-01 pos-03-01 right)), (relativ-dir pos-01-01 pos-00-01 left), (relativ-dir pos-02-03 pos-03-03 right), (not (relativ-dir pos-06-00 pos-06-01 down)), (not (boarder pos-00-03)), (not (relativ-dir pos-02-02 pos-02-03 down)), (clear pos-04-03), (not (relativ-dir pos-01-03 pos-00-03 left)), (not (clear pos-03-00)), (not (relativ-dir pos-06-02 pos-07-02 right)), (not (clear pos-06-03)), (clear pos-07-00), (relativ-dir pos-04-01 pos-04-00 up), (ground brown pos-02-02), (not (relativ-dir pos-05-03 pos-05-02 up)), (relativ-dir pos-01-03 pos-01-02 up), (relativ-dir pos-00-02 pos-01-02 right), (relativ-dir pos-04-03 pos-03-03 left), (not (clear pos-04-03)), (relativ-dir pos-01-02 pos-01-03 down), (relativ-dir pos-07-01 pos-07-02 down), (relativ-dir pos-06-01 pos-07-01 right), (not (clear pos-05-00)), (clear pos-07-01), (relativ-dir pos-02-01 pos-02-02 down), (relativ-dir pos-06-02 pos-06-03 down), (clear pos-00-00), (not (relativ-dir pos-01-03 pos-02-03 right)), (not (relativ-dir pos-02-01 pos-01-01 left)), (not (relativ-dir pos-03-01 pos-04-01 right)), (relativ-dir pos-06-01 pos-06-02 down), (clear pos-03-00), (relativ-dir pos-00-01 pos-00-00 up), (not (boarder pos-04-03)), (not (relativ-dir pos-01-00 pos-01-01 down)), (relativ-dir pos-06-00 pos-05-00 left), (ground brown pos-06-02), (not (relativ-dir pos-04-02 pos-03-02 left)), (clear pos-01-03), (relativ-dir pos-02-02 pos-02-03 down), (relativ-dir pos-03-00 pos-03-01 down), (not (relativ-dir pos-03-01 pos-03-02 down)), (relativ-dir pos-02-00 pos-03-00 right), (relativ-dir pos-01-00 pos-00-00 left), (not (clear pos-03-01)), (not (relativ-dir pos-02-03 pos-03-03 right)), (not (relativ-dir pos-05-02 pos-06-02 right)), (boarder pos-02-03), (relativ-dir pos-06-01 pos-05-01 left), (relativ-dir pos-01-02 pos-01-01 up), (not (relativ-dir pos-05-02 pos-05-03 down)), (not (ground brown pos-06-02)), (clear pos-03-01), (not (relativ-dir pos-06-01 pos-06-00 up)), (not (relativ-dir pos-06-03 pos-05-03 left)), (relativ-dir pos-04-03 pos-04-02 up), (not (relativ-dir pos-07-01 pos-06-01 left)), (relativ-dir pos-03-01 pos-04-01 right), (not (relativ-dir pos-01-00 pos-00-00 left)), (relativ-dir pos-05-01 pos-05-00 up), (not (clear pos-02-03)), (relativ-dir pos-04-02 pos-03-02 left), (not (relativ-dir pos-02-02 pos-02-01 up)), (not (relativ-dir pos-03-01 pos-03-00 up)), (not (relativ-dir pos-04-01 pos-05-01 right)), (relativ-dir pos-05-02 pos-06-02 right), (clear pos-05-03), (not (relativ-dir pos-01-02 pos-01-01 up)), (not (clear pos-00-03)), (not (relativ-dir pos-03-01 pos-02-01 left)), (relativ-dir pos-00-02 pos-00-03 down), (not (relativ-dir pos-01-02 pos-00-02 left)), (relativ-dir pos-03-00 pos-02-00 left), (not (boarder pos-07-03)), (not (relativ-dir pos-00-02 pos-00-03 down)), (not (relativ-dir pos-04-00 pos-04-01 down)), (relativ-dir pos-04-03 pos-05-03 right), (relativ-dir pos-07-01 pos-07-00 up), (not (relativ-dir pos-02-03 pos-02-02 up)), (relativ-dir pos-06-02 pos-05-02 left), (boarder pos-01-03), (not (ground brown pos-02-02)), (relativ-dir pos-01-03 pos-00-03 left), (relativ-dir pos-02-01 pos-01-01 left), (relativ-dir pos-07-02 pos-07-03 down), (relativ-dir pos-01-01 pos-01-02 down), (not (relativ-dir pos-02-01 pos-02-02 down)), (not (clear pos-06-01)), (not (relativ-dir pos-01-00 pos-02-00 right)), (not (clear pos-04-01)), (relativ-dir pos-00-01 pos-01-01 right), (relativ-dir pos-00-03 pos-00-02 up), (boarder pos-06-03), (not (relativ-dir pos-04-02 pos-05-02 right)), (ground brown pos-01-02), (not (relativ-dir pos-05-01 pos-06-01 right)), (relativ-dir pos-04-00 pos-04-01 down), (not (ground brown pos-01-02)), (not (clear pos-01-03)), (not (relativ-dir pos-06-00 pos-05-00 left)), (not (relativ-dir pos-07-03 pos-07-02 up)), (relativ-dir pos-05-03 pos-04-03 left), (relativ-dir pos-06-02 pos-07-02 right), (not (relativ-dir pos-03-00 pos-03-01 down)), (not (relativ-dir pos-01-01 pos-01-02 down)), (relativ-dir pos-01-01 pos-01-00 up), (not (clear pos-00-02)), (relativ-dir pos-07-00 pos-06-00 left), (not (relativ-dir pos-07-01 pos-07-00 up)), (clear pos-00-03), (relativ-dir pos-04-02 pos-04-01 up), (not (relativ-dir pos-04-01 pos-04-00 up)), (not (relativ-dir pos-01-01 pos-01-00 up)), (not (relativ-dir pos-04-01 pos-03-01 left)), (relativ-dir pos-05-03 pos-06-03 right), (relativ-dir pos-05-01 pos-04-01 left), (not (relativ-dir pos-02-02 pos-01-02 left)), (clear pos-04-01), (boarder pos-05-03), (relativ-dir pos-04-00 pos-05-00 right), (relativ-dir pos-00-00 pos-00-01 down), (not (clear pos-04-00)), (relativ-dir pos-07-02 pos-07-01 up), (ground brown pos-05-02), (relativ-dir pos-03-02 pos-02-02 left), (clear pos-00-02), (not (boarder pos-02-03)), (not (relativ-dir pos-00-00 pos-01-00 right)), (not (relativ-dir pos-07-02 pos-07-03 down)), (relativ-dir pos-01-01 pos-02-01 right), (clear pos-04-00), (relativ-dir pos-05-01 pos-05-02 down), (relativ-dir pos-00-02 pos-00-01 up), (not (relativ-dir pos-00-03 pos-01-03 right)), (not (relativ-dir pos-03-02 pos-04-02 right)), (not (relativ-dir pos-05-01 pos-04-01 left)), (not (clear pos-05-01)), (not (relativ-dir pos-07-00 pos-06-00 left)), (relativ-dir pos-03-03 pos-03-02 up), (relativ-dir pos-07-00 pos-07-01 down), (relativ-dir pos-03-02 pos-03-03 down), (not (relativ-dir pos-07-02 pos-07-01 up))]"
				,hypo.usedGroundPredicates.toString());


//		assertEquals("[ground, clear, relativDir, boarder, at]", hypo.usedPredicates.keySet().toString());
//		hypo.usedPredicates.forEach((k, v)-> assertEquals(k, v.type));

	}


	@Test
	public void possiblePredicates(){

		Path path = Paths.get("levels/prob01.xml");
		World world = new World(path);


		PddlProblem before = new PddlProblem(world);

		Hypothesis hypo = new Hypothesis(before);
		ArrayList<Predicate> possible =hypo.possiblePrediacates(new String[] {"player-01", "pos-01-01","pos-02-01" ,"right"});
		assertEquals("[(not (clear pos-01-01)), (clear pos-01-01), (not (clear pos-02-01)), (clear pos-02-01), (not (relativ-dir pos-01-01 pos-01-01 right)), (relativ-dir pos-01-01 pos-01-01 right), (not (relativ-dir pos-01-01 pos-02-01 right)), (relativ-dir pos-01-01 pos-02-01 right), (not (relativ-dir pos-02-01 pos-01-01 right)), (relativ-dir pos-02-01 pos-01-01 right), (not (relativ-dir pos-02-01 pos-02-01 right)), (relativ-dir pos-02-01 pos-02-01 right), (not (boarder pos-01-01)), (boarder pos-01-01), (not (boarder pos-02-01)), (boarder pos-02-01), (not (at player-01 pos-01-01)), (at player-01 pos-01-01), (not (at player-01 pos-02-01)), (at player-01 pos-02-01)]", 
				possible.toString());
		possible =hypo.FilterpossiblePrediacates(possible);
//		System.out.println(possible);

		possible.removeIf(e -> !before.isPresent(e));
		Litereal lit= new Litereal("pos-02-01", litType.location);
		assertTrue(possible.contains(new Predicate(Ptype.clear, lit)));

		assertFalse(possible.contains(new Predicate(Ptype.clear, true, lit)));

//		System.out.println(possible);
	}

	@Test
	public void possiblePredicates2(){

		Path path = Paths.get("levels/level03intro.xml");
		World world = new World(path);


		PddlProblem before = new PddlProblem(world);

		Hypothesis hypo = new Hypothesis(before);
		ArrayList<Predicate> possible =hypo.possiblePrediacates(new String[] {"player-01", "pos-01-01","pos-02-01" ,"right"});
		assertEquals("[(not (clear pos-01-01)), (clear pos-01-01), (not (clear pos-02-01)), (clear pos-02-01), (not (relativ-dir pos-01-01 pos-01-01 right)), (relativ-dir pos-01-01 pos-01-01 right), (not (relativ-dir pos-01-01 pos-02-01 right)), (relativ-dir pos-01-01 pos-02-01 right), (not (relativ-dir pos-02-01 pos-01-01 right)), (relativ-dir pos-02-01 pos-01-01 right), (not (relativ-dir pos-02-01 pos-02-01 right)), (relativ-dir pos-02-01 pos-02-01 right), (not (boarder pos-01-01)), (boarder pos-01-01), (not (boarder pos-02-01)), (boarder pos-02-01), (not (at player-01 pos-01-01)), (at player-01 pos-01-01), (not (at player-01 pos-02-01)), (at player-01 pos-02-01)]", 
				possible.toString());
		possible =hypo.FilterpossiblePrediacates(possible);
//		System.out.println(possible);

		possible.removeIf(e -> !before.isPresent(e));
		Litereal lit= new Litereal("pos-02-01", litType.location);
		assertTrue(possible.contains(new Predicate(Ptype.clear, lit)));

		assertFalse(possible.contains(new Predicate(Ptype.clear, true, lit)));

//		System.out.println(possible);
	}
	
	@Test
	public void equality(){
		Path path = Paths.get("levels/level03intro.xml");
		World world = new World(path);


		PddlProblem before = new PddlProblem(world);

		ArrayList<Litereal> param = new ArrayList<>();
		param.add(new Litereal("right", litType.direction));
		
		Set eq =Predicate.presentEquality(param);
		assertEquals("[(not (= right up)), (not (= right left)), (= right right), (not (= right down))]", eq.toString());
		Set eq2 =Predicate.generateEquality(param);
		assertEquals("[(not (= right up)), (not (= right left)), (not (= right right)), (= right right), (= right down), (= right left), (not (= right down)), (= right up)]", eq2.toString());
		
		param.add(new Litereal("pos-01-01", litType.location));
		eq =Predicate.presentEquality(param);
		eq2 =Predicate.generateEquality(param);

		assertEquals("[(not (= right up)), (not (= right left)), (= right right), (not (= right down))]", eq.toString());
		assertEquals("[(not (= right up)), (not (= right left)), (not (= right right)), (= right right), (= right down), (= right left), (not (= right down)), (= right up)]", eq2.toString());
	
//		System.out.println(eq);
//		System.out.println(eq2);
	}
	
	@Test
	public void Failing() throws IOException{
		Path pDomain = Paths.get("learning/domain.pddl");
		Path path = Paths.get("levels/prob01.xml");
		World world = new World(path);


		PddlProblem before = new PddlProblem(world);

		Hypothesis hypo = new Hypothesis(before);
		Command a =new Move(Direction.right, new String[] {"player-01", "pos-01-03","pos-03-03", "right"});

		hypo.addKnowledge(a, before);
		
		
		Action walk =hypo.getAction(a);
		assertEquals("Walk", walk.name);
		
		assertEquals(0, walk.effects.size());
		
		assertEquals(1, walk.candidatesPressent.size());
		assertEquals(1, walk.candidatesNotPressent.size());
		
		System.out.println(walk.candidatesPressent.get(0).toString());
		System.out.println(walk.candidatesNotPressent.get(0).toString());
		Files.write(pDomain, walk.toPDDL());
		assertEquals("", walk.candidatesPressent.get(0).toString());
		
	}

}
