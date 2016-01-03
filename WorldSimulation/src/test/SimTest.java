package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import world.Point;
import world.World;
import world.World.Color;
import world.objects.Goal;
import world.objects.Ground;
import world.objects.MovableObject;
import world.objects.PhysObject.Direction;
import world.objects.Player;
import world.objects.Robot;
import world.objects.Stone;

public class SimTest {


	/**
	 * p g
	 * ¤¤¤
	 * @return
	 */
	public World setupWorld(){
		World world =new World(10,5);
		world.addPlayer(2,2);
		world.addGround(2,3);
		world.addGround(3,3);
		world.addGround(4,3);
		world.addGoal(4,2);
		
		return world;
	}
	
	@Test
	public void testButton(){
		/**
		 * bspwg 
		 * ¤¤¤¤¤
		 * 
		 */
		World world = new World(10, 10);
		 world.addGround(2,3);
		 world.addButton(2, 2, Color.red);
		 world.addGround(3, 3);
		 world.addStone(3,2);
		 world.addGround(4, 3);
		 world.addPlayer(4, 2);
		 world.addGate(5, 2, Color.red );
		 world.addGround(5, 3);
		 world.addGround(6, 3);
		 world.addGoal(6, 2);
		 
		 
		 assertFalse(world.isClear(5,2));
		 assertFalse(world.playerAction(Direction.right));
		 world.update();

		 assertTrue(world.getLocation(4, 2) instanceof Player);
		
		 assertTrue(world.playerAction(Direction.left));
		 world.update();
		 assertTrue(world.getLocation(4, 2) instanceof Player);
		 assertTrue(world.playerAction(Direction.right));
		 world.update();
		 assertTrue(world.getLocation(5, 2) instanceof Player);
		 
		 assertTrue(world.playerAction(Direction.right));
		 world.update();
		 assertTrue(world.getLocation(6, 2) instanceof Player);
		
		 assertTrue(world.isGoal());
	}
	
	
	@Test
	public void testButtonFail(){
		/**
		 * bspwg 
		 * ¤¤¤¤¤
		 * 
		 */
		World world = new World(10, 10);
		 world.addGround(2,3);
		 world.addButton(2, 2, Color.red);
		 world.addGround(3, 3);
		 world.addStone(3,2);
		 world.addGround(4, 3);
		 world.addPlayer(4, 2);
		 world.addGate(5, 2, Color.green );
		 world.addGround(5, 3);
		 world.addGround(6, 3);
		 world.addGoal(6, 2);
		 world.addButton(5, 5,Color.green);
		 assertEquals(2, world.getButtons().size());
		 
		 assertTrue(world.isClear(2,2));
		 assertFalse(world.isClear(3,2));
		 assertFalse(world.isClear(5,2));
		 assertFalse(world.playerAction(Direction.right));
		 world.update();
		 assertTrue(world.getLocation(4, 2) instanceof Player);
		
		 assertTrue(world.playerAction(Direction.left));
		 world.update();
		 assertTrue(world.getLocation(4, 2) instanceof Player);
		 
		 assertFalse(world.playerAction(Direction.right));
		 world.update();
		 assertTrue(world.getLocation(4, 2) instanceof Player);
		 
	}
	
	
	@Test
	public void testCreateSimple(){
		World world =setupWorld();
		
		
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 5; y++) {
				if((x==2 && (y==2 || y==3))|| (x==3 && y==3 )  || (x==4 &&  y==3) ){
					assertFalse(""+world.getLocation(x, y),world.isClear(x, y));
				}else{
					assertTrue(""+world.getLocation(x, y),world.isClear(x, y));
				}
			}
		}
		
	}
	
	@Test
	public void testFallSimple(){
		World world =setupWorld();
		world.playerAction(Direction.left);
		
		world.update();
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 5; y++) {
				if((x==2 &&  y==3)|| (x==1 && y==2 ) || (x==3 && y==3 )  || (x==4 &&  y==3) ){
					assertFalse(""+world.getLocation(x, y),world.isClear(x, y));
				}else{
					assertTrue(""+world.getLocation(x, y),world.isClear(x, y));
				}
			}
		}
		
		
		world.update();

		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 5; y++) {
				if((x==2 &&  y==3)|| (x==1 && y==3 ) || (x==3 && y==3 )  || (x==4 &&  y==3) ){
					assertFalse(""+world.getLocation(x, y),world.isClear(x, y));
				}else{
					assertTrue(""+world.getLocation(x, y),world.isClear(x, y));
				}
			}
		}
		world.update();
		world.update();
		assertTrue(""+world.getLocation(1, 4),world.isClear(1, 4));
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 5; y++) {
				if((x==2 &&  y==3) || (x==3 && y==3 )  || (x==4 &&  y==3) ){
					assertFalse(""+world.getLocation(x, y),world.isClear(x, y));
				}else{
					assertTrue(""+world.getLocation(x, y),world.isClear(x, y));
				}
			}
		}
	}
	
	@Test
	public void testFallSlide(){
//		; ps      
//		; ¤¤cc    
//		;     #cc 
//		;    g#   
//		;    ¤¤   
//		;        
		World world = new World(Paths.get("levels/prob13.xml"));
		
		assertTrue(""+world.getLocation(1, 0), world.getLocation(1, 0) instanceof Player);
		assertTrue(""+world.getLocation(2, 0), world.getLocation(2, 0) instanceof Stone);
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(1, 0), world.getLocation(1, 0) instanceof Player);
		assertTrue(""+world.getLocation(3, 0), world.getLocation(3, 0) instanceof Stone);
		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(2, 0), world.getLocation(2, 0) instanceof Player);
		assertTrue(""+world.getLocation(4, 0), world.getLocation(4, 0) instanceof Stone);
		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(3, 0), world.getLocation(3, 0) instanceof Player);
		assertTrue(""+world.getLocation(5, 0), world.getLocation(5, 0) instanceof Stone);
		
		world.update();

		assertTrue(""+world.getLocation(4, 0), world.getLocation(4, 0) instanceof Player);
		assertTrue(""+world.getLocation(5, 1), world.getLocation(5, 1) instanceof Stone);
		
		world.update();
		assertTrue(""+world.getLocation(5, 0), world.getLocation(5, 0) instanceof Player);
		assertTrue(""+world.getLocation(6, 1), world.getLocation(6, 1) instanceof Stone);
		
		world.update();
		assertTrue(""+world.getLocation(5, 1), world.getLocation(5, 1) instanceof Player);
		assertTrue(""+world.getLocation(7, 1), world.getLocation(7, 1) instanceof Stone);
		
		assertTrue(world.playerAction(Direction.down));
		world.update();
		assertTrue(""+world.getLocation(5, 2), world.getLocation(5, 2) instanceof Player);
		assertTrue(world.playerAction(Direction.down));
		
		world.update();
		assertTrue(""+world.getLocation(5, 3), world.getLocation(5, 3) instanceof Player);
		
		assertTrue(world.playerAction(Direction.left));
		world.update();
		assertTrue(""+world.getLocation(4, 3), world.getLocation(4, 3) instanceof Player);
		
		assertTrue(world.isGoal());
	}
	@Test
	public void testLadderDown(){
		/**
		 *  p
		 *  ¤#¤
		 *   #
		 *   #
		 *  ¤¤¤
		 * 
		 */
		
		World world = new World(10, 10);
		
		world.addGround(2,3);
		world.addPlayer(2,2);
		world.addGround(3,3);
		world.addLadder(3,3);
		world.addGround(4,3);
		world.addLadder(3,4);
		world.addLadder(3,5);
		world.addGround(2, 6);
		world.addGround(3, 6);
		world.addGround(4, 6);
		
		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(3, 2), world.getLocation(3, 2) instanceof Player);
		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(4, 2), world.getLocation(4, 2) instanceof Player);
		
		assertTrue(world.playerAction(Direction.left));
		world.update();
		assertTrue(""+world.getLocation(3, 2), world.getLocation(3, 2) instanceof Player);
		assertTrue(world.playerAction(Direction.down));
		world.update();
		assertTrue(""+world.getLocation(3, 3), world.getLocation(3, 3) instanceof Player);
		
		world.update();
		assertTrue(""+world.getLocation(3, 3), world.getLocation(3, 3) instanceof Player);
		
		assertTrue(world.playerAction(Direction.down));
		world.update();
		assertTrue(""+world.getLocation(3, 4), world.getLocation(3, 4) instanceof Player);
		
		assertTrue(world.playerAction(Direction.down));
		world.update();
		assertTrue(""+world.getLocation(3, 5), world.getLocation(3, 5) instanceof Player);
		
		assertTrue(world.playerAction(Direction.left));
		world.update();
		assertTrue(""+world.getLocation(2, 5), world.getLocation(2, 5) instanceof Player);

	}
	
	@Test
	public void testLadderDownFall(){
		/**
		 * p
		 * #
		 * #
		 * #
		 * g
		 * 
		 */
		
		World world = new World(Paths.get("levels/prob00.xml"));

		
		assertTrue(""+world.getLocation(1, 1), world.getLocation(1, 1) instanceof Player);
		assertTrue(world.playerAction(Direction.down));
		world.update();
		assertTrue(""+world.getLocation(1, 2), world.getLocation(1, 2) instanceof Player);
		
		assertTrue(world.playerAction(Direction.down));
		world.update();
		assertTrue(""+world.getLocation(1, 3), world.getLocation(1, 3) instanceof Player);
		
		assertTrue(world.playerAction(Direction.down));
		world.update();
		assertTrue(""+world.getLocation(1, 4), world.getLocation(1, 4) instanceof Player);
		
		assertTrue(world.playerAction(Direction.down));	
		world.update();
		assertTrue(""+world.getLocation(1, 5), world.getLocation(1, 5) instanceof Player);
	}
	
	@Test
	public void testWalkOn(){
		/**
		 *   p r  g         
		 *  ¤¤¤¤ ¤¤         
		 *      z    
		 */
		World world = new World(Paths.get("levels/prob08.xml"));

		
		assertTrue(""+world.getLocation(2, 1), world.getLocation(2, 1) instanceof Player);
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(3, 1), world.getLocation(3, 1) instanceof Player);
		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(3, 1), world.getLocation(3, 1) instanceof Player);
		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(4, 1), world.getLocation(4, 1) instanceof Player);
		
		assertTrue(world.playerAction(Direction.right));	
		world.update();
		assertTrue(""+world.getLocation(5, 1), world.getLocation(5, 1) instanceof Player);
		
		assertTrue(world.playerAction(Direction.right));	
		world.update();
		assertTrue(""+world.getLocation(6, 1), world.getLocation(6, 1) instanceof Player);
		
		assertTrue(world.playerAction(Direction.right));	
		world.update();
		assertTrue(""+world.getLocation(7, 1), world.getLocation(7, 1) instanceof Player);
		assertTrue(world.isGoal());
	}
	@Test
	public void testWalkOnGreen(){

		World world = new World(Paths.get("levels/prob17.xml"));

		assertTrue(world.playerAction(Direction.up));
		world.update();
	
		assertTrue(""+world.getLocation(1, 1), world.getLocation(1, 1) instanceof Player);
		assertTrue(world.playerAction(Direction.up));
		world.update();
		
		assertTrue(""+world.getLocation(1, 0), world.getLocation(1, 0) instanceof Player);
		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(2, 0), world.getLocation(2, 0) instanceof Player);
		
		
	}
	@Test
	public void testWalkOnFail(){
		/**
		 *   p s  g         
		 *  ¤¤¤¤ ¤¤         
		 *      z    
		 */
		World world = new World(Paths.get("levels/prob08fail.xml"));
		
		assertTrue(""+world.getLocation(2, 1), world.getLocation(2, 1) instanceof Player);
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(3, 1), world.getLocation(3, 1) instanceof Player);
		

		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(3, 1), world.getLocation(3, 1) instanceof Player);
		

		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(4, 1), world.getLocation(4, 1) instanceof Player);
		

		assertTrue(world.playerAction(Direction.right));	
		world.update();

		assertTrue(""+world.getLocation(5, 1), world.getLocation(5, 1) instanceof Player);
		assertTrue(""+world.getLocation(5, 2), world.isClear(5, 2));
		
		assertFalse(world.playerAction(Direction.right));	
		world.update();
		assertTrue(""+world.getLocation(5, 2), world.isClear(5, 2));

	}
	@Test
	public void testDestroy(){
		World world = new World(5, 4);
		world.addStone(1, 1);
		world.addGround(1, 2, Color.purple);
		assertFalse(((MovableObject)world.getLocation(1, 1)).isLegal());
		world.update();
		assertTrue(world.getLocation(1, 1)+"",world.getLocation(1, 1)==null);
		
		world.addPlayer(2,1);
		world.addGround(2, 2, Color.blue);
		
		assertFalse(((MovableObject)world.getLocation(2, 1)).isLegal());
		world.update();
		assertTrue(world.getLocation(2, 1)+"",world.isClear(2,1));
	}
	
	@Test
	public void testLadderUp(){
		/**
		 *  
		 *  ¤#¤
		 *   #
		 *   #p
		 *  ¤¤¤
		 * 
		 */
		
		World world = new World(10, 10);
		
		world.addGround(2,3);
		
		world.addGround(3,3);
		world.addLadder(3,3);
		world.addGround(4,3);
		world.addLadder(3,4);
		world.addLadder(3,5);
		world.addGround(2, 6);
		world.addGround(3, 6);
		world.addPlayer(4,5);
		world.addGround(4, 6);
		
		
		assertTrue(world.playerAction(Direction.left));
		world.update();
		assertTrue(""+world.getLocation(3, 5), world.getLocation(3, 5) instanceof Player);
		
		assertTrue(world.playerAction(Direction.up));
		world.update();
		assertTrue(""+world.getLocation(3, 4), world.getLocation(3, 4) instanceof Player);

		world.update();
		assertTrue(""+world.getLocation(3, 4), world.getLocation(3, 4) instanceof Player);
		
		assertTrue(world.playerAction(Direction.up));
		world.update();
		assertTrue(""+world.getLocation(3, 3), world.getLocation(3, 3) instanceof Player);
		
		assertFalse(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(3, 3), world.getLocation(3, 3) instanceof Player);
		
		assertTrue(world.playerAction(Direction.down));
		world.update();
		assertTrue(""+world.getLocation(3, 4), world.getLocation(3, 4) instanceof Player);
		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(4, 4), world.getLocation(4, 4) instanceof Player);
		
	}
	
	
	@Test
	public void testMoveSimple(){
		World world =setupWorld();
		world.playerAction(Direction.right);
		
		world.update();
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 5; y++) {
				if((x==2 &&  y==3)|| (x==3 && y==2 ) || (x==3 && y==3 )  || (x==4 &&  y==3) ){
					assertFalse(""+world.getLocation(x, y),world.isClear(x, y));
				}else{
					assertTrue(""+world.getLocation(x, y),world.isClear(x, y));
				}
			}
		}
		
		world.update();
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 5; y++) {
				if((x==2 &&  y==3)|| (x==3 && y==2 ) || (x==3 && y==3 )  || (x==4 &&  y==3) ){
					assertFalse(""+world.getLocation(x, y),world.isClear(x, y));
				}else{
					assertTrue(""+world.getLocation(x, y),world.isClear(x, y));
				}
			}
		}
		world.playerAction(Direction.right);
		world.update();
		assertTrue(world.getLocation(4, 2)+"",world.isGoal());
		
	}
	@Test
	public void testRobotActivate(){
		
		/**
		 *  npr  g 
		 *  ���c��
		 *        ���
		 */
		World world =new World(13,5);
		world.addRemote(3,2);
		world.addGround(3, 3);
		world.addPlayer(4,2);

		world.addGround(4,3);
		world.addGround(5,3);
		world.addRobot(5, 2, Direction.right);
		world.addGround(6,3,Color.green);
		world.addGround(7,3);
		world.addGround(8,3);
		world.addGoal(8,2);
		world.addGround(9,4);
		world.addGround(10,4);
		world.addGround(11,4);
		
		assertTrue(""+world.getLocation(4, 2),world.getLocation(4, 2) instanceof Player);
		assertTrue(""+world.getLocation(5, 2),world.getLocation(5, 2) instanceof Robot);
		//
		assertTrue(world.playerAction(Direction.left));
		world.update();
		assertTrue(world.getPlayer().hasRemote());
		
		
		assertTrue(world.playerAction(5,2));
		world.update();
		assertFalse(world.getPlayer().hasRemote());
		assertTrue(""+world.getLocation(5, 2),world.isClear(5, 2));
		assertTrue(""+world.getLocation(3, 2),world.getLocation(3, 2) instanceof Player);
		assertTrue(""+world.getLocation(6, 2),world.getLocation(6, 2) instanceof Robot);

		
		
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(6, 2),world.isClear(6, 2));
		assertTrue(""+world.getLocation(7, 2),world.getLocation(7, 2) instanceof Robot);
		
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(6, 2),world.isClear(6, 2));
		assertTrue(""+world.getLocation(8, 2),world.getLocation(8, 2) instanceof Robot);
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(8, 2),world.isClear(8, 2));
		assertTrue(""+world.getLocation(9, 2),world.getLocation(9, 2) instanceof Robot);
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(9, 2),world.isClear(9, 2));
		assertTrue(""+world.getLocation(9, 3),world.getLocation(9, 3) instanceof Robot);
		//nothing
		world.update();
		assertTrue(""+world.getLocation(9, 3),world.isClear(9, 3));
		assertTrue(""+world.getLocation(10, 3),world.getLocation(10, 3) instanceof Robot);

	}
	@Test
	public void testRobotActivateFail(){
		
		/**
		 *  pnr  g 
		 *  ¤¤¤c¤¤
		 *        ¤¤¤
		 */
		World world =new World(13,5);
		
		world.addRemote(4,2);
		world.addGround(3, 3);
		world.addPlayer(3,2);
		world.addGround(4,3);
		world.addGround(5,3);
		world.addRobot(5, 2, Direction.left);
		world.addGround(6,3,Color.green);
		world.addGround(7,3);
		world.addGround(8,3);
		world.addGoal(8,2);
		world.addGround(9,4);
		world.addGround(10,4);
		world.addGround(11,4);
		
		assertTrue(""+world.getLocation(3, 2),world.getLocation(3, 2) instanceof Player);
		assertTrue(""+world.getLocation(5, 2),world.getLocation(5, 2) instanceof Robot);
		assertFalse(world.getPlayer().hasRemote());
		//activate
		assertFalse(world.playerAction(5,2));
		world.update();
		assertTrue(""+world.getLocation(3, 2),world.getLocation(3, 2) instanceof Player);
		assertTrue(""+world.getLocation(5, 2),world.getLocation(5, 2) instanceof Robot);

		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(world.getPlayer().hasRemote());
		
		assertTrue(world.playerAction(5,2));
		world.update();
		assertTrue(""+world.getLocation(4, 2),world.getLocation(4, 2) instanceof Player);
		
		assertTrue(""+world.getLocation(5, 2),world.getLocation(5, 2) instanceof Robot);


	}
	
	@Test
	public void testRobotSimple(){
		
		/**
		 *   pr  g 
		 *   ¤¤c¤¤
		 *        ¤¤¤
		 */
		World world =new World(13,5);
		world.addPlayer(4,2);

		world.addGround(4,3);
		world.addGround(5,3);
		world.addRobot(5, 2, Direction.left);
		world.addGround(6,3,Color.green);
		world.addGround(7,3);
		world.addGround(8,3);
		world.addGoal(8,2);
		world.addGround(9,4);
		world.addGround(10,4);
		world.addGround(11,4);
		
		assertTrue(""+world.getLocation(4, 2),world.getLocation(4, 2) instanceof Player);
		assertTrue(""+world.getLocation(5, 2),world.getLocation(5, 2) instanceof Robot);
		//push
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(5, 2),world.isClear(5, 2));
		assertTrue(""+world.getLocation(4, 2),world.getLocation(4, 2) instanceof Player);
		assertTrue(""+world.getLocation(6, 2),world.getLocation(6, 2) instanceof Robot);

		
		
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(6, 2),world.isClear(6, 2));
		assertTrue(""+world.getLocation(7, 2),world.getLocation(7, 2) instanceof Robot);
		
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(6, 2),world.isClear(6, 2));
		assertTrue(""+world.getLocation(8, 2),world.getLocation(8, 2) instanceof Robot);
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(8, 2),world.isClear(8, 2));
		assertTrue(""+world.getLocation(9, 2),world.getLocation(9, 2) instanceof Robot);
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(9, 2),world.isClear(9, 2));
		assertTrue(""+world.getLocation(9, 3),world.getLocation(9, 3) instanceof Robot);
		//nothing
		world.update();
		assertTrue(""+world.getLocation(9, 3),world.isClear(9, 3));
		assertTrue(""+world.getLocation(10, 3),world.getLocation(10, 3) instanceof Robot);

	}
	
	@Test
	public void testSlideHitSimple(){
		
		/**
		 *   ps  g 
		 *   ¤¤c¤¤
		 */
		World world =new World(12,5);
		world.addPlayer(4,2);

		world.addGround(4,3);
		world.addGround(5,3);
		world.addStone(5,2);
		world.addGround(6,3,Color.green);
		world.addGround(7,3);
		world.addGround(8,3);
		world.addGoal(8,2);
		
	
		//push
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(5, 2),world.isClear(5, 2));
		assertTrue(""+world.getLocation(4, 2),world.getLocation(4, 2) instanceof Player);
		assertTrue(""+world.getLocation(6, 2),world.getLocation(6, 2) instanceof Stone);

		
		
		
		//walk
		world.playerAction(Direction.right);
		world.update();
		assertTrue(""+world.getLocation(4, 2),world.isClear(4, 2));
		assertTrue(""+world.getLocation(5, 2),world.getLocation(5, 2) instanceof Player);
		assertTrue(""+world.getLocation(6, 2),world.isClear(6, 2));
		assertTrue(""+world.getLocation(7, 2),world.getLocation(7, 2) instanceof Stone);
		
		
		//walk
		world.playerAction(Direction.right);
		world.update();
		assertTrue(""+world.getLocation(5, 2),world.isClear(5, 2));
		assertTrue(""+world.getLocation(6, 2),world.getLocation(6, 2) instanceof Player);
		assertTrue(""+world.getLocation(7, 2),world.getLocation(7, 2) instanceof Stone);
		
		//slide
		world.update();
		assertTrue(""+world.getLocation(6, 2),world.isClear(6, 2));
		assertTrue(""+world.getLocation(7, 2),world.getLocation(7, 2) instanceof Player);
		assertTrue(""+world.getLocation(8, 2),world.getLocation(8, 2) instanceof Stone);
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(6, 2),world.isClear(6, 2));
		assertTrue(""+world.getLocation(7, 2),world.getLocation(7, 2) instanceof Player);
		assertTrue(""+world.getLocation(8, 2),world.getLocation(8, 2) instanceof Stone);
		
		//push
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(7, 2),world.getLocation(7, 2) instanceof Player);
		assertTrue(""+world.getLocation(8, 2),world.isClear(8, 2));
		assertTrue(""+world.getLocation(9, 2),world.getLocation(9, 2) instanceof Stone);
		
		//walk
		world.playerAction(Direction.right);
		world.update();
		
		assertTrue(world.getLocation(8, 2)+"",world.isGoal());
	}
	@Test
	public void testSlideSimple(){
		/**
		 * p  g
		 * ¤c¤¤
		 * 
		 */
		World world =new World(10,5);
		world.addPlayer(2,2);
		world.addGround(2,3);
		world.addGround(3,3,Color.green);
		world.addGround(4,3);
		world.addGround(5,3);
		world.addGoal(5,2);

		//walk
		world.playerAction(Direction.right);
		world.update();
		
		assertTrue(world.isClear(2, 2));
		assertTrue(""+world.getLocation(3, 2) , world.getLocation(3, 2) instanceof Player);
		
		//slide
		assertFalse(world.playerAction(Direction.left));
		world.update();
		
		assertTrue(""+world.getLocation(2, 2),world.isClear(2, 2));
		assertTrue(""+world.getLocation(3, 2),world.isClear(3, 2));
		assertTrue(""+world.getLocation(4, 2),world.getLocation(4, 2) instanceof Player);
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(2, 2),world.isClear(2, 2));
		assertTrue(""+world.getLocation(3, 2),world.isClear(3, 2));
		assertTrue(""+world.getLocation(4, 2),world.getLocation(4, 2) instanceof Player);
		
		//walk
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(4, 2),world.isClear(4, 2));
		assertTrue(""+world.getLocation(5, 2),world.getLocation(5, 2) instanceof Player);
		assertTrue(world.getLocation(5, 2)+"",world.isGoal());
	}
	
	@Test
	public void testSlideStoneSimple(){
		
		/**
		 *  ps   g 
		 *  ¤¤cc¤¤¤
		 */
		World world =new World(10,5);
		world.addPlayer(2,2);

		world.addGround(2,3);
		world.addGround(3,3);
		world.addStone(3,2);
		world.addGround(4,3,Color.green);
		world.addGround(5,3,Color.green);
		world.addGround(6,3);
		world.addGround(7,3);
		world.addGoal(7,2);
		world.addGround(8,3);
		
	
		//push
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(3, 2),world.isClear(3, 2));
		assertTrue(""+world.getLocation(2, 2),world.getLocation(2, 2) instanceof Player);
		assertTrue(""+world.getLocation(4, 2),world.getLocation(4, 2) instanceof Stone);


		//nothing (slide)
		world.update();
		assertTrue(""+world.getLocation(2, 2),world.getLocation(2, 2) instanceof Player);
		assertTrue(""+world.getLocation(4, 2),world.isClear(4, 2));
		assertTrue(""+world.getLocation(5, 2),world.getLocation(5, 2) instanceof Stone);
		
		
		//nothing (stop)
		world.update();
		assertTrue(""+world.getLocation(2, 2),world.getLocation(2, 2) instanceof Player);
		assertTrue(""+world.getLocation(5, 2),world.isClear(5, 2));
		assertTrue(""+world.getLocation(6, 2),world.getLocation(6, 2) instanceof Stone);
		
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(2, 2),world.getLocation(2, 2) instanceof Player);
		assertTrue(""+world.getLocation(5, 2),world.isClear(5, 2));
		assertTrue(""+world.getLocation(7, 2),world.isClear(7, 2));
		assertTrue(""+world.getLocation(6, 2),world.getLocation(6, 2) instanceof Stone);
		
		//nothing
		world.update();
		assertTrue(""+world.getLocation(2, 2),world.getLocation(2, 2) instanceof Player);
		assertTrue(""+world.getLocation(5, 2),world.isClear(5, 2));
		assertTrue(""+world.getLocation(7, 2),world.isClear(7, 2));
		assertTrue(""+world.getLocation(6, 2),world.getLocation(6, 2) instanceof Stone);
		
	}
	
	@Test
	public void testStoneSimple(){
		
		/**
		 *  ps   g 
		 *  ¤¤¤¤¤¤¤
		 */
		World world =new World(10,5);
		world.addPlayer(2,2);

		world.addGround(2,3);
		world.addGround(3,3);
		world.addStone(3,2);
		world.addGround(4,3);
		world.addGround(5,3);
		world.addGround(6,3);
		world.addGround(7,3);
		world.addGoal(7,2);
		world.addGround(8,3);
		
	
		//push
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(3, 2),world.isClear(3, 2));
		assertTrue(""+world.getLocation(2, 2),world.getLocation(2, 2) instanceof Player);
		assertTrue(""+world.getLocation(4, 2),world.getLocation(4, 2) instanceof Stone);


		//nothing
		world.update();
		assertTrue(""+world.getLocation(3, 2),world.isClear(3, 2));
		assertTrue(""+world.getLocation(2, 2),world.getLocation(2, 2) instanceof Player);
		assertTrue(""+world.getLocation(4, 2),world.getLocation(4, 2) instanceof Stone);
		
		//walk
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(2, 2),world.isClear(2, 2));
		assertTrue(""+world.getLocation(3, 2),world.getLocation(3, 2) instanceof Player);
		assertTrue(""+world.getLocation(4, 2),world.getLocation(4, 2) instanceof Stone);
		
		
		//push
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertTrue(""+world.getLocation(4, 2),world.isClear(4, 2));
		assertTrue(""+world.getLocation(3, 2),world.getLocation(3, 2) instanceof Player);
		assertTrue(""+world.getLocation(5, 2),world.getLocation(5, 2) instanceof Stone);


		//nothing
		assertTrue(""+world.getLocation(4, 2),world.isClear(4, 2));
		assertTrue(""+world.getLocation(3, 2),world.getLocation(3, 2) instanceof Player);
		assertTrue(""+world.getLocation(5, 2),world.getLocation(5, 2) instanceof Stone);
	}
	
	@Test
	public void testTeleport(){
		/**
		 *  pt 
		 * ¤¤¤¤¤
		 *  tg
		 * ¤¤¤¤¤
		 * 
		 */
		World world = new World(10, 10);
		 world.addGround(2,3);
		 world.addGround(3, 3);
		 world.addGround(4, 3);
		 world.addPlayer(4, 2);
		 world.addTeleport(5, 2);
		 world.addTeleport(4, 4);
		 world.addGround(5, 3);
		 world.addGround(6, 3);

		 
		 world.addGround(2,5);
		 world.addGround(3,5);
		 world.addGround(4, 5);
		 world.addGoal(5, 4);
		 world.addGround(5, 5);
		 world.addGround(6, 5);
		 
		 //move
		 assertTrue(world.playerAction(Direction.right));
		 world.update();
		 
		 //TODO: should the teleport effect be delayed or not?
//		 assertTrue(world.getLocation(5, 2) instanceof Player);
//		 
//		 //teleport
//		 assertFalse(world.playerAction(Direction.right));
//		 world.update();
		 assertTrue(world.getLocation(4, 4) instanceof Player);
		 
		 //move
		 assertTrue(world.playerAction(Direction.right));
		 world.update();
		 assertTrue(world.getLocation(5, 4) instanceof Player);
		 
		 assertTrue(world.isGoal());
	}
	
	@Test
	public void testXmlWrite(){
		
		/**
		 *  ps   g 
		 *  ¤¤cc¤¤¤
		 */
		World world =new World(10,5);
		world.addPlayer(2,2);

		world.addGround(2,3);
		world.addGround(3,3);
		world.addStone(3,2);
		world.addGround(4,3,Color.green);
		world.addGround(5,3,Color.green);
		world.addGround(6,3);
		world.addGround(7,3);
		world.addGoal(7,2);
		world.addGround(8,3);
		
		try {
			world.toXml("test.xml");
			File fXmlFile = new File("test.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);


			doc.getDocumentElement().normalize();

			assertEquals(5, Integer.parseInt(doc.getDocumentElement().getAttributeNode("height").getValue()));
			assertEquals(10, Integer.parseInt(doc.getDocumentElement().getAttributeNode("width").getValue()));

			NodeList nList = doc.getElementsByTagName("Ground");
			assertEquals(7, nList.getLength());
			
			nList = doc.getElementsByTagName("Player");
			assertEquals(1, nList.getLength());
			
			nList = doc.getElementsByTagName("Stone");
			assertEquals(1, nList.getLength());
			
			nList = doc.getElementsByTagName("Goal");
			assertEquals(1, nList.getLength());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testXmlRead() throws SAXException, IOException, ParserConfigurationException{
		/**
		 *  ps   g 
		 *  ��cc���
		 */
		World world= new World(Paths.get("test.xml"));
		
		assertEquals(5, world.getHeight());
		assertEquals(10, world.getWidth());
		assertTrue(world.getLocation(2, 2) instanceof Player);
		assertTrue(world.getLocation(2, 3) instanceof Ground);
		assertTrue(world.getLocation(3, 3) instanceof Ground);
		assertTrue(world.getLocation(3, 2) instanceof Stone);
		assertTrue(world.getLocation(4, 3) instanceof Ground);
		assertEquals(Color.green, ((Ground)world.getLocation(4, 3)).getColor());
		assertTrue(world.getLocation(5, 3) instanceof Ground);
		assertEquals(Color.green, ((Ground)world.getLocation(5, 3)).getColor());
		assertTrue(world.getLocation(6, 3) instanceof Ground);
		assertTrue(world.getLocation(7, 3) instanceof Ground);
		assertTrue(world.getLocation(7, 2)+"",world.getLocation(7, 2) instanceof Goal);
		assertTrue(world.getLocation(8, 3) instanceof Ground);
	
	}
	
	@Test
	public void testFalling(){
		/**
		 *    s          
		 * p  r          
		 * ¤¤¤¤  ¤¤¤#¤cc 
		 *     ¤¤   #    
		 *          #    
		 * ¤¤¤    r #    
		 *      ¤¤¤¤¤¤#  
		 *            #  
		 *   gr ccccc¤¤  
		 * ¤¤¤¤¤ 
		 */
		World world= new World(Paths.get("levels/level04.xml"));
		assertEquals(new Point(1,2), world.getPlayer().getPosition());
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertEquals(new Point(2,2), world.getPlayer().getPosition());
		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertEquals(new Point(3,2), world.getPlayer().getPosition());
		assertTrue(world.getLocation(4, 2) instanceof Robot);
		assertTrue(world.getLocation(4, 1) instanceof Stone);
		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertEquals(new Point(3,2), world.getPlayer().getPosition());
		assertTrue(world.getLocation(5, 2) instanceof Robot);
		assertTrue(world.getLocation(4, 2)+"",world.getLocation(4, 2) instanceof Stone);
		
		assertTrue(world.playerAction(Direction.right));
		world.update();
		assertEquals(new Point(3,2), world.getPlayer().getPosition());
		assertTrue(world.getLocation(5, 3) instanceof Robot);
		assertTrue(world.getLocation(5, 2) instanceof Stone);
	}
	
	@Test
	public void testBootGreen(){
		
		World world = new World(10, 5);
		world.addPlayer(2, 2);
		world.addGround(2, 3);
		world.addBoot(3, 2, Color.green);
		world.addGround(3,3);
		world.addGround(4, 3, Color.green);
		
		world.playerAction(Direction.right);
		world.update();
		assertTrue(world.getLocation(3, 2) instanceof Player);
		
		world.playerAction(Direction.right);
		world.update();
		assertTrue(world.getLocation(4, 2) instanceof Player);
		
		world.update();
		assertTrue(world.getLocation(4, 2) instanceof Player);
		
		world.update();
		assertTrue(world.getLocation(4, 2) instanceof Player);
	}
	
	@Test
	public void testBootBlue(){
		
		World world = new World(10, 5);
		world.addPlayer(2, 2);
		world.addGround(2, 3);
		world.addBoot(3, 2, Color.blue);
		world.addGround(3,3);
		world.addGround(4, 3, Color.blue);
		
		world.playerAction(Direction.right);
		world.update();
		assertTrue(world.getLocation(3, 2) instanceof Player);
		
		world.playerAction(Direction.right);
		world.update();
		assertTrue(world.getLocation(4, 2) instanceof Player);
		
		world.update();
		assertTrue(world.getLocation(4, 2) instanceof Player);
		
		world.update();
		assertTrue(world.getLocation(4, 2) instanceof Player);
	}
	
	@Test
	public void testBoots(){
		
		World world = new World(10, 5);
		world.addPlayer(2, 2);
		world.addGround(2, 3);
		world.addBoot(3, 2, Color.blue);
		world.addGround(3,3);
		world.addBoot(4, 2, Color.green);
		world.addGround(4, 3);
		world.addGround(5, 3, Color.blue);
		
		world.playerAction(Direction.right);
		world.update();
		assertTrue(world.getLocation(3, 2) instanceof Player);
		
		world.playerAction(Direction.right);
		world.update();
		assertTrue(world.getLocation(4, 2) instanceof Player);
		
		world.playerAction(Direction.right);
		world.update();
		assertTrue(world.isClear(5, 2));
		assertTrue(world.getPlayer()==null);

	}

	
	@Test
	public void testLevel25(){
		
		World world = new World(Paths.get("levels/level25.xml"));

		assertEquals("Stone 2:9",world.getLocation(2, 9).toString());
		world.playerAction(Direction.right);
		world.update();
		assertTrue(world.getPlayer().toString(),world.getLocation(1, 10) instanceof Player);
		assertEquals("Stone 2:9",world.getLocation(2, 9).toString());
		
		world.playerAction(Direction.right);
		world.update();
		assertTrue(world.getPlayer().toString(),world.getLocation(1, 10) instanceof Player);
		assertNull(world.getLocation(3, 9));
		assertEquals("Stone 2:9",world.getLocation(2, 9).toString());
		
		world.playerAction(Direction.right);
		world.update();
		assertTrue(world.getPlayer().toString(),world.getLocation(1, 10) instanceof Player);
		assertNull(world.getLocation(3, 9));
	}
}
