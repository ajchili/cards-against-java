/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.gui;

import com.kirinpatel.Main;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * This method will handle component events for GUI parts of the game.
 *
 * @author Kirin Patel
 * @version 0.1
 */
public class CloseListener implements ComponentListener {
    
    /**
     * Unused method.
     * 
     * @param e Component Event
     */
    @Override
    public void componentResized(ComponentEvent e) {
        // Unused method
    }

    /**
     * Unused method.
     * 
     * @param e Component Event
     */
    @Override
    public void componentMoved(ComponentEvent e) {
        // Unused method
    }

    /**
     * Unused method.
     * 
     * @param e Component Event
     */
    @Override
    public void componentShown(ComponentEvent e) {
        // Unused method
    }

    /**
     * Closes application on window hide event.
     * 
     * @param e Component Event
     */
    @Override
    public void componentHidden(ComponentEvent e) {
        Main.closeGame = true;
    }
}
