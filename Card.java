package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mark93 on 6/8/2017.
 */

public class Card {

    //SUITE
    public final static int HEARTS = 1;
    public final static int SPADES = 2;
    public final static int CLUBS = 3;
    public final static int DIAMONDS = 4;

    //FACE VALUES
    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    //creating suit and value mapping
    private static final Map<Integer, String> valueMap = createValueMap();
    private static Map<Integer, String> createValueMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "ACE");
        map.put(11, "JACK");
        map.put(12, "QUEEN");
        map.put(13, "KING");
        return map;
    }

    private static final Map<Integer, String> suitMap = createSuitMap();
    private static Map<Integer, String> createSuitMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "HEARTS");
        map.put(2, "SPADES");
        map.put(3, "CLUBS");
        map.put(4, "DIAMONDS");
        return map;
    }

    //instance variables
    private final int suit;
    private final int value;

    public Card(int _suit, int _value) {

        //check if suit and value are valid
        if(_suit != HEARTS && _suit != SPADES && _suit != CLUBS && _suit != DIAMONDS) {
            throw new IllegalArgumentException("Suit must be between 1 - 4");
        }

        if(_value < ACE || _value > KING) {
            throw new IllegalArgumentException("Face value must be between 1 - 13");
        }

        this.suit = _suit;
        this.value = _value;
    }

    //getters
    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(value > 1 && value < 11) {
            builder.append(value).append(" of ").append(suitMap.get(suit));
        } else {
            builder.append(valueMap.get(value)).append(" of ").append(suitMap.get(suit));
        }

        return builder.toString();
    }
}
