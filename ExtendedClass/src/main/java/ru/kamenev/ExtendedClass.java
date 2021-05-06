package ru.kamenev;

import java.util.Objects;

public class ExtendedClass {

    private byte b;
    private int i;
    private double d;
    private String s;

    @Override
    public String toString() {
        return "ExtendedClass{" +
                "b=" + b +
                ", i=" + i +
                ", d=" + d +
                ", s='" + s + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        ExtendedClass that = (ExtendedClass) anObject;
        return b == that.b &&
                i == that.i &&
                Double.compare(that.d, d) == 0 &&
                Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(b, i, d, s);
    }
}