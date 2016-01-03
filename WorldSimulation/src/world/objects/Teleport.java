package world.objects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import world.Point;
import world.World;
import world.World.Type;

public class Teleport extends PhysObject {

	public Teleport(World world, Point position) {
		super(world, position);
	}

	public Point getExit(){
		for (Teleport teleport : world.getTeleports()) {
			if(teleport.getPosition()!=getPosition()){
				return teleport.getPosition();
			}
		}
		return null;
	}
	
	@Override
	public Character getChar() {
		return 't';
	}

	@Override
	public Boolean isSolid() {
		return false;
	}

	@Override
	public Type getType() {
		return Type.teleport;
	}
	@Override
	public Element toXml(Document doc) {
		Element boot = doc.createElement("Teleport");
		boot.appendChild(position.toXml(doc));
		return boot;
	}
}
