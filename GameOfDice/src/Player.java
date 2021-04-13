/**
 * Класс, который представляет из себя сущность игрока
 */
public class Player {

    /** Имя */
    private String name;
    /** Количетсво выигрышей в игре */
    private int winnings;
    /** Количетсво очков в раунде */
    private int points;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

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