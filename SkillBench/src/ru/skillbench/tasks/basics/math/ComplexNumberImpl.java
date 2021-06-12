package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ComplexNumberImpl implements ComplexNumber {

    private double re;
    private double im;

    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {
        if (im == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {

        if (value.matches("(-\\d|\\+\\d|\\d)(\\d*(\\.\\d+)?)?")) {
            re = Double.parseDouble(value);
            im = 0;
        }

        else if (value.matches("i")) {
            im = 1;
            re = 0;
        }

        else if (value.matches("-i")) {
            im = -1;
            re = 0;
        }

        else if (value.matches("(-\\d|\\+\\d|\\d)(\\d*(\\.\\d+)?)?i")) {
            im = Double.parseDouble(value.substring(0, value.length() - 1));
            re = 0;
        }

        else if (value.matches("(-\\d|\\+\\d|\\d)(\\d*(\\.\\d+)?)?(\\+|-)i")) {
            re = Double.parseDouble(value.substring(0, value.length() - 2));
            if (value.charAt(value.length() - 1) == '+')
                im = 1;
            else
                im = -1;
        }

        else if (value.matches("(-\\d|\\+\\d|\\d)(\\d*(\\.\\d+)?)?(-\\d|\\+\\d)(\\d*(\\.\\d+)?)?i")) {
            int i = value.indexOf('+', 1);
            int j = value.indexOf('-',1);
            int index = i != -1 ? i : j;
            re = Double.parseDouble(value.substring(0, index));
            im = Double.parseDouble(value.substring(index, value.length() - 1));
        }
        else {
            throw new NumberFormatException();
        }
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumber complexNumber = new ComplexNumberImpl();
        complexNumber.set(re, im);
        return complexNumber;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return (ComplexNumber) super.clone();
    }

    @Override
    public String toString() {
        String result = "";
        if (re != 0) {
            result += re;
        }
        if (im != 0) {
            if (im > 0 && re != 0) {
                result += "+";
            }
            result += im + "i";
        }
        if (result.length() == 0) {
            return "0";
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof ComplexNumber)) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.getRe(), re) == 0 &&
                Double.compare(that.getIm(), im) == 0;
    }

    @Override
    public int compareTo(ComplexNumber other) {
        if (Math.abs(re) + Math.abs(im) > Math.abs(other.getRe()) + Math.abs(other.getIm()))
            return 1;
        else if (Math.abs(re) + Math.abs(im) < Math.abs(other.getRe()) + Math.abs(other.getIm()))
            return -1;
        else return 0;
    }
    
    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array);
    }

    @Override
    public ComplexNumber negate() {
        this.re = - re;
        this.im = - im;
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        this.re += arg2.getRe();
        this.im += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double re = this.re;
        double im = this.im;
        this.re = re * arg2.getRe() - im * arg2.getIm();
        this.im = im * arg2.getRe() + re * arg2.getIm();
        return this;
    }
}