package cards.classique;

public enum Value {
	AS("AS"), DEUX(" 2"), TROIS(" 3"), QUATRE(" 4"), CINQ(" 5"), SIX(" 6"), SEPT(" 7"), HUIT(" 8"), NEUF(" 9"), DIX("10"), VALET(" V"), CAVALIER(" C"), DAME(" D"), ROI(" R");

	private String visual;
	
	/**
	 * Constructor
	 * @param value
	 */
	Value(String value) {
		this.visual = value;
	}
	/**
	 * Return visual value
	 */
	public String toString() {
		return this.visual;
	}
	
	/**
	 * Return for pack 32
	 * @return Value[] cardGame
	 */
	public static Value[] getValueFor32Cards() {
		Value[] cardGame = {
				Value.SEPT, Value.HUIT, Value.NEUF, Value.DIX,
				Value.VALET, Value.DAME, Value.ROI, Value.AS,
				};
		return  cardGame;
	}
	
	/**
	 * Return for pack 52
	 * @return Value[] cardGame
	 */
	public static Value[] getValueFor52Cards() {
		Value[] cardGame = {
				Value.AS, Value.DEUX, Value.TROIS, Value.QUATRE, Value.CINQ,
				Value.SIX, Value.SEPT, Value.HUIT, Value.NEUF, Value.DIX,
				Value.VALET,Value.DAME, Value.ROI
				};
		return  cardGame;
	}
	
	/**
	 * Return for pack 56
	 * @return Value[] cardGame
	 */
	public static Value[] getValueFor56Cards() {
		Value[] cardGame = {
				Value.AS, Value.DEUX, Value.TROIS, Value.QUATRE, Value.CINQ,
				Value.SIX, Value.SEPT, Value.HUIT, Value.NEUF, Value.DIX,
				Value.VALET, Value.CAVALIER, Value.DAME, Value.ROI
				};
		return  cardGame;
	}
	
	/**
	 * Return for pack 32 
	 * @return String[] cardGame
	 */
	public static String[] getValueFor32CardsToString() {
		String[] cardGame = {
				Value.SEPT.toString(), Value.HUIT.toString(), Value.NEUF.toString(), Value.DIX.toString(),
				Value.VALET.toString(), Value.DAME.toString(), Value.ROI.toString(), Value.AS.toString(),
				};
		return  cardGame;
	}
	
	/**
	 * Return for pack 52 
	 * @return String[] cardGame
	 */
	public static String[] getValueFor52CardsToString() {
		String[] cardGame = {
				Value.AS.toString(), Value.DEUX.toString(), Value.TROIS.toString(), Value.QUATRE.toString(), Value.CINQ.toString(),
				Value.SIX.toString(), Value.SEPT.toString(), Value.HUIT.toString(), Value.NEUF.toString(), Value.DIX.toString(),
				Value.VALET.toString(), Value.DAME.toString(), Value.ROI.toString()
				};
		return  cardGame;
	}
	
	/**
	 * Return for pack 56 
	 * @return String[] cardGame
	 */
	public static String[] getValueFor56CardsToString() {
		String[] cardGame = {
				Value.AS.toString(), Value.DEUX.toString(), Value.TROIS.toString(), Value.QUATRE.toString(), Value.CINQ.toString(),
				Value.SIX.toString(), Value.SEPT.toString(), Value.HUIT.toString(), Value.NEUF.toString(), Value.DIX.toString(),
				Value.VALET.toString(), Value.CAVALIER.toString(), Value.DAME.toString(), Value.ROI.toString()
				};
		return  cardGame;
	}

}
