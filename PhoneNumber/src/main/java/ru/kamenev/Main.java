package ru.kamenev;

//проверочный класс
public class Main {
    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();

        phoneNumber.setPhoneNumber("+79215627531");
        System.out.println(phoneNumber.getPhoneNumber());

        phoneNumber.setPhoneNumber("+139215627531");
        System.out.println(phoneNumber.getPhoneNumber());

        phoneNumber.setPhoneNumber("89215627531");
        System.out.println(phoneNumber.getPhoneNumber());
    }
}
