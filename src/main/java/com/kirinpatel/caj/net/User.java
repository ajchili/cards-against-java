package main.java.com.kirinpatel.caj.net;

import main.java.com.kirinpatel.caj.util.Card;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private final String name;
    private ArrayList<Card> hand = new ArrayList<>();

    public User() {
        name = System.getProperty("user/name");
    }

    public void addCardToHand(Card card) {
        if (hand.size() > 5 && card.getType() == Card.CARD_TYPE.FILLER) {
            hand.add(card);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
