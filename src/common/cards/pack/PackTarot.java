package common.cards.pack;

import common.cards.classique.CardClassic;
import common.cards.classique.Trump;
import common.cards.classique.Value;

public class PackTarot extends Pack<CardClassic> {

	/**
	 * Constructor
	 * @param empty
	 */
	public PackTarot(boolean empty) {
		super();
		if(!empty) {
			for(Trump trump : Trump.values()) {
				for(Value value : Value.getValueForTarot() ) {
					this.add(new CardClassic(trump, value));
				}
			}

			for(int i = 1; i < 22; i++){
				this.add(new CardClassic(i, Value.ATOUT));
			}

			this.add(new CardClassic(null, Value.EXCUSE));
			super.mixPack();
		}
	}
}
