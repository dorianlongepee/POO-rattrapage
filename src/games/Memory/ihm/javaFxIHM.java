package games.Memory.ihm;

import java.util.ArrayList;
import java.util.Objects;

import common.cards.classique.CardTarot;
import games.Memory.controller.FxController;
import javafx.animation.FadeTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class javaFxIHM {
	private static FxController controller = new FxController();
	private static ArrayList<CardTarot> cardsSelected = new ArrayList<CardTarot>();
	private CardTarot cardTarot;
	private Label score;

	/**
	 * Constructor
	 * @param deck
	 * @param indexCurrent
	 * @param scoreText
	 */
	public javaFxIHM(CardTarot[] deck, int indexCurrent, Label scoreText) {
		// Search card
		cardTarot = deck[indexCurrent];
		score = scoreText;

		if (cardVisible() || controller.getnumberClick() == 0) {
			return;
		}

		controller.setnumberClick(controller.getnumberClick() - 1);

		// Add card
		if(!cardsSelected.contains(cardTarot) && cardsSelected.size() < 2 ) {
			cardsSelected.add(cardTarot);
		}
		if (controller.getSelected() == null) {
			controller.setSelected(this);
			visible(() -> {});
		} else {
			visible(() -> {
				if (cardsSelected.size() == 2) {
					boolean same = cardsSelected.get(0).isCompatible(cardsSelected.get(1));

					if(!same) {
						this.hidden();
					}

					if(same) {
						int indexCard1 = cardsSelected.get(0).getIndex();
						int indexCard2 = cardsSelected.get(1).getIndex();

						// EMPTY
						Image image0 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("../../../assets/vide.png")));
						ImageView emptyCard = new ImageView(image0);
						Rectangle2D viewportRect0 = new Rectangle2D(1,1, 58, 105);
						emptyCard.setViewport(viewportRect0);
						deck[indexCard1-1].getCardImageView().setImage(emptyCard.getImage());	
						deck[indexCard2-1].getCardImageView().setImage(emptyCard.getImage());
						controller.getGame().getCurrentPlayer().addScore(2);
						score.setText(controller.getGame().scorePlayers());
					}
					// Reset
					controller.setSelected(null);
					cardsSelected = new ArrayList<>();
					controller.setnumberClick(2);
					controller.getGame().getNextPlayer();
				}
			});
		}
	}
	
	/**
	 * Adjust opacity card
	 * @return
	 */
	private boolean cardVisible() {
		return cardTarot.getCardImageView().getOpacity() == 1;
	}

	/**
	 * Hide the card in the IHM JAVAFX
	 */
	public void hidden() {
		FadeTransition fadePrev = new FadeTransition(Duration.seconds(.5), cardsSelected.get(0).getCardImageView());
		fadePrev.setToValue(0);
		fadePrev.play();
		FadeTransition fade = new FadeTransition(Duration.seconds(.5), cardTarot.getCardImageView());
		fade.setToValue(0);
		fade.play();
	}
	/**
	 * Show the card in the IHM JAVAFX
	 */
	public void visible(Runnable action) {
		FadeTransition fade = new FadeTransition(Duration.seconds(.5), cardTarot.getCardImageView());
		fade.setToValue(1);
		fade.setOnFinished(e -> action.run());
		fade.play();
	}
	
}
