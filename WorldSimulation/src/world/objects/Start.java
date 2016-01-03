package world.objects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import world.Point;
import world.World;
import world.World.Type;

public class Start extends PhysObject{

	public Start(World world, Point position) {
		super(world,position);
	}

	@Override
	public Character getChar() {
		return 's';
	}

	@Override
	public Boolean isSolid() {
		return false;
	}

	@Override
	public Type getType() {
		return Type.start;
	}
	
	@Override
	public Element toXml(Document doc) {
		Element boot = doc.createElement("Start");
		boot.appendChild(position.toXml(doc));
		return boot;
	}
}
