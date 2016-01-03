package world.commands;

import java.util.Arrays;

import pddl.Learn;
import world.World;
import world.objects.Player;
import world.objects.MovableObject;
import world.objects.PhysObject.Direction;

public class Push extends Command {
	Direction dir;
	public Push(Direction dir) {
		this.dir=dir;
	}
	public Push(Direction dir, String[] strings) {
		this.dir=dir;
		parameters=strings;
	}
	@Override
	public boolean Do(World world) {
		if(Learn.learning && parameters!=null && !Arrays.equals(parameters, getSuccessParameters(world))){
			System.out.println("Do failed: "+this);
			return false;
		}
		return world.playerAction(dir);
	}
	
	@Override
	public String toString(){
		return "Push "+dir;
	}

	@Override
	public String[] getSuccessParameters(World world) {
		String[] parameters = new String[9];
			Player player= world.getPlayer();
			MovableObject obj =(MovableObject)world.getLocation(player.relativTo(dir));
			parameters[0]=player.getName();
			parameters[1]=obj.getName();
			parameters[2]=player.getPosition().getName();//at
			parameters[3]=player.relativTo(Direction.down).getName();//under
			parameters[4]=obj.getPosition().getName();//from
			parameters[5]=obj.relativTo(dir).getName();//to
			parameters[6]=obj.relativTo(Direction.down).getName();//underfrom
			parameters[7]=obj.relativTo(dir).relativTo(Direction.down).getName();//underto
			parameters[8]=dir.toString();
		return parameters;
	}
}
