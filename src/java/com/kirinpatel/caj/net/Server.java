package java.com.kirinpatel.caj.net;

import java.com.kirinpatel.caj.util.CardImporter;
import java.com.kirinpatel.caj.util.Deck;

import java.util.ArrayList;

public class Server {

    private static final ArrayList<Deck> DECKS = CardImporter.importCards();

    public Server() {

    }
}
