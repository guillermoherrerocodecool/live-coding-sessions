package com.codecool.codewars.pokerflush;

public class PokerFlushCheck {
    public boolean check(String[] cards) {
        String[] card = cards[0].split("");
        String suit = card[card.length - 1];
        return check(cards, 1, suit);
    }

    private boolean check(String[] cards, int index, String suit) {
        if (index == cards.length) {
            return true;
        }
        String card = cards[index];
        return card.endsWith(suit) && check(cards, index + 1, suit);
    }
}
