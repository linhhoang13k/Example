package com.sleepsoft.tests;

/**
 * Created by agermenos on 6/8/16.
 */
public class Factorial {
    private Integer index;
    private Long value;

    public Factorial(int k) {
        index = k;
        value = getFactorial(Long.valueOf(index));
    }

    private Long getFactorial(Long r_index) {
        if (r_index>0) {
            return r_index*getFactorial(r_index - 1);
        }
        return 1l;
    }

    public String toString(){
        return (index + "! = " + value);
    }



    public static void main(String args[]){
        Factorial factorial;
        for (int k=0; k<5; k++){
            int testValue = (int)(10*Math.random());
            factorial = new Factorial(testValue);
            System.out.println(factorial);
        }
    }
}
