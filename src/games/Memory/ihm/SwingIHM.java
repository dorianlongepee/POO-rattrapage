package games.Memory.ihm;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.cards.classique.CardTarot;
import common.cards.classique.Trump;
import common.cards.classique.Value;
import games.Memory.controller.SwingController;

public class SwingIHM {

	private static final int WIDTH_IMAGE_CARDS = 800;
	private static final int HEIGHT_IMAGE_CARDS =	630;
	
	private static ArrayList<JLabel> myLabels = new ArrayList<JLabel>();
	private CardTarot[] deck;
	private ImageIcon[] cuttedImages;
	private JFrame window;
	private SwingController controller;
	private int nbCartes;
	private JLabel scoreLabel;
	
	/**
	 * Constructor
	 * @param controller
	 */
	public SwingIHM(SwingController controller) {
		super();
		this.controller = controller;
		this.nbCartes = this.controller.getChoicePack();
		this.play();
	}
	
	/**
	 * Launcher common.game
	 */
	public void play() {

		JPanel panel = new JPanel();
		window = new JFrame();
		this.scoreLabel  = new JLabel("Score : ");
		EmptyBorder border = new EmptyBorder(15, 20, 5, 20);
		this.scoreLabel.setBorder(border);
		this.scoreLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		
		this.deckOfCards();		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.BOTH;

		gc.insets = new Insets(5, 5, 5, 5);

		gc.ipady = gc.anchor = GridBagConstraints.CENTER;	
		
		switch (nbCartes) {
		case 32:
			createGridMemory(gc,panel,4, 8);
			break;
		case 52:
			createGridMemory(gc,panel,4, 13);
			break;
		default:
			createGridMemory(gc,panel,4, 14);
		}

		// Visual deck of common.cards
		this.mixCards();
		for (int i = 0; i < deck.length; i++) {
			CardTarot cardTarot = deck[i];
			String card = cardTarot.toString();
			System.out.println(card);
		}
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(panel); 
		window.add(scoreLabel, BorderLayout.NORTH);
	    window.setTitle("MEMORY");
		window.setSize(950,850);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	/**
	 * Construct the deck of common.cards
	 */
	public void deckOfCards() {
		int width = WIDTH_IMAGE_CARDS/14;
		int height = HEIGHT_IMAGE_CARDS/6;

		deck = new CardTarot[nbCartes];
		cuttedImages=new ImageIcon[nbCartes+2];
		try {
			//EMPTY
			ImageIcon image0 = new ImageIcon(ImageIO.read(new File("./src/images/vide.png")));
			Image image = image0.getImage();
			cuttedImages[0] = new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_DEFAULT));
			//BACK
			image0 = new ImageIcon(ImageIO.read(new File("./src/images/dos.jpg")));
			image = image0.getImage();
			cuttedImages[1] = new ImageIcon(image.getScaledInstance(width, height, Image.SCALE_DEFAULT));
			
			int indice = 2;
			int index = 0;
			//Number Begin 6 => 32 | 0 => 56
			int nbBegin = (nbCartes == 32)? 6 : 0;
			int nbEnd = 14;
			
			for (int line = 2; line < 6; line++) {

				for (int i = nbBegin; i < nbEnd; i++) {
					image0 = new ImageIcon("./src/images/tarotcards.jpg");
					image = image0.getImage();
					image = window.createImage(new FilteredImageSource(image.getSource(),
							new CropImageFilter(i*width+1, line*height, width, height)));
					if(Value.getValueFor56CardsToString()[i].toString().equals(Value.CAVALIER.toString()) && nbCartes == 52) {
						continue;
					}
					cuttedImages[indice] = new ImageIcon(image);
					deck[indice-2] = new CardTarot(Trump.getTrumpsForCards()[line-2], Value.getValueFor56CardsToString()[i], index++, new ImageIcon(image));
					indice++;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adjust the points
	 * @param labeltext
	 */
	 public void setPoints (String labeltext){
        this.scoreLabel.setText(labeltext);
    }
	
	 /**
	  * Construct the grid of the common.game
	  * @param gc
	  * @param panel
	  * @param x
	  * @param y
	  */
	public void constructGrid(GridBagConstraints gc, JPanel panel,int x, int y) {
		gc.gridx = x;    
		gc.gridy = y;

		ImageIcon image = cuttedImages[1];
		JLabel label = new JLabel(image);
		myLabels.add(label);
		label.addMouseListener(new Mouse(x, y, this, nbCartes));
		panel.add(label, gc);
	}
	
	/**
	 * Loop for position the card step by step
	 * @param gc
	 * @param panel
	 * @param lengthX
	 * @param lengthY
	 */
	public void createGridMemory(GridBagConstraints gc, JPanel panel, int lengthX, int lengthY) {
		for(int x=0; x< lengthX; x++) {
			for(int y=0; y<lengthY;y++) {
				constructGrid(gc, panel,y,x);
			}
		}
	}
	
	/**
	 * Return the click of the card
	 * @param indexCardCliked
	 */
	public void getIndexCardClicked(int indexCardCliked) {
		this.controller.getIndexCardClicked(indexCardCliked);
	}
	
	/**
	 * Change the card by face card
	 * @param index
	 */
	public void changeCard(int index) {
		ImageIcon cardTarot = deck[index].getCardImage();
		JLabel newLabel = myLabels.get(index);
		newLabel.setIcon(cardTarot);
		myLabels.set(index, newLabel);
	}
	
	/**
	 * Change the card by back card
	 * @param index
	 */
	public void changeBackCard(int index) {
		ImageIcon cardTarot = this.cuttedImages[1];
		JLabel newLabel = myLabels.get(index);
		newLabel.setIcon(cardTarot);
		myLabels.set(index, newLabel);
	}
	
	/**
	 * Change the card by empty card
	 * @param index
	 */
	public void changeEmptyCard(int index) {
		ImageIcon cardTarot = this.cuttedImages[0];
		deck[index].setCardImage(cardTarot);
		JLabel newLabel = myLabels.get(index);
		newLabel.setIcon(cardTarot);
		myLabels.set(index, newLabel);
	}

	/**
	 * Return the deck of common.cards
	 * @return CardTarot[]
	 */
	public CardTarot[] getDeck() {
		return deck;
	}
	/**
	 * Updated the deck of common.cards
	 * @return CardTarot[]
	 */
	public void setDeck(CardTarot[] deck) {
		this.deck = deck;
	}	
	/**
	 * mixed the deck of common.cards
	 * @return CardTarot[]
	 */
	public CardTarot[] mixCards() {
		List<CardTarot> deckCards = Arrays.asList(deck);
    	Collections.shuffle(deckCards);
		return deckCards.toArray(deck);
	}
	
}
