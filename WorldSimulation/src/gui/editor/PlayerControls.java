package gui.editor;

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
	public void keyPressed(KeyEvent e) {
		if (e.getID() == KeyEvent.KEY_PRESSED) {
            switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				world.playerAction(Direction.up);
				world.update();
				break;
			case KeyEvent.VK_DOWN:
				world.playerAction(Direction.down);
				world.update();
				break;
			case KeyEvent.VK_LEFT:
				world.playerAction(Direction.left);
				world.update();
				break;
			case KeyEvent.VK_RIGHT:
				world.playerAction(Direction.right);
				world.update();
				break;
			case KeyEvent.VK_SPACE:
				world.update();
				break;
			default:
				break;
			}
        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
        } else if (e.getID() == KeyEvent.KEY_TYPED) {
           
        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
