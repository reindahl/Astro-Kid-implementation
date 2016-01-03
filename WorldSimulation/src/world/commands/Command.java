package world.commands;

import world.World;

public abstract class Command {
	
	public String[] parameters;
	
	public abstract boolean Do(World world);
	
	public abstract String[] getSuccessParameters(World world);
	
	public String[] getParameters(){
		return parameters;
		
	}
}
