package world.objects;

import world.Point;
import world.World;

public abstract class MovableObject extends PhysObject{

	public Direction facing;
	public Boolean moving=false;
	int lastUpdated=-1;
	public MovableObject(World world, Point position) {
		super(world, position);
	}

	public void updatePosition() {
		Point below = relativTo(Direction.down);
		if(world.isClear(below)){
			//start falling
			world.Move(position, below);
			this.position=below;
			keepmoving();
			return;
		}


		if(!moving){
			//it is not suppose to move
			return;
		}
		moveTo();
	}



	/**
	 * moves the object to the new position if it is legal
	 * @param to
	 */
	protected abstract Boolean moveTo();

	public boolean isLegal() {
		if(position.getX()==0 || position.getX()== world.width-1 || position.getY()==world.height-1){
			return false;
		}
		return true;
	}

	//should it keep moving
	protected abstract boolean keepmoving();
}
