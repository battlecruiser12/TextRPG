package world;

import java.util.ArrayList;

import entities.Civilian;
import main.FileBufferedReader;
import main.Game;
import races.Human;
import settlements.Building;
import settlements.Inn;
import settlements.Settlement;
import settlements.Village;

public class World {
	private ArrayList<Settlement> settlements;
	private Game game;
	private Tile[][] worldMap;
	
	public World(Game game) {
		this.game = game;
		worldMap = new Tile[32][32];
	}
	
	public Tile[][] getWorldMap() {
		return this.worldMap;
	} 
	
	private Tile[][] loadMapFromFile(String fileName) {
		Tile[][] temp = new Tile[32][32];
		
		
		return temp;
	}
	
	private ArrayList<Settlement> loadSettlementsFromFile() throws Exception {
		ArrayList<Settlement> temp = new ArrayList<Settlement>();
		ArrayList<String> load = FileBufferedReader.fileBuffReader("settlements1.txt");
		String[] loadedArray = (String[]) load.toArray();
		String[] tempSettlement = new String[7];
		int row = 0;
		int subRow = 0;
		int rowModulus = 0;
		
		while(row < loadedArray.length) {
			while(subRow < 8) {
				tempSettlement[subRow] = loadedArray[row];
				
				rowModulus = subRow % 7;
			}
			ArrayList<Building> tempPoI = new ArrayList<Building>();
			tempPoI.add(new Inn("The Snakecross Inn", new Civilian("Grel Nildrafk", new Human()), game, 5));
			Village tempVillage = new Village(Integer.valueOf(tempSettlement[3]), Integer.valueOf(tempSettlement[4]), tempSettlement[0], Integer.valueOf(tempSettlement[2]), tempPoI);
			temp.add(tempVillage);
			subRow = 0;
		}
		
		
		return temp;
	}

}
