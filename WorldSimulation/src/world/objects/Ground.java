package world.objects;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import world.Point;
import world.World;
import world.World.Color;
import world.World.Type;

public class Ground extends PhysObject{

	Color color;
	public Ground(World world, Point position) {
		super(world,position);
		color=Color.brown;
	}

	public Ground(World world, Point position, Color color) {
		super(world, position);
		this.color=color;
	}
	
	public Color getColor(){
		return color;
	}
	
	@Override
	public String toString(){
		return "Ground: "+color+" "+position;
	}

	@Override
	public Character getChar() {
		if(color==Color.green){
			return 'c';
		}
		if(color==Color.blue){
			return 'z';
		}
		if(color==Color.purple){
			return 'x';
		}
		return '¤';
	}
	
	@Override
	public Boolean isSolid() {
		return true;
	}
	
	@Override
	public Type getType() {
		switch (color) {
		case blue:
			return Type.groundBlue;
		case green:
			return Type.groundGreen;
		case purple:
			return Type.groundPurple;

		default:
			return Type.ground;
		}
	}
	
	@Override
	public Element toXml(Document doc) {
		Element boot = doc.createElement("Ground");
		boot.appendChild(position.toXml(doc));
		Element color = doc.createElement("Color");
		color.appendChild(doc.createTextNode(this.color.toString()));
		boot.appendChild(color);
		return boot;
	}
}
