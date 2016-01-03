package world.commands;

import java.util.Arrays;

import pddl.Learn;
import world.World;
import world.objects.PhysObject.Direction;
import world.objects.Player;

public class Climb extends Command {
	public Direction dir;
	public Climb(Direction dir) {
		this.dir=dir;
	}

	public Climb(Direction dir, String[] strings) {
		this.dir=dir;
		parameters=strings;
	}

	@Override
	public boolean Do(World world) {
		if(Learn.learning && parameters!=null && !Arrays.equals(parameters, getSuccessParameters(world))){
			System.out.println("Climb: Do failed: "+this);
			System.out.println(world.getPlayer());
			System.out.println(Arrays.toString(parameters));
			System.out.println(Arrays.toString(getSuccessParameters(world)));
			return false;
		}
		
		return world.playerAction(dir);
	}
	@Override
	public String toString(){
		return "Climb "+dir;
	}


	@Override
	public String[] getSuccessParameters(World world) {
		String[] parameters=null;
		if(dir==Direction.up || Direction.down== dir){
			parameters = new String[3];
			Player play= world.getPlayer();
			parameters[0]=play.getName();
			parameters[1]=play.getPosition().getName();
			parameters[2]=play.relativTo(dir).getName();
		}
		
		return parameters;
	}
}
