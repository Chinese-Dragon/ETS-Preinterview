package com.example;

import java.util.Random;

/**
 * Created by mark93 on 6/8/2017.
 */

public class Deck {
    private final static int NUM_CARD = 52;
    private Card[] deck;
    private int numUsed;

    public Deck() {
        deck = new Card[NUM_CARD];
        numUsed = 0;

        int size = 0;
        for(int suit = 1; suit <= Card.DIAMONDS; suit++) {
            for(int value = 1; value <= Card.KING; value++ ) {
                deck[size] = new Card(suit, value);
                size ++;
            }
        }
    }

    public void shuffle() {
        for(int i = 0; i < NUM_CARD; i ++) {
            int randIndex = i + new Random().nextInt(NUM_CARD - i);
            Card temp = deck[randIndex];
            deck[randIndex] = deck[i];
            deck[i] = temp;
        }
    }

    public Card dealOneCard() {
        Card result;
        if(numUsed == NUM_CARD) {
            throw new IllegalStateException("There is nothing left in the deck");
        }
        result = deck[numUsed];
        numUsed ++;

        return result;
    }

    public Card[] getDeck() {
        return deck;
    }

    public int getNumUsed() {
        return numUsed;
    }

    public int getSize() {
        return NUM_CARD;
    }

    public void restore() {
        numUsed = 0;
    }
}
