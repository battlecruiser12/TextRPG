package main;

import javax.swing.JPanel;

import races.Race;

public class VisibilityManager {
	UI ui;
	public VisibilityManager(UI ui) {
		this.ui = ui;
	}
	
	private void hideAll() {
		for(JPanel j : ui.uiArrayList) {
			j.setVisible(false);
		}
	}
	
	public void showTitleScreen() {
		hideAll();
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		ui.game.menu = "main";
	}
	
	public void showRaceSelection() {
		hideAll();
		ui.characterCreationPanel.setVisible(true);
		ui.characterCreationTextArea.setText("Select a race.");
		if(CharCreator.chosenPlayerRace == null) {
		ui.confirm.setEnabled(false);
		}
		ui.charCreationBottomPanel.setVisible(true);
		ui.raceButtonPanel.setVisible(true);
		ui.game.menu = "pickRace";
	}
	
	public void showClassSelection() {
		hideAll();
		ui.characterCreationPanel.setVisible(true);
		ui.classButtonPanel.setVisible(true);
		ui.charCreationBottomPanel.setVisible(true);
		if(CharCreator.chosenPlayerClass == null) {
		ui.confirm.setEnabled(false);
		}
		ui.refreshWindow(ui.window);
		ui.characterCreationTextArea.setText("Select a class.");
		ui.game.menu = "pickClass";

	}
	
	public void showNameSelection() {
		hideAll();
		ui.nameInputPanel.setVisible(true);
		ui.charCreationBottomPanel.setVisible(true);
		ui.game.menu = "pickName";
	}
}
