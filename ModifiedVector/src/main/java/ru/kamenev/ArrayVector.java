package ru.kamenev;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Вектор, основанный на массиве
 */
public class ArrayVector implements Serializable  {

    private double[] vector;

    public ArrayVector() {
        vector = new double[0];
    }

    public ArrayVector(int lengthVector) {
        vector = new double[lengthVector];
    }

    /**
     * Задает все элементы вектора (определяет длину вектора).
     * @param elements
     */
    public void set(double... elements) {
        vector = elements;
    }

    /**
     * Возвращает все элементы вектора.
     */
    public double[] get() {
        return vector;
    }

    /**
     * Возвращает копию вектора (такую, изменение элементов
     *  в которой не приводит к изменению элементов данного вектора).
     */
    public ArrayVector clone() {
        ArrayVector arrayVector = new ArrayVector(this.getSize());
        System.arraycopy(vector, 0, arrayVector.get(), 0, vector.length);
        return arrayVector;
    }

    /**
     * Возвращает число элементов вектора.
     */
    public int getSize() {
        return vector.length;
    }

    /**
     * Изменяет элемент по индексу.
     * @param index В случае выхода индекса за пределы массива:<br/>
     *  а) если index<0, ничего не происходит;<br/>
     *  б) если index>=0, размер массива увеличивается так, чтобы index стал последним.
     */
    public void set(int index, double value) {
        if (index >= 0 && index < vector.length) {
            vector[index] = value;
        }
        else if (index >= vector.length) {
            double[] newVector = new double[index + 1];
            for (int i = 0; i < vector.length; i++) {
                newVector[i] = vector[i];
            }
            newVector[index] = value;
            vector = newVector;
        }
    }

    /**
     * Возвращает элемент по индексу.
     * @param index индекс
     */
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return vector[index];
    }

    /**
     * Возвращает максимальный элемент вектора.
     */
    public double getMax() {
        double max = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > max) {
                max = vector[i];
            }
        }
        return max;
    }

    /**
     * Возвращает минимальный элемент вектора.
     */
    public double getMin() {
        double min = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < min) {
                min = vector[i];
            }
        }
        return min;
    }

    /**
     * Сортирует элементы вектора в порядке возрастания.
     */
    public void sortAscending() {
        Arrays.sort(vector);
    }

    /**
     * Умножает вектор на число.<br/>
     * @param factor
     */
    public void mult(double factor) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= factor;
        }
    }

    /**
     * Складывает вектор с другим вектором, результат запоминает в элементах данного вектора.<br/>
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются<br/>
     *  (если данный вектор - больший, его размер не меняется).
     * @param anotherVector Не равен null
     * @return Ссылка на себя (результат сложения)
     */
    public ArrayVector sum(ArrayVector anotherVector) {
        if (vector.length > anotherVector.getSize()){
            for (int i = 0; i < anotherVector.getSize(); i++) {
                vector[i] += anotherVector.get(i);
            }
        }
        else {
            for (int i = 0; i < vector.length; i++) {
                vector[i] += anotherVector.get(i);
            }
        }
        return this;
    }

    /**
     * Возвращает скалярное произведение двух векторов.<br/>
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются.
     * @param anotherVector Не равен null
     */
    public double scalarMult(ArrayVector anotherVector) {
        double result = 0;
        int length = vector.length;
        if (anotherVector.getSize() < length) {
            length = anotherVector.getSize();
        }
        for (int i = 0; i < length; i++) {
            result += vector[i] * anotherVector.get(i);
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