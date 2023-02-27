package controller;

import cards.classique.CardClassic;
import game.Game;
import ihm.ConsoleText;

public class GameController {
	
	protected static Game<CardClassic> game;
	
	/**
	 * Choice the route
	 * @return int
	 */
	public static int getRoute() {
		return ConsoleText.readANumber(
				"Jeu du Memory - Choisissez votre type de jeu ? \n 1- Jeu en console \n 2- Jeu swing(Graphique) \n 3- Jeu JavaFx(Graphique)\n");
	}
	
	/**
	 * Initialize the players
	 * @param game
	 */
	public static void initGame(Game<CardClassic> game) {
		game.initPlayers();
		game.showPlayers();
		game.getCurrentPlayer();
	}
	
	/**
	 * Launcher App
	 * @param args
	 */
	public static void main(String[] args) {
		getGame();
		router(getRoute());
	}
	
	/**
	 * Initialize the Game
	 */
	public static void getGame() {
		game = new Game<CardClassic>();
		initGame(game);
	}
	
	/**
	 * Make choice of user interaction
	 * @param choice
	 */
	private static void router(int choice) {
		switch (choice) {
		case 1: 
			System.out.println("Text Controller");
			new TextController(game);
			break;
		case 2: 
			System.out.println("Swing Controller");
			new SwingController(game);
			break;
		case 3: 
			System.out.println("JAVA fx Controller");
			FxController.setGame(game);
			javafx.application.Application.launch(FxController.class);
			break;
		}
		if(choice <= 0 || choice >= 4) {
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
