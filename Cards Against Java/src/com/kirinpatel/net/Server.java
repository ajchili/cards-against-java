/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.net;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Kirin Patel
 * @version 0.1
 */
public class Server extends JFrame {
    
    private static boolean isRunning = false;
    private JTextArea console;
    
    public Server() {
        super("Cards Against Java - Server");
        
        setSize(600, 400);
        setResizable(false);
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        addComponentListener(new com.kirinpatel.gui.CloseListener());
        setLocationRelativeTo(null);
        
        console = new JTextArea();
        add(console);
        
        JPanel interactionPanel = new JPanel();
        add(interactionPanel);
        
        setVisible(true);
        isRunning = true;
    }
    
    public void stop() {
        isRunning = false;
        dispose();
    }
}
