/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arcade;

import java.util.Arrays;

/**
 *
 * @author epiercy
 */
public class ArcadeUtils {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "adcaa";
        
        System.out.println(commonCharacterCount(s1,s2));
    }
    
    boolean isLucky(int n) {

    }
    
    static int commonCharacterCount(String s1, String s2) {
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        int valsFound = 0;
        
        Arrays.sort(s1Char);
        Arrays.sort(s2Char);
        
        //potential swap
        if(s2Char[0] < s1Char[0]){
            char[] temp = s2Char.clone();
            s2Char = s1Char.clone();
            s1Char = temp;
        }
        
        int s2Counter = 0;
        
        for(int i = 0; i < s1Char.length; i++)
            while(s2Counter < s2Char.length){
                if(s1Char[i] < s2Char[s2Counter]) //if the value I'm comparing is less on lefthand, check next lefthand value
                    break;
                else if(s1Char[i] > s2Char[s2Counter]){ //if it's larger, temp dec lefthand counter
                    s2Counter++;
                    i--; //this is a temporary decrement, no big deal, just sets back i one to re-examine last char
                    break;
                }
                else if(s1Char[i] == s2Char[s2Counter]){
                    valsFound++;
                    s2Counter++;
                    break;
                }
            }
        return valsFound;
    }
    
    static String[] allLongestStrings(String[] inputArray) {
        
        int maxStrLen = 0;
        int inputLen = inputArray.length;
        int outputLen = 1;
        
        for(int i = 0; i < inputLen; i++){
            int strLen = inputArray[i].length();
            if(strLen > maxStrLen){
                maxStrLen = strLen;
                outputLen = 1;
            }
            else if(strLen == maxStrLen)
                outputLen++;
        }
        
        String[] outputStrArr = new String[outputLen];
        
        int outputCounter = 0;
        
        for(int i = 0; i < inputLen; i++){
            if(inputArray[i].length() == maxStrLen){
                outputStrArr[outputCounter] = inputArray[i];
                outputCounter++;
            }
        }
        
        return outputStrArr;
    }
    
    static int matrixElementsSum(int[][] matrix) {
        int val = 0;
        //row, column
        for(int col = 0; col < matrix[0].length; ++col) //for each column
            for(int row = 0; row < matrix.length; ++row){ //for each row inside a column
                if(matrix[row][col] == 0)
                    break;
                else
                    val += matrix[row][col];
            }
        return val;
}
    
    static boolean almostIncreasingSequence(int[] sequence) {
        
        int len = sequence.length;
        int wrong = 0;
        
        if(len == 2)
            return true;
        
        int compare = sequence[0];

        for(int i = 1; i < len; i++){
            if(i == 1 && !(compare < sequence[i])){
                wrong++;
                compare = sequence[1];
            }
            else if(!(compare < sequence[i])) //if the next number in the sequence is greater
                wrong++;
            else
                compare = sequence[i];
            if(wrong > 1)
                return false;
        }
        return true;
    }

    static int add(int param1, int param2) {
        return param1 + param2;
    }
    
    static int centuryFromYear(int year) {
        int century = year/100; //we have the century now, more or less
        if(year % 100 == 0)
            return century;
        return ++century;
        
    }
    
    static boolean checkPalindrome(String inputString){
        int begin = 0;
        int end = inputString.length() - 1;
        
        while(begin <= end){
            if(inputString.charAt(begin) != inputString.charAt(end))
                return false;
            ++begin;
            --end;
        }
        
        return true;
    }
    
    static int adjacentElementsProduct(int[] inputArray) {
        int largestProd = -51;
        int i = 0;
        for(int j = 1; j < inputArray.length; ++j){
            int prod = inputArray[i] * inputArray[j];
            if(prod > largestProd)
                largestProd = prod;
            ++i;
        }
        return largestProd;
    }
    
    static int shapeArea(int n){
        if(n == 1)
            return 1;
        return ((n-1)*4) + shapeArea(n-1);
    }
    
    static int makeArrayConsecutive2(int[] statues) {
        Arrays.sort(statues);
        int i = 0;
        int total = 0;
        for(int j = 1; j < statues.length; ++j ){
            total += (statues[j]-statues[i])-1;
            ++i;
        }
        return total;
    }
}
