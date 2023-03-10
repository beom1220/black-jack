package card;

public class Card {
    public enum Suit {
        SPADE, DIAMOND, HEART, CLOVER
    }
    private int cardNum;
    private Suit cardSuit;

    public Card(int cardNum, Suit cardSuit) {
        this.cardNum = cardNum;
        this.cardSuit = cardSuit;
    }

    public String getShowNum() {
        if (cardNum == 1) {
            return "A";
        } else if (cardNum == 11) {
            return "J";
        } else if (cardNum == 12) {
            return "Q";
        } else if (cardNum == 13) {
            return "K";
        } else {
            return Integer.toString(cardNum);
        }
    }
    public String getSuit() {
        switch (cardSuit) {
            case SPADE:
                return "♠";
            case DIAMOND:
                return "♢";
            case HEART:
                return "♡";
            default:
                return "♣";
        }
    }
    public int getCardScore() {
        if (cardNum > 10) {
            return 10;
        } else {
            return cardNum;
        }
    }
}
