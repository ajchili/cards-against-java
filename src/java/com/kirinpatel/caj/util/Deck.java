package java.com.kirinpatel.caj.util;

import java.util.ArrayList;

public class Deck {

    private final String name;
    private ArrayList<Card> fillerCards = new ArrayList<>();
    private ArrayList<Card> phraseCards = new ArrayList<>();

    Deck(String name) {
        this.name = name;
    }

    private void addFillerCard(Card card) {
        if (card.getType() == Card.CARD_TYPE.FILLER) {
            fillerCards.add(card);
        }
    }

    void addFillerCards(ArrayList<Card> cards) {
        for (Card card : cards) {
            addFillerCard(card);
        }
    }

    private void addPhraseCard(Card card) {
        if (card.getType() == Card.CARD_TYPE.PHRASE) {
            phraseCards.add(card);
        }
    }

    void addPhraseCards(ArrayList<Card> cards) {
        for (Card card : cards) {
            addPhraseCard(card);
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getFillerCards() {
        return fillerCards;
    }

    public ArrayList<Card> getPhraseCards() {
        return phraseCards;
    }
}
