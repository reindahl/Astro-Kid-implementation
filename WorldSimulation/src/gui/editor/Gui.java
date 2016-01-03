package gui.editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.world.JWorld;
import world.World;
import world.World.Type;

public class Gui {

	JWorld map;
	JFrame frame;
	
	public static ToolListener toolListner= new ToolListener();
	JComboBox<Integer> heightCombo;
	JComboBox<Integer> widthCombo;
	MenuListener menuListener;
	ComboBoxRenderer renderer = new ComboBoxRenderer();
	String imageFolder ="images/";
	
	JPanel mapPanel;
	
	public Gui(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		

		frame=new JFrame("Editor");
		
		
		try {
			frame.setIconImage(ImageIO.read(new File("icon.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuListener= new MenuListener(this);
		
		JMenuBar menu= new JMenuBar();
		JMenu file = new JMenu("File");
		menu.add(file);
		JMenuItem generate =new JMenuItem("generate pddl");
		generate.setName("pddl");
		generate.addActionListener(menuListener);
		file.add(generate);
		JMenuItem save =new JMenuItem("save");
		save.setName("save");
		save.addActionListener(menuListener);
		file.add(save);
		JMenuItem open =new JMenuItem("open");
		open.setName("open");
		open.addActionListener(menuListener);
		file.add(open);
		
		JMenuItem run =new JMenuItem("run");
		run.setName("run");
		run.addActionListener(menuListener);
		file.add(run);
		
		JMenuItem play = new JMenuItem("play");
		play.setName("play");
		play.addActionListener(menuListener);
		file.add(play);
		
		menu.add(new JSeparator(SwingConstants.VERTICAL));
		Integer[] numbers= new Integer[20];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i]=i+1;
		}
		int height=8,width=15;
		
		JLabel heightLabel= new JLabel("height:");
		heightLabel.setForeground(menu.getForeground());
		menu.add(heightLabel);
		heightCombo = new JComboBox<>(numbers);
		heightCombo.setSelectedIndex(height-1);
		heightCombo.setName("height");
		heightCombo.addActionListener(menuListener);
		heightCombo.setOpaque(false);
		menu.add(heightCombo);
		
		
		JLabel widthLabel= new JLabel("width:");
		widthLabel.setForeground(menu.getForeground());
		menu.add(widthLabel);
		widthCombo = new JComboBox<>(numbers);
		widthCombo.setName("width");
		widthCombo.setSelectedIndex(width-1);
		widthCombo.addActionListener(menuListener);
		widthCombo.setOpaque(false);
		menu.add(widthCombo);
		frame.setJMenuBar(menu);

//		LayoutManager border= new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS);
		LayoutManager border= new BorderLayout();
		frame.setLayout(border);
		
		
		



		map = new JWorld(width,height);
		
		
		mapPanel= new JPanel();
		mapPanel.setLayout(new BorderLayout());
		mapPanel.add(map);
		frame.add(mapPanel, BorderLayout.CENTER);
		
		frame.add(tools(), BorderLayout.EAST);
		
		frame.pack();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int screenWidth = gd.getDisplayMode().getWidth();
		int screenHeight = gd.getDisplayMode().getHeight();
		frame.setLocation(screenWidth/2-frame.getWidth()/2, screenHeight/3-frame.getHeight()/2);
	
		frame.setVisible(true);
	}

	public Gui(World world, Boolean Exit, boolean Controls) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		JFrame frame=new JFrame("Astro Kid");
		if(Exit){
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}else{
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		if(Controls){
			frame.addKeyListener(new PlayerControls(world));
		}
		BorderLayout border= new BorderLayout();
		frame.setLayout(border);


		map = new JWorld(world);
		

		frame.add(map);
		frame.pack();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int screenWidth = gd.getDisplayMode().getWidth();
		int screenHeight = gd.getDisplayMode().getHeight();
		frame.setLocation(screenWidth/2-frame.getWidth()/2, screenHeight/3-frame.getHeight()/2);
		map.update(world, null);
		frame.setVisible(true);
	}

	public void setWorld(World world){
		mapPanel.remove(map);
		menuListener.disable=true;
		heightCombo.setSelectedItem(world.height);
		widthCombo.setSelectedItem(world.width);
		menuListener.disable=false;
		map= new JWorld(world);

		mapPanel.add(map);
		frame.pack();
		map.update(world, null);

	}
	
	public JPanel tools(){
		JPanel tools= new JPanel();
		
		tools.setLayout(new GridLayout(6, 2));
		JButton start=new JButton(new ImageIcon(imageFolder+Type.player.toString()+".png"));
		start.setPreferredSize(new Dimension(75, 75));
		start.setName("player");
		start.addActionListener(toolListner);
		tools.add(start);
		
		JButton goal=new JButton(new ImageIcon(imageFolder+"goal.png"));
		goal.setPreferredSize(new Dimension(75, 75));
		goal.setName("goal");
		goal.addActionListener(toolListner);
		tools.add(goal);
		
		
		 Object[] items =
		        {
		            new ImageIcon(imageFolder+Type.ground.toString()+".png"),
		            new ImageIcon(imageFolder+Type.groundBlue.toString()+".png"),
		            new ImageIcon(imageFolder+Type.groundGreen.toString()+".png"),
		            new ImageIcon(imageFolder+Type.groundPurple.toString()+".png")
		        };
		 
		JComboBox<Object> grounds= new JComboBox<>(items);
//		grounds.setRenderer(renderer);
		grounds.setName("grounds");
		grounds.addActionListener(toolListner);
		tools.add(grounds);
		
		JButton ladder=new JButton(new ImageIcon(imageFolder+Type.ladder.toString()+".png"));
		ladder.setPreferredSize(new Dimension(75, 75));
		ladder.setName("ladder");
		ladder.addActionListener(toolListner);
		tools.add(ladder);
		
		JButton stone=new JButton(new ImageIcon(imageFolder+Type.stone.toString()+".png"));
		stone.setPreferredSize(new Dimension(75, 75));
		stone.setName("stone");
		stone.addActionListener(toolListner);
		tools.add(stone);
		
		 Object[] items2 =
		        {
		            new ImageIcon(imageFolder+Type.robotLeft.toString()+".png"),
		            new ImageIcon(imageFolder+Type.robotRight.toString()+".png"),

		      
		        };
		JComboBox<Object> robots= new JComboBox<>(items2);
//		robots.setRenderer(renderer);
		robots.setName("robots");
		robots.addActionListener(toolListner);
		tools.add(robots);
		
		
		Object[] items3 =
	        {
	            new ImageIcon(imageFolder+Type.gateRed.toString()+".png"),
	            new ImageIcon(imageFolder+Type.gateBlue.toString()+".png"),
	            new ImageIcon(imageFolder+Type.gateYellow.toString()+".png"),
	        };
		JComboBox<Object> gates= new JComboBox<>(items3);
//		gates.setRenderer(renderer);
		gates.setName("gates");
		gates.addActionListener(toolListner);
		tools.add(gates);
		
		Object[] items4 =
	        {
	            new ImageIcon(imageFolder+Type.buttonRed.toString()+".png"),
	            new ImageIcon(imageFolder+Type.buttonBlue.toString()+".png"),
	            new ImageIcon(imageFolder+Type.buttonYellow.toString()+".png"),
	        };
		JComboBox<Object> buttons= new JComboBox<>(items4);
//		buttons.setRenderer(renderer);
		buttons.setName("buttons");
		buttons.addActionListener(toolListner);
		tools.add(buttons);
		
		JButton teleport=new JButton(new ImageIcon(imageFolder+Type.teleport.toString()+".png"));
		teleport.setPreferredSize(new Dimension(75, 75));
		teleport.setName(Type.teleport.toString());
		teleport.addActionListener(toolListner);
		tools.add(teleport);
		
		JButton remote=new JButton(new ImageIcon(imageFolder+Type.remote.toString()+".png"));
		remote.setPreferredSize(new Dimension(75, 75));
		remote.setName(Type.remote.toString());
		remote.addActionListener(toolListner);
		tools.add(remote);
		
		
		 Object[] items5 =
		        {
		            new ImageIcon(imageFolder+Type.bootGreen.toString()+".png"),
		            new ImageIcon(imageFolder+Type.bootBlue.toString()+".png"),
		            new ImageIcon(imageFolder+Type.bootPurple.toString()+".png"),
		        };
		JComboBox<Object> boots= new JComboBox<>(items5);
//		boots.setRenderer(renderer);
		boots.setName("boots");
		boots.addActionListener(toolListner);
		tools.add(boots);
		return tools;
	}
	
	public static void main(String[] args) {
		
		new Gui();
	}

}
