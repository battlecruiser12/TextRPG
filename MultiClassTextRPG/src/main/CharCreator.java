package main;

import java.util.ArrayList;
import java.util.Random;

import backgrounds.Background;
import entities.Civilian;
import entities.Druid;
import entities.Entity;
import entities.Fighter;
import entities.Wizard;
import races.Dwarf;
import races.Elf;
import races.Gnome;
import races.Human;
import races.Orc;
import races.Race;

public class CharCreator {
	 public static String chosenPlayerClass, chosenPlayerName;
	 public static Race chosenPlayerRace;
	 public static Background background;
	 private static Random rand = new Random();
	 private static Human human = new Human();
	 Game game;

	 
	 
public static void pickRace(String choice) {
	switch(choice) {
	case "human": chosenPlayerRace = new Human(); break;
	case "dwarf": chosenPlayerRace = new Dwarf(); break;
	case "elf": chosenPlayerRace = new Elf(); break;
	case "gnome": chosenPlayerRace = new Gnome(); break;
	case "orc": chosenPlayerRace = new Orc(); break;
	
	}

}



public static ArrayList<Civilian> rollCivilians(int amount) throws Exception {
	ArrayList<Civilian> temp = new ArrayList<Civilian>();
	ArrayList<String> firstNames = FileBufferedReader.fileBuffReader("firstNames.txt");
	ArrayList<String> surnames = FileBufferedReader.fileBuffReader("surnames.txt");
	
	for(int i = 0; i < amount; i++) {
		String name = firstNames.get(rand.nextInt(firstNames.size())) + " " + surnames.get(rand.nextInt(surnames.size())); 
		Civilian civ = new Civilian(name, human);
		temp.add(civ);
		
	}
	
	return temp;
}


public static ArrayList<Entity> rollCharacters(int amount, int lvl) throws Exception {
	ArrayList<Entity> temp = new ArrayList<Entity>();
	ArrayList<String> firstNames = FileBufferedReader.fileBuffReader("firstNames.txt");
	ArrayList<String> surnames = FileBufferedReader.fileBuffReader("surnames.txt");
	
	for(int i = 0; i < amount; i++) {
		int classRoll = rand.nextInt(3);
		String name = firstNames.get(rand.nextInt(firstNames.size())) + " " + surnames.get(rand.nextInt(surnames.size())); 
		Background bg = new Background(name);
		if(classRoll == 0) {
		Wizard w = new Wizard(name, lvl, human, bg);
		temp.add(w);
		}
		
		if(classRoll == 1) {
			Fighter f = new Fighter(name, lvl, human, bg);
			temp.add(f);
		}
		
		if(classRoll == 2) {
			Druid d = new Druid(name, lvl, human, bg);
			temp.add(d);
		}
		
	}
	
	
	return temp;
}

public static String randomTownName() throws Exception {
	ArrayList<String> nameList = FileBufferedReader.fileBuffReader("townNames.txt");
	String townName = nameList.get(rand.nextInt(nameList.size()-1));
	return townName;
}

public static void wait(int t) {
	try {
		Thread.sleep(t);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //time is in milliseconds
}
}