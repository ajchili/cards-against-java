package com.kirinpatel.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will import cards from .dat files inside of the res folder.
 * Currently there is no support for custom cards.
 *
 * @author Kirin Patel
 * @version 1.1
 */
public class CardImporter {
    
    private static final String[] GAME_TYPE = { "humanity", "profanity"};
    private static final String[] CARD_TYPE = { "black", "orange", "white" };
    
    /**
     * This method will import cards from specified game and card type.
     * For the humanity version of the cards, provide a game type of 0. Then,
     * use a card type of 0 for black cards or a card type of 2 for white cards.
     * For the profanity version of the cards, provide a game type of 1. Then,
     * use a card type of 1 for the orange cards or a card type of 2 for the
     * white cards.
     * 
     * @param gameType Type of game
     * @param cardType Type of card
     * @return Returns card for specified game and card type
     */
    public static ArrayList<String> importCards(int gameType, int cardType) throws FileNotFoundException {
        ArrayList<String> cards = new ArrayList<>();
        Scanner s = new Scanner(new File("./res/" + GAME_TYPE[gameType] + "/" + CARD_TYPE[cardType] + ".dat"));
        
        while(s.hasNext()) {
            cards.add(s.nextLine());
        }
        
        return cards;
    }
}
