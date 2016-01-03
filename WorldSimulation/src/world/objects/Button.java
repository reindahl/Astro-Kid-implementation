package world.objects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import world.Point;
import world.World;
import world.World.Color;
import world.World.Type;

public class Button extends PhysObject{

	Color color;
	
	public Button(World world, Point position, Color color) {
		super(world, position);
		this.color=color;
	}

	@Override
	public Character getChar() {
		return 'b';
	}

	@Override
	public Boolean isSolid() {
		return false;
	}
	
	@Override
	public Type getType() {
		switch (color) {
		case red:
			return Type.buttonRed;
		case blue:
			return Type.buttonBlue;
		case yellow:
			return Type.buttonYellow;
		default:
			return null;
		}
		

	}
	
	@Override
	public Element toXml(Document doc) {
		Element boot = doc.createElement("Button");
		boot.appendChild(position.toXml(doc));
		Element color = doc.createElement("Color");
		color.appendChild(doc.createTextNode(this.color.toString()));
		boot.appendChild(color);
		return boot;
	}

	public String getColor() {
		return color.toString();
	}
}
