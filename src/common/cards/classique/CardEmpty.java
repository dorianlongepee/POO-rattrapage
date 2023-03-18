package common.cards.classique;

import common.cards.Card;
import common.cards.ICardMemory;

public class CardEmpty extends Card implements ICardMemory {

	public CardEmpty() {
		super();
	}
	
	@Override
	public String toString() {
		String visual = "[CARD]";
		return visual;
	}

	@Override
	public boolean isCompatible(ICardMemory card) {
		return false;
	}

	
}
