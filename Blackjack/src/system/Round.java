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
            UI ui = new UI(player, dealer);
            //ui에서 배팅 문구 띄워서 ui에서는 progress 통해서 배팅금액 받아줌.
            ui.betting();
            // ui 통해서 플레이어 카드 2장 보여주고, 딜러 카드 1장 보여줌. 뽑기는 그 내부의 progress 통해서
            ui.openFirstCard();
            //둘 중 블랙잭 없으면 ui 통해서 히트할지 물어보고, 플레이어 핸드 진행. 전부 다 ui는 보여지는 것만 하고, 실행 과정은 progress로.
            //핸드 끝났으면(버스트나 스탠드), 버스트 아니면 딜러 핸드 진행.
            ui.letHitOrStand();
            //딜러 핸드 끝났으면, 승부 결과 출력 후 결과 따라 배당금 지급.
            ui.result();
            //이어서 게임할지 물어봄. 혹은 돈 없으면 나가짐.
            gameContinue = ui.gameContinue();
        }
    }
    public boolean isGameContinue() {
        return gameContinue;
    }
}