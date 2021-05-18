package ru.kamenev;

import java.io.*;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        Vector<Double> vector1 = new Vector<>();
        vector1.add(1D);
        vector1.add(2D);
        vector1.add(3.5D);
        vector1.add(4D);
        vector1.add(5D);

        Vector<Double> vector2 = new Vector<>();
        vector2.add(9D);
        vector2.add(8D);
        vector2.add(7.5D);
        vector2.add(6D);
        vector2.add(2_123_456.5D);

        System.out.println("vector1: " + vector1);
        System.out.println("vector2: " + vector2);

        Vectors.mult(vector1, 2);
        System.out.println("vector1 после умножения на 2: " + vector1);

        Vectors.sum(vector1, vector2);
        System.out.println("vector1 + vector2: " + vector1);

        System.out.println("Скалярное произведение vector1 и vector2: " + Vectors.scalarMult(vector1, vector2));

        //запись вектора в файл через байтовый поток
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\Netcracker\\Vectors\\file\\outputVector");
        Vectors.outputVector(vector1, outputStream);
        outputStream.close();

        //чтение вектора из файла, в который был записан vector1 через байтовый поток
        FileInputStream inputStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\Netcracker\\Vectors\\file\\outputVector");
        Vector newVector = Vectors.inputVector(inputStream);
        System.out.println(newVector.size() + " " + newVector);
        inputStream.close();

        //запись вектора в файл через символьный поток
        Writer writer = new FileWriter("C:\\Users\\User\\IdeaProjects\\Netcracker\\Vectors\\file\\writeVector.txt");
        Vectors.writeVector(vector1, writer);
        writer.close();

        //чтение вектора из файла, в который был записан vector1 через символьный поток
        Reader reader = new FileReader("C:\\Users\\User\\IdeaProjects\\Netcracker\\Vectors\\file\\writeVector.txt");
        newVector = Vectors.readVector(reader);
        System.out.println(newVector.size() + " " + newVector);
        reader.close();

    }
}