package system;

import person.Dealer;
import person.Person;
import person.Player;

public final class UI {
    public static void menuMessage(Player player) {
        System.out.println("***********************************");
        System.out.println("************* [블랙잭] *************");
        System.out.println("******* 실행할 번호를 입력하세요.******");
        System.out.println("****[1.진행 2.초기화 3.규칙 4.종료]***");
        System.out.println("***** 현재 보유 금액 : [" + player.getMoney() + "]달러 *****");
        System.out.println("***********************************");
        System.out.print("실행할 번호 : ");
    }
    public static void resetMessage() {
        System.out.println("플레이어의 시드머니가 100 달러로 초기화되었습니다.");
    }
    public static void ruleMessage() {
        System.out.println("블랙잭 게임의 규칙을 설명해드리겠습니다.");
        System.out.println("1. 라운드마다 플레이어는 배팅을 합니다.");
        System.out.println("2. 딜러와 플레이어는 2장씩의 카드를 받습니다.");
        System.out.println("3. 딜러는 그 중 한장의 카드를 공개합니다.");
        System.out.println("4. 플레이어는 카드를 더 받을지(히트), 더 받지 않을지(스탠드) 선택합니다.");
        System.out.println("5. 합이 21을 초과하지 않는 한, 히트는 계속할 수 있습니다.");
        System.out.println("6. 합이 21을 초과하는 건 버스트라고 하며, 즉시 패배합니다.");
        System.out.println("7. 처음 두 장의 합이 21인 경우에는 블랙잭이라고 하며, 배팅 금액의 1.5배를 돌려받습니다.");
        System.out.println("8. 이 경우, 딜러도 블랙잭이라면 무승부로 배팅 금액을 그대로 돌려받습니다.");
        System.out.println("9. 블랙잭도 버스트도 아닌 경우에, 플레이어의 스탠드 이후에 딜러의 히트or스탠드가 진행됩니다.");
        System.out.println("10. 딜러는 총합이 16 이하이면 히트, 17 이상이면 스탠드합니다.");
        System.out.println("11. 딜러는 버스트하지 않는 한, A를 11로 취급합니다.");
        System.out.println("12. J, Q, K는 모두 10점이며, A는 1 또는 11로 계산합니다.");
        System.out.println("13. 딜러가 버스트하면 즉시 승리하며, 딜러가 스탠드하면 서로의 총합을 비교합니다.");
        System.out.println("14. 총합이 21에 가까운 쪽이 승리하며, 같다면 무승부입니다.");
        System.out.println("15. 승리하면 배팅 금액의 2배를, 패배하면 0배를 돌려받습니다.");
        System.out.println("16. 추가로, 라운드를 진행하다가 덱이 10장 이하가 되면 덱을 새로 셔플합니다.");
    }
    public static void bet() {
        System.out.print("배팅 금액을 입력해주세요. : ");
    }
    public static void overBet() {
        System.out.println("입력하신 금액이 보유 금액보다 큽니다. 다시 입력해주세요. : ");
    }
    public static void minusBet() {
        System.out.println("배팅금액은 0보다 큰 값을 입력해야 합니다. 다시 입력해주세요. : ");
    }
    public static void openFirstCard(Person player, Person dealer) {
        System.out.println("카드를 받습니다.");
        System.out.println("-------------------------------");
        System.out.println("딜러의 공개 카드 : " + dealer.getHandCard(0).getShowNum() + dealer.getHandCard(0).getSuit());
        System.out.println("-------------------------------");
        System.out.println("플레이어의 핸드카드 1 : " + player.getHandCard(0).getShowNum() + player.getHandCard(0).getSuit());
        System.out.println("플레이어의 핸드카드 2 : " + player.getHandCard(1).getShowNum() + player.getHandCard(1).getSuit());
        System.out.println("현재 합 : " + player.getScore());
    }
    public static void blackjackMessage(Person person) {
        if (person instanceof Player) {
            System.out.println("플레이어가 블랙잭입니다!!");
        } else {
            System.out.println("딜러가 블랙잭입니다!!");
        }
    }
    public static void hitMessage(Person person) {
        System.out.println("히트하여 카드를 추가로 받습니다. : " + person.getHandCard(person.getNumOfHands()-1).getShowNum() + person.getHandCard(person.getNumOfHands()-1).getSuit());
        System.out.println("현재 합 : " + person.getScore());
    }
    public static void bustMessage(Person person) {
        if (person instanceof Player) {
            System.out.println("플레이어가 버스트되었습니다!!");
        } else {
            System.out.println("딜러가 버스트되었습니다!!");
        }
    }
    public static void goHitOrStand(Person person) {
        if (person instanceof Player) {
            System.out.println("플레이어가 \"히트 or 스탠드\"를 선택합니다.");
        } else {
            System.out.println("딜러가 \"히트 or 스탠드\"를 선택합니다.");
        }
    }
    public static void selectHitOrStand(Person person) {
        if (person instanceof Player) {
            System.out.println("히트 : 1 / 스탠드 : 2");
        } else {
            System.out.println("딜러가 히트 혹은 스탠드를 선택합니다. (tip 딜러 규칙 : 합이 16 이하면 히트 / 합이 17 이상이면 스탠드)");
        }
    }
    public static void standMessage(Person person) {
        if (person instanceof Player) {
            System.out.println("스탠드를 선택하셨습니다.");
        } else {
            System.out.println("딜러의 합이 17 이상이기 때문에 스탠드합니다. 결과에 따라 정산됩니다.");
        }
    }
    public static void openDealerCard(Dealer dealer) {
        System.out.println("딜러의 나머지 카드를 먼저 오픈합니다.");
        System.out.println("딜러의 히든카드 : " + dealer.getHandCard(1).getShowNum() + dealer.getHandCard(1).getSuit());
        System.out.println("딜러의 현재 합 : " + dealer.getScore());
    }
    public static void resultMessage(Result result) {
        switch (result) {
            case BLACKJACK:
                System.out.println("*******************************************");
                System.out.println("블랙잭으로 승리하여 배팅 금액의 1.5배를 획득합니다.");
                System.out.println("*******************************************");
                break;
            case WIN:
                System.out.println("***************************************");
                System.out.println("라운드를 승리하여 배팅 금액의 2배를 획득합니다.");
                System.out.println("***************************************");
                break;
            case LOSE:
                System.out.println("************************************");
                System.out.println("라운드에서 패배하여 배팅 금액을 잃었습니다.");
                System.out.println("************************************");
                break;
            case DRAW:
                System.out.println("**********************************");
                System.out.println("무승부하여 배팅 금액이 그대로 돌아옵니다.");
                System.out.println("**********************************");
                break;
        }
    }
    public static void continueGame(Player player) {
        System.out.println("현재 보유 금액 : " + player.getMoney() + " 달러");
        System.out.println("게임을 이어서 하시겠습니까? (예:1 / 아니오:2)");
    }
    public static void noMoneyMessage(Player player) {
        System.out.println("돈이 없어서 자동 퇴장합니다.");
    }
    public static void exitMessage() {
        System.out.println("블랙잭 프로그램을 종료합니다.");
    }
    public static void wrongMessage() {
        System.out.println("잘못된 입력입니다. 1~4번 중에 원하는 기능을 선택해주세요.");
    }
    public static void errorMessage() {
        System.out.println("잘못된 입력입니다. 배팅 금액에는 정수값만을 입력해주세요.");
        System.out.println("배팅 금액을 입력해주세요. : ");
    }
}