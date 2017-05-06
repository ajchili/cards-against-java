package com.kirinpatel.net;

import com.kirinpatel.Main;
import com.kirinpatel.gui.ServerConsole;
import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Kirin Patel
 * @version 0.2
 */
public class Server extends JFrame {
    
    private static ExecutorService connectionExecutorService;
    private ServerSocket service;
    private static boolean isRunning = false;
    private ServerConsole console;
    
    public Server() {
        super("Cards Against Java - Server");
        
        setSize(600, 400);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        addComponentListener(new com.kirinpatel.gui.CloseListener());
        setLocationRelativeTo(null);
        
        console = new ServerConsole();
        add(console);
        
        isRunning = true;
        setVisible(true);
        
        new Thread(new ServerConnectionHandler()).start();
    }
    
    public void stop() {
        isRunning = false;
    }
    
    class ServerGameHandler implements Runnable {
        
        @Override
        public void run() {
            
        }
    }
    
    class ServerConnectionHandler implements Runnable {
    
        @Override
        public void run() {
            connectionExecutorService = Executors.newFixedThreadPool(10);
            
            try {
                service = new ServerSocket(8000);
                
                Socket socket;
                
                do {
                    socket = service.accept();
                    
                    connectionExecutorService.execute(new ServerClientHandler(socket));
                } while(isRunning && !Main.closeGame);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                stop();
            }
        }
    }
    
    class ServerClientHandler implements Runnable {
        
        private Socket socket;
        private boolean isConnected;
        
        public ServerClientHandler(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run() {
            
        }
    }
}
