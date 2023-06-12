package entities;

import java.util.ArrayList;
import java.util.Random;

import backgrounds.Background;
import races.Race;

public abstract class Entity {
	private int maxHealth;
	private int currentHealth;
	private int level;
	private Race race;
	private String name;
	private int healthIncreaseOnLevel;
	private Random rand = new Random();
	private int[] stats = new int[6];
	private Background bg;
	private int armorClass;
	private ArrayList<String> resistances;
	
	public Entity(String name, int level, Race race, Background bg) {
		this.name = name;
		this.level = level;
		this.healthIncreaseOnLevel = 10;
		this.maxHealth = race.getBonusHealth() + (level-1)*healthIncreaseOnLevel + rand.nextInt(7) - 3;
		this.currentHealth = maxHealth;
		this.race = race;
		this.bg = bg;
		this.armorClass = 10;
		this.resistances = new ArrayList<String>();
	}
	
	public void levelUp() {
		level++;
		maxHealth += 10;
		if(maxHealth == currentHealth + 10) {
			currentHealth += 10;
		}
		
		System.out.println("Level up! " + name + " is now level " + level + "!");
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public void changeHealth(int amount) {
		this.currentHealth += amount;
		if(currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
	}
	
	public int[] getStats() {
		return this.stats;
	}
	
	
	public String toString() {
		return name + ": level " + level + " " + race;
	}
	
	public String getNameOfClass() {
		return "classless";
	}
	
	public String getName() {
		return name;
	}
	
	public int getArmorClass() {
		return armorClass;
	}
	
	public Background getBackground() {
		return this.bg;
	}
	
	public ArrayList<String> getResistances() {
		return this.resistances;
	}
	
	
}
