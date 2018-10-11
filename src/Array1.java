package com.taidev198.game.CodingInterview.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author traig on 7/19/2018.
 * @project Codefights
 */
public class Array1 {



    static boolean variableName(String name) {
        if(Character.toString(name.charAt(0)).matches("(0|1|2|3|4|5|6|7|8|9)*"))
            return false;
        if (name.matches("[a-zA-Z_0-9]+"))
            return true;
        return false;
    }

    static String alphabeticShift(String inputString) {
        List<Character> list = new ArrayList<>();
        int n = inputString.length();
        StringBuilder temp = new StringBuilder(inputString);
        for (char ch = 'a'; ch <= 'z'; ch++) {
            list.add(ch);
        }
        for(int i = 0; i < n; i++ ){
            char ch = inputString.charAt(i);
            int index = list.indexOf(ch);
            temp = temp.replace(i,i, Character.toString(list.get((index +1) % 26)));
            temp.deleteCharAt(i +1);
        }
        return temp.toString();
    }

   static String alphabeticShift1(String inputString) {
        char[] ss = inputString.toCharArray();
        for (int i = 0; i < ss.length; ++i) {
            ss[i]++;
            if (ss[i] > 'z')
                ss[i] = 'a';
        }
        return new String(ss);
    }


   static boolean chessBoardCellColor(String cell1, String cell2) {
        char rowCell1  = cell1.charAt(1);
        char rowCell2 = cell2.charAt(1);
        char colCell1 = cell1.charAt(0);
        char colCell2 = cell2.charAt(0);
        int dif = (colCell2 - '0') - (colCell1 - '0');
        if(dif % 2 == 0)
            return (Character.getNumericValue(rowCell2) - Character.getNumericValue(rowCell1)) % 2 == 0;
        return (Character.getNumericValue(rowCell2) - Character.getNumericValue(rowCell1)) % 2 != 0;
    }

    static boolean chessBoardCellColor2(String cell1, String cell2) {
        return Math.abs(cell1.charAt(0) - cell2.charAt(0)) % 2 == Math.abs(cell1.charAt(1) - cell2.charAt(1)) % 2;
    }
    /**Link:https://app.codesignal.com/arcade/intro/level-7/vExYvcGnFsEYSt8nQ/description
     * */
    static int circleOfNumbers(int n, int firstNumber) {
        return (firstNumber+n/2)%n;
    }

    static int[] minSizeSubArray(int[] arr, int s){

        int minLen = 2;
        int len =0;
        int minStartIndex = 0, minEndIndex = 0, currentStartIndex =0;
        int sum = 0;
        int n = arr.length;
        for (int currentEndIndex = 0; currentEndIndex < n; currentEndIndex++) {
            sum += arr[currentEndIndex];
            len ++;
            if (sum == s  ){
                if (minLen >= len){
                    minStartIndex = currentStartIndex;
                    minEndIndex = currentEndIndex;
                    minLen = len;
                    sum = 0;
                    len = 0;
                }else {
                    currentStartIndex = currentEndIndex;
                    sum = 0;
                    len = 0;
                }
            }
            if (sum > s){
            }
        }
        return new int[]{minStartIndex, minEndIndex};
    }

   static int arrayMaxConsecutiveSum(int[] inputArray, int k) {
        int max = 0;
        int n = inputArray.length;
        int[] p = new int[n +1];
         p[0] = inputArray[0];
       for (int i = 1; i < n +1; i++) {
           p[i] = p[i - 1] + inputArray[i-1];
       }
        for(int i =0 ;i <= n -k; i++){
            int value= p[i + k ] - p[i ] ;
            if(value > max)
                max = value;
        }
        return max;

    }

    /**Link:https://app.codesignal.com/arcade/intro/level-9/6M57rMTFB9MeDeSWo
     * */
    static boolean bishopAndPawn(String bishop, String pawn) {

        char row = bishop.charAt(0);
        int  col = bishop.charAt(1) - '0';
        List<String> result = new ArrayList<>();
        int temp = col;
        for (char i = row; i >= 'a' && temp <=8; i--, temp++) {
            result.add(Character.toString(i) + temp);

        }
        temp = col;
        for (char i = row; i <= 'h' && temp >= 1; i++, temp --) {
            result.add(Character.toString(i) + temp);

        }
        temp = col;
        for (char i = row; i <= 'h' && temp <= 8; i++, temp ++) {
            result.add(Character.toString(i) + temp);

        }

        temp = col;
        for (char i = row; i >= 'a' && temp >= 1; i--, temp --) {
            result.add(Character.toString(i) + temp);

        }
        return result.contains(pawn);
    }

