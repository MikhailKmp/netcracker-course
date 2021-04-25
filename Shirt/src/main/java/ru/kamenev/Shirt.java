package ru.kamenev;

/**
 * Сущность рубашка
 */
public class Shirt {

    /** id рубашки */
    private String id;
    /** описание рубашки */
    private String description;
    /** цвет рубашки */
    private String color;
    /** размер рубашки */
    private String size;

    /**
     * Конструктор, который создает объект
     * на основе строки
     * @param string строка с информацией о рубашке
     */
    public Shirt(String string) {
        String[] strings = string.split(",");
        id = strings[0];
        description = strings[1];
        color = strings[2];
        size = strings[3];
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}