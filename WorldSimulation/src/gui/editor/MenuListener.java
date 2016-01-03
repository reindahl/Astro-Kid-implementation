package gui.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import gui.run.ShowPlan;
import pddl.Converter;
import world.World;

public class MenuListener implements ActionListener {

	Gui gui;
	boolean disable=false;

	public MenuListener(Gui gui) {
		this.gui=gui;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {

		;
		switch (((JComponent) e.getSource()).getName()) {
		case "pddl":
			pddl();
			break;
		case "open":
			open();
			break;
		case "save":
			save();
			break;
		case "run":
			run();
			break;
		case "play":
			play();
			break;
		case "width":
			if(!disable)
			changeSize((int) ((JComboBox<Integer>)e.getSource()).getSelectedItem(), gui.map.rows);
			break;
		case "height":
			if(!disable)
			changeSize(gui.map.cols,(int) ((JComboBox<Integer>)e.getSource()).getSelectedItem());
			break;
		default:
			break;
		}


	}

	private void play() {
		Path path= Paths.get("tmp.xml");
		try {
			gui.map.world.toXml(path.toString());
			new Gui(new World(path), false, true);
			Files.deleteIfExists(path);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	private void changeSize(int width, int height) {
		System.out.println(width +" "+height);
		if(width!= gui.map.cols || height != gui.map.rows){
			gui.setWorld(new World(width, height));
		}
		
	}

	private void run() {
		
		Thread thread = new Thread(new ShowPlan(gui.map.world));
		thread.start();


	}

	private void pddl(){
		JFileChooser chooser=new JFileChooser();

		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		File workingDirectory = new File(System.getProperty("user.dir")+"/pddl");
		chooser.setCurrentDirectory(workingDirectory);
		chooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "pddl";
			}

			@Override
			public boolean accept(File f) {
				if(f.getName().endsWith(".pddl") || f.isDirectory()){
					return true;
				}
				return false;
			}
		});
		int returnVal = chooser.showSaveDialog(gui.frame);

		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String path=chooser.getSelectedFile().getPath();
			System.out.println(path);
			if(!path.endsWith(".pddl")){
				path=path.concat(".pddl");
			}

			String[] tmp=path.split("(.pddl)|/");
			String name =tmp[tmp.length-1];
			try {

				Files.write(Paths.get(path), Converter.toPDDL(gui.map.world, name));
			} catch (IOException e1) {

				e1.printStackTrace();
			}


		}else{
			System.out.println("no file saved");

		}
	}
	private void open(){
		JFileChooser chooser=new JFileChooser();

		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		File workingDirectory = new File(System.getProperty("user.dir")+"/levels");
		chooser.setCurrentDirectory(workingDirectory);
		chooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "xml";
			}

			@Override
			public boolean accept(File f) {
				if(f.getName().endsWith(".xml") || f.isDirectory()){
					return true;
				}
				return false;
			}
		});
		int returnVal = chooser.showOpenDialog(gui.frame);

		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String path=chooser.getSelectedFile().getPath();
			System.out.println(path);
			try {
				World world=new World(Paths.get(path));
				System.out.println(world);
				gui.setWorld(world);
			} catch (Exception e1) {

				e1.printStackTrace();
			}


		}else{
			System.out.println("no file saved");

		}
	}

	private void save(){
		JFileChooser chooser=new JFileChooser();

		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		File workingDirectory = new File(System.getProperty("user.dir")+"/levels");
		chooser.setCurrentDirectory(workingDirectory);
		chooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "xml";
			}

			@Override
			public boolean accept(File f) {
				if(f.getName().endsWith(".xml") || f.isDirectory()){
					return true;
				}
				return false;
			}
		});
		int returnVal = chooser.showSaveDialog(gui.frame);

		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String path=chooser.getSelectedFile().getPath();
			System.out.println(path);
			if(!path.endsWith(".xml")){
				path=path.concat(".xml");
			}
			try {

				gui.map.world.toXml(path);
			} catch (Exception e1) {

				e1.printStackTrace();
			}


		}else{
			System.out.println("no file saved");

		}
	}
}
