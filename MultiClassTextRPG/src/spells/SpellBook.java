package spells;

import java.util.Random;

import entities.Entity;

public abstract class SpellBook {
	static Random rand = new Random();

	public static boolean fireBolt(Entity caster, Entity target) {
		int hitRoll = rand.nextInt(21);
		if(target.getArmorClass() < hitRoll) {
			int damage = rand.nextInt(10)+1;
			target.changeHealth(-damage);
			System.out.println("Roll: " + hitRoll + " | " + target.getName() + " was struck by " + caster.getName() + "'s Fire Bolt for " + damage + " fire damage.");
		} else {
			System.out.println("Roll:" + hitRoll + " | " + "Missed!");
		}
		return true;
	}
	
	public static boolean chromaticOrb(Entity caster, Entity target, String damageType) {
		int hitRoll = rand.nextInt(21);
		if(target.getArmorClass() < hitRoll) {
			int damage = 0;
			for(int i = 0; i < 3; i++) {
				damage += rand.nextInt(8)+1;
			}
			target.changeHealth(-damage);
			System.out.println("Roll: " + hitRoll + " | " + target.getName() + " was struck by " + caster.getName() + "'s Chromatic Orb for " + damage + " " + damageType + " damage.");
		} else {
			System.out.println("Roll:" + hitRoll + " | " + "Missed!");

		}
		return true;
	}

}
