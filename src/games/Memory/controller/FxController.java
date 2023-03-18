package games.Memory.controller;

import common.cards.classique.CardClassic;
import common.cards.classique.CardTarot;
import common.cards.classique.Trump;
import common.cards.classique.Value;
import common.game.Game;
import games.Memory.ihm.javaFxIHM;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

public class FxController extends Application {

	private GridPane box;
	private Group root;
	private int indexCurrent;
	Stage window;
	private ImageView frontCard;
	private int lineHeight = 210;
	private int numberClick = 2;
	private javaFxIHM selected = null;
	private int[] nbCardsAvailable = {32, 52, 56};
	private int nbCartes;
	private CardTarot[] deck;
	private ImageView[] cuttedImages;
	private Rectangle border;
	private Label scoreText;
	private static Game<CardClassic> game;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("JavaFX Memory");
		Scene scene = new Scene(createContent());

		// Visual deck of common.cards
		for (int i = 0; i < deck.length; i++) {
			CardTarot cardTarot = deck[i];
			String card = cardTarot.toString();
			System.out.println(card);
		}
		scene.setOnMouseClicked(e-> {
			new javaFxIHM(deck, this.indexClicked(e), scoreText);
		});
		
		this.scoreText.layoutYProperty().bind(scene.heightProperty().subtract(this.scoreText.getHeight() + 35));
		scene.setFill(Color.BLACK);
		window.setWidth(835);
		window.setHeight(500);
		window.setScene(scene);
		window.show();
	}

	/**
	 * Create content for common.game
	 * @return
	 */
	private Parent createContent() {
		box = this.deckOfCards();
		root = new Group();
        //Score
        this.scoreText = new Label();
        this.scoreText.setTextFill(Color.WHITE);
        this.scoreText.setAlignment(Pos.TOP_LEFT);
        this.scoreText.setStyle("-fx-font-size:12px;-fx-font-weight: bold;-fx-text-fill:#5E34B1;-fx-background-color:#ffc300;");
        this.scoreText.setPrefSize(1000, 50); 
        this.scoreText.setText("Score: ");
		root.getChildren().add(box);
		root.getChildren().add(scoreText);
		return root;
	}

	public static void main(String[] args) { 
		launch(args); 
		
		System.out.println("Score : " + args);
	}
	
	/**
	 * Put PlusOuMoins in Controller
	 * @param gameCurrent
	 */
	public static void setGame(Game<CardClassic> gameCurrent) {
		game = gameCurrent;
	}
	/**
	 * Return this current common.game
	 * @return
	 */
	public Game<CardClassic> getGame() {
		return game;
	}

	/**
	 * Give this selected
	 * @return
	 */
	public javaFxIHM getSelected() {
		return selected;
	}

	/**
	 * Updated this selected
	 * @param selected
	 */
	public void setSelected(javaFxIHM selected) {
		this.selected = selected;
	}

	/**
	 * Give the number click
	 * @return
	 */
	public int getnumberClick() {
		return numberClick;
	}

	/**
	 * Updated this number click
	 * @param numberClick
	 */
	public void setnumberClick(int numberClick) {
		this.numberClick = numberClick;
	}

	/**
	 * Adapte the mouse click for screen and number common.cards
	 * @param e
	 * @return
	 */
	private int indexClicked(javafx.scene.input.MouseEvent e) {	
		if(this.nbCartes == 32) {
			
			if(((int) e.getY()/105) == 0) {
				this.indexCurrent = (int) e.getX()/58; 
			}else {
				int tmpIndex = ((int) e.getY()/105) * 7; 
				this.indexCurrent = ((int) e.getY()/105 + (int) e.getX()/58)+ tmpIndex;
			}
		}
		
		if(this.nbCartes == 52) {
			
			if(((int) e.getY()/105) == 0) {
				this.indexCurrent = (int) e.getX()/58; 
			}else {
				int tmpIndex = ((int) e.getY()/105) * 12; 
				this.indexCurrent = ((int) e.getY()/105 + (int) e.getX()/58)+ tmpIndex;
			}
		}
				
		if(this.nbCartes == 56) {
			
			if(((int) e.getY()/105) == 0) {
				this.indexCurrent = (int) e.getX()/58; 
			}else {
				int tmpIndex = ((int) e.getY()/105) * 13; 
				this.indexCurrent = ((int) e.getY()/105 + (int) e.getX()/58)+ tmpIndex;
			}
		}
		return this.indexCurrent;
	}

	/**
	 * Constructor the deck of common.cards
	 * @return GridPane
	 */
	private GridPane deckOfCards() {
		int choice = GameController.getControllerChoicePack();
		nbCartes = nbCardsAvailable[choice-1];

		deck = new CardTarot[this.nbCartes];
		cuttedImages=new ImageView[nbCartes+2];
		int indice = 0;
		box = new GridPane();
		
		//Number Begin 6 => 32 | 0 => 56
		int nbBegin = (nbCartes == 32)? 6 : 0;
		int nbEnd = 14;

		// Load the image
		Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("../../../assets/tarotcards.jpg")));

		for (int line = 0; line < 4; line++) {
			for (int column = nbBegin; column < nbEnd; column++) {

				// ALL
				this.frontCard = new ImageView(image);
				this.border = new Rectangle(58, 105);
				this.border.setFill(null);
				this.border.setStroke(Color.RED);
				Rectangle2D viewportRect = new Rectangle2D((57*column), lineHeight, 58, 105);
				this.frontCard.setViewport(viewportRect);
				
				if(Value.getValueFor56CardsToString()[column].toString().equals(Value.CAVALIER.toString()) && nbCartes == 52) {
					continue;
				}
				
				//Cards
				cuttedImages[indice] = this.frontCard;
				deck[indice] = new CardTarot(Trump.getTrumpsForCards()[line], Value.getValueFor56CardsToString()[column], indice+1, this.frontCard);
	
				box.add(deck[indice].getCardImageView(), column, line);
				box.add(border, column, line);
				FadeTransition fade = new FadeTransition(Duration.seconds(.5), deck[indice].getCardImageView());
				fade.setToValue(0);
				fade.play();
				indice++;
			}		 
			lineHeight += 105;
		}
		return box;
	}
	
}
