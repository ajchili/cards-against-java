package main.java.com.kirinpatel.caj.gui;

import com.sun.media.jfxmedia.logging.Logger;
import main.java.com.kirinpatel.caj.net.Client;
import main.java.com.kirinpatel.caj.net.Network;
import main.java.com.kirinpatel.caj.net.Server;
import main.java.com.kirinpatel.caj.util.Deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GUI extends JFrame {

    private final Network network;
    private Server server;
    private Client client;
    private ServerStatusPanel serverStatusPanel;

    public GUI (Network network) {
        super("Cards Against Java");
        Logger.logMsg(Logger.INFO, "Starting gui...");
        this.network = network;
        if (network.getType() == Network.NETWORK_TYPE.SERVER) {
            initializeServerGUI();
        } else {
            initializeClientGUI();
        }
        Logger.logMsg(Logger.INFO, "Started gui.");
    }

    private void initializeServerGUI() {
        server = (Server) network;
        setSize(600, 400);
        setResizable(false);
        setLayout(new GridLayout(2, 1));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        int deckSize = server.getDecks().size();
        JPanel decksPanel = new JPanel(new GridLayout(deckSize / 2 + deckSize % 2, 2));
        JScrollPane decksScrollPane = new JScrollPane(decksPanel);
        for (Deck deck : server.getDecks()) {
            JCheckBox deckBox = new JCheckBox(deck.getName()
                    + " (" + deck.getFillerCards().size() + ":" + deck.getPhraseCards().size() + ")",
                    deck.isEnabled());
            deckBox.addActionListener(e -> {
                deck.setEnabled(!deck.isEnabled());
                Logger.logMsg(Logger.INFO, deck.getName()
                        + " was " + (deck.isEnabled() ? "enabled." : "disabled."));
            });
            decksPanel.add(deckBox);
        }
        add(decksScrollPane);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
            }

            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                Logger.logMsg(Logger.INFO, "Closing gui...");
                server.stop();
                dispose();
                Logger.logMsg(Logger.INFO, "Closed gui.");
            }
        });
        setVisible(true);
    }

    private void initializeClientGUI() {
        client = (Client) network;
    }

    class ServerStatusPanel extends JPanel {

        public ServerStatusPanel() {
            super();
        }
    }
}
