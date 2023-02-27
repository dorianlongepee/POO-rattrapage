package cards.pack;

import cards.classique.CardClassic;
import cards.classique.Trump;
import cards.classique.Value;

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
