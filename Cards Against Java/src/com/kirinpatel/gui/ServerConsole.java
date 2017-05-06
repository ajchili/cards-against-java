/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Kirin Patel
 * @verion 0.1
 */
public class ServerConsole extends JPanel {
    
    private JTextArea console;
    
    public ServerConsole() {
        super();
        console = new JTextArea();
        console.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(console);
        add(console);
    }
    
    public void appendText(String text) {
        console.append(text);
    }
}
