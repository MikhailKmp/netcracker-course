import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

/**
 * Класс Person для хранения даты рождения
 */
public class Person {

    private Date dateOfBirth;

    public Person(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dateOfBirth=" + dateOfBirth +
                '}';
    }

    /**
     * Метод, который возвращает строковое представление
     * даты рождения по вводимому формату
     * @param format формат вывода
     * @return строка в указанном формате
     */
    public String toStringFormat(String format) {
        switch (format) {
            case "short":
                return new SimpleDateFormat("dd.MM.yy.").format(dateOfBirth);
            case "middle":
                return new SimpleDateFormat("dd-MMM-yy").format(dateOfBirth);
            case "full":
                return new SimpleDateFormat("dd MMMM yyyy").format(dateOfBirth);
            default:
                throw new InputMismatchException();
        }
    }
}