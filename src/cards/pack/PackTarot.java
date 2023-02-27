package cards.pack;

import cards.classique.CardClassic;
import cards.classique.Trump;
import cards.classique.Value;

public class PackTarot extends Pack<CardClassic> {

	/**
	 * Constructor
	 * @param empty
	 */
	public PackTarot(boolean empty) {
		super();
		if(!empty) {
			for(Trump trump : Trump.values()) {
				for(Value value : Value.values() ) {
					this.add(new CardClassic(trump, value));
				}
			}
			super.mixPack();
		}
	}
}
