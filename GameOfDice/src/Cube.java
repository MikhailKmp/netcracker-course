import java.util.Random;

/**
 * Класс, который представляет из себя сущность игровая кость (кубик)
 */
public class Cube {
    private Random random;

    public Cube() {
        this.random = new Random();
    }

    /**
     *
     * @return возвращает случайное число от 1 до 6
     */
    public int getPoints() {
        return (1 + random.nextInt(6));
    }
}