/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.util;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kirin Patel
 * @version 1.0
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
    public static ArrayList<String> importCards(int gameType, int cardType) {
        ArrayList<String> cards = new ArrayList<>();
        Scanner s = new Scanner("./res/" + GAME_TYPE[gameType] + "/" + CARD_TYPE[cardType] + ".dat");
        
        while(s.hasNext()) {
            cards.add(s.nextLine());
        }
        
        return cards;
    }
}
