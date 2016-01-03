package test;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Test;

import world.World;

public class DownwardTestLevels {

	
	@Test
	public void level01() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level01.xml"));
		DownwardTest.run(world);
	}
	
	@Test
	public void level02() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level02.xml"));
		DownwardTest.run(world);
	}
	@Test
	public void level03() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level03.xml"));
		DownwardTest.run(world);
	}
	@Test
	public void level04() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level04.xml"));
		DownwardTest.run(world);
	}
	
	@Test
	public void level05() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level05.xml"));
		DownwardTest.run(world);
		
	}
	
	@Test
	public void level06() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level06.xml"));
		DownwardTest.run(world);
	}
	
	@Test
	public void level07() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level07.xml"));
		DownwardTest.run(world);

	}
	
	//missing noops
	@Test
	public void level08() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level08.xml"));
		DownwardTest.run(world);

	}
	@Test
	public void level09() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level09.xml"));
		DownwardTest.run(world);

	}
	//slide hit faliure in sim
	@Test
	public void level10() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level10.xml"));
		DownwardTest.run(world);

	}
//	@Test
//	public void level11() throws IOException, InterruptedException{
//		World world = new World(Paths.get("levels/level11.xml"));
//		DownwardTest.run(world);
//
//	}
//	@Test
//	public void level12() throws IOException, InterruptedException{
//		World world = new World(Paths.get("levels/level12.xml"));
//		DownwardTest.run(world);
//
//	}
//	@Test
//	public void level13() throws IOException, InterruptedException{
//		World world = new World(Paths.get("levels/level13.xml"));
//		DownwardTest.run(world);
//
//	}
//	
	@Test
	public void level14() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level14.xml"));
		DownwardTest.run(world);

	}
	//missing noops
	@Test
	public void level15() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level15.xml"));
		DownwardTest.run(world);

	}
	
	@Test
	public void level16() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level16.xml"));
		DownwardTest.run(world);

	}
	
//	@Test
//	public void level17() throws IOException, InterruptedException{
//		World world = new World(Paths.get("levels/level17.xml"));
//		DownwardTest.run(world);
//
//	}
//	
	@Test
	public void level18() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level18.xml"));
		DownwardTest.run(world);

	}
	

	@Test
	public void level20() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level20.xml"));
		DownwardTest.run(world);

	}
	//impossible for no update
//	@Test
//	public void level25() throws IOException, InterruptedException{
//		World world = new World(Paths.get("levels/level25.xml"));
//		DownwardTest.run(world);
//
//	}
//	
	@Test
	public void level28() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level28.xml"));
		DownwardTest.run(world);

	}
	//missing noops
	@Test
	public void level30() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level30.xml"));
		DownwardTest.run(world);

	}
	
	
//	@Test
//	public void level31() throws IOException, InterruptedException{
//		World world = new World(Paths.get("levels/level31.xml"));
//		DownwardTest.run(world);
//
//	}
	
	@Test
	public void level32() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level32.xml"));
		DownwardTest.run(world);

	}
	
	@Test
	public void level33() throws IOException, InterruptedException{
		World world = new World(Paths.get("levels/level33.xml"));
		DownwardTest.run(world);

	}
}
