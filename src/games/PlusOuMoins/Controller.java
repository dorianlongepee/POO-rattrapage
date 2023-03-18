package games.PlusOuMoins;

import common.cards.classique.CardTarot;
import common.cards.pack.PackTarotPlusOuMoins;
import common.player.Player;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Objects;

public class Controller {
    @FXML
    ImageView currentCard;
    @FXML
    ImageView guessCard;
    @FXML
    Text scoreText;
    @FXML
    Text endGameText;
    private PackTarotPlusOuMoins deck;
    private static boolean endGame = false;
    private static final int NBCARTES = 77;
    private int cardCount = 0;
    private Player player;
    private final Image turnedCard = new Image(Objects.requireNonNull(getClass().getResourceAsStream("../../assets/dos.jpg")));

    protected PackTarotPlusOuMoins getDeck(){
        return this.deck;
    }

    protected void setDeck(PackTarotPlusOuMoins deck){
        this.deck = deck;
    }
    private void setPlayer(Player player) {
        this.player = player;
    }

    public void initiateGame(PackTarotPlusOuMoins deck, Player player){
        setDeck(deck);
        setPlayer(player);
        this.player.setScore(10);
        scoreText.setText(String.valueOf(this.player.getScore()));
        currentCard.setImage(this.deck.get(0).getImage());
    }

    public void input(String input) throws InterruptedException {
        revealCard();
        boolean res = checkValues(input);
        countPoints(res);
        checkScore(this.player.getScore());
    }

    private void countPoints(boolean hasGuessedRight) {
        int currentScore = this.player.getScore();
        if (hasGuessedRight) {
            currentScore += 1;
        } else {
            currentScore -= 1;
        }
        this.player.setScore(currentScore);
        scoreText.setText(String.valueOf(currentScore));
    }

    private void checkScore(int score) {
        if(score >= 20){
            endGame("GAGNÉ");
        }
        if(score <= 0){
            endGame("PERDU");
        }
        cardCount++;
    }

    private boolean checkValues(String input) {
        CardTarot currentCard = this.deck.get(cardCount);
        CardTarot guessCard = this.deck.get(cardCount + 1);
        switch (input){
            case "+" -> {
                return isGreater(guessCard, currentCard);
            }
            case "-" -> {
                return isLower(guessCard, currentCard);
            }
            default -> throw new IllegalStateException("Unexpected value: " + input);
        }
    }

    private boolean isLower(CardTarot guessCard, CardTarot currentCard) {
        if(guessCard.getIndex() == 20 && currentCard.getIndex() == 20){
            return guessCard.getValueAsNumber() < currentCard.getValueAsNumber();
        }
        if(guessCard.getIndex() == currentCard.getIndex() && guessCard.getIndex() != 20 ){
            endGame("GAGNÉ PAR ÉGALITÉ");
        }
        return guessCard.getIndex() < currentCard.getIndex();
    }

    private boolean isGreater(CardTarot guessCard, CardTarot currentCard) {
        if(guessCard.getIndex() == 20 && currentCard.getIndex() == 20){
            return guessCard.getValueAsNumber() > currentCard.getValueAsNumber();
        }
        if(guessCard.getIndex() == currentCard.getIndex() && guessCard.getIndex() != 20 ){
            endGame("GAGNÉ PAR ÉGALITÉ");
        }
        return guessCard.getIndex() > currentCard.getIndex();
    }

    private void revealCard() {

        if(cardCount < NBCARTES){
            guessCard.setImage(this.deck.get(cardCount + 1).getImage());
            PlusOuMoins.setGamePaused(true);

            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event ->
                    replaceCards()
            );
            pause.play();
        } else {
            endGameText.setText("FIN DE PARTIE");
            PlusOuMoins.setGamePaused(true);
        }
    }

    private void replaceCards() {
        currentCard.setImage(guessCard.getImage());
        guessCard.setImage(this.turnedCard);
        PlusOuMoins.setGamePaused(false);
    }

    public boolean isEndGame(){
        return endGame;
    }

    public void endGame(String text){
        endGame = true;
        endGameText.setText(text);
    }

}
