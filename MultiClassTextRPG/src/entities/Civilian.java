package entities;

import backgrounds.Background;
import races.Race;
import settlements.Building;

public class Civilian{
	private String profession;
	private String name;
	private Race race;
	private Building workPlace;
	public Civilian(String name, Race race) {
		this.name = name;
		this.race = race;
	}
	
	public String toString() {
		return name + ", " + race + " " + profession + " working at " + workPlace.toString();
	}

}