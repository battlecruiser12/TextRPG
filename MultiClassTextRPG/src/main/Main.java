package main;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		game.musicHandler.playSound("combat.wav");
		game.vm.showTitleScreen();
	}

}
