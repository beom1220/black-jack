package system;

import card.Deck;
import person.Dealer;
import person.Person;
import person.Player;

import java.util.Scanner;

public class Progress {
    private Deck deck = new Deck();
    public Progress() {
        deck.makeDeck();
    }
    public void giveFirstCard(Player player, Dealer dealer) {
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
    }
    public void betting(Player player) {
        int bet;
        Scanner sc = new Scanner(System.in);
        do {
            bet = sc.nextInt();
            if (bet > player.getMoney()) {
                System.out.println("입력하신 금액이 보유 금액보다 큽니다. 다시 입력해주세요. : ");
            }
        } while (bet > player.getMoney());
        player.betting(bet);
    }
    public void hit(Person person) {
        person.receiveCard(deck.drawCard());
    }
}