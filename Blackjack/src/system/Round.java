package system;

import person.Dealer;
import person.Player;

public class Round {
    private boolean gameContinue = true;
    public void play(Player player) {
        Dealer dealer = new Dealer();
        Progress progress = new Progress();
        UI.bet();
        progress.setNewGame(player, dealer);
        UI.openFirstCard(player, dealer);
        progress.checkBlackjack(player);
        progress.checkBlackjack(dealer);
        progress.letHitOrStand(player, dealer);
        progress.showResult(player, dealer);
        UI.continueGame(player);
        gameContinue = progress.continueGame(player);
        progress.checkMoney(player);
    }
    public boolean isGameContinue() {
        return gameContinue;
    }
}
