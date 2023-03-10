package system;

import card.Card;
import person.Person;

public class Judge {
    public boolean isBlackjack(Person person) {
        return ((person.getNumber(0) * person.getNumber(1) == 10) && ((person.getNumber(0) + person.getNumber(1) == 11)));
    }
    public boolean isBust(Person person) {
        return (person.getScore()>21);
    }
    public Result judge(Person player, Person dealer) {
        if (isBlackjack(player) && !isBlackjack(dealer)) {
            return Result.BLACKJACK;
        } else if (isBlackjack(player)) {
            return Result.DRAW;
        } else if (isBlackjack(dealer)) {
            return Result.LOSE;
        } else if (isBust(player)) {
            return Result.LOSE;
        } else if (isBust(dealer)) {
            return Result.WIN;
        } else {
            if (21-player.getScore() == 21-dealer.getScore()) {
                return Result.DRAW;
            } else if (21-player.getScore() > 21-dealer.getScore()) {
                return Result.LOSE;
            } else {
                return Result.WIN;
            }
        }
    }
    public int pay(Result result, int betMoney) {
        switch (result) {
            case BLACKJACK:
                System.out.println("*******************************************");
                System.out.println("블랙잭으로 승리하여 배팅 금액의 1.5배를 획득합니다.");
                System.out.println("*******************************************");
                return (int) (betMoney * 1.5);
            case WIN:
                System.out.println("***************************************");
                System.out.println("라운드를 승리하여 배팅 금액의 2배를 획득합니다.");
                System.out.println("***************************************");
                return betMoney * 2;
            case LOSE:
                System.out.println("************************************");
                System.out.println("라운드에서 패배하여 배팅 금액을 잃었습니다.");
                System.out.println("************************************");
                return 0;
            default:
                System.out.println("**********************************");
                System.out.println("무승부하여 배팅 금액이 그대로 돌아옵니다.");
                System.out.println("**********************************");
                return betMoney;
        }
    }
    public enum Result {
        BLACKJACK, WIN, LOSE, DRAW
    }
}
