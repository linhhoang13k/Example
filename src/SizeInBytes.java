package com.sleepsoft.challenges;

import com.sleepsoft.test.BaseTest;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by agerm on 8/21/2016.
 Given the capacity of a hard drive and its measure unit, return its capacity in bytes.

 Here are all possible measure units and their sizes:

 Kilobyte (KB)	1,024 bytes
 Megabytes (MB)	1,048,576 bytes
 Gigabyte (G)	1,073,741,824 bytes
 Terabyte (TB)	1,099,511,627,776 bytes
 Petabyte (P)	1,125,899,906,842,624 bytes
 Example

 For capacity = 12 and unit = "KB", the output should be
 `ComputerUnitsToByte(capacity, unit) = "12288".

 12 * 1024 = 12288, which is the answer.

 Input/Output

 [time limit] 3000ms (java)
 [input] integer capacity

 Disk capacity.

 Constraints:
 1 ≤ capacity ≤ 100.

 [input] string unit

 Unit symbol, one of the following strings: 'KB', 'MB', 'G', 'TB' or 'P'.

 [output] string

 The answer as a string. It is guaranteed to be smaller than 2^51.
 */
public class SizeInBytes extends BaseTest {
    String ComputerUnitsToByte(int capacity, String unit) {
        BigInteger potency=(BigInteger.valueOf(1));
        int base=0;
        switch (unit) {
            case"KB": base=1; break;
            case"MB": base=2; break;
            case"G":  base=3; break;
            case"TB": base=4; break;
            case"P":  base=5;
        }
        for (int k=0;k<base; k++){
            potency = potency.multiply(BigInteger.valueOf(1024));
        }
        potency = potency.multiply(BigInteger.valueOf(capacity));
        return potency.toString();
    }

    public void preTest(int value, String unit, String expected){
        System.out.print("\n\ttest: " + value + ", " + unit + "\t");
        prepare(ComputerUnitsToByte(value, unit), expected);
    }
    @Test
    public void test1(){
        // preTest(3, 1);
        preTest(12, "KB", "12288");

    }
    @Test
    public void test2(){
        preTest(5, "MB", "5242880");

    }
    @Test
    public void test3(){
        preTest(1, "P", "1125899906842624");

    }
    @Test
    public void test4(){
        preTest(51, "TB", "56075093016576");
    }
    @Test
    public void test5(){
        preTest(70, "KB", "71680");
    }
    @Test
    public void test6(){
        preTest(72, "KB", "73728");
    }
}
