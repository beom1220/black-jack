package system;

import person.Dealer;
import person.Person;
import person.Player;

import java.util.Scanner;

public class UI {
    private Progress progress = new Progress();
    private Judgement judgement = new Judgement();
    public void betting(Player player, Dealer dealer) {
        player.clearHand();
        dealer.clearHand();
        Scanner sc = new Scanner(System.in);
        System.out.println("배팅 금액을 입력해주세요. : ");
    }
    public void openFirstCard(Player player, Dealer dealer) {
        System.out.println("-------------------------------");
        System.out.println("딜러의 공개 카드 : " + dealer.getHandCard(0).getShowNum() + dealer.getHandCard(0).getSuit());
        System.out.println("-------------------------------");
        System.out.println("플레이어의 핸드카드 1 : " + player.getHandCard(0).getShowNum() + player.getHandCard(0).getSuit());
        System.out.println("플레이어의 핸드카드 2 : " + player.getHandCard(1).getShowNum() + player.getHandCard(1).getSuit());
        System.out.println("현재 합 : " + player.getScore());
        blackjackMessage(player, judgement.isBlackjack(player));
        blackjackMessage(dealer, judgement.isBlackjack(dealer));
    }
    public void hitOrStand(Player player, Dealer dealer, Person person) {
        boolean hit = true;
        while (!judgement.isBlackjack(player) && !judgement.isBlackjack(dealer) && !judgement.isBust(person) && hit) {
            System.out.println("히트 혹은 스탠드를 선택합니다.");
            hit = person.hitSelect();
            hitOrStandMessage(person, hit);
        }
    }
    public void hitOrStandMessage(Person person, boolean hit) {
        if (hit) {
            progress.hit(person);
            System.out.println("히트하여 카드를 추가로 받습니다. : " + person.getHandCard(person.getNumOfHands()-1).getShowNum() + person.getHandCard(person.getNumOfHands()-1).getSuit());
            System.out.println("현재 합 : " + person.getScore());
            bustMessage(person, judgement.isBust(person));
        } else {
            System.out.println("스탠드하였습니다.");
        }
    }
    public void letHitOrStand(Player player, Dealer dealer) {
        if (!judgement.isBlackjack(player) && !judgement.isBlackjack(dealer)) {
            System.out.println("플레이어가 진행합니다. (히트:1/스탠드:2)");
            hitOrStand(player, dealer, player);
            if (!judgement.isBust(player)) {
                System.out.println("딜러가 진행합니다.");
                openDealerCard(dealer);
                hitOrStand(player, dealer, dealer);
            }
        }
    }
    public void openDealerCard(Dealer dealer) {
        System.out.println("딜러의 나머지 카드를 먼저 오픈합니다.");
        System.out.println("딜러의 히든카드 : " + dealer.getHandCard(1).getShowNum() + dealer.getHandCard(1).getSuit());
        System.out.println("딜러의 현재 합 : " + dealer.getScore());
    }
    public void result(Player player, Dealer dealer) {
        resultMessage(judgement.judge(player, dealer));
        player.setMoney(player.getMoney() + judgement.pay(judgement.judge(player, dealer), player.getBetMoney()));
    }
    public boolean gameContinue(Player player) {
        System.out.println("현재 보유 금액 : " + player.getMoney() + " 달러");
        System.out.println("게임을 이어서 하시겠습니까? (예:1 / 아니오:2)");
        Scanner sc = new Scanner(System.in);
        return (sc.nextInt()==1);
    }
    public void resultMessage(Result result) {
        switch (result) {
            case BLACKJACK:
                System.out.println("*********************************************");
                System.out.println("*블랙잭으로 승리하여 배팅 금액의 1.5배를 획득합니다.*");
                System.out.println("*********************************************");
                break;
            case WIN:
                System.out.println("*****************************************");
                System.out.println("*라운드를 승리하여 배팅 금액의 2배를 획득합니다.*");
                System.out.println("*****************************************");
                break;
            case LOSE:
                System.out.println("**************************************");
                System.out.println("*라운드에서 패배하여 배팅 금액을 잃었습니다.*");
                System.out.println("**************************************");
                break;
            case DRAW:
                System.out.println("************************************");
                System.out.println("*무승부하여 배팅 금액이 그대로 돌아옵니다.*");
                System.out.println("************************************");
                break;
        }
    }
    public void bustMessage(Person person, Boolean isBust) {
        if (isBust) {
            if (person instanceof Player) {
                System.out.println("플레이어가 버스트되었습니다!!");
            } else {
                System.out.println("딜러가 버스트되었습니다!!");
            }
        }
    }
    public void blackjackMessage(Person person, Boolean isBlackjack) {
        if (isBlackjack) {
            if (person instanceof Player) {
                System.out.println("플레이어가 블랙잭입니다!!");
            } else {
                System.out.println("딜러가 블랙잭입니다!!");
            }
        }
    }
}
