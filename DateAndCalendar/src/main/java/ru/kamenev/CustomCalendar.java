package ru.kamenev;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс, в котором формируется объект Calendar
 */
public class CustomCalendar {

    private Calendar calendar;

    public CustomCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute) {
        calendar = new GregorianCalendar(year, month - 1, dayOfMonth, hourOfDay, minute);
    }

    /**
     * Конструктор, который на основе строки создает объект
     * @param date строковое представление даты в формате:
     *             <Год><Месяц><Число>
     *             <Часы><Минуты>
     */
    public CustomCalendar(String date) {
        Pattern pattern = Pattern.compile("(\\d{4})(\\d{2})(\\d{2})\\s(\\d{2})(\\d{2})");
        Matcher matcher = pattern.matcher(date);
        if (!matcher.find()) {
            throw new NoSuchElementException();
        }
        this.calendar = new GregorianCalendar(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1,
                Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));
    }


    @Override
    public String toString() {
        return "CustomCalendar{" +
                "calendar=" + calendar.getTime() +
                '}';
    }
}