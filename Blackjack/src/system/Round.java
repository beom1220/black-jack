package system;

import person.Dealer;
import person.Person;
import person.Player;

public class Round {
    private boolean gameContinue = true;
    private Player player;
    public Round (Player player) {
        this.player = player;
    }
    public void play() {
        while (gameContinue) {
            Dealer dealer = new Dealer();
            Progress progress = new Progress();
            UI ui = new UI();
            ui.betting(player, dealer);
            progress.betting(player);
            progress.giveFirstCard(player, dealer);
            ui.openFirstCard(player, dealer);
            ui.letHitOrStand(player, dealer);
            ui.result(player, dealer);
            gameContinue = ui.gameContinue(player);
        }
    }
    public boolean isGameContinue() {
        return gameContinue;
    }
    public void setGameContinue(int inputContinue) {
        this.gameContinue = (inputContinue == 1);
    }
}
