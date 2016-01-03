package world.objects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import world.Point;
import world.World;
import world.World.Type;

public class Remote extends PhysObject{

	public Remote(World world, Point position) {
		super(world, position);
	}

	@Override
	public Character getChar() {
		return 'n';
	}

	@Override
	public Boolean isSolid() {
		return false;
	}

	@Override
	public Type getType() {
		return Type.remote;
	}
	@Override
	public Element toXml(Document doc) {
		Element boot = doc.createElement("Remote");
		boot.appendChild(position.toXml(doc));
		return boot;
	}
}
