package main.java.com.kirinpatel.caj.net;

import com.sun.media.jfxmedia.logging.Logger;
import main.java.com.kirinpatel.caj.gui.GUI;
import main.java.com.kirinpatel.caj.util.CardImporter;
import main.java.com.kirinpatel.caj.util.Deck;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static main.java.com.kirinpatel.caj.net.Network.NETWORK_TYPE.SERVER;

public class Server extends Network {

    private static final ArrayList<Deck> DECKS = CardImporter.importCards();
    private static ArrayList<User> clients = new ArrayList<>();
    private boolean allowBlankCards = true;
    private GUI gui;
    private ServerThread serverThread;

    public Server() {
        super(SERVER);
        Logger.logMsg(Logger.INFO, "Starting server...");
        gui = new GUI(this);
        serverThread = new ServerThread();
        new Thread(serverThread).start();
    }

    public void setAllowBlankCards(boolean allowBlankCards) {
        this.allowBlankCards = allowBlankCards;
    }

    public void stop() {
        Logger.logMsg(Logger.INFO, "Closing server...");
        serverThread.stop();
    }

    class ServerThread implements Runnable {

        private ExecutorService executorService;
        private ServerSocket service;
        private Socket socket;
        private boolean isRunning = true;

        @Override
        public void run() {
            executorService = Executors.newCachedThreadPool();
            try {
                service = new ServerSocket(8000);
            } catch (IOException e) {
                Logger.logMsg(Logger.ERROR, "Error starting server! " + e.getMessage());
                isRunning = false;
            }
            Logger.logMsg(Logger.INFO, "Server started.");
            while (isRunning) {
                try {
                    socket = service.accept();
                    executorService.execute(new CommunicationThread(socket));
                } catch (IOException e) {
                    // Ignore as it is almost always thrown when server is shutting down
                }
            }
            Logger.logMsg(Logger.INFO, "Closed server.");
        }

        void stop() {
            isRunning = false;
            try {
                service.close();
            } catch (IOException e) {
                // Ignore as sever will be closing
            }
            try {
                if (socket!= null) {
                    socket.close();
                }
            } catch (IOException e) {
                // Ignore as sever will be closing
            }
        }

        class CommunicationThread implements Runnable {

            private final Socket socket;
            private User client;

            CommunicationThread(Socket socket) {
                this.socket = socket;
            }

            @Override
            public void run() {
                while (isRunning) {

                }
            }
        }
    }
}
