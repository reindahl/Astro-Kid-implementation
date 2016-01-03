package world.objects;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import world.Point;
import world.World;
import world.World.Type;

public abstract class PhysObject {
	
	public String name;
	
	public enum Direction{
		left, right, up, down
	}
	
	World world;
	
	protected Point position;

	
	public PhysObject(World world, Point position){
		this.position=position;
		this.world=world;
	}
	

	
	public Point relativTo(Direction dir){
		return position.relativTo(dir);

	}
	
	public abstract Type getType();
	
	public Point getPosition(){
		return position;
	}
	public int getX() {
		
		return position.getX();
	}

	public int getY() {
		
		return position.getY();
	}
	
	public String getName() {
		
		return name;
	}
	public abstract Character getChar();
	
	public abstract Boolean isSolid();

	

	public void setPosition(Point position) {
		this.position = position;
	}
	
	public abstract Element toXml(Document doc);
}
