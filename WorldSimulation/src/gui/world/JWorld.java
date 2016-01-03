package gui.world;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import world.Point;
import world.World;
import world.World.Type;

public class JWorld extends JPanel implements Observer{

	public Tile[][] tmap;
	public World world;
	public MouseListener mapListener;
	BufferedImage background;

	BufferedImage[] images= new BufferedImage[Type.values().length];
	Image[] imagesScaled= new Image[images.length];
	
	public int rows, cols;
	
	int heightOld, widthOld;
	/**
	 * 
	 */
	private static final long serialVersionUID = -1982096666518655356L;

	public JWorld(World world) {
		this.world=world;
		mapListener= new MapListener(this);
		init();
	}
	public JWorld(int width, int height) {
		world = new World(width, height);

		mapListener= new MapListener(this);
		init();
	}
	public JWorld(LayoutManager arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JWorld(boolean arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public JWorld(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public void init(){
		try {
			background = ImageIO.read(new File("images/"+"background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Type type : Type.values()) {
			try {
				images[type.ordinal()]=ImageIO.read(new File("images/"+type.toString()+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println(type.toString());
				e.printStackTrace();
			}
		}
		

		int width = cols=world.width;
		int height = rows=world.height;
		
		tmap= new Tile[width][height];

		world.addObserver(this);
		this.setLayout(new GridLayout(rows,cols));
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				Tile label = new Tile(new Point(x, y),this);
				label.setName(x+","+y);
				label.setPreferredSize(new Dimension(30, 30));
				label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				label.addMouseListener(mapListener);
				tmap[x][y]= label;
				this.add(label);
			}
		}

	}




	@Override
	public void paint(Graphics g){
		if(this.getHeight() != heightOld || this.getWidth() != widthOld){
			heightOld=this.getHeight();
			widthOld=this.getWidth();
			resizeIcons();
		}
		super.paint(g);
	}


	private void resizeIcons() {
		
		int height =this.getHeight();
		int width = this.getWidth();
		int magic;
		if(height/rows>width/cols){
			magic=width/cols;
		}else{
			magic=height/rows;
		}
		
		for (int i = 0; i < images.length; i++) {
			if(images[i].getWidth()>images[i].getHeight()){
				width = magic;
				height = (int) (images[i].getHeight()/((double)images[i].getWidth())*magic);
			}else{
				width = (int) (images[i].getWidth()/((double)images[i].getHeight())*magic);
				height = magic;
			}
			if(height<=0)
				height=1;
			if(width<=0)
				width=1;

			imagesScaled[i]= images[i].getScaledInstance(width, height, Image.SCALE_SMOOTH);
		}
		
	}

	public Image getImageIcon(Type type){
		return imagesScaled[type.ordinal()];
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Update view intelligently
		System.out.println("updated");
		
		for (int i = 0; i < tmap.length; i++) {
			for (int j = 0; j < tmap[0].length; j++) {
				
				Tile t=tmap[i][j];
				t.clear();
				world.getLocationType(i, j).forEach(type->t.setType(type));
			}
		}
		repaint();
	}
}