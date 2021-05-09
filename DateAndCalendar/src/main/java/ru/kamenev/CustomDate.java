package ru.kamenev;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс, в котором формируется объект Date
 */
public class CustomDate {

    private Date date;

    public CustomDate(int year, int month, int day, int hrs, int min) {
        date = new Date(year - 1900, month - 1, day, hrs, min);
    }

    /**
     * Констркутор, который на основе строки создает объект
     * @param date строкове представление даты в формате:
     *             <Год><Месяц><Число>
     *             <Часы><Минуты>
     */
    public CustomDate(String date) {
        Pattern pattern = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})\\s(\\d{2})(\\d{2})");
        Matcher matcher = pattern.matcher(date);
        if (!matcher.find()) {
            throw new NoSuchElementException();
        }
        this.date = new Date(Integer.parseInt(matcher.group(1)) - 1900, Integer.parseInt(matcher.group(2)) - 1,
                Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));
    }

    @Override
    public String toString() {
        return "CustomDate{" +
                "date=" + date +
                '}';
    }
}