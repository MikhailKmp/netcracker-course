import java.util.Objects;

/**
 * Класс, который представляет из себя сущность адрес
 */
public class Address {
    /** Улица */
    private String street;
    /** Дом */
    private int house;
    /** Квартира */
    private int flat;

    public Address(String street, int house, int flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
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
        return house == address.house &&
                flat == address.flat &&
                Objects.equals(street, address.street);
    }
}