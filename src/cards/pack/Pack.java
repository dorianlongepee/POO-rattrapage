package cards.pack;

import java.util.ArrayList;
import java.util.Collections;

import cards.ICard;
import cards.classique.CardClassic;
import cards.classique.CardEmpty;

public class Pack<T extends ICard> {
	
	private ArrayList<T> cards = new ArrayList<T>();
	/**
	 * Add value in cards
	 * @param card
	 */
	public void add(T card) {
		this.cards.add(card);
	}

	/**
	 * Remove value in cards
	 * @param i
	 */
	public void remove(int i) {
		T cardEmpty = (T) new CardEmpty();
		this.cards.set(i, cardEmpty);
	}
	/**
	 * Give size on cards ArrayList
	 * @return int
	 */
	public int size() {
		return this.cards.size();
	}
	
	/**
	 * Get all cards of pack
	 * @return
	 */
	public ArrayList<T> getCards() {
		return this.cards;
	}

	/**
	 * Updated cards
	 * @param cards
	 */
	public void setCards(ArrayList<T> cards) {
		this.cards = cards;
	}
	
	/**
	 * Shuffle collection of pack
	 */
	public void mixPack() {
		Collections.shuffle(this.cards);
	}
	
	@Override
	public String toString() {
		String visual = this.size() + " cartes\n";
		int i = 1;
		for(T t : this.cards) {
			if(i<10) {
				visual +="0"+i+" "+t.toString();
			}else {
				visual +=i+" "+t.toString();
			}
						
			if(i%4==0) {
				visual+="\n";
			}
			i++;
		}
		return visual;
	}
	
}
