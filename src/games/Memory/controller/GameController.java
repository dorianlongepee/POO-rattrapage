package games.Memory.controller;

import common.cards.classique.CardClassic;
import games.PlusOuMoins.PlusOuMoins;
import games.Memory.ihm.ConsoleText;

public class GameController {
	
	protected static common.game.Game<CardClassic> game;
	
	/**
	 * Choice the route
	 * @return int
	 */
	public static int getRoute(int gameChoice) {
		if(gameChoice == 1){
			return ConsoleText.readANumber(
					"Choisissez votre jeu ! \n 1- Memory(Console) \n 2- Memory(Swing) \n 3- Memory(JavaFX)\n");
		}
		return 4;
	}
	
	/**
	 * Initialize the players
	 * @param game
	 */
	public static void initGame(common.game.Game<CardClassic> game) {
		game.initPlayers();
		game.getCurrentPlayer();
	}
	
	/**
	 * Launcher App
	 * @param args
	 */
	public static void main(String[] args) {
		getGame();
		router(getRoute(game.getGame()));
	}
	
	/**
	 * Initialize the PlusOuMoins
	 */
	public static void getGame() {
		game = new common.game.Game<CardClassic>();
		initGame(game);
	}
	
	/**
	 * Make choice of user interaction
	 * @param choice
	 */
	private static void router(int choice) {
		switch (choice) {
			case 1 -> {
				System.out.println("Memory(Console)");
				new TextController(game);
			}
			case 2 -> {
				System.out.println("Memory(Swing)");
				new SwingController(game);
			}
			case 3 -> {
				System.out.println("Memory(JavaFX)");
				FxController.setGame(game);
				javafx.application.Application.launch(FxController.class);
			}
			case 4 -> {
				System.out.println("Plus ou Moins (JavaFX)");
				PlusOuMoins.setGame(game);
				javafx.application.Application.launch(PlusOuMoins.class);
			}
		}
		if(choice <= 0 || choice >= 5) {
			ConsoleText.print("Erreur de choix ... Réessayer: \n");
		}
	}
	
	/**
	 * Return the user' s choice
	 * @return
	 */
	public static int getControllerChoicePack() {
		System.out.println(game.getChoicePack());
		return game.getChoicePack();	
	}
		
}
