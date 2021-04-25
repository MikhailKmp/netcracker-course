package ru.kamenev;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Сущность телефонный номер
 */
public class PhoneNumber {

    /** Номер телефона в формате:
     * +<Код страны><Три цифры>–<Три цифры>–<Четыре цифры>
     */
    private String phoneNumber;

    /**
     * Метод, который задает номер телефона на основе строки
     * @param string номер телефона в формате:
     *               +<Код страны><Номер 10 цифр> или 8<Номер 10 цифр>
     */
    public void setPhoneNumber(String string) {
        Pattern pattern = Pattern.compile("(\\+\\d+|8)(\\d{10})");
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            phoneNumber = matcher.group(1) + matcher.group(2).substring(0, 3) + "-" +
                    matcher.group(2).substring(3, 6) + "-" +
                    matcher.group(2).substring(6);
        }
        else {
            throw new InputMismatchException();
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}