package settlements;

import java.util.ArrayList;

import entities.Civilian;
import entities.Entity;
import main.Game;

public abstract class Building {
	protected String name;
	protected Civilian owner;
	protected ArrayList<Entity> visitingAdventurers;
	protected ArrayList<Civilian> visitingCivilians;
	protected ArrayList<Civilian> workers;
	protected Game game;
	
	public Building(String name, Civilian owner, Game game) {
		this.name = name;
		this.owner = owner;
		this.game = game;
	}

}
