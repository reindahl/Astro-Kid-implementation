package gui.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;

import world.World.Type;

public class ToolListener implements ActionListener{
	
	public Type selected =Type.player;
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println(((JComponent)e.getSource()).getName());
		if(e.getSource() instanceof JComboBox<?>){
			JComboBox<?> combo=(JComboBox<?>) e.getSource();
			if(combo.getName().equals("robots")){
				switch (combo.getSelectedIndex()) {
				case 0:
					selected =Type.robotLeft;
					break;
				case 1:
					selected =Type.robotRight;
					break;
				default:
					System.err.println("fuck2");
					break;
				}
			}else if(combo.getName().equals("grounds")){
				switch (combo.getSelectedIndex()) {
				case 0:
					selected =Type.ground;
					break;
				case 1:
					selected =Type.groundBlue;
					break;
				case 2:
					selected =Type.groundGreen;
					break;
				case 3:
					selected =Type.groundPurple;
					break;
				default:
					System.err.println("fuck");
					break;
				}

			}else if(combo.getName().equals("boots")){
				switch (combo.getSelectedIndex()) {
				case 1:
					selected =Type.bootBlue;
					break;
				case 0:
					selected =Type.bootGreen;
					break;
				case 2:
					selected =Type.bootPurple;
					break;
				default:
					System.err.println("fuck");
					break;
				}

			}else if(combo.getName().equals("buttons")){
				switch (combo.getSelectedIndex()) {
				case 0:
					selected =Type.buttonRed;
					break;
				case 2:
					selected =Type.buttonYellow;
					break;
				case 1:
					selected =Type.buttonBlue;
					break;
				default:
					System.err.println("fuck");
					break;
				}

			}else if(combo.getName().equals("gates")){
				switch (combo.getSelectedIndex()) {
				case 0:
					selected =Type.gateRed;
					break;
				case 1:
					selected =Type.gateBlue;
					break;
				case 2:
					selected =Type.gateYellow;
					break;

				default:
					System.err.println("fuck");
					break;
				}

			}
		}else{
			selected=Type.valueOf(((JComponent)e.getSource()).getName());
		}
		
	}


}
