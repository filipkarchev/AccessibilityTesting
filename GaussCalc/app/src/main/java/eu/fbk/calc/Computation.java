package eu.fbk.calc;

/**
 * Created by lestat on 27/04/2017.
 */

public class Computation {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private static double valueOne = Double.NaN;
    private static double valueTwo;

    public static double getValueOne() {
        return valueOne;
    }

    public static void setValueOne(double valueOne) {
        Computation.valueOne = valueOne;
    }

    public static double getValueTwo() {
        return valueTwo;
    }

    public static void setValueTwo(double valueTwo) {
        Computation.valueTwo = valueTwo;
    }

    public static void compute(char OPERATION, Double value) {
        valueTwo = value;
        if(!Double.isNaN(valueOne)) {
            if(OPERATION == ADDITION)
                valueOne = valueOne + valueTwo;
            else if(OPERATION == SUBTRACTION)
                valueOne = valueOne - valueTwo;
            else if(OPERATION == MULTIPLICATION)
                valueOne = valueOne * valueTwo;
            else if(OPERATION == DIVISION)
                valueOne = valueOne / valueTwo;
        }
    }

    public static void storeFirst(Double value) {
        if(Double.isNaN(valueOne)) {
            valueOne = value;
        }
    }
}
