package main.java.com.kirinpatel.caj.net;

import main.java.com.kirinpatel.caj.util.CardImporter;
import main.java.com.kirinpatel.caj.util.Deck;

import java.util.ArrayList;

import static main.java.com.kirinpatel.caj.net.Network.NETWORK_TYPE.SERVER;

public class Server extends Network {

    private static final ArrayList<Deck> DECKS = CardImporter.importCards();
    private static ArrayList<User> clients = new ArrayList<>();

    public Server() {
        super(SERVER);
    }
}
