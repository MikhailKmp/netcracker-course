package ru.kamenev;

//Проверочный класс
public class Main {
    public static void main(String[] args) {
        Address address = new Address();

        address.setAddressFirstFormat(" Страна0, Регион0 , Город0,Улица0,Дом0   , Корпус0, Квартира0 ");
        System.out.println(address.toString());

        address.setAddressFirstFormat("Страна1  ,Регион1,Город1  ,Улица1,   Дом1   ,   Корпус1,   Квартира1");
        System.out.println(address.toString());

        address.setAddressSecondFormat("Страна2, Регион2 . Город2;Улица2,Дом2   - Корпус2- Квартира2");
        System.out.println(address.toString());

        address.setAddressSecondFormat(" Страна3-Регион3;Город3.  Улица3   .Дом3   , Корпус3; Квартира3");
        System.out.println(address.toString());
    }
}
