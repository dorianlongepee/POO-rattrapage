package common.cards.classique;

import java.awt.Color;

public enum Trump {
	PIQUE("♠", Color.black), COEUR("♥", Color.red), CARREAU("♦", Color.red), TREFLE("♣", Color.black);
	
	private String visual;
	private Color color;
	
	/**
	 * Constructor Trump of card
	 * @param character
	 * @param color
	 */
	Trump(String character, Color color) {
		this.visual = character;
		this.color = color;
	}
	/**
	 * Same color between two common.cards
	 * @param trump
	 * @return
	 */
	public boolean sameColor(Trump trump) {
		return this.color == trump.color;
	}
	/**
	 * Return visual trump card
	 */
	public String toString() {
		return this.visual;
	}
	
	/**
	 * Return for pack 32
	 * @return String[] cardGame
	 */
	public static String[] getTrumpsForCards() {
		String[] cardGame = {Trump.PIQUE.toString(), Trump.COEUR.toString(), Trump.CARREAU.toString(), Trump.TREFLE.toString()};
		return  cardGame;
	}
}