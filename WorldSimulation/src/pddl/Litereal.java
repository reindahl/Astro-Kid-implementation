package pddl;

import java.util.ArrayList;

public class Litereal {
	
	public enum litType {colour, remote, thing, location, direction, goal, flag, object, player, stone, robot};
	
	
	
	String name;
	litType type;
	public Litereal(String name, litType types) {
		this.name=name;
		this.type= types;
		
	}


	public ArrayList<litType> getTypes(){
		return getTypes(type);
	}
	public static ArrayList<litType> getTypes(litType type){
		ArrayList<litType> types = new ArrayList<>();
		types.add(type);
		types.add(litType.object);
		if(type==litType.stone || type==litType.robot || type==litType.player){
			types.add(litType.thing);
		}
		if(type==litType.thing){
			types.add(litType.player);
			types.add(litType.robot);
			types.add(litType.stone);
		}
		return types;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	@Override
	public int hashCode() {

		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {

		return toString().equals(obj.toString());
	}
}
