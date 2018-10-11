/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author BigBoss
 */

import java.util.Arrays;

public class CodeFights {
    /**
     * Determine the max product of adjacent elements in an array.
     * @author BigBoss
     */
    static int adjacentElementsProduct(int[] inputArray) {
        int maxProd = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {                        
            if (i == 0) {
                maxProd = inputArray[i] * inputArray[i+1];
                continue;
            }
            if (inputArray[i] * inputArray[i+1] > maxProd ) {
                maxProd = inputArray[i] * inputArray[i+1];
            }
        }
        return maxProd;   
   }
    
   /**
    * Return the area of a shape.
    * @param n
    * @return Area of shape
    */
   static int shapeArea(int n) {       
       int area = 1;      
       if (n > 1) {           
           for(int i = 2; i <= n; i++)
               area += (i - 1)*4;
       }
       return area;
   }
   
   /**
    * Code fight problem, which wanted to know how many additional statues
    * were needed, if the statues were to be ordered from smallest to largest,
    * with an increment of 1 unit in size between each one.
    * @param statues
    * @return Number of extra statues needed.
    */
   static int makeArrayConsecutive2(int[] statues) {
       Arrays.sort(statues);
       int count = 0;
       for(int i = 0; i < statues.length - 1; i++) {
           if (statues.length == 1)
               break;
           count += statues[i+1] - (statues[i]+1);
       }           
       return count;           
   }
   
   /**
    * Determines whether an integer array is increasing or not.
    * @param sequence
    * @return Whether or not the sequence is increasing. 
    */
   static boolean almostIncreasingSequence(int[] sequence) {
       int count = 0;
       int index = 0;
       do {
           if (sequence.length == 1)
               break;           
           if (sequence[index] - sequence[index + 1] >= 0) {
               count++;
               if (index != 0)
                   if (sequence[index + 1] - sequence[index - 1] <= 0) {
                       if (index + 2 != sequence.length)
                            if (sequence[index] - sequence[index + 2] >= 0) {
                                count++;                       
                                break;
                            } else
                                index += 2;                                                      
                   }                       
           }           
           index++;
       } while (count < 2 && index < sequence.length - 1);
       return count < 2;
   }
   
   
}
