import person.Player;
import system.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int inputNum;
        Player player = new Player();
        player.money = 100;
        do {
            System.out.println("--------------------------");
            System.out.println("--- 블랙잭 프로그램입니다. --");
            System.out.println("-- 실행할 번호를 입력하세요.--");
            System.out.println("--- 1.진행 2.규칙 3.종료 ---");
            System.out.println("--------------------------");
            System.out.print("실행할 번호 : ");
            Scanner exeInput = new Scanner(System.in);
            inputNum = exeInput.nextInt();
            switch (inputNum) {
                case 1:
                    Game game = new Game();
                    game.play();
                    break;
                case 2:
                    System.out.println("블랙잭 게임의 규칙을 설명해드리겠습니다.");
                    System.out.println("1. 라운드마다 플레이어는 배팅을 합니다.");
                    System.out.println("2. 딜러와 플레이어는 2장씩의 카드를 받습니다.");
                    System.out.println("3. 딜러는 그 중 한장의 카드를 공개합니다.");
                    System.out.println("4. 플레이어는 카드를 더 받을지(히트), 더 받지 않을지(스탠드) 선택합니다.");
                    System.out.println("5. 합이 21을 초과하지 않는 한, 히트는 계속할 수 있습니다.");
                    System.out.println("6. 합이 21을 초과하는 건 버스트라고 하며, 즉시 패배합니다.");
                    System.out.println("7. 처음 두 장의 합이 21인 경우에는 블랙잭이라고 하며, 배팅 금액의 1.5배를 돌려받습니다.");
                    System.out.println("8. 이 경우, 딜러도 블랙잭이라면 무승부로 배팅 금액을 그대로 돌려받습니다.");
                    System.out.println("9. 블랙잭도 버스트도 아닌 경우에, 플레이어의 스탠드 이후에 딜러의 히트or스탠드가 진행됩니다.");
                    System.out.println("10. 딜러는 총합이 16 이하이면 히트, 17 이상이면 스탠드합니다.");
                    System.out.println("11. 딜러는 버스트하지 않는 한, A를 11로 취급합니다.");
                    System.out.println("12. J, Q, K는 모두 10점이며, A는 1 또는 11로 계산합니다.");
                    System.out.println("13. 딜러가 버스트하면 즉시 승리하며, 딜러가 스탠드하면 서로의 총합을 비교합니다.");
                    System.out.println("14. 총합이 21에 가까운 쪽이 승리하며, 같다면 무승부입니다.");
                    System.out.println("15. 승리하면 배팅 금액의 2배를, 패배하면 0배를 돌려받습니다.");
                    System.out.println("16. 추가로, 라운드를 진행하다가 덱이 10장 이하가 되면 덱을 새로 셔플합니다.");
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;
            }
        } while (inputNum != 3);
    }
}