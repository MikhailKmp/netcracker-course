package ru.kamenev;

import java.util.List;

/**
 * Интерфейс, в котором содержатся методы по выводу информации о ходе игры
 */
public interface Interface {

    public void enterNumberPlayers();

    public void enterNumberCubes();

    public void enterYourName();

    public void enterPlayerName(int i);

    public void displayRoundNumber(int round);

    public void displayNumberPointsOnCubes(int i, int glasses);

    public void displayNumberOfPointsPlayer(Player player);

    public void displayWinnerOfRound(List<Player> players, int round);

    public void displayNumberOfWinningsPlayer(Player player);

    public void displayWinner(Player player);
}