package card;
import java.util.ArrayList;
import java.util.List;

public class Deck {
    List<Integer> cardDeck = new ArrayList<>();
    public int cardIndex = 0;
    public void makeDeck() {
        cardDeck.clear();
        cardIndex = 0;
        for (int i = 0; i < 52; i++) {
            int mixed = 0;
            do {
                mixed = (int) (Math.random() * 52) + 1;
                //System.out.println("이번엔"+mixed+"가 나왔다.");
            } while (cardDeck.contains(mixed));
            cardDeck.add(mixed);
            //System.out.println("그래서" + mixed + "를 넣었다.");
        }
        System.out.println("덱을 셔플했습니다.");
    }

    public int drawCard() {
        int cardId = cardDeck.get(cardIndex);
        //cardDeck.remove(cardIndex);
        cardIndex++;
        return cardId;
    }
}