package gui.world;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import world.Point;
import world.World.Type;

public class Tile extends JLabel{

	Point position;

	/**
	 * 
	 */
	private static final long serialVersionUID = -8347905137731878617L;

	Type typeBack = null;
	Type typeMid = null;
	Type typeFor = null;

	JWorld parrent;

	public Tile(ImageIcon imageIcon, JWorld parrent) {
		super(imageIcon);
		this.setOpaque(false);
		this.parrent=parrent;
		this.setPreferredSize(new Dimension(48, 48));
	}

	public Tile(Point position, JWorld parrent) {
		super();
		this.position=position;
		this.setOpaque(false);
		this.parrent=parrent;
		this.setPreferredSize(new Dimension(48, 48));
	}

	public void setType(Type type){


		switch (type) {
		case goal:
		case ground:	
		case groundBlue:
		case groundGreen:
		case groundPurple:	
		case teleport:
		case start:
			typeBack=type;
			break;

		case ladder:
		case buttonRed:
		case buttonYellow:
		case buttonBlue:
		case gateRed:
		case gateBlue:
		case gateYellow:
			typeMid=type;
			break;
		
		case player:
		case stone:	
		case robotLeft:
		case robotRight:	
		case bootBlue:
		case bootGreen:
		case bootPurple:
		case remote:
			typeFor=type;
			break;
		default:
			System.err.println("Tile: unknown type "+type);
			System.exit(-3);
			break;

		}
		this.repaint();
	}


	public Point getPosition(){
		return new Point(position);
	}

	@Override
	public void paint(Graphics g){
		super.paint(g);

	}

	@Override
	protected void paintComponent(Graphics g){
		int x, y;
		if(typeBack!=null){
			Image image =parrent.getImageIcon(typeBack);
			x=(this.getWidth()-image.getWidth(null))/2;				
			y=(this.getHeight()-image.getHeight(null));
			g.drawImage(image, x, y, null);
		}
		if(typeMid!=null){
			Image image =parrent.getImageIcon(typeMid);
			x=(this.getWidth()-image.getWidth(null))/2;				
			y=(this.getHeight()-image.getHeight(null));
			g.drawImage(image, x, y, null);
		}
		if(typeFor!=null){
			Image image =parrent.getImageIcon(typeFor);
			x=(this.getWidth()-image.getWidth(null))/2;				
			y=(this.getHeight()-image.getHeight(null));
			g.drawImage(image, x, y, null);
		}
	}

	public void clear() {
		typeBack=null;
		typeMid=null;
		typeFor=null;
		repaint();

	}
}
