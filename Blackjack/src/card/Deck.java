package card;

import java.util.*;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public void makeDeck() {
        cards.clear();
        for (Card.Suit suit : Card.Suit.values()) {
            for (int num = 1; num <= 13; num++) {
                Card card = new Card(num, suit);
                cards.add(card);
            }
        }
    }

    public Card drawCard() {
        return cards.get((int) (Math.random() * cards.size()));
    }
}