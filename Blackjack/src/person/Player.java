package person;

import java.util.Scanner;

public class Player extends Person {
    private int money = 100;
    private int betMoney;

    @Override
    public boolean selectHit() {
        Scanner sc = new Scanner(System.in);
        return (sc.nextLine().equals("1"));
    }
    public int getMoney() {
        return money;
    }
    public int getBetMoney() {
        return betMoney;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void bet(int betMoney) {
        this.money -= betMoney;
        this.betMoney = betMoney;
    }
}
