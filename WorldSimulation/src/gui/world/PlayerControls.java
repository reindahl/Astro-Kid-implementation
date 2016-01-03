package gui.world;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import world.World;
import world.objects.PhysObject.Direction;

public class PlayerControls implements KeyListener {
	World world;
	public PlayerControls(World world) {
		this.world=world;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    System.out.println(keyCode);
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            world.playerAction(Direction.up);
	            world.update();
	            break;
	        case KeyEvent.VK_DOWN:
	        	world.playerAction(Direction.up);
	            world.update();
	            break;
	        case KeyEvent.VK_LEFT:
	        	world.playerAction(Direction.up);
	            world.update();
	            break;
	        case KeyEvent.VK_RIGHT :
	        	world.playerAction(Direction.up);
	            world.update();
	            break;
	     }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
