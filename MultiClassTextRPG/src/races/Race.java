package races;

import java.util.ArrayList;

public abstract class Race {
	private ArrayList<String> traits;
	private int[] statBonus;
	private int bonusHealth;
	
	public Race() {
		statBonus = new int[6];
		traits = new ArrayList<String>();
		this.bonusHealth = 20;
		assignTraits();
		assignStatBonus();
	}
	
	private void assignTraits() {
		traits.add(null);
	}
	
	private void assignStatBonus() {
		statBonus[0] = 0;
		statBonus[1] = 0;
		statBonus[2] = 0;
		statBonus[3] = 0;
		statBonus[4] = 0;
		statBonus[5] = 0;
	}
	
	public ArrayList<String> getTraits() {
		return this.traits;
	}
	
	public int[] getStatBonus() {
		return this.statBonus;
	}
	
	public int getBonusHealth() {
		return bonusHealth;
	}
	
	public String toString() {
		return "Race";
	}


	
}
