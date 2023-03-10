package system;

import person.Person;

public class Judge {
    boolean isPlayerBlackjack;
    boolean isDealerBlackjack;
    boolean isPlayerBust;
    boolean isDealerBust;
    int playerScore;
    int dealerScore;
    boolean isPlayerA;
    boolean isDealerA;

    public Judge(boolean isPlayerBlackjack, boolean isDealerBlackjack, boolean isPlayerBust, boolean isDealerBust, int playerScore, int dealerScore, boolean isPlayerA, boolean isDealerA) {
        this.isPlayerBlackjack = isPlayerBlackjack;
        this.isDealerBlackjack = isDealerBlackjack;
        this.isPlayerBust = isPlayerBust;
        this.isDealerBust = isDealerBust;
        this.playerScore = playerScore;
        this.dealerScore = dealerScore;
        this.isPlayerA = isPlayerA;
        this.isDealerA = isDealerA;
    }

    public int judge() {
        int judgeResult;
        if (isPlayerBlackjack && !isDealerBlackjack) {
            judgeResult = 0;
        } else if (isPlayerBlackjack) {
            judgeResult = 3;
        } else if (isDealerBlackjack) {
            judgeResult = 2;
        } else if (isPlayerBust) {
            judgeResult = 2;
        } else if (isDealerBust) {
            judgeResult = 1;
        } else {
            if (isPlayerA && (playerScore+10) <= 21) {
                playerScore += 10;
            }
            if (isDealerA && (dealerScore+10) <= 21) {
                dealerScore += 10;
            }
            if(21-playerScore == 21-dealerScore) {
                judgeResult = 3;
                System.out.println("서로 총합이 같기 때문에 무승부입니다.");
            } else if (21-playerScore > 21-dealerScore) {
                judgeResult = 2;
                System.out.println("딜러의 합이 21에 더 근접하여 패배하였습니다.");
            } else {
                judgeResult = 1;
                System.out.println("플레이어의 합이 21에 더 근접하여 승리하였습니다.");
            }
        }
        return judgeResult;
    }

//    public boolean isPersonBlackJack(Person person) {
//        결과값;
//    }

//    public Person judge(Person p1, Person p2) {
//
//        return 이긴사람;
//    }
}
