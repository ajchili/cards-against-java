package com.kirinpatel.gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Kirin Patel
 * @version 0.1
 */
public class CardButton extends JButton {
    
    private String text;
    
    public CardButton(String text) {
        setText(text);
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
}
