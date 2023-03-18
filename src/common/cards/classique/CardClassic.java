package common.cards.classique;

import common.cards.Card;
import common.cards.ICardMemory;

public class CardClassic extends Card implements ICardMemory {
	
	private Trump trump = null;
	private int trumpAtout;
	private Value value = null;
	
	/**
	 * Constructor
	 * @param trump
	 * @param value
	 */
	public CardClassic(Trump trump, Value value) {
		super();
		this.setTrump(trump);
		this.setValue(value);
	}

	public CardClassic(int trump, Value value) {
		super();
		this.setTrumpAtout(trump);
		this.setValue(value);
	}

	@Override
	public boolean isCompatible(ICardMemory card) {
		CardClassic card1 = (CardClassic) card;
		if (this.getValue().equals(Value.ATOUT)) {
			if (card1.getValue().equals(Value.EXCUSE)){
				return true;
			}
			return this.getValue().equals(card1.getValue());
		}

		if (this.getValue().equals(Value.EXCUSE) && card1.getValue().equals(Value.ATOUT)){
			return true;
		}
		return this.getValue().equals(card1.getValue()) && this.trump.sameColor(card1.getTrump());
	}

	/**
	 * Return trump
	 * @return Trump
	 */
	public Trump getTrump() {
		return trump;
	}

	/**
	 * Updated trump
	 */
	public void setTrump(Trump trump) {
		this.trump = trump;
	}

	/**
	 * Return value
	 * @return Value
	 */
	public Value getValue() {
		return value;
	}

	/**
	 * Updated value
	 */
	public void setValue(Value value) {
		this.value = value;
	}

	private int getTrumpAtout() {
		return this.trumpAtout;
	}

	private void setTrumpAtout(int trump) {
		this.trumpAtout = trump;
	}
	
	@Override
	public String toString() {
		String visual = "[****]";
		if(!this.isVisible()) {
			if(this.getValue().equals(Value.ATOUT)){
				return visual = "[" + this.getValue() + "/" + this.getTrumpAtout() + "]";
			}
			if(this.getValue().equals(Value.EXCUSE)){
				return visual = "[" + this.getValue() + "]";
			}
			return visual = "[" + this.getValue() + "/" + this.getTrump() + "]";
		}
		return visual;
	}

}