    static boolean bishopAndPawn1(String bishop, String pawn){
        return Math.abs(bishop.charAt(0) - pawn.charAt(0)) == Math.abs(bishop.charAt(1) - pawn.charAt(1));
    }


    static boolean isBeautifulString(String inputString){

        int pre =isBeautifulStringHelper('a', inputString), curr = 0;
        for (char i = 'b'; i <= 'z'; i++) {
                    curr = isBeautifulStringHelper(i, inputString);
                 if(curr > pre)
                     return false;
                pre = curr;
        }
        return true;
    }

    static int isBeautifulStringHelper(char ch, String inputString){

        int  count = 0;
        int n = inputString.length();
        int index = inputString.indexOf(Character.toString(ch));
        if (index != -1){
            int j ;
            do{
                count++;
                j = index +1;
                index = inputString.indexOf(Character.toString(ch),j);
            }while (j < n && index != -1);
        }
        return count;
    }

    /**Link:https://app.codesignal.com/arcade/code-arcade/loop-tunnel*/

    static int lineUp(String commands) {
        int count = 0 ;
        int length = commands.length();
        if(length ==0)
            return 0;
        if(length == 1)
            return commands.charAt(0) == 'A'? 1:0;
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < length; j++) {
            char ch = commands.charAt(j);
            if (ch == 'A' && stack.empty())
                count++;
            if (ch == 'R' || ch == 'L'  ){
                if (stack.empty())
               stack.push(ch);
                else{
                    char ch1 = stack.pop();
                    count++;
                }
            }
        }
        return count;
    }

    static void findLongestSubarrayBySum(int s, int[] arr) {

        int currentStartIndex = 0;
        int n = arr.length;
        int startIndex = 0;
        int endIndex = 0;
        int sum =0;
        int maxLen = 0;
        for (int currentEndIndex = 0; currentEndIndex < n; currentEndIndex++) {
            sum += arr[currentEndIndex];
            if (sum == s){
                while (  currentEndIndex < n){
                    if (arr[currentEndIndex+1] != 0)
                        break;
                    currentEndIndex++;
                }

                if ((currentEndIndex - currentStartIndex +1) > maxLen){
                    maxLen = currentEndIndex - currentStartIndex +1;
                    startIndex = currentStartIndex;
                    endIndex = currentEndIndex;
                    sum = 0;
                }
                currentEndIndex = currentStartIndex ;
                currentStartIndex = currentEndIndex +1;
            }
            if (sum > s){
                currentEndIndex = currentStartIndex ;
                currentStartIndex = currentEndIndex +1;
                sum = 0;
            }
        }
        System.out.println("i:" +startIndex +" \tj:"+endIndex);
    }


    /**For s = 15 and arr = [1, 2, 3, 4, 5, 0, 0, 0, 6, 7, 8, 9, 10], the output should be
     findLongestSubarrayBySum(s, arr) = [1, 8].
     The sum of elements from the 1st position to the 8th position (1-based) is equal to 15: 1 + 2 + 3 + 4 + 5 + 0 + 0 + 0.*/

    static int[] findLongestSubarrayBySum1(int s, int[] arr){
        int left ;
        int right;
        int[] p = prefixSumSubArray(arr);
        int temp = 0;
        int n = arr.length;
        int maxLen = 0;
        int start =0;
        int end = 0;
        while (temp < n){
            left = temp;
            right = n-1;
            while (p[right +1] - p[left] > s){
                right--;
            }
            if (p[right +1] - p[left] == s && (right - left +1) > maxLen){
                maxLen = right - left + 1;
                start = left;
                end = right;
            }
            temp ++;
        }
        return maxLen == 0?new int[]{-1}: new int[]{start +1, end +1};
    }

    static int[] findLongestSubarrayBySum3(int s, int[] arr) {
        int sum = 0;
        int l = 0;
        int[] a = new int[] {-1};
        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (l < r && sum > s) {
                sum -= arr[l++];
            }
            if (sum == s && (a.length == 1 || a[1] - a[0] < r - l)) {
                a = new int[] {l + 1, r + 1};
            }
        }
        return a;
    }


    static int[] prefixSumSubArray(int[] arr){
        int[] p = new int[arr.length +1];
        for (int k = 1; k <= arr.length; k++) {
            p[k ] = p[k -1] + arr[k -1];
        }
        return p;
    }

    static int zigzag(int[] a) {
        int len = a.length;
        if(len ==1|| len ==2) return 1;
        int lenSequence = 0;
        int maxLen = 1;
        for(int i=0;i< len-2; i++){
            int left = i, right = len -i-1;
        }
        return maxLen;
    }

    public static void main(String...args){
       int[] arr =  findLongestSubarrayBySum1(1, new int[]{1});
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

}
