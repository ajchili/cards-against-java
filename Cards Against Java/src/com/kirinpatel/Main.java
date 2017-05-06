/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel;

import com.kirinpatel.util.CardImporter;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Kirin Patel
 * @version 0.2
 */
public class Main {
    
    public static boolean closeGame = false;
    
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> cards = CardImporter.importCards(1, 2);
        
        cards.forEach((card) -> {
            System.out.println(card);
        });
    }
}
