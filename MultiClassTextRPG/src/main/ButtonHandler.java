package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener{
	
	Game game;
	public ButtonHandler(Game game) {
		this.game = game;
	}
	
	public void actionPerformed(ActionEvent e) {
		game.sfxHandler.playSound("button.wav");
		String choice = e.getActionCommand();
		if(game.menu.equals("main")) {
		switch(choice) {
		case "start":
			game.menu = "pickClass";
			game.vm.showClassSelection();;
			break;
		}
		}
		if(game.menu.equals("pickClass")) {
		switch(choice) {
		case "back":
			System.out.println("Returning to title screen.");
			game.vm.showTitleScreen();
			game.menu = "main";
			break;
		case "confirm":
			System.out.println("Confirming chice: " + game.chosenClass);
			break;
		case "start": break;
		default:
			game.ui.confirm.setEnabled(true);
			game.ui.charCreationClassInfo(choice);
			game.chosenClass = choice;
			System.out.println("Class selected: " + game.chosenClass);
			break;
		}
		}

		
		}
	}
		


