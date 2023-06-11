package main;


public class Game {
	UI ui;
	protected String choice;
	ButtonHandler bHandler = new ButtonHandler(this);
	SoundHandler musicHandler = new SoundHandler(true);
	SoundHandler sfxHandler = new SoundHandler(false);
	String menu, chosenClass, chosenRace, chosenGender, chosenName;
	VisibilityManager vm;
	public Game() {
		ui = new UI(this);
		ui.createUI(bHandler);
		vm = new VisibilityManager(ui);
		choice = "";
		menu = "main";
		vm.showTitleScreen();

	}
	public String getCurrentChoice() {
		return choice;
	}
	
	public void makeChoice(String choice) {
		System.out.println(this.choice);
		this.choice = choice;
		System.out.println(choice);
	}
	

}
