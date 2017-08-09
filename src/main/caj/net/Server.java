package main.caj.net;

import main.caj.util.CardImporter;
import main.caj.util.Deck;

import java.util.ArrayList;

public class Server {

    private static final ArrayList<Deck> DECKS = CardImporter.importCards();

    public Server() {

    }
}
