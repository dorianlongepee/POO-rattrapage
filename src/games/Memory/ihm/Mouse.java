package games.Memory.ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
	
	private SwingIHM swing;
	private int line;
	private int column;
	private int indexCardCliked;
	private int nbCartes;


	private int currentIndex;

	public Mouse(int line, int column, SwingIHM swing, int nbCartes) {
		super();
		this.line = line;
		this.column = column;
		this.swing = swing;
		this.nbCartes = nbCartes;
	}
	
	/**
	 * Click for the 32 common.cards or 52 or 56 common.cards
	 */
	public void mouseClicked(MouseEvent e) {
		if(this.nbCartes == 32) {
			if(this.column == 0) {
				this.indexCardCliked = (this.line + this.column);
				this.currentIndex = this.indexCardCliked;
			}else {
				this.currentIndex = (this.column * 7);
				this.indexCardCliked = (this.column + this.line)+this.currentIndex;
			}
			swing.getIndexCardClicked(this.indexCardCliked);
		}
		
		if(this.nbCartes == 52) {
			if(this.column == 0) {
				this.indexCardCliked = (this.line + this.column);
				this.currentIndex = this.indexCardCliked;
			}else {
				this.currentIndex = (this.column * 12);
				this.indexCardCliked = (this.column + this.line)+this.currentIndex;
			}
			swing.getIndexCardClicked(this.indexCardCliked);
		}
		
		if(this.nbCartes == 56) {
			if(this.column == 0) {
				this.indexCardCliked = (this.line + this.column);
				this.currentIndex = this.indexCardCliked;
			}else {
				this.currentIndex = (this.column * 13);
				this.indexCardCliked = (this.column + this.line)+this.currentIndex;
			}
			swing.getIndexCardClicked(this.indexCardCliked);
		}
	}
}
