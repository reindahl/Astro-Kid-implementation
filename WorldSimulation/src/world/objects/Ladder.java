package world.objects;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import world.Point;
import world.World;
import world.World.Type;

public class Ladder extends PhysObject{

	public Ladder(World world, Point position) {
		super(world, position);
	}

	@Override
	public Character getChar() {
		return '#';
	}
	@Override
	public Boolean isSolid() {
		return false;
	}

	@Override
	public Type getType() {
		return Type.ladder;
	}
	
	@Override
	public String toString(){
		return "Ladder "+position;
	}
	
	@Override
	public Element toXml(Document doc) {
		Element boot = doc.createElement("Ladder");
		boot.appendChild(position.toXml(doc));
		return boot;
	}
}
