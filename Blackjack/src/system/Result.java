package system;

import person.Dealer;
import person.Player;

public class Result {
    int gameResult; //블랙잭, 승리, 패배, 무승부

    public Result (int gameResult) {
        this.gameResult = gameResult;
    }

    public int settle(int money, int betMoney) {
        switch (gameResult) {
            case 0:
                money += (int) betMoney * 1.5;
                System.out.println("*******************************************");
                System.out.println("블랙잭으로 승리하여 배팅 금액의 1.5배를 획득합니다.");
                System.out.println("*******************************************");
                break;
            case 1:
                money += betMoney * 2;
                System.out.println("***************************************");
                System.out.println("라운드를 승리하여 배팅 금액의 2배를 획득합니다.");
                System.out.println("***************************************");
                break;
            case 2:
                System.out.println("************************************");
                System.out.println("라운드에서 패배하여 배팅 금액을 잃었습니다.");
                System.out.println("************************************");
                break;
            case 3:
                money += betMoney;
                System.out.println("**********************************");
                System.out.println("무승부하여 배팅 금액이 그대로 돌아옵니다.");
                System.out.println("**********************************");
                break;
        }
        return money;
    }
}
