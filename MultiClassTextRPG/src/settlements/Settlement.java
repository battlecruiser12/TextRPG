package settlements;

import java.util.ArrayList;

import entities.Civilian;
import main.Main;

public abstract class Settlement {
protected int population;
protected int x;
protected int y;
protected String name;
protected ArrayList<Building> PoI;
protected ArrayList<Civilian> residents;

public Settlement(int x, int y, String name, int population, ArrayList<Building> PoI) throws Exception {
	this.x = x;
	this.y = y;
	this.population = population;
	this.PoI = PoI;
	this.residents = Main.rollCivilians(population);
	this.name = name;
}

public int getX() {
	return x;
}

public int getY() {
	return y;
}

public String getName() {
	return name;
}

public int getPopulation() {
	return population;
}


public ArrayList<Building> getPointsOfInterest() {
	return PoI;
}




}
