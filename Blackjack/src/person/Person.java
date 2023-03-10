package person;

import card.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    private List<Card> handCard = new ArrayList<>();
    public abstract boolean hitSelect();
    public void receiveCard(Card card) {
        handCard.add(card);
    }
    public int getScore() {
        int sum = 0;
        boolean hasA = false;
        for (int scoreLoop = 0; scoreLoop<handCard.size();scoreLoop++) {
            sum += getHandCard(scoreLoop).getCardScore();
            if (getHandCard(scoreLoop).getCardScore() == 1) {
                hasA = true;
            }
        }
        if (hasA && (sum+10)<=21) {
            sum += 10;
        }
        return sum;
    }
    public void clearHand() {
        handCard.clear();
    }
    public Card getHandCard(int index) {
        return handCard.get(index);
    }
    public int getNumOfHands() {
        return handCard.size();
    }
}
