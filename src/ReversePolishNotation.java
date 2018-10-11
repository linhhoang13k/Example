package com.sleepsoft.tests;

import java.util.Stack;

/**
 * Created by agermenos on 6/17/16.
 */

public class ReversePolishNotation {
    Stack<String> mainStack =new Stack<>();

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

    public String calculate (Double value1, Double value2, Operators selectedOperation) {
        switch (selectedOperation) {
            case ADD: return new Double (value1 + value2).toString();
            case SUBTRACT: return new Double (value1 - value2).toString();
            case MULTIPLY: return new Double (value1 * value2).toString();
            case DIVIDE: return new Double (value1 / value2).toString();
            case EXPONENT: return (Math.pow(value1, value2)+"");
            case REMAINDER: return new Double (value1 % value2).toString();
            case ERROR: return "Not an acceptable operation: " + selectedOperation;
            default: return null;
        }
    }

    public String calculate(String input){
        System.out.print (input + " = ");
        String[] strValues = input.split(" ");
        Double value1 = Double.parseDouble(strValues[0]);
        Double value2 = Double.parseDouble(strValues[1]);
        String operator = strValues[2];
        Operators selectedOperation = Operators.ERROR.getSymbol(operator);
        return calculate(value1, value2, selectedOperation);
    }

    public void push(String value){
        if (!Operators.ERROR.getSymbol(value).equals(Operators.ERROR)) {
            Double value2 = Double.parseDouble(mainStack.pop());
            Double value1 = Double.parseDouble(mainStack.pop());
            mainStack.push(calculate(
                    value1,
                    value2,
                    Operators.ERROR.getSymbol(value)
            ));
        }
        else {
            mainStack.push(value);
        }
        System.out.println(mainStack.toString());
    }

    public static void main(String args[]) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        System.out.println (rpn.calculate("15 3 /"));
        System.out.println (rpn.calculate("4 2 * "));
        System.out.println (rpn.calculate("123 34 -"));
        System.out.println (rpn.calculate("5 2 ^"));
        System.out.println (rpn.calculate("234 50 %"));
        System.out.println (rpn.calculate("1 2 T "));
        rpn.push("5");
        rpn.push("4");
        rpn.push("*");
        rpn.push("2");
        rpn.push("/");
        rpn.push("3");
        rpn.push("%");
        rpn.push("10");
        rpn.push("^");
    }
}

