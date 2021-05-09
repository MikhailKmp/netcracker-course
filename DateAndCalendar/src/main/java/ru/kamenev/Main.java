package ru.kamenev;

//проверочный класс
public class Main {
    public static void main(String[] args) {
        String text = "20210509\n" +
                "1830"; // дата: 09.05.2021 18:30
        CustomDate date = new CustomDate(text);
        CustomCalendar calendar = new CustomCalendar(text);

        System.out.println(date.toString());
        System.out.println(calendar.toString());
    }
}