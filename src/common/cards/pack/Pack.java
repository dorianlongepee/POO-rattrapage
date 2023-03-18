package common.cards.pack;

import java.util.ArrayList;
import java.util.Collections;

import common.cards.ICard;
import common.cards.classique.CardEmpty;

public class Pack<T extends ICard>  {
	
	private ArrayList<T> cards = new ArrayList<T>();
	/**
	 * Add value in common.cards
	 * @param card
	 */
	public void add(T card) {
		this.cards.add(card);
	}

	/**
	 * Remove value in common.cards
	 * @param i
	 */
	public void remove(int i) {
		T cardEmpty = (T) new CardEmpty();
		this.cards.set(i, cardEmpty);
	}

	public T get(int i){
		return this.cards.get(i);
	}
	/**
	 * Give size on common.cards ArrayList
	 * @return int
	 */
	public int size() {
		return this.cards.size();
	}
	
	/**
	 * Get all common.cards of pack
	 * @return
	 */
	public ArrayList<T> getCards() {
		return this.cards;
	}

	/**
	 * Updated common.cards
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
