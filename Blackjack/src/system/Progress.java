package system;

import card.Deck;
import person.Dealer;
import person.Person;
import person.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Progress {
    Deck deck = new Deck();
    Scanner sc = new Scanner(System.in);
    public void setNewGame(Player player, Dealer dealer) {
        player.clearHand();
        dealer.clearHand();
        deck.makeDeck();
        bet(player);
        receiveFirstCard(player, dealer);
    }
    public void bet(Player player) {
        int bet;
        do {
            while (true) {
                try {
                    bet = sc.nextInt();
                    break;
                } catch (InputMismatchException ime) {
                    sc = new Scanner(System.in);
                    UI.errorMessage();
                }
            }
            if (bet > player.getMoney()) {
                UI.overBet();
            }
            if (bet <= 0) {
                UI.minusBet();
            }
        } while (bet > player.getMoney() | bet<=0);
        player.bet(bet);
    }
    public void receiveFirstCard(Person player, Person dealer) {
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
    }
    public void checkBlackjack(Person person) {
        if (Judgement.isBlackjack(person)) {
            UI.blackjackMessage(person);
        }
    }
    public void letHitOrStand(Player player, Dealer dealer) {
        if (!Judgement.isBlackjack(player) && !Judgement.isBlackjack(dealer)) {
            UI.goHitOrStand(player);
            hitOrStand(player);
            if (!Judgement.isBust(player)) {
                UI.goHitOrStand(dealer);
                UI.openDealerCard(dealer);
                hitOrStand(dealer);
            }
        }
    }
    public void hitOrStand(Person person) {
        boolean hitSelect = true;
        while (!Judgement.isBust(person) && hitSelect) {
            UI.selectHitOrStand(person);
            hitSelect = person.selectHit();
            if (hitSelect) {
                hit(person);
            } else {
                UI.standMessage(person);
            }
            checkBust(person);
        }
    }
    public void hit(Person person) {
        person.receiveCard(deck.drawCard());
        UI.hitMessage(person);
    }
    public void checkBust(Person person) {
        if (Judgement.isBust(person)) {
            UI.bustMessage(person);
        }
    }
    public void showResult(Player player, Dealer dealer) {
        UI.resultMessage(Judgement.judge(player, dealer));
        player.setMoney(player.getMoney() + Judgement.pay(Judgement.judge(player, dealer), player.getBetMoney()));
    }
    public boolean continueGame(Player player) {
        Scanner sc = new Scanner(System.in);
        return (player.getMoney() != 0 && sc.nextLine().equals("1"));
    }
    public void checkMoney(Player player) {
        if (player.getMoney() == 0) {
            UI.noMoneyMessage(player);
        }
    }
}
