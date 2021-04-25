package ru.kamenev;

import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Класс, который представляет из себя сущность адрес
 */
public class Address {
    /** Страна */
    private String country;
    /** Регион */
    private String region;
    /** Город */
    private String city;
    /** Улица */
    private String street;
    /** Дом */
    private String house;
    /** Корпус */
    private String corps;
    /** Квартира */
    private String flat;

    public void setAddressFirstFormat(String address) {
        String[] strings = address.split(",");
        country = strings[0].trim();
        region = strings[1].trim();
        city = strings[2].trim();
        street = strings[3].trim();
        house = strings[4].trim();
        corps = strings[5].trim();
        flat = strings[6].trim();
    }

    public void setAddressSecondFormat(String address) {
        StringTokenizer stringTokenizer = new StringTokenizer(address, ",.;-");
        country = stringTokenizer.nextToken().trim();
        region = stringTokenizer.nextToken().trim();
        city = stringTokenizer.nextToken().trim();
        street = stringTokenizer.nextToken().trim();
        house = stringTokenizer.nextToken().trim();
        corps = stringTokenizer.nextToken().trim();
        flat = stringTokenizer.nextToken().trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", corps='" + corps + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }

    /**
     * Переопределенный метод equals для корректного сравнения объектов
     * @param o объект, с котором будет осуществляться сравнение
     * @return результат сравнения
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.getCountry()) &&
                Objects.equals(region, address.getRegion()) &&
                Objects.equals(city, address.getCity()) &&
                Objects.equals(street, address.getStreet()) &&
                Objects.equals(house, address.getHouse()) &&
                Objects.equals(corps, address.getCorps()) &&
                Objects.equals(flat, address.getFlat());
    }
}