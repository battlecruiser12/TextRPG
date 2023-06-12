package races;

import java.util.ArrayList;
import java.util.Random;

public class Human extends Race{
	private Random rand = new Random();
	private ArrayList<String> traits;
	private int[] statBonus;
	private int bonusHealth;

	
	public Human() {
		statBonus = new int[6];
		traits = new ArrayList<String>();
		bonusHealth = 5;
		assignTraits();
		assignStatBonus();
		
	}
	
	private void assignTraits() {
		traits.add("versatile");
	}
	
	private void assignStatBonus() {
		for(int i = 0; i < 3; i++) {
			statBonus[rand.nextInt(6)] += 1;
		}
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
		return "Human";
	}
	
}
