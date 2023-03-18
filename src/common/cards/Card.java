package common.cards;

public class Card implements ICard {

	private boolean isVisible = false;
    //private boolean isVisible = true;
	@Override
	public boolean isVisible() {
		return this.isVisible;
	}

	@Override
	public void flip() {
		this.isVisible = !this.isVisible();
	}

}