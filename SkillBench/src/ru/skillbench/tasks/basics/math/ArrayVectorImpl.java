package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector {

    private double[] vector;

    public ArrayVectorImpl() {
        vector = new double[0];
    }

    public ArrayVectorImpl(int lengthVector) {
        vector = new double[lengthVector];
    }

    @Override
    public void set(double... elements) {
        vector = elements;
    }

    @Override
    public double[] get() {
        return vector;
    }

    @Override
    public ArrayVector clone() {
        ArrayVector arrayVector = new ArrayVectorImpl(this.getSize());
        System.arraycopy(vector, 0, arrayVector.get(), 0, vector.length);
        return arrayVector;
    }

    @Override
    public int getSize() {
        return vector.length;
    }

    @Override
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

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return vector[index];
    }

    @Override
    public double getMax() {
        double max = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] > max) {
                max = vector[i];
            }
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = vector[0];
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < min) {
                min = vector[i];
            }
        }
        return min;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(vector);
    }

    @Override
    public void mult(double factor) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= factor;
        }
    }
    
    @Override
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

    @Override
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

    @Override
    public double getNorm() {
        return Math.sqrt(this.scalarMult(this));
    }
}