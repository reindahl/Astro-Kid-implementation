package world.objects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import world.Point;
import world.World;
import world.World.Type;

public class Goal extends PhysObject{

	public Goal(World world, Point position) {
		super(world,position);
	}

	@Override
	public Character getChar() {
		return 'g';
	}

	@Override
	public Boolean isSolid() {
		return false;
	}

	@Override
	public Type getType() {
		return Type.goal;
	}
	
	@Override
	public Element toXml(Document doc) {
		Element boot = doc.createElement("Goal");
		boot.appendChild(position.toXml(doc));
		return boot;
	}
}
