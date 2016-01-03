package world.objects;



import org.w3c.dom.Document;
import org.w3c.dom.Element;

import world.Point;
import world.World;
import world.World.Color;
import world.World.Type;

public class Stone extends MovableObject{

	static int count =0;
	public Stone(World world, Point position) {
		super(world,position);

	}

	@Override
	public boolean keepmoving() {

		if(!isLegal()){
			moving=false;
			return false;
		}
		PhysObject under = world.getLocation(relativTo(Direction.down));
		if(under instanceof Ground && ((Ground) under).getColor()==Color.green){
			
			return true;
		}
		if(world.isClear(relativTo(Direction.down))){
			return true;
		}
		
		moving=false;
		return false;
		
	}
	
	@Override
	public boolean isLegal() {
		if(!super.isLegal()){
			return false;
		}
		PhysObject under= world.getLocation(relativTo(Direction.down));
		if(under instanceof Ground && (((Ground) under).getColor() == Color.blue || ((Ground) under).getColor() == Color.purple)){
			return false;
			
		}
		return true;
	}

	@Override
	protected Boolean moveTo() {
		if(lastUpdated==world.getSteps()){
			return true;
		}else{
			lastUpdated=world.getSteps();
		}
		Point to = relativTo(facing);

		if((facing==Direction.left ||facing==Direction.right) && world.isClear(to)){
			world.Move(position, to);
			this.position=to;
			keepmoving();
			return true;
		}
		return false;

	}
	@Override
	public String toString(){
		return "Stone "+position;
	}

	@Override
	public Character getChar() {
		return 's';
	}
	
	@Override
	public Boolean isSolid() {
		return true;
	}

	@Override
	public Type getType() {
		return Type.stone;
	}
	@Override
	public Element toXml(Document doc) {
		Element boot = doc.createElement("Stone");
		boot.appendChild(position.toXml(doc));
		return boot;
	}

}
