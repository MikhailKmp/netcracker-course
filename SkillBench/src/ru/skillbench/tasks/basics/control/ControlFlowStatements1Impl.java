package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements1Impl implements ControlFlowStatements1 {

    @Override
    public float getFunctionValue(float x) {
        if (x > 0) {
            return (float) (2 * Math.sin(x));
        }
        else{
            return (6 - x);
        }
    }

    @Override
    public String decodeWeekday(int weekday) {
        switch (weekday){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
        }
        return null;
    }

    @Override
    public int[][] initArray() {
        int[][] arr = new int[8][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i * j;
            }
        }
        return arr;
    }

    @Override
    public int getMinValue(int[][] array) {
        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        double amount = 1000;
        int years = 0;

        while (amount <= 5000) {
            amount *= 1 + P / 100;
            years++;
        }

        ControlFlowStatements1.BankDeposit bankDeposit = new ControlFlowStatements1.BankDeposit();
        bankDeposit.amount = amount;
        bankDeposit.years = years;

        return bankDeposit;
    }
}