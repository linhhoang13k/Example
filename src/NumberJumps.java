package com.sleepsoft.challenges;

import com.sleepsoft.test.BaseTest;
import org.junit.Test;

/**
 * Created by agermenos on 8/22/16.
 */

/**
 There are several points on a straight line, and you're standing at point 1. Your task is to get to the last point in the minimum number of jumps. There are two constraints on the jumps you can make:

 the first and last jumps should be of size 1;
 the absolute difference between the lengths of two consecutive jumps should be less than or equal to 1.
 Return the minimum number of jumps you should make to get from the first point to the last one under the conditions given above.

 Example

 For n = 14, the output should be
 minJumpToReachEnd(n) = 7.

 Here's the fastest way to get to the last point:

 JUMP LENGTH	POSITION
    -	            1
    1	            2
    2	            4
    3	            7
    3	            10
    2	            12
    1	            13
    1	            14
 Input/Output

 [time limit] 3000ms (java)
 [input] integer points

 The number of points.

 Constraints:
 5 ≤ points ≤ 109.

 [output] integer

 The minimum required number of jumps.
 */

public class NumberJumps extends BaseTest {
    int minJumpToReachEnd(int points) {
        int length=0; int k=0; int position=1;
        while (position<points) {
            if (position+length + (length)*(length+1)/2 > points & length>1) length--;
            if (position+length + (length)*(length+1)/2 < points) length++;
            position = position + length;
            k++;
        }
        return k;
    }

    @Test
    public void test(){
        prepare(14,minJumpToReachEnd(14));
        prepare(12,minJumpToReachEnd(12));
        prepare(8,minJumpToReachEnd(8));
        prepare(6,minJumpToReachEnd(6));
        prepare(5,minJumpToReachEnd(5));
    }
}
