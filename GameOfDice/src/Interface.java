import java.util.List;

/**
 * Класс, в котором реализованы методы по выводу информации о ходе игры в консоль
 */
public class Interface {

    public void enterNumberPlayers() {
        System.out.println("Введите количество игроков (включая компьютер): ");
    }

    public void enterNumberCubes() {
        System.out.println("Введите количество кубиков: ");
    }

    public void enterYourName() {
        System.out.println("Введите Ваше имя: ");
    }

    public void enterPlayerName(int i) {
        System.out.println("Введите имя игрока №" + i + ": ");
    }

    public void displayRoundNumber(int round) {
        System.out.println("Раунд №" + round + "\n");
    }

    public void displayNumberPointsOnCubes(int i, int glasses) {
        System.out.println("На кубике " +i + " выпало очков: " + glasses);
    }

    public void displayNumberOfPointsPlayer(Player player) {
        System.out.println("Итого очков у " + player.getName() + " " + player.getPoints() + "\n");
    }

    public void displayWinnerOfRound(List<Player> players, int round) {
        for (Player player : players) {
            System.out.println("В раунде "+ round + " выиграл: " + player.getName() + "\n");
        }
    }

    public void displayNumberOfWinningsPlayer(Player player) {
        System.out.println("Выигрышей у игрока " + player.getName() + ": " + player.getWinnings());
    }

    public void displayWinner(Player player) {
        System.out.println("Игру выиграл: " + player.getName());
    }
}