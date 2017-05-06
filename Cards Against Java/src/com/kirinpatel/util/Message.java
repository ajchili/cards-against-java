/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.util;

import javax.json.JsonObject;

/**
 *
 * @author Kirin Patel
 * @version 0.1
 */
public class Message {
    
    private int type;
    private Object message;
    
    public Message(int type, Object message) {
        this.type = type;
        this.message = message;
    }
    
    public Message(JsonObject object) {
        this.type = object.getInt("type");
    }
    
    public int getType() {
        return type;
    }
    
    public Object getMessage() {
        return message;
    }
}
