package person;

import java.util.Scanner;

public class Player extends Person {
    private int money = 100;
    private int betMoney;
    @Override
    public boolean hitOrStand(int sc) {
        return (sc == 1);
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
    public void setBetMoney(int betMoney) {
        this.betMoney = betMoney;
    }
}
