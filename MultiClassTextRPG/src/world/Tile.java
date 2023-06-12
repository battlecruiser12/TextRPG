package world;

import settlements.Settlement;

public abstract class Tile {
	protected int passability;
	protected boolean water;
	protected Settlement settlement;
	protected World world;
	protected int x;
	protected int y;
	protected String name;
	public Tile(World world, int x, int y) {
		this.world = world;
		this.x = x;
		this.y = y;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPassability() {
		return this.passability;
	}
	
	public boolean hasWater() {
		return this.water;
	}
	
	public boolean hasSettlement() {
		if(settlement != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Settlement getSettlement() {
		return settlement;
	}
}
