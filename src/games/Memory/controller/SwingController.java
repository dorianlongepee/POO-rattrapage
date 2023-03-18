package games.Memory.controller;

import java.util.ArrayList;
import java.util.List;

import common.cards.classique.CardClassic;
import common.cards.classique.CardTarot;
import common.game.Game;
import games.Memory.ihm.SwingIHM;
import games.Memory.ihm.ToastMessage;

public class SwingController extends GameController {

	private SwingIHM ihm;
	private CardTarot[] deck;
	private int nbClick = 2;
	private List<Integer> allIndex = new ArrayList<Integer>();
	private int choicePack;
	private int[] nbCardsAvailable = {32, 52, 56};

	/**
	 * Constructor
	 * @param game
	 */
	public SwingController(Game<CardClassic> game) {
		super();
		this.choicePack = nbCardsAvailable[game.getChoicePack()-1];
		this.ihm = new SwingIHM(this);
		this.deck = ihm.getDeck();
	}
	
	/**
	 * Return the click of user
	 * @param indexCardCliked
	 */
	public void getIndexCardClicked(int indexCardCliked) {
		ihm.setPoints(game.scorePlayers());
		
		if(this.getNbClick() > 0 && !this.allIndex.contains(indexCardCliked)) {
			//Change  visual Card (2 possibility)
			countNbClick(indexCardCliked);
			// If index does not exist in index array
			this.allIndex.add(indexCardCliked);
		}
		
		// If NbClick == 0 => compare common.cards
		if(this.getNbClick() == 0) {
			//Retrieve two common.cards in allIndex length-2 && length-1
			int indexCard1 = this.allIndex.get(this.allIndex.size()-2);// index 1
			int indexCard2 = this.allIndex.get(this.allIndex.size()-1);// index 2		
			
			//Compare is compatible
			boolean isSameCards = deck[indexCard1].isCompatible(deck[indexCard2]);
			
			this.compareCards(isSameCards);
			
			// Reset nbClick for restart choice
			this.nbClick = 2;
			
			this.endGame();
		}
	}
	
	/**
	 * Return number click
	 * @return int
	 */
	public int getNbClick() {
		return nbClick;
	}
	/**
	 * Return choice Pack
	 * @return int
	 */
	public int getChoicePack() {
		return choicePack;
	}

	/**
	 * Updated choicePack
	 * @param choicePack
	 */
	public void setChoicePack(int choicePack) {
		this.choicePack = choicePack;
	}
	/**
	 * Count number click
	 * @param indexCardCliked
	 */
	public void countNbClick(int indexCardCliked) {
		//Change visual Card
		ihm.changeCard(indexCardCliked);
		nbClick--;
	}
	
	/**
	 * Compare the common.cards
	 * @param isSame
	 */
	private void compareCards(boolean isSame) {
		//If compatible
		int index1 = this.allIndex.get(this.allIndex.size()-2);
		int index2 = this.allIndex.get(this.allIndex.size()-1);
		
		if(isSame & this.allIndex.size()%2 == 0) {
			game.getCurrentPlayer().addScore(2);
			ihm.setPoints(game.scorePlayers());
			// Message
			ToastMessage message = new ToastMessage("BRAVO: " + game.getCurrentPlayer() + "! Au tour de " + game.getNextPlayer().getName() + "." );
			message.display();
			ihm.changeEmptyCard(index1);
			ihm.changeEmptyCard(index2);
		}else {
			this.allIndex.remove(this.allIndex.get(this.allIndex.size()-2));
			this.allIndex.remove(this.allIndex.get(this.allIndex.size()-1));
			ihm.changeBackCard(index1);
			ihm.changeBackCard(index2);
			//Message
			ToastMessage message = new ToastMessage("FAUX! Au tour de " + game.getNextPlayer().getName() + " de jouer.");
			message.display();
		}
	}
	
	/**
	 * Return the end Game
	 */
	private void endGame() {
		//If length deck == length allIndex => end Game
		if(deck.length == this.allIndex.size()) {
			ToastMessage message = new ToastMessage("END GAME .");
			message.display();
		}
	}
	
}
