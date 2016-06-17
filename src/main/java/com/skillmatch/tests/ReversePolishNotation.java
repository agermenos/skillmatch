package com.skillmatch.tests;

/**
 * Created by agermenos on 6/17/16.
 */

public class ReversePolishNotation {
    public enum Operators {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EXPONENT, REMAINDER, ERROR;
        public Operators getSymbol(String operator) {
            switch (operator) {
                case "+": return ADD;
                case "-": return SUBTRACT;
                case "*": return MULTIPLY;
                case "/": return DIVIDE;
                case "^": return EXPONENT;
                case "%": return REMAINDER;
                default: {
                    return ERROR;
                }
            }
        }
    };

    public String calculate(String input){
        System.out.print (input + " = ");
        String[] strValues = input.split(" ");
        Double value1 = Double.parseDouble(strValues[0]);
        Double value2 = Double.parseDouble(strValues[1]);
        String operator = strValues[2];
        Operators selectedOperation = Operators.ERROR.getSymbol(operator);
        switch (selectedOperation) {
            case ADD: return new Double (value1 + value2).toString();
            case SUBTRACT: return new Double (value1 - value2).toString();
            case MULTIPLY: return new Double (value1 * value2).toString();
            case DIVIDE: return new Double (value1 / value2).toString();
            case EXPONENT: return (Math.pow(Integer.parseInt(strValues[0]),(Integer.parseInt(strValues[1])))+"");
            case REMAINDER: return new Double (value1 % value2).toString();
            case ERROR: return "Not an acceptable operation: " + operator;
        }
        return "Unreachable end";
    }

    public static void main(String args[]) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        System.out.println (rpn.calculate("15 3 /"));
        System.out.println (rpn.calculate("4 2 * "));
        System.out.println (rpn.calculate("123 34 -"));
        System.out.println (rpn.calculate("5 2 ^"));
        System.out.println (rpn.calculate("234 50 %"));
        System.out.println (rpn.calculate("1 2 T "));
    }
}

