package cards.classique;

import cards.Card;
import cards.ICardMemory;
import javafx.scene.Node;

public class CardClassic extends Card implements ICardMemory {
	
	private Trump trump = null;
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

	@Override
	public boolean isCompatible(ICardMemory card) {
		CardClassic card1 =  (CardClassic) card;
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
	
	@Override
	public String toString() {
		String visual = "[****]";
		if(this.isVisible()) {
			visual = "[" + this.getValue() + "/" + this.getTrump() + "]";
		}
		return visual;
	}

}
