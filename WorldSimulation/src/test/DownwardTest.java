package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import downward.Down;
import pddl.Converter;
import pddl.Converter.PDDL;
import pddl.PddlProblem;
import world.Plan;
import world.World;
import world.commands.Command;

public class DownwardTest {

	@Test
	public void filterTest(){
		ArrayList<String> lines = readExample();
		
		Plan plan = new Plan(lines);
		assertEquals("[walk right, walk right, walk right, walk right, walk right]", plan.getActions().toString());
		assertEquals(5, plan.getActions().size());
		assertEquals("[Move right, Move right, Move right, Move right, Move right]", plan.toString());
	}
	
	
	
	public ArrayList<String> readExample(){
		try {
			return (ArrayList<String>) Files.readAllLines(Paths.get("output example.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void problem00() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob00.xml"));
		run(world);
	}
	@Test
	public void problem00v2() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob00v2.xml"));
		run(world);
	}
	@Test
	public void problem01() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob01.xml"));
		run(world);
	}
	
	
	@Test
	public void problem02() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob02.xml"));
		run(world);

	}
	@Test
	public void prob02v0() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob02v0.xml"));
		run(world);
	}
	
	@Test
	public void problem03() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob03.xml"));
		run(world);
	}
	
	@Test
	public void problem03v2() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob03v2.xml"));
		run(world);
	}
	
	@Test
	public void problem04() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob04.xml"));
		run(world);
	}
	
	@Test
	public void problem05() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob05.xml"));
		run(world);
	}
	@Test
	public void problem06() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob06.xml"));
		run(world);
	}
	
	@Test
	public void problem07() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob07.xml"));
		run(world);
	}
	
	@Test
	public void problem08() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob08.xml"));
		run(world);
	}
	
	@Test
	public void problem09() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob09.xml"));
		run(world);
	}
	@Test
	public void problem09v2() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob09v2.xml"));
		run(world);
	}
	@Test
	public void problem10() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob10.xml"));
		run(world);
	}
	
	@Test
	public void problem11() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob11.xml"));
		run(world);
	}
	
	
	//missing noops
	@Test
	public void problem12() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob12.xml"));
		run(world);
	}
	@Test
	public void problem12v2() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob12v2.xml"));
		run(world);
	}
	@Test
	public void problem13() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob13.xml"));
		run(world);
	}
	
	@Test
	public void problem13v2() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob13v2.xml"));
		run(world);
	}
	@Test
	public void problem13v3() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob13v3.xml"));
		run(world);
	}
	@Test
	public void problem14() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob14.xml"));
		run(world);
	}
	@Test
	public void problem15() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob15.xml"));
		run(world);
	}

	@Test
	public void problem16() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob16.xml"));
		run(world);
	}

	@Test
	public void problem18() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob18.xml"));
		run(world);
	}
	
	//cheating
	@Test
	public void problem19() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob19.xml"));
		run(world);
	}
	

	//missing noops
	@Test
	public void problem20() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob20.xml"));
		run(world);
	}
	
	@Test
	public void problem21() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob21.xml"));
		run(world);
	}
	
	@Test
	public void problem22() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob22.xml"));
		run(world);
	}
	
	@Test
	public void problem23() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/prob23.xml"));
		run(world);
	}
	static Random random = new Random(System.nanoTime());
	public static Plan run(World world){
		char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 10; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		
		Plan plan = null;
		Path path= Paths.get(sb.toString());
		try {
			Converter.toPDDL(world, path, PDDL.AxiomGate);
//			PddlProblem.toPDDL(path, PDDL.AxiomGate, world);
			plan = Down.run(Down.domainNoUpdate, path);
			Files.deleteIfExists(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		if(plan.getCommands().isEmpty()){
			fail("\n"+world+"\nno solution found");
		}
		int i=0;
		for (Command command : plan.getCommands()) {
			if(!command.Do(world)){
				fail("\n"+world+"\n"+plan+"\nilligal action: "+i+" "+command);
			}
			world.update();
			i++;
		}
		assertTrue("Goal not reached\n"+plan+"\n"+world,world.isGoal());
		return plan;
	}
}
