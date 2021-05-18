package ru.kamenev;

import java.io.*;
import java.util.Vector;

/**
 * Класс, в котором реализованы методы по работе с классом Vector<Double>
 */
public class Vectors {

    /**
     * Умножает вектор на число.
     * @param vector вектор
     * @param factor число
     */
    public static void mult(Vector<Double> vector, double factor) {
        for (int i = 0; i < vector.size(); i++) {
            vector.set(i, vector.get(i) * factor);
        }
    }

    /**
     * Складывает вектор с другим вектором, результат запоминает в элементах первого вектора.
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются
     * @param vector1 первый вектор
     * @param vector2 второй вектор
     */
    public static void sum(Vector<Double> vector1, Vector<Double> vector2) {
        if (vector1.size() > vector2.size()) {
            for (int i = 0; i < vector2.size(); i++) {
                vector1.set(i, vector1.get(i) + vector2.get(i));
            }
        }
        else {
            for (int i = 0; i < vector1.size(); i++) {
                vector1.set(i, vector1.get(i) + vector2.get(i));
            }
        }
    }

    /**
     * Возвращает скалярное произведение двух векторов
     * Если векторы имеют разный размер, последние элементы большего вектора не учитываются
     * @param vector1 первый вектор
     * @param vector2 второй вектор
     * @return скалярное произведение
     */
    public static double scalarMult(Vector<Double> vector1, Vector<Double> vector2) {
        double result = 0;
        int length = vector1.size();
        if (vector2.size() < length) {
            length = vector2.size();
        }
        for (int i = 0; i < length; i++) {
            result += vector1.get(i) * vector2.get(i);
        }
        return result;
    }

    /**
     * Записывает вектор в байтовый поток. Первое число - размерность вектора
     * Далее - значения координат вектора
     * @param v вектор
     * @param out байтовый поток
     */
    public static void outputVector(Vector<Double> v, OutputStream out) {
        try (ObjectOutputStream o = new ObjectOutputStream(out)) {
            o.writeDouble(v.size());
            for (Double d : v) {
                o.writeDouble(d);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Читает вектор из байтового потока
     * @param in байтовый поток
     * @return вектор
     */
    public static Vector inputVector(InputStream in) {
        Vector vector = new Vector();
        try (ObjectInputStream o = new ObjectInputStream(in)) {
            if (o.available() > 0) {
                o.readDouble();
            }
            while (o.available() > 0) {
                vector.add(o.readDouble());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vector;
    }

    /**
     * Записывает вектор в символьный поток. Первое число - размерность вектора
     * Далее - значения координат вектора
     * @param v вектор
     * @param out символьный поток
     */
    public static void writeVector(Vector<Double> v, Writer out) {
        try {
            out.write(String.valueOf(v.size()));
            for (Double d : v) {
                out.write(" " + d.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Читает вектор из символьного потока
     * @param in символьный поток
     * @return вектор
     */
    public static Vector readVector(Reader in) {
        Vector vector = new Vector();
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.parseNumbers();
        try {
            tokenizer.nextToken();
            while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                vector.add(tokenizer.nval);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vector;
    }
}