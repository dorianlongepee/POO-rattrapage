package common.cards.pack;

import common.cards.classique.CardTarot;
import common.cards.classique.Trump;
import common.cards.classique.Value;
import javafx.scene.image.Image;

import java.util.Objects;

public class PackTarotPlusOuMoins extends Pack<CardTarot> {

    public PackTarotPlusOuMoins(boolean isEmpty){
        super();
        if(!isEmpty) {
            for(Trump trump : Trump.values()) {
                for(Value value : Value.getValueForTarot() ) {
                    String path = "../../../assets/cards/"+ value.toString() + "-" + trump.toString() +".png";
                    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
                    this.add(new CardTarot(trump.toString(),value.toString(),value.getWeight(), image));
                }
            }

            for(int i = 0; i < 22; i++){
                String path = "../../../assets/cards/atouts/" + i + "-" + Value.ATOUT + ".png";
                Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
                this.add(new CardTarot(Value.ATOUT.toString(), String.valueOf(i),Value.ATOUT.getWeight(), image));
            }

            super.mixPack();
        }
    }
}
