package main.java.com.kirinpatel.caj.net;

import main.java.com.kirinpatel.caj.gui.GUI;

import static main.java.com.kirinpatel.caj.net.Network.NETWORK_TYPE.CLIENT;

public class Client extends Network {

    public Client() {
        super(CLIENT);
        new GUI(this);
    }
}
