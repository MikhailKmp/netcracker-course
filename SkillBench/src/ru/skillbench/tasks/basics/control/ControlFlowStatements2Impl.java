package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements2Impl implements ControlFlowStatements2 {

    @Override
    public int getFunctionValue(int x) {
        if (x < -2 || x > 2) {
            return 2 * x;
        }
        else {
            return  -3 * x;
        }
    }

    @Override
    public String decodeMark(int mark) {
        switch (mark){
            case 1:
                return "Fail";
            case 2:
                return "Poor";
            case 3:
                return "Satisfactory";
            case 4:
                return "Good";
            case 5:
                return "Excellent";
            default:
                return "Error";
        }
    }

    @Override
    public double[][] initArray() {
        double[][] arr = new double[5][8];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Math.pow(i, 4) - Math.sqrt(j);
            }
        }
        return arr;
    }

    @Override
    public double getMaxValue(double[][] array) {
        double max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    @Override
    public Sportsman calculateSportsman(float P) {
        ControlFlowStatements2.Sportsman sportsman = new ControlFlowStatements2.Sportsman();
        float distance = 10;

        while (sportsman.getTotalDistance() < 200) {
            sportsman.addDay(distance);
            distance *= 1 + P / 100;
        }
        return sportsman;
    }
}