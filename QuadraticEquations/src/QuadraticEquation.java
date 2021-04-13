import java.util.Scanner;

/**
 * Класс для решения квадратных уравнений.
 * Квадратное уравнение: a * x^2 + b * x + c = 0
 */
public class QuadraticEquation {

    /** Первый коэффициент (a ≠ 0) */
    private double a;
    /** Второй коэффициент */
    private double b;
    /** Свободный член */
    private double c;
    /** Первый корень уравнения */
    private double x1;
    /** Второй корень уравнения */
    private double x2;
    /** Дискриминант */
    private double discriminant;

    /**
     * Метод инициализация коэффициентов уранения.
     * Так же в данном методе вычисляется значения дискриминанта
     * с помощью вложенного класса Discriminant.
     * Коэффицинт a не может равняться нулю.
     */
    public void equationInitialization() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите параметры квадратного уравнения\n" +
                            "Квадратное уравнения имеет вид: a * x^2 + b * x + c = 0\n" +
                            "Параметр a не может быть равен 0");

        do {
            System.out.println("Введите a: ");
            a = scanner.nextDouble();
            if (a == 0) {
                System.out.println("Параметр a не может быть равен 0");
            }
        } while (a == 0);

        System.out.println("Введите b: ");
        b = scanner.nextDouble();

        System.out.println("Введите c: ");
        c = scanner.nextDouble();

        discriminant = Discriminant.calculateDiscriminant(a, b, c);
        scanner.close();
    }

    /**
     * Метод вычисляет корни уравнения и выводит результат в консоль.
     */
    public void calculateRoots() {

        if (discriminant < 0) {
            System.out.println("Дискриминант меньше 0. Корней нет");
            return;
        }
        else if (discriminant > 0) {
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        }
        else if (discriminant == 0) {
            x1 = -b / (2 * a);
            x2 = -b / (2 * a);
        }

        System.out.println("Дискриминант равен " + discriminant);
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
    }

    /**
     * Класс для вычисления дискриминанта.
     */
    static class Discriminant {
        /**
         * Метод вычисления дискриминанта.
         * @param a первый коэффициент уравнения (не может равняться нулю)
         * @param b второй коэффициент уравнения
         * @param c свободный член
         * @return значение дискриминанта
         */
        public static double calculateDiscriminant(double a, double b, double c) {
            return (b * b - 4 * a * c);
        }
    }
}