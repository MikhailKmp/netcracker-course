import java.util.Calendar;
import java.util.Date;

//проверочный класс
public class Main {
    public static void main(String[] args) {
        Date date = new Date(1999 - 1900, Calendar.APRIL, 5);
        Person person = new Person(date);

        System.out.println(person.toString());
        System.out.println(person.toStringFormat("short"));
        System.out.println(person.toStringFormat("middle"));
        System.out.println(person.toStringFormat("full"));
        System.out.println(person.toStringFormat("none"));
    }
}