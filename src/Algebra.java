package com.sleepsoft.challenges;

import org.junit.Test;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 Peter is taking his very first algebra class today. At the end of the lesson, the teacher posts a homework on the blackboard, and for each given problem he provides the answer so that students could check their results at home.

 Harry, Peter's classmate who hates math, sabotaged the class. The second the teacher left the room, he scribbled over one number of the homework, making it illegible. As a person who loves math and hopes to become a great programmer one day, Peter still wrote down the homework, and replaced the illegible number with the '?' symbol.

 Prior to completing the task, Peter needs to find out what symbol was scribbled over. Given the problem and its answer, your task is to help Peter and find the number hidden under the '?' symbol.

 Example:

 For problem = "5*x = ?" and answer = "x = 2", the output should be
 algebraHomework(problem, answer) = 10.

 Harry scribbled over some number in the problem, so in order to find it you should replace x with its value 2 and solve the equation with '?' as unknown.

 For problem ="(((5 * x) / 4) + 13) - 15 = 23" and answer = "x = ?",
 the output should be
 algebraHomework(problem, answer) = 20.

 Harry scribbled over the answer, so all you have to do is solve the problem.

 Input/Output

 [time limit] 3000ms (java)
 [input] string problem

 The problem is guaranteed to have the following format:
 ((...(a × b) × c ) ...) × y = z, where × is some operator ('+', '-', '*' or '/') and each letter can be:

 a number;
 a variable;
 the '?' sign.
 The problem can contain arbitrary number of whitespace characters, both leading and trailing. It is guaranteed that:

 there is only one variable, and it is the same as in the answer;
 the variable is always to the left of the the = sign;
 there is no '?' in the problem if it's present in the answer;
 there is at most one '?' symbol, and it substitutes a number;
 all numbers are integers;
 the solution is also an integer.
 [input] string answer

 The answer in the format <var> = <num>, where <var> is guaranteed to be a lowercase English letter and <num> is guaranteed to be either an integer or a '?' character.

 Note that the answer can contain an arbitrary number of whitespace characters.

 [output] integer

 The number that is hidden behind the '?' character.
 */
public class Algebra {

    public static final String EQ_PATTERN="-?[0-9.]+|[A-Za-z]+|[-+=*/()]|==|<=|>=|&&|[|]{2}";
    public static final String OP_PATTERN="[-+*/]";

    public int algebraHomework(String problem, String answer) {
        String[] answer_values = answer.split("=");
        if (answer_values[1].equals("?")) {
            LinkedList<String>[] stacks = makeStacks(problem.replace(answer_values[0].trim(), "?"));
            for (int k = Integer.MIN_VALUE; k < Integer.MAX_VALUE; k++) {
                //if (resolveStacks(stacks, k)) return k;
            }
        }
        else {
            LinkedList<String>[] stacks = makeStacks(problem.replace(answer_values[0].trim(), answer_values[1]));
            return resolveStacks(stacks, Integer.valueOf(answer_values[1]));
        }
        return 0;
    }

    private LinkedList<String>[] makeStacks(String equation){
        LinkedList<String> equationStack = new LinkedList<>();
        LinkedList<String> operatorStack = new LinkedList<>();
        Pattern pattern = Pattern.compile(EQ_PATTERN);
        Matcher match = pattern.matcher(equation);
        while (match.find()) {
            String element=match.group();
            if (element.contains("*|+|-|/|=")){
                operatorStack.add(element);
            }
            else {
                equationStack.add(element);
            }
        }
        return new LinkedList[]{equationStack, operatorStack};
    }

    private int resolveStacks(LinkedList[]stacks, int var){
        LinkedList<String> varStack = stacks[0];
        LinkedList<String> opStack = stacks[1];
        while (varStack.size()>1) {
            String element = varStack.remove();
            if (isAN(element)){
                varStack.push(element);
            }
            if (element.equals(")") && varStack.size()>=2 && opStack.size()>=1){
                String element1 = varStack.remove();
                String element2 = varStack.remove();
                String oper = opStack.remove();
                varStack.addFirst(execute(element1, element2, oper)+"");
            }
            if (element.equals("?")) {
                varStack.push(var+"");
            }
            Pattern pattern = Pattern.compile(OP_PATTERN);
            Matcher match = pattern.matcher(element);
            if (match.matches()) {
                opStack.push(element);
            }
        }
        return Integer.valueOf(varStack.remove());
    }

    private boolean isAN(String number){
        try {
            Integer.parseInt(number);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    private int execute(String operand, String first, String second){
        switch (operand){
            case "+": return new Integer(Integer.valueOf(first)+Integer.valueOf(second));
            case "-": return new Integer(Integer.valueOf(first)-Integer.valueOf(second));
            case "*": return new Integer(Integer.valueOf(first)*Integer.valueOf(second));
            case "/": return new Integer(Integer.valueOf(first)/Integer.valueOf(second));
        }
        return 0;
    }

    private void prepare(String eq, String ans, String result){
        int ah_result = algebraHomework(eq, ans);
        System.out.println("********\n\tEquation:\t" + eq);
        System.out.println("\tAnswer:\t" + ans + "\n\tResult:\t" + result);
        System.out.println("\tOutput:" +ah_result);
        assertEquals (result,ah_result+"");
    }

    @Test
    public void test_1(){
        prepare("(5+x)/2=?", "x=1", "1");
    }

    public static void main(String args[]){
        String test = "((x+1)/2)+6=8";
        Pattern pattern = Pattern.compile(EQ_PATTERN);
        Matcher match = pattern.matcher(test);
        while (match.find()) {
            System.out.println(match.group());
        }
    }
}
