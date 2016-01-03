package gui.world;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import gui.editor.Gui;
import world.World.Color;
import world.objects.PhysObject.Direction;

public class MapListener implements MouseListener {
	
	JWorld map;


	public MapListener(JWorld jWorld) {
		map=jWorld;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){
			//add
			Tile tile=((Tile)e.getSource());
			tile.setType(Gui.toolListner.selected);
			switch (Gui.toolListner.selected) {
			case player:
				tile.setType(world.World.Type.start);
				map.world.addPlayer(tile.getPosition());
				break;
			case goal:
				map.world.addGoal(tile.getPosition());
				break;	
			case stone:
				map.world.addStone(tile.getPosition());
				break;	
			case ground:
				map.world.addGround(tile.getPosition());
				break;	
			case groundBlue:
				map.world.addGround(tile.getPosition(),Color.blue);
				break;	
			case groundGreen:
				map.world.addGround(tile.getPosition(),Color.green);
				break;	
			case groundPurple:
				map.world.addGround(tile.getPosition(),Color.purple);
				break;	
			case ladder:
				map.world.addLadder(tile.getPosition());
				break;	
			case robotLeft:
				map.world.addRobot(tile.getPosition(),Direction.left);
				break;	
			case robotRight:
				map.world.addRobot(tile.getPosition(),Direction.right);
				break;
			case gateRed:
				map.world.addGate(tile.getPosition(), Color.red);
				break;
			case gateBlue:
				map.world.addGate(tile.getPosition(), Color.blue);
				break;
			case gateYellow:
				map.world.addGate(tile.getPosition(), Color.yellow);
				break;
			case buttonRed:
				map.world.addButton(tile.getPosition(), Color.red);
				break;
			case buttonBlue:
				map.world.addButton(tile.getPosition(), Color.blue);
				break;
			case buttonYellow:
				map.world.addButton(tile.getPosition(), Color.yellow);
				break;
			case remote:
				map.world.addRemote(tile.getPosition());
				break;
			case teleport:
				map.world.addTeleport(tile.getPosition());
				break;
			case bootGreen:
				map.world.addBoot(tile.getPosition(),Color.green);
				break;	
			case bootBlue:
				map.world.addBoot(tile.getPosition(),Color.blue);
				break;	
			case bootPurple:
				map.world.addBoot(tile.getPosition(),Color.purple);
				break;	
			default:
				System.err.println("unkown type: "+ Gui.toolListner.selected);
				System.exit(-1);
				break;
			}
			
		}else if(SwingUtilities.isRightMouseButton(e)){
			((Tile)e.getSource()).clear();
			//remove
			map.world.clear(((Tile)e.getSource()).getPosition());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		
	}


}
