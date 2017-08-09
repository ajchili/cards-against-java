package main.java.com.kirinpatel.caj.util;

import java.io.Serializable;

public class Card implements Serializable {

    private static final String[] BLANK_SPACE = { "BLANK", "________"};
    private final CARD_TYPE type;
    private final String text;
    private int blankSpaces = 0;

    public enum CARD_TYPE {
        FILLER(0),
        PHRASE(1),
        BLANK(2);

        private int cardType;

        CARD_TYPE(int cardType) {
            this.cardType = cardType;
        }

        public int getCardType() {
            return cardType;
        }
    }

    public Card(CARD_TYPE type, String text) {
        this.type = type;
        while (text.contains(BLANK_SPACE[0])) {
            blankSpaces++;
            text = text.replaceFirst(BLANK_SPACE[0], BLANK_SPACE[1]);
        }
        this.text = text;
    }

    public CARD_TYPE getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
