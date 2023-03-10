package system;

import person.Person;

public final class Judgement {
    public static boolean isBlackjack(Person person) {
        return (person.getScore() == 21 && person.getNumOfHands() == 2);
    }
    public static boolean isBust(Person person) {
        return (person.getScore()>21);
    }
    public static Result judge(Person player, Person dealer) {
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
    public static int pay(Result result, int betMoney) {
        switch (result) {
            case BLACKJACK:
                return (int) (betMoney * 1.5);
            case WIN:
                return betMoney * 2;
            case LOSE:
                return 0;
            default:
                return betMoney;
        }
    }
}
