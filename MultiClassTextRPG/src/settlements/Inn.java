package settlements;

import entities.Civilian;
import main.CharCreator;
import main.Game;
import main.Main;

public class Inn extends Building{
	private int size;
	public Inn(String name, Civilian owner, Game game, int size) {
		super(name, owner, game);
		this.size = size;
	}
	
	public void randomVisitors() throws Exception {
		super.visitingAdventurers = CharCreator.rollCharacters(size, super.game.getAveragePartyLevel());
		super.visitingCivilians = CharCreator.rollCivilians(size*3);
	}
	
	

}
