package world.commands;

import java.util.Arrays;

import pddl.Learn;
import world.Point;
import world.World;
import world.objects.Player;
import world.objects.Robot;

public class Activate extends Command {
	Point pos;
	public Activate(Point pos) {
		this.pos=pos;
	}

	public Activate(int x, int y) {
		pos=new Point(x, y);
	}
	public Activate(Point pos, String[] strings) {
		this.pos=pos;
		parameters=strings;
	}

	public Activate(int x, int y, String[] strings) {
		pos=new Point(x, y);
		parameters=strings;
	}
		
	@Override
	public boolean Do(World world) {
		if(Learn.learning && parameters!=null && !Arrays.equals(parameters, getSuccessParameters(world))){
			System.out.println("Do failed: "+this);
			return false;
		}
		
		return world.playerAction(pos);
	}
	
	@Override
	public String toString(){
		return "Activate "+pos;
	}
	
	@Override
	public String[] getSuccessParameters(World world) {
		String[] parameters = new String[4];
		Player play= world.getPlayer();
		parameters[0]=pos.getName();
		Robot robo=(Robot) world.getLocation(pos);
		parameters[1]=robo.getName();
		parameters[2]=play.remotes.get(play.remotes.size()-1).getName();
		parameters[3]=robo.facing.toString();
		return parameters;
	}
}
