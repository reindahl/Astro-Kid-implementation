package world.commands;

import world.World;

public class NoOp extends Command{

	public NoOp() {
	}

	@Override
	public boolean Do(World world) {
		return true;
	}
	@Override
	public String toString(){
		return "NoOp";
	}

	@Override
	public String[] getSuccessParameters(World world) {
		// TODO Auto-generated method stub
		return new String[]{};
	}
}
