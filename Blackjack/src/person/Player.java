package person;

import java.util.Scanner;

public class Player extends Person {
    public int money;
    public int betMoney;
    @Override
    public boolean hitOrStand(int sc) {
        boolean isHit;
        switch (sc) {
            case 1:
                System.out.println("히트하여 카드를 한장 더 받습니다.");
                isHit = true;
                break;
            case 2:
                System.out.println("스탠드하여 더 이상 카드를 받지 않습니다.");
                isHit = false;
                break;
            default:
                System.out.println("잘못된 입력입니다. 스탠드하겠습니다.");
                isHit = false;
                break;
        }
        return isHit;
    }
}
