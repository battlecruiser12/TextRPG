package main;

import javax.swing.JPanel;

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
		
	}
	
	public void showRaceSelection() {
		hideAll();
		ui.characterCreationPanel.setVisible(true);
		ui.characterCreationTextArea.setText("Select a race.");
	}
	
	public void showClassSelection() {
		hideAll();
		ui.characterCreationPanel.setVisible(true);
		ui.classButtonPanel.setVisible(true);
		ui.charCreationBottomPanel.setVisible(true);
		ui.confirm.setEnabled(false);
		ui.refreshWindow(ui.window);
		ui.characterCreationTextArea.setText("Select a race.");

	}
}
