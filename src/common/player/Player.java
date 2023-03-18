package common.player;

import common.cards.ICard;
import common.cards.classique.CardClassic;
import common.cards.pack.Pack;

public class Player<T extends ICard> {
	private String name;
	private Pack<CardClassic> cardsWon = null;
	private int score = 0;
	
	/**
	 * Constructor
	 * @param name
	 * @param cardsWon
	 */
	public Player(String name, Pack<CardClassic> cardsWon) {
		super();
		this.name = name;
		this.setCardsWon(cardsWon);
		this.score = 0;
	}
	
	/**
	 * Show the content
	 */
	public String toString() {
		return "Joueur [nom: " + this.name + " | " + this.score + " = cartesGagnees]";
	}

	/**
	 * return the card won
	 * @return Pack<CardClassic>
	 */
	public Pack<CardClassic> getCardsWon() {
		return cardsWon;
	}
	
	/**
	 * Updated the card won
	 */
	public void setCardsWon(Pack<CardClassic> cardsWon2) {
		this.cardsWon = cardsWon2;
	}
	
	/**
	 * Return the name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Updated the name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Return the score
	 * @return
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Updated the score
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	public void addScore(int score){
		this.score += score;
	}

	
}	
