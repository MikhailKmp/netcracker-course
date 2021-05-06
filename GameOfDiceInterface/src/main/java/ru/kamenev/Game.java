package ru.kamenev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Класс, в котором реализована логика игры в кости
 */
public class Game {

    private Interface anInterface;
    private List<Player> players;
    private List<Cube> cubes;
    /** Количество игроков */
    private int numberPlayers;
    /** Количество кубиков */
    private int numberCubes;
    /** Колчество раундов */
    private int round;

    /**
     * Метод запрашивает у пользователя количество игроков, количество кубиков
     * и создает массивы игроков и кубиков
     * @param scanner Scanner с помощью которого будет осущетсвляться ввод
     */
    private void gameInitialization(Scanner scanner) {
        anInterface = new InterfaceImpl();

        anInterface.enterNumberPlayers();
        numberPlayers = Integer.parseInt(scanner.nextLine());
        players = new ArrayList<>(numberPlayers);

        anInterface.enterNumberCubes();
        numberCubes = Integer.parseInt(scanner.nextLine());

        cubes = new ArrayList<>(numberCubes);
    }

    /**
     * Метод создает игроков.
     * В первую очередь запрашивается имя главного игрока (Вас) и создается его объект.
     * После запрашиваются имена других игроков и создаются объекты для них.
     * В самую последнюю очередь создаетя игрок "компьютер".
     * Все игроки (объекты Player) добавляются в массив players.
     * @param scanner Scanner с помощью которого будет осущетсвляться ввод
     */
    private void creatingPlayers(Scanner scanner) {
        User user = new User();

        anInterface.enterYourName();
        user.setName(scanner.nextLine());
        players.add(user);

        for (int i = 1; i < numberPlayers - 1; i++) {
            user = new User();

            anInterface.enterPlayerName(i);
            user.setName(scanner.nextLine());
            players.add(user);
        }
        players.add(new Computer());
    }

    /**
     * Метод создает кубики
     */
    private void creatingCubes() {
        for (int i = 0; i < numberCubes; i++) {
            cubes.add(new Cube());
        }
    }

    /**
     * Метод, который осуществляет игру одного раунда
     *
     */
    private void round() {
        anInterface.displayRoundNumber(round);

        //Обнуление очков у всех игроков
        for (Player player : players) {
            player.resetPoints();
        }

        //Каждый игрок бросает кубики, каждому игроку начисляются очки.
        //Для каждого кубика выводися количество очков, которая на нем выпала.
        //Для каждого игрока выводится сумма очков, которая ему выпала.
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < cubes.size(); j++) {
                int glasses = cubes.get(j).getPoints();
                players.get(i).addPoints(glasses);
                anInterface.displayNumberPointsOnCubes(j, glasses);
            }
            anInterface.displayNumberOfPointsPlayer(players.get(i));
        }

        //получаем список игроков с максимальным количеством очков
        List<Player> winners = getWinners(players);

        //вывод победителей раунда
        anInterface.displayWinnerOfRound(winners, round);

        //вывод количества выигрышей у игроков
        for (int i = 0; i < players.size(); i++) {
            anInterface.displayNumberOfWinningsPlayer(players.get(i));
        }

        //победитель раунда (если их несколько, то случайный из победителей)
        //помещается на первое место в массиве, чтобы он бросал кубик первым
        Player tempPlayer = players.get(0);
        for (int i = 0; i < players.size(); i++) {
            if (winners.get(0) == players.get(i)) {
                int indexWinner = i;
                players.set(0, players.get(indexWinner));
                players.set(indexWinner, tempPlayer);
            }
        }
        round++;
    }

    /**
     * В методе определяются игроки с максимальным количеством очков в раунде
     * @param players список игроков
     * @return список игроков с максимальным количеством очков
     */
    private List<Player> getWinners(List<Player> players) {
        List<Player> winners = new ArrayList<>();

        //вычисление индекса какого-либо игрока, который имеет максимальное количество очков
        int indexWinner = 0;
        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getPoints() > players.get(indexWinner).getPoints()) {
                indexWinner = i;
            }
        }

        //выполняем провеку на наличие игроков с таким же количеством очков
        //если такие имеются, то добавляем их в список победителей
        //и добавляем выигрыш в раунде
        for (Player player : players) {
            if (player.getPoints() == players.get(indexWinner).getPoints()) {
                winners.add(player);
                player.addWinnings();
            }
        }
        return winners;
    }

    /**
     * Метод, в котором осуществляется логика игры
     * (Если у нескольких игроков одновременно становится по 7 очков,
     * то все они считаются победителями)
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean stopGame = false;
        gameInitialization(scanner);
        creatingPlayers(scanner);
        creatingCubes();

         //пока ни у кого нет 7 выигрышей, игра продолжается
        while (!stopGame) {
            round();

            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getWinnings() == 7) {
                    anInterface.displayWinner(players.get(i));
                    stopGame = true;
                }
            }
        }
        scanner.close();
    }
}