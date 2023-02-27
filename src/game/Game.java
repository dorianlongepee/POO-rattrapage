package game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cards.classique.CardClassic;
import cards.pack.Pack;
import cards.pack.Pack32;
import cards.pack.Pack52;
import cards.pack.PackTarot;
import ihm.ConsoleText;
import player.Player;

public class Game<T extends CardClassic> {
	
	private List<Player<T>> players = new ArrayList<Player<T>>();
	private int playerIndex;
	protected Pack<CardClassic> theGame;
	private int choicePack;

	/**
	 * Initialize the players
	 */
	public void initPlayers() {
		int nbPlayers = ConsoleText.readANumber("Nombre de joueurs ? \n");
		int choice = ConsoleText.readANumber("Choix du paquet ?\n 1- 32 cartes\n 2- 52 cartes\n 3- Cartes Tarot \n");
		for (int i = 0; i < nbPlayers; i++) {
			String name = ConsoleText.readAString("Joueur " +(i+1)+ ": Quel est votre nom ? \n");
			Player<T> player = this.generatePlayer(choice, name);
			this.addPlayer(player);
		}
		this.generatePack(choice);
	}
	
	/**
	 * Choice and generate Pack
	 * @param choice
	 */
	public void generatePack(int choice) {
		switch(choice) {
		case 1: 
			theGame = new Pack32(false);
			setChoicePack(choice);
			break;
		case 2: 
			theGame = new Pack52(false);
			setChoicePack(choice);
			break;
		case 3: 
			theGame = new PackTarot(false);
			setChoicePack(choice);
			break;
		default:
			break;
		}
	}
	/**
	 * Generate the players
	 * @param choice
	 * @param name
	 * @return
	 */
	public Player<T> generatePlayer(int choice, String name) {
		Player<T> player = null;
		switch(choice) {
		case 1:
			Pack<CardClassic> pack = new Pack32(true);
			player = new Player<T>(name, pack);
			break;
		case 2:
			Pack<CardClassic> pack2 = new Pack52(true);
			player = new Player<T>(name, pack2);
			break;
		case 3:
			Pack<CardClassic> pack3 = new PackTarot(true);
			player = new Player<T>(name, pack3);
			break;
		default:
			break;
		}
		return player;
	}
	/**
	 * Add the player
	 * @param player
	 */
	public void addPlayer(Player<T> player) {
		this.players.add(player);
	}
	/**
	 * Return the game 
	 */
	public void showGame() {
		System.out.println(theGame);
	}
	/**
	 * Return the list of players
	 */
	public void showPlayers() {
		for (Player<T> player : players) {
			System.out.println(player);
		}
	}
	/**
	 * Return  the score of players in IHM
	 * @return
	 */
	public String scorePlayers() {
		return "Score : " + players.stream().
				map(i -> String.valueOf(i)).
				collect(Collectors.joining(" / ", "( ", " )"));
	}
	/**
	 * Return the current player
	 * @return Player
	 */
	public Player<T> getCurrentPlayer() {
		return players.get(playerIndex);
	}
	/**
	 * Return the next player
	 * @return Player
	 */
	public Player<T> getNextPlayer() {
		playerIndex++;
		playerIndex = playerIndex%(this.players.size());
		return this.getCurrentPlayer();
	}
	/**
	 * Return the choice pack
	 * @return int
	 */	
	public 	int getChoicePack() {
		return this.choicePack;
	}
	/**
	 * Updated the choice pack
	 */	
	public void setChoicePack(int choice) {
		this.choicePack = choice;
	}
	
	/**
	 * Return on card of the game
	 * @param i
	 * @return
	 */
	public CardClassic getCard(int i) {
		return this.theGame.getCards().get(i-1);
	}
	/**
	 * Remove the card of game
	 * @param i
	 */
	public void removeCard(int i) {
		theGame.remove(i);
	}

	/**
	 * Check the cards game is empty
	 * @param sizeCurrent
	 * @return boolean
	 */
	public boolean isEmpty(int sizeCurrent) {
		return sizeCurrent == theGame.size();
	}
	/**
	 * Return the size of game
	 * @return
	 */
	public int gameSize() {
		return theGame.size();
	}
	
	@Override
	public String toString() {
		return theGame.toString();
	}
	
}
