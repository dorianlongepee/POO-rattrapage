package games.Memory.controller;

import java.util.ArrayList;
import java.util.List;

import common.cards.classique.CardClassic;
import common.game.Game;
import games.Memory.ihm.ConsoleText;

public class TextController extends GameController {
	private int card1;
	private int card2;
	private int size = 0;
	private List<Integer> allIndex = new ArrayList<Integer>();
	
	/**
	 * Constructor
	 * @param game
	 */
	public TextController(Game<CardClassic> game) {
		super();
		this.play();
	}
	
	/**
	 * Launcher common.game
	 */
	private void play() {
	
		while(!game.isEmpty(size)) {
						
				game.showGame();
				
				List<CardClassic> cardsSelected = new ArrayList<CardClassic>();
				int saveIndex = -1;
				
				
				// Carte1
				this.card1 = this.choiceACard("première");
				while(this.allIndex.contains(this.card1)) {
					this.card1 = this.choiceACard("première");
				}
				saveIndex = this.card1;
				game.getCard(card1).flip();
				cardsSelected.add((CardClassic) game.getCard(card1));
				System.out.println(game.getCard(card1));
				
				
				// Carte2
				this.card2 = this.choiceACard("deuxième");
				while(this.allIndex.contains(this.card2) || saveIndex == this.card2) {
					this.card2 = this.choiceACard("deuxième");
				}
				game.getCard(card2).flip();
				cardsSelected.add((CardClassic) game.getCard(card2));
				System.out.println(game.getCard(card2));
				
				
				saveIndex = -1;
				
				boolean sameCards = game.getCard(card1).isCompatible(game.getCard(card2));
				
				this.analyzeGameRound(sameCards);
				
			}	
		
	}
	/**
	 * Ask choice card
	 * @param text
	 * @return int
	 */
	public int choiceACard(String text) {
		return ConsoleText.readANumber(game.getCurrentPlayer().getName() + " choisit la "+ text +" carte ?");
	}
	
	/**
	 * Analize the common.game
	 * @param same
	 */
	private void analyzeGameRound(boolean same) {
		if(same) {
			this.allIndex.add(card1);
			this.allIndex.add(card2);
			game.removeCard(card1-1);
			game.removeCard(card2-1);
			game.getCurrentPlayer().addScore(2);
			this.size +=2;
			if(game.isEmpty(size)) {
				ConsoleText.print("Le Gagnant est : ");
				game.showPlayers();
			}else {
				ConsoleText.print("2 points pour " + game.getCurrentPlayer().getName() + " Au suivant!");
				game.getNextPlayer();
				game.showPlayers();
			}
		}else {
			game.getCard(card1).flip();
			game.getCard(card2).flip();
			ConsoleText.print("Dommage, Raté! Au suivant => " + game.getCurrentPlayer().getName() + " Que choisis tu?");
		}
		
	}
	/**
	 * Return the index of card
	 * @return int
	 */
	public int getCard1() {
		return card1;
	}

	/**
	 * Updated the index of card
	 * @param card1
	 */
	public void setCard1(int card1) {
		this.card1 = card1;
	}

	/**
	 * Return the index of card
	 * @return int
	 */
	public int getCard2() {
		return card2;
	}

	/**
	 * Updated the index of card
	 * @param card1
	 */
	public void setCard2(int card2) {
		this.card2 = card2;
	}
	
}
