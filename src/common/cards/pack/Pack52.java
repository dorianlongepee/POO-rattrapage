package common.cards.pack;

import common.cards.classique.CardClassic;
import common.cards.classique.Trump;
import common.cards.classique.Value;

public class Pack52 extends Pack<CardClassic> {

	/**
	 * Constructor
	 * @param empty
	 */
	public Pack52(boolean empty) {
		super();
		if(!empty) {
			for(Trump trump : Trump.values()) {
				for(Value value : Value.getValueFor52Cards()) {
					this.add(new CardClassic(trump, value));
				}
			}
			
			super.mixPack();
		}
	}
}
