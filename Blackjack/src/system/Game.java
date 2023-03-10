package system;

import person.Player;

import java.util.Scanner;

public class Game {
    public void play() {
        Player player = new Player();
        while (true) {
            UI.menuMessage(player);
            Scanner exeInput = new Scanner(System.in);
            switch (exeInput.nextLine()) {
                case "1":
                    Round round = new Round();
                    while (round.isGameContinue()) {
                        round.play(player);
                    }
                    break;
                case "2":
                    player.setMoney(100);
                    UI.resetMessage();
                    break;
                case "3":
                    UI.ruleMessage();
                    break;
                case "4":
                    UI.exitMessage();
                    System.exit(0);
                default:
                    UI.wrongMessage();
                    break;
            }
        }
    }
}
