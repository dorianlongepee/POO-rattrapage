package cards.classique;

import javax.swing.ImageIcon;

import cards.Card;
import cards.ICard;
import cards.ICardMemory;
import javafx.scene.image.ImageView;

public class CardTarot extends Card implements ICardMemory, ICard  {
	
	private String trump;
	private String value;
	private int index;
	private static int counter = 0;

	private ImageIcon cardImage;
	private ImageView cardImageView;
	
	/**
	 * Constructor for Swing
	 * @param trump
	 * @param value
	 * @param index
	 * @param imageIcon
	 */
	public CardTarot(String trump, String value, int index, ImageIcon imageIcon) {
		this.trump = trump; //Pique,coeur,carreau,trefle 
		this.value = value; //AS,2,3,4....D,R
		this.index = index; //1....14..56
		this.setCardImage(imageIcon); //image
	}

	/**
	 * Constructor for JavaFX
	 * @param trump
	 * @param value
	 * @param index
	 * @param imageView
	 */
	public CardTarot(String trump, String value, int index, ImageView imageView) {
		this.trump = trump; //Pique,coeur,carreau,trefle 
		this.value = value; //AS,2,3,4....D,R
		this.index = index; //1....14..56		
		this.setCardImageView(imageView);// Front image
	}

	/**
	 *  Return if cards is compatible
	 */
	public boolean isCompatible(ICardMemory card) {
		CardTarot card1 = (CardTarot) card;
		return this.getValue().equals(card1.getValue()) && setTrumpStringToTrump(this.trump).sameColor(setTrumpStringToTrump(card1.getTrump()));
	}
	
	/**
	 * Show cards and this values
	 */
	public String toString() {
		counter++;
		if(this.getCardImage() instanceof ImageIcon) {
			return counter + " " + this.value + " of " + this.trump + " image " + this.getCardImage();
		}
		return counter + " " + this.value + " of " + this.trump + " image " + this.getCardImageView();
	}
	
	/**
	 * Return index
	 * @return int
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * Updated index
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * Return image card for SWING
	 * @return ImageIcon
	 */
	public ImageIcon getCardImage() {
		return cardImage;
	}
	/**
	 * Updated image card for SWING
	 * @param cardImage
	 * @return ImageIcon
	 */
	public ImageIcon setCardImage(ImageIcon cardImage) {
		return this.cardImage = cardImage;
	}
	/**
	 * Return Trump of card
	 * @return string
	 */
	public String getTrump() {
		return trump;
	}
	/**
	 * Updated Trump of card
	 * @param trump string
	 */
	public void setTrump(String trump) {
		this.trump = trump;
	}
	/**
	 * Return value of card
	 * @return string
	 */
	public String getValue() {
		return value;
	}
	/**
	 * Updated Value of card
	 * @param value string
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * Updated this string of trump on Trump
	 * @param cardTrump
	 * @return null | trump
	 */
	public Trump setTrumpStringToTrump(String cardTrump) {
		for (Trump trump : Trump.values()) {
			if(trump.toString().equals(cardTrump)){
				return trump;
			}
		}
		return null;
	}
	/**
	 * Updated this string of value on Value
	 * @param cardValue
	 * @return null | value
	 */
	public Value setValueStringToValue(String cardValue) {
		for (Value value : Value.values()) {
			if(value.toString().equals(cardValue)){
				return value;
			}
		}
		return null;
	}
	/**
	 * Return ImageView of card
	 * @return ImageView
	 */
	public ImageView getCardImageView() {
		return this.cardImageView;
	}
	/**
	 * Updated ImageView
	 * @param cardImageView
	 */
	public void setCardImageView(ImageView cardImageView) {
		this.cardImageView = cardImageView;
	}
	
}
