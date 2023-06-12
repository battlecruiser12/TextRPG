package entities;

import java.util.Random;

import backgrounds.Background;
import races.Race;

public class Druid extends Entity{
	private int maxHealth;
	private int currentHealth;
	private int level;
	private Race race;
	private String name;
	private int baseHealth;
	private int healthIncreaseOnLevel;
	private Random rand = new Random();
	private Background bg;
	private int armorClass;
	
	public Druid(String name, int level, Race race, Background bg) {
		super(name, level, race, bg);
		this.name = name;
		this.level = level;
		this.baseHealth = 24;
		this.healthIncreaseOnLevel = 9;
		this.maxHealth = this.baseHealth + race.getBonusHealth() + (level-1)*healthIncreaseOnLevel + rand.nextInt(7) - 3;
		this.currentHealth = maxHealth;
		this.race = race;
		this.bg = bg;
		this.armorClass = 10;
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

	
	public String toString() {
		return name + ": level " + level + " " + race + " " + "Druid. Current health: " + this.currentHealth + "/" + this.maxHealth;
	}
	
	public String getNameOfClass() {
		return "druid";
	}
	
	public int getArmorClass() {
		return armorClass;
	}
	
	public Background getBackground() {
		return this.bg;
	}
	
}
