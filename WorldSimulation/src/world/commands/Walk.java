package world.commands;

import java.util.Arrays;

import pddl.Learn;
import world.World;
import world.objects.PhysObject.Direction;
import world.objects.Player;

public class Walk extends Command {
	public Direction dir;
	public Walk(Direction dir) {
		this.dir=dir;
	}

	public Walk(Direction dir, String[] strings) {
		this.dir=dir;
		parameters=strings;
	}

	@Override
	public boolean Do(World world) {
		if(Learn.learning && parameters!=null && !Arrays.equals(parameters, getSuccessParameters(world))){
			System.out.println("Walk: Do failed: "+this);
			System.out.println(world.getPlayer());
			System.out.println(Arrays.toString(parameters));
			System.out.println(Arrays.toString(getSuccessParameters(world)));
			return false;
		}
		
		return world.playerAction(dir);
	}
	@Override
	public String toString(){
		return "walk "+dir;
	}


	@Override
	public String[] getSuccessParameters(World world) {
		String[] parameters=null;
		if(dir==Direction.right || Direction.left== dir){
			parameters = new String[6];
			Player play= world.getPlayer();
			parameters[0]=play.getName();
			parameters[1]=play.getPosition().getName();
			parameters[2]=play.relativTo(dir).getName();
			parameters[3]=play.relativTo(Direction.down).getName();
			parameters[4]=play.relativTo(Direction.down).relativTo(dir).getName();
			parameters[5]=dir.toString();
		}
		return parameters;
	}
}
