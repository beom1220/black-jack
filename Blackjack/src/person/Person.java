package person;

import card.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private List<Card> handCard = new ArrayList<>();
    public abstract boolean hitOrStand(int check);
    public void receiveCard(Card card) {
        handCard.add(card);
    }
    public int getNumber(int index) {
        return handCard.get(index).getCardNum();
    }
    public int getScore() {
        int sum = 0;
        for (int scoreLoop = 0; scoreLoop < handCard.size(); scoreLoop++) {
            sum += handCard.get(scoreLoop).getCardScore();
        }
        return sum;
    }
    public void clearHand() {
        handCard.clear();
    }
    public Card getHandCard(int index) {
        return handCard.get(index);
    }
}
