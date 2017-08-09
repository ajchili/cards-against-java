package main.java.com.kirinpatel.caj.util;

import com.sun.media.jfxmedia.logging.Logger;

import java.io.*;
import java.util.ArrayList;

import static main.java.com.kirinpatel.caj.util.Card.CARD_TYPE.BLANK;

public class CardImporter {

    public static ArrayList<Deck> importCards() {
        ArrayList<Deck> decks = new ArrayList<>();
        Logger.logMsg(Logger.INFO, "Loading cards...");
        File folder = new File("cards/");
        String[] subFolders = folder.list();
        if (subFolders != null && subFolders.length > 0) {
            Logger.logMsg(Logger.INFO, subFolders.length + " decks found.");
            for (String f : subFolders) {
                String deckName = f.replace('-', ' ');
                Logger.logMsg(Logger.INFO, "Loading \"" + deckName + "\" deck...");
                File fillerCards = new File("cards/" + f + "/filler.txt");
                File phraseCards = new File("cards/" + f + "/phrase.txt");
                if (fillerCards.exists() && phraseCards.exists()) {
                    Deck deck = new Deck(deckName);
                    Logger.logMsg(Logger.INFO, "Loading filler cards for deck \"" + deckName + "\"...");
                    deck.addFillerCards(readCards(fillerCards, deckName, Card.CARD_TYPE.FILLER));
                    Logger.logMsg(Logger.INFO, "Loading phrase cards for deck \"" + deckName + "\"...");
                    deck.addPhraseCards(readCards(phraseCards, deckName, Card.CARD_TYPE.PHRASE));
                    Logger.logMsg(Logger.INFO, "Loaded deck \"" + deckName + "\".");
                    decks.add(deck);
                } else {
                    Logger.logMsg(Logger.ERROR, "Missing card set for deck \"" + deckName + "\".");
                }
            }
        } else {
            Logger.logMsg(Logger.ERROR, "Unable to find decks.");
        }
        Logger.logMsg(Logger.INFO, "Loaded " +decks.size() + " decks.");
        Logger.logMsg(Logger.INFO, "Cards loaded.");
        return decks;
    }

    private static ArrayList<Card> readCards(File file, String deckName, Card.CARD_TYPE type) {
        ArrayList<Card> cards = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String card;
            while((card = reader.readLine()) != null) {
                if (card.isEmpty()) {
                    cards.add(new Card(BLANK, card));
                } else {
                    cards.add(new Card(type, card));
                }
            }
            if (type == Card.CARD_TYPE.FILLER) {
                Logger.logMsg(Logger.INFO, "Loaded " + cards.size() + " filler cards for \"" + deckName + "\".");
            } else {
                Logger.logMsg(Logger.INFO, "Loaded " + cards.size() + " phrase cards for \"" + deckName + "\".");
            }
        } catch (IOException e) {
            Logger.logMsg(Logger.ERROR, "Unable to read filler cards for deck \"" + deckName + "\"."
                    + "\n" + e.getMessage());
        }
        return cards;
    }
}
