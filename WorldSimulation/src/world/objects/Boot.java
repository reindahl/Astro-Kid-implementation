package world.objects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import world.Point;
import world.World;
import world.World.Color;
import world.World.Type;

public class Boot extends PhysObject {
	Color color;
	public Boot(World world, Point position, Color color) {
		super(world, position);
		this.color=color;
	}

	@Override
	public Character getChar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isSolid() {
		return false;
	}
	
	public Color getColor(){
		return color;
	}

	@Override
	public Type getType() {
		switch (color) {
		case blue:
			return Type.bootBlue;
		case green:
			return Type.bootGreen;
		case purple:
			return Type.bootPurple;

		default:
			return null;
		}
	}

	@Override
	public Element toXml(Document doc) {
		Element boot = doc.createElement("Boot");
		boot.appendChild(position.toXml(doc));
		Element color = doc.createElement("Color");
		color.appendChild(doc.createTextNode(this.color.toString()));
		boot.appendChild(color);
		return boot;
	}

}
