package system;

import card.Deck;
import person.Dealer;
import person.Player;

import java.util.Scanner;

public class Game {
    private boolean gameContinue = true;
    public void play() {
        Deck deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer();
        System.out.println("블랙잭 게임을 시작합니다. 라운드가 끝나면 게임을 이어서 진행할지, 게임을 그만둘지 결정할 수 있습니다.");
        System.out.println("처음 시드머니는 100 달러에서 시작합니다.");
        do {
            deck.makeDeck();
            player.clearHand();
            int playerHitCount = 0;
            dealer.clearHand();
            int dealerHitCount = 0;
            System.out.println("라운드를 시작하기 전에, 가진 돈 이하로 배팅할 금액을 입력해주세요. : ");
            Scanner sc = new Scanner(System.in);
            player.setBetMoney(sc.nextInt());
            while (player.getBetMoney()>player.getMoney()) {
                System.out.println("배팅 금액이 보유 금액보다 큽니다. 다시 입력해주세요.");
                player.setBetMoney(sc.nextInt());
            }
            player.setMoney(player.getMoney() - player.getBetMoney());
            System.out.println(player.getBetMoney() + " 달러를 배팅하셨습니다. 게임을 진행합니다.");
            player.receiveCard(deck.drawCard());
            player.receiveCard(deck.drawCard());
            dealer.receiveCard(deck.drawCard());
            dealer.receiveCard(deck.drawCard());
            System.out.println("-------------------------------");
            System.out.println("딜러의 공개 카드 : " + dealer.getHandCard(0).showNum() + dealer.getHandCard(0).showSuit());
            System.out.println("-------------------------------");
            System.out.println("플레이어의 핸드카드 1 : " + player.getHandCard(0).showNum() + player.getHandCard(0).showSuit());
            System.out.println("플레이어의 핸드카드 2 : " + player.getHandCard(1).showNum() + player.getHandCard(1).showSuit());
            Judge judge = new Judge();
            System.out.println("현재 합 : " + player.getScore());
            if (judge.isBlackjack(player)) {
                System.out.println("플레이어가 블랙잭입니다!!");
            }
            if (judge.isBlackjack(dealer)) {
                System.out.println("딜러가 블랙잭입니다!!");
            }
            if (!judge.isBlackjack(player) && !judge.isBlackjack(dealer)) {
                System.out.println("히트하시겠습니까, 스탠드하시겠습니까? (히트:1 / 스탠드:2)");
                while (player.hitOrStand(sc.nextInt())) {
                    player.receiveCard(deck.drawCard());
                    System.out.println("카드를 추가로 받았습니다. : " + player.getHandCard(2+playerHitCount).showNum() + player.getHandCard((2+playerHitCount)).showSuit());
                    playerHitCount++;
                    System.out.println("현재 합 : " + player.getScore());
                    if (judge.isBust(player)) {
                        System.out.println("\n***합이 21을 초과하여 버스트하였습니다.***\n");
                        break;
                    }
                }
            }
            if (!judge.isBust(player)) {
                System.out.println("딜러 카드를 오픈합니다. : " + dealer.getHandCard(1).showNum() + dealer.getHandCard(1).showSuit());
                while (dealer.hitOrStand(dealer.getScore())) {
                    dealer.receiveCard(deck.drawCard());
                    System.out.println("딜러가 카드를 추가로 받았습니다. : " + dealer.getHandCard(2+dealerHitCount).showNum() + dealer.getHandCard(2+dealerHitCount).showSuit());
                    dealerHitCount++;
                    if (judge.isBust(dealer)) {
                        System.out.println("\n***딜러 합이 21을 초과하여 버스트하였습니다.***\n");
                        break;
                    }
                }
            }
            if (!judge.isBust(player) && !judge.isBust(dealer)) {
                System.out.println("딜러 최종 합 : " + dealer.getScore());
            }
            player.setMoney(judge.pay(judge.judge(player, dealer), player.getBetMoney())+player.getMoney());
            System.out.println("\n이어서 다음 라운드를 진행하시겠습니까? (진행 1 / 중단 2)");
            System.out.println("현재 시드머니 : " + player.getMoney() + " 달러");
            if (player.getMoney() == 0) {
                System.out.println("시드머니를 모두 소진하여 퇴장합니다.");
                break;
            } else {
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("게임을 이어서 진행합니다.");
                        break;
                    case 2:
                        System.out.println("게임을 중단합니다.");
                        gameContinue = false;
                        break;
                    default:
                        System.out.println("잘못된 입력값입니다. 게임을 중단합니다.");
                        gameContinue = false;
                        break;
                }
            }
        } while(gameContinue);
    }
}
