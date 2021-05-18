package ru.kamenev;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Вектор, основанный на связном списке
 */
public class LinkedListVector implements Serializable {

    private LinkedList<Double> vector;

    public LinkedListVector() {
        vector = new LinkedList<>();
    }

    /**
     * Задает все элементы вектора.
     * @param vector
     */
    public void set(LinkedList<Double> vector) {
        this.vector = vector;
    }

    /**
     * Возвращает все элементы вектора.
     */
    public LinkedList<Double> get() {
        return vector;
    }

    /**
     * Возвращает копию вектора (такую, изменение элементов
     *  в которой не приводит к изменению элементов данного вектора).
     */
    public LinkedListVector clone() {
        LinkedList<Double> list = (LinkedList<Double>) vector.clone();
        LinkedListVector newVector = new LinkedListVector();
        newVector.set(list);
        return newVector;
    }

    /**
     * Возвращает число элементов вектора.
     */
    public int getSize() {
        return vector.size();
    }

    /**
     * Изменяет элемент по индексу.
     * @param index В случае выхода индекса за пределы массива:<br/>
     *  а) если index<0, ничего не происходит;<br/>
     *  б) если index>=0, размер массива увеличивается так, чтобы index стал последним.
     */
    public void set(int index, double value) {
        if (index >= 0 && index < vector.size()) {
            vector.add(index, value);
        }
        else if (index >= vector.size()) {
            LinkedList<Double> newVector = new LinkedList<>();
            for (int i = 0; i < vector.size(); i++) {
                newVector.add(vector.get(i));
            }
            for (int i = vector.size(); i < index; i++) {
                newVector.add(null);
            }
            newVector.add(value);
            vector = newVector;
        }
    }

    /**
     * Возвращает элемент по индексу.
     * @param index индекс
     */
    public double get(int index) {
        return vector.get(index);
    }

    /**
     * Возвращает максимальный элемент вектора.
     */
    public double getMax() {
        return vector.stream().max(Double::compareTo).get();
    }

    /**
     * Возвращает минимальный элемент вектора.
     */
    public double getMin() {
        return vector.stream().min(Double::compareTo).get();
    }

    /**
     * Сортирует элементы вектора в порядке возрастания.
     */
    public void sortAscending() {
        vector.sort(Double::compareTo);
    }

    /**
     * Умножает вектор на число.<br/>
     * @param factor
     */
    public void mult(double factor) {
         List list = vector.stream().map(d -> d * factor).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            vector.set(i, (Double) list.get(i));
        }
    }

    /**
     * Складывает вектор с другим вектором, результат запоминает в элементах данного вектора.<br/>
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются<br/>
     *  (если данный вектор - больший, его размер не меняется).
     * @param anotherVector Не равен null
     * @return Ссылка на себя (результат сложения)
     */
    public LinkedListVector sum(LinkedListVector anotherVector) {
        if (vector.size() > anotherVector.getSize()){
            for (int i = 0; i < anotherVector.getSize(); i++) {
                vector.set(i, vector.get(i) + anotherVector.get(i));
            }
        }
        else {
            for (int i = 0; i < vector.size(); i++) {
                vector.set(i, vector.get(i) + anotherVector.get(i));
            }
        }
        return this;
    }

    /**
     * Возвращает скалярное произведение двух векторов.<br/>
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются.
     * @param anotherVector Не равен null
     */
    public double scalarMult(LinkedListVector anotherVector) {
        double result = 0;
        int length = vector.size();
        if (anotherVector.getSize() < length) {
            length = anotherVector.getSize();
        }
        for (int i = 0; i < length; i++) {
            result += vector.get(i) * anotherVector.get(i);
        }
        return result;
    }

    /**
     * Возвращает евклидову норму вектора
     */
    public double getNorm() {
        return Math.sqrt(this.scalarMult(this));
    }
}
