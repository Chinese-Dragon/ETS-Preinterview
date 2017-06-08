package com.example;

/**
 * Created by mark93 on 6/8/2017.
 */

public class App {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Card[] cards = deck.getDeck();

        for(int i = 0; i < deck.getSize(); i ++) {
            System.out.println(deck.dealOneCard().toString());
        }

        deck.restore();
        System.out.println("<<=======================>>")
        System.out.println("Restore");
        System.out.println("<<=======================>>")


        for(int i = 0; i < deck.getSize(); i ++) {
            System.out.println(deck.dealOneCard().toString());
        }

        //this will give Exception
        deck.dealOneCard();
    }
}
