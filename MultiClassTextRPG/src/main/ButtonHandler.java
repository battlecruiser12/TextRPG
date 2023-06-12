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
			game.vm.showClassSelection();;
			break;
		}
		}
		if(game.menu.equals("pickClass")) {
		switch(choice) {
		case "back":
			System.out.println("Returning to title screen.");
			CharCreator.chosenPlayerClass = "";
			game.vm.showTitleScreen();
			break;
		case "confirm":
			System.out.println("Confirming choice: " + CharCreator.chosenPlayerClass);
			game.vm.showRaceSelection();
			break;
		case "start": break;
		default:
			game.ui.confirm.setEnabled(true);
			game.ui.charCreationClassInfo(choice);
			CharCreator.chosenPlayerClass = choice;
			CharCreator.chosenPlayerClass = choice;
			System.out.println("Class selected: " + CharCreator.chosenPlayerClass);
			break;
		}
		}
		if(game.menu.equals("pickRace")) {
			switch(choice) {
			case "confirm":
				if(game.ui.confirm.isEnabled()) {
				System.out.println("Confirming choice: " + CharCreator.chosenPlayerRace.getClass().getSimpleName().toLowerCase());
				game.vm.showNameSelection();
				}
				break;
			case "back":
				game.vm.showClassSelection();
				CharCreator.chosenPlayerRace = null;
				break;
			default:
				CharCreator.pickRace(choice);
				System.out.println("Race selected: " + CharCreator.chosenPlayerRace.getClass().getSimpleName().toLowerCase());
				game.ui.confirm.setEnabled(true);
				break;
			}
		}
		if(game.menu.equals("pickName")) {
			switch(choice) {
			case "confirm":
				if(game.ui.nameInput.getText() != "" && game.ui.confirm.isEnabled()) {
					CharCreator.chosenPlayerName = game.ui.nameInput.getText();
					System.out.println("Name confirmed: " + CharCreator.chosenPlayerName);
				}
				break;
			case "back": game.vm.showRaceSelection(); break;
			}
		}

		
		}
	}
		


