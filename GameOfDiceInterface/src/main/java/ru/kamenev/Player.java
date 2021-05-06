package ru.kamenev;

/**
 * Интерфейс, который должен реализовывать игрок
 */
public interface Player {

    public String getName();

    public int getWinnings();

    public void addWinnings();

    public void addPoints(int points);

    public void resetPoints();

    public int getPoints();

}