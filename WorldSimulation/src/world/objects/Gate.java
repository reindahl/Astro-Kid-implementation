package world.objects;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import world.Point;
import world.World;
import world.World.Color;
import world.World.Type;

public class Gate extends PhysObject{
 
	Color color;
	
	public Gate(World world, Point position, Color color) {
		super(world, position);
		this.color=color;
	}

	@Override
	public Character getChar() {
		return 'w';
	}

	/**
	 * Default open if no buttons
	 */
	@Override
	public Boolean isSolid() {
		ArrayList<Button> buttons= world.getButtons(color);
		
		boolean result=false;
		if(buttons.isEmpty()){
			result=true;
		}
		for (Button button : buttons) {
			if(world.isClear(button.position)){
				result= true;
				break;
			}
		}

		return result;
	}

	@Override
	public Type getType() {
		switch (color) {
		case red:
			return Type.gateRed;
		case blue:
			return Type.gateBlue;
		case yellow:
			return Type.gateYellow;
		default:
			return null;
		}
		
	}
	
	@Override
	public Element toXml(Document doc) {
		Element boot = doc.createElement("Gate");
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
