package card;
public class Card {
    String cardNum;
    String cardSuit;
    int cardScore;
    int cardId;

    public Card(int cardId) {
        this.cardId = cardId;
        this.cardNum = setNum();
        this.cardScore = setScore();
        this.cardSuit = setSuit();
    }

    public String setNum() {
        if((cardId) % 13 == 1) {
            cardNum = "A";
        } else if ((cardId) % 13 == 11) {
            cardNum = "J";
        } else if ((cardId) % 13 == 12) {
            cardNum = "Q";
        } else if ((cardId) % 13 == 0) {
            cardNum = "K";
        } else {
            cardNum = Integer.toString((cardId) % 13);
        }
        return cardNum;
    }

    public String setSuit() {
        switch ((int) (cardId-1) / 13){
            case 0:
                cardSuit = "♠";
                break;
            case 1:
                cardSuit = "♢";
                break;
            case 2:
                cardSuit = "♡";
                break;
            case 3:
                cardSuit = "♣";
                break;
        }
        return cardSuit;
        // 0이면 스페이드, 1은 다이아몬드, 2는 하트, 3은 클로버로 사용될 예정.
    }

    public int setScore() {
        int checkScore = (cardId) % 13;
        if (checkScore>10 | checkScore == 0) {
            checkScore = 10;
        }
        return checkScore;
    }

    //private enum Suit {
    //    SPADE, DIAMOND, HEART, CLOVER
    //}
}
