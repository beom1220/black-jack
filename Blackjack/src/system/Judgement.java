package system;

import person.Person;

import static system.Result.DRAW;

public class Judgement {
    public boolean isBlackjack(Person person) {
        return (person.getScore() == 21 && person.getNumOfHands() == 2);
    }
    public boolean isBust(Person person) {
        return (person.getScore()>21);
    }
    public Result judge(Person player, Person dealer) {
        if (isBlackjack(player) && !isBlackjack(dealer)) {
            return Result.BLACKJACK;
        } else if (isBlackjack(player)) {
            return DRAW;
        } else if (isBlackjack(dealer)) {
            return Result.LOSE;
        } else if (isBust(player)) {
            return Result.LOSE;
        } else if (isBust(dealer)) {
            return Result.WIN;
        } else {
            if (21-player.getScore() == 21-dealer.getScore()) {
                return DRAW;
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
