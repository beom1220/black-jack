package system;

import card.Card;
import card.Deck;
import person.Dealer;
import person.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public void play() {
        Deck deck = new Deck();
        deck.makeDeck();
        boolean inputContinue = true;
        Player player = new Player();
        Dealer dealer = new Dealer();
        player.money = 100;
        int hitCount = 0;
        int dealerHitCount = 0;
        int roundCount = 0;
        System.out.println("블랙잭 게임을 시작합니다. 라운드가 끝나면 게임을 이어서 진행할지, 게임을 그만둘지 결정할 수 있습니다.");
        System.out.println("처음 시드머니는 100 달러에서 시작합니다.");
        do {
            boolean isPlayerBlackjack = false, isDealerBlackjack = false, isPlayerBust = false, isDealerBust = false, isPlayerA = false, isDealerA = false;
            if (4*roundCount + hitCount + dealerHitCount >= 42) {
                System.out.println("남은 덱의 매수가 10장 이하이기 때문에 덱을 리필하여 셔플합니다.");
                deck.makeDeck();
                hitCount = 0;
                dealerHitCount = 0;
                roundCount = 0;
            }
            System.out.println("라운드를 시작하기 전에, 가진 돈 이하로 배팅할 금액을 입력해주세요. : ");
            Scanner sc = new Scanner(System.in);
            player.betMoney = sc.nextInt();
            while (player.betMoney > player.money) {
                System.out.println("입력하신 배팅 금액이 가진 돈보다 큽니다. 다시 입력해주세요. : ");
                player.betMoney = sc.nextInt();
            }
            player.money -= player.betMoney;
            System.out.println(player.betMoney + " 달러를 배팅하셨습니다. 게임을 진행합니다.");
            roundCount++;
            //뭔가 게임 진행을 함.
            Card p1 = new Card(deck.drawCard());
            Card p2 = new Card(deck.drawCard());
            Card d1 = new Card(deck.drawCard());
            Card d2 = new Card(deck.drawCard());
            player.handCard.add(p1);
            player.handCard.add(p2);
            dealer.handCard.add(d1);
            dealer.handCard.add(d2);
            System.out.println("-------------------------------");
            System.out.println("딜러의 공개 카드 : " + d1.setNum() + d1.setSuit());
            System.out.println("-------------------------------");
            System.out.println("플레이어의 핸드카드 1 : " + p1.setNum() + p1.setSuit());
            System.out.println("플레이어의 핸드카드 2 : " + p2.setNum() + p2.setSuit());
            if (d1.setScore() == 1 | d2.setScore() == 1) {
                isDealerA = true;
            }
            if (p1.setScore() == 1 | p2.setScore() == 1) {
                isPlayerA = true;
            }
            player.score = p1.setScore() + p2.setScore();
            //System.out.println("현재 점수 : " + player.score);
            dealer.score = d1.setScore() + d2.setScore();
            if (p1.setScore() * p2.setScore() == 10 && player.score == 11) {
                System.out.println("플레이어가 블랙잭입니다!!");
                isPlayerBlackjack = true;
            }
            if (d1.setScore() * d2.setScore() == 10 && dealer.score == 11) {
                System.out.println("딜러가 블랙잭입니다!!");
                isDealerBlackjack = true;
            }
            if (isDealerA) {
                dealer.score += 10;
            }
            if (!isPlayerBlackjack && !isDealerBlackjack) {
                System.out.println("히트하시겠습니까, 스탠드하시겠습니까? (히트:1 / 스탠드:2)");
                boolean isHit = player.hitOrStand(sc.nextInt());
                while (isHit) {
                    player.handCard.add(new Card(deck.drawCard()));
                    System.out.println("카드를 추가로 받았습니다. : " + player.handCard.get(2*roundCount + hitCount).setNum() + player.handCard.get(2*roundCount + hitCount).setSuit());
                    player.score += player.handCard.get(2*roundCount + hitCount).setScore();
                    //System.out.println("현재 점수 : " + player.score);
                    hitCount++;
                    if (player.score > 21) {
                        isPlayerBust = true;
                        isHit = false;
                        System.out.println("\n***합이 21을 초과하여 버스트하였습니다.***\n");
                    }
                    if (!isPlayerBust) {
                        System.out.println("히트하시겠습니까, 스탠드하시겠습니까? (히트:1 / 스탠드:2)");
                        isHit = player.hitOrStand(sc.nextInt());
                    }
                }
                if (!isPlayerBust) {
                    System.out.println("딜러 카드를 오픈합니다. : " + d2.setNum() + d2.setSuit());
                    isHit = dealer.hitOrStand(dealer.score);
                    while (isHit) {
                        dealer.handCard.add(new Card(deck.drawCard()));
                        System.out.println("딜러가 카드를 추가로 받았습니다." + dealer.handCard.get(2*roundCount + dealerHitCount).setNum() + dealer.handCard.get(2*roundCount + dealerHitCount).setSuit());
                        dealer.score += dealer.handCard.get(2*roundCount + dealerHitCount).setScore();
                        dealerHitCount++;
                        if (dealer.score > 21) {
                            if (isDealerA) {
                                dealer.score -= 10;
                            }
                            if (dealer.score > 21) {
                                isDealerBust = true;
                                System.out.println("\n***딜러 합이 21이 초과되어 버스트되었습니다.***\n");
                            }
                        }
                        isHit = dealer.hitOrStand(dealer.score);
                    }
                }
                if (!isDealerBust && !isPlayerBust) {
                    System.out.println("딜러 최종 합 : " + dealer.score);
                }
            }
            //여기까지 게임 진행에 관한 거.
            Judge judge = new Judge(isPlayerBlackjack, isDealerBlackjack, isPlayerBust, isDealerBust, player.score, dealer.score, isPlayerA, isDealerA);
            Result result = new Result(judge.judge());
            player.money = result.settle(player.money, player.betMoney);
            System.out.println("\n이어서 다음 라운드를 진행하시겠습니까? (진행 : 1 / 중단 : 2)");
            System.out.println("현재 시드머니 : " + player.money + " 달러");
            if (player.money == 0) {
                inputContinue = false;
                System.out.println("시드머니를 모두 소진하여 퇴장합니다.");
            } else {
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("게임을 이어서 진행합니다.");
                        //inputContinue = true;
                        break;
                    case 2:
                        System.out.println("게임을 중단합니다.");
                        inputContinue = false;
                        break;
                    default:
                        System.out.println("잘못된 입력을 하여 게임을 중단합니다.");
                        inputContinue = false;
                        break;
                }
            }
        } while (inputContinue);
    }
}
