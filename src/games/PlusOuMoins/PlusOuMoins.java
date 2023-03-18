package games.PlusOuMoins;

import common.cards.classique.CardClassic;
import common.cards.pack.PackTarotPlusOuMoins;
import common.game.Game;
import common.player.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class PlusOuMoins extends Application {
    Stage window;
    private static Game<CardClassic> game;

    private static boolean gamePaused = false;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Scene scene = new Scene(loader.load(), Color.BLACK);
        PackTarotPlusOuMoins deck = new PackTarotPlusOuMoins(false);
        System.out.println(deck);
        Player player = game.getCurrentPlayer();
        stage.setTitle("Plus ou Moins");
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();

        Controller controller = loader.getController();
        controller.initiateGame(deck, player);

        scene.setOnKeyPressed(event -> {
            if(!gamePaused && !controller.isEndGame()) {
                switch (event.getCode()) {
                    case UP -> {
                        try {
                            controller.input("+");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    case DOWN -> {
                        try {
                            controller.input("-");
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            } else {
                System.out.println("game paused, can't play");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setGamePaused(boolean isPaused){
        gamePaused = isPaused;
    }
    public static void setGame(common.game.Game<CardClassic> gameCurrent){
        game = gameCurrent;
    }
}