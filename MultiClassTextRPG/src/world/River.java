package world;

import java.util.ArrayList;
import java.util.Random;

import main.FileBufferedReader;

public class River extends Tile{
	private Random rand = new Random();
	public River(World world, int x, int y) {
		super(world, x, y);
		super.passability = 1;
		super.water = true;
		try {
			this.name = randomRiverName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return super.name;
	}
	
	private String randomRiverName() throws Exception {
		ArrayList<String> temp = FileBufferedReader.fileBuffReader("riverNames.txt");
		String name = temp.get(rand.nextInt(temp.size()));
		return name;
	}
	
	private boolean findConnectedRiverTile() {
		for(int i = -1; i < 2; i++) {
			for(int j = -1; i < 2; i++) {
				if(x+i >= 0 && x+i <= world.getWorldMap().length && y+j >= 0 && y+j <= world.getWorldMap().length) {
					if(world.getWorldMap()[x+i][x+j] instanceof River) {
						this.name = world.getWorldMap()[x+i][y+j].getName();
						return true;
					}
				}
			}
		}
		return false;
	}
	

	
	
}
