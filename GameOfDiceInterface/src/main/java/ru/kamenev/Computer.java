package ru.kamenev;

/**
 * Класс, который представляет из себя сущность игрок-компьютер
 */
public class Computer implements Player {
    /** Имя */
    private String name;
    /** Количетсво выигрышей в игре */
    private int winnings;
    /** Количетсво очков в раунде */
    private int points;

    public Computer() {
        name = "Компьютер";
    }

    public String getName() { return name; }

    public int getWinnings() {
        return winnings;
    }

    public void addWinnings() {
        this.winnings++;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void resetPoints() {
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }
}