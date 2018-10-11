package com.taidev198.game.CodingInterview.Array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author traig on 7/14/2018.
 * @project Codefights
 */
public class Array {


    /***/
    static char firstNotRepeatingCharacter(String s) {
        int n = s.length() ;
        if (n == 1)
            return s.charAt(0);
        if (n == 2){
            if (s.charAt(0) == s.charAt(1))
                return '_';
            return s.charAt(0);
        }
        for (int i = 0; i < n -1; i++) {
            char ch = s.charAt(i);
            String left = i == 0? "": s.substring(0,i );
            if (!left.contains(Character.toString(ch))) {

                String right = i == (n-1)? "" : s.substring(i +1,n);
                if (right.contains(Character.toString(ch)))
                    continue;
                return ch;
            }
        }
        return '_';
    }

/**Problem:https://app.codesignal.com/interview-practice/task/pMvymcahZ8dY4g75q
 * */
    static int firstDuplicate(int[] a){

        int[] iterated = new int[a.length + 1];
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == iterated[a[i]])
            {
                return a[i];
            }
            else
            {
                iterated[a[i]] = a[i];
            }
        }
        return -1;
    }

    static boolean isPower(int n) {
        if (n == 1)
            return true;
        for(int i = 2; i < n /2; i++){
            int temp = n;
            if(n % i == 0){
                System.out.println("divide:" + i);
                temp /= i;
                while(temp  %i == 0)
                    temp /=i;
                if(temp == 1)
                    return true;
            }
        }
        return false;
    }
    static String[] addBorder(String[] picture) {
        int n = picture[0].length();
        int nRow = picture.length;
        int newLen = n +2;
        String[] newPicture = new String[picture.length + 2];
       char[] ch = new char[newLen];
        Arrays.fill(ch, '*');
        newPicture[0] = new String(ch);
        newPicture[nRow +1   ] = new String(ch);

        for (int i = 0; i < nRow; i++) {
            newPicture[i+1] = '*' + picture[i] + '*';
        }
        return newPicture;
    }

    static boolean areSimilar(int[] a, int[] b) {

        int nA = a.length;
        int nB = b.length;

        if( nA != nB )
            return false;

        if( nA == 2 )
            return true;
        if(nA == 1)
            return true;

        int i = 0;
        while (i < nA){
            if (a[i] == b[i])
                i++;
            else break;
        }
        int firstDif = i;
        if (i == nA)
            return true;
        i++;
        while( i < nA){
            if (a[i] != b[i])
                break;
            i++;
        }
        int secondDif = i;
        i++;
        while( i < nA){
            if (a[i] != b[i])
                return false;
            i++;
        }
        return a[firstDif] == b[secondDif] && a[secondDif] == b[firstDif];
    }

    static boolean isIPv4Address(String inputString) {
        String temp = "0.0..1";
        if (temp.charAt(0) == '.' || temp.charAt(temp.length() -1) == '.')
            return false;
        String[] test = temp.split("\\.");

        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) >='A' && temp.charAt(i) <='z')
                return false;
        }
        if (test.length != 4)
           return false;
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
                if (test[i].equals("") || Integer.parseInt(test[i]) > 255 || Integer.parseInt(test[i]) < 0)
                    return false;
        }
        return  true;

    }

   static int squareDigitsSequence(int a0) {
        int d  = a0;
        List<Integer> list = new ArrayList<>();
        list.add(a0);
       int temp = 0;
       while(true){
            while (d !=0){
                temp += (d % 10) * (d%10);
                d /=10;
            }
            d = temp;
            temp = 0;
            if (list.indexOf(d) == -1){
                System.out.println("add:"+d);list.add(d);
            }
            else break;
        }
        return list.size() +1;
    }

    static int pagesNumberingWithInk(int current, int numberOfDigits) {

        while( numberOfDigits >= 0){
            int numDigits =(int) (Math.log10(current) +1);
            if(numberOfDigits - numDigits >= 0){
                numberOfDigits -= numDigits;
                current ++;
            }else break;

        }
        return current -1;
    }

    static int comfortableNumbers(int l, int r) {
        int count = 0;

        for(int i =l; i < r ; i++){
            for(int j = l+1; j <= r; j++){
                if(j <= i+ sumOfDigits(i) ){
                    if(i >= j - sumOfDigits(j)  )
                        count ++;
                }
            }
        }
        return count;
    }


    static int numOfWeakness(int n, List<Integer> list){

        int num = Collections.max(list);

        return num;
    }

    static int sumOfDigits(int n){
        if(n == 0)
            return 0;
        return n %10 + sumOfDigits(n /10);
    }



    static int avoidObstacles(int[] inputArray) {
        Arrays.sort(inputArray);
        List<Integer> list = new ArrayList<>();
        int n = inputArray.length;
        if (n == 1)
            return inputArray[0] + 1;
        for (int i = 0; i < n; i++) {
            list.add(inputArray[i]);
        }
        int jump = 3;
        int temp = jump;
        while(temp <= inputArray[n -1]){
            if (list.indexOf(temp) != -1){
                jump++;
                temp = jump;
            }
            else temp += jump;
        }
        return jump;
    }


    static int[][] boxBlur(int[][] image) {
        int n = image.length;
        int m = image[0].length;
        int[][] result = new int[n -2][m -2];

        for(int i = 0 ;i < n -2; i++){

            for(int col = 0; col < m -2; col ++){

                int sum =0;
                for(int j = i ; j < i +3; j++){
                    for(int k = col; k < col + 3; k++){
                        sum += image[j][k];
                    }
                }
                result[i][col] = sum /9;
            }
        }
        return result;
    }

   static int[][] minesweeper(boolean[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] answer = new int[n][m];


        for(int i = 0; i< n; i++){
            for(int j = 0 ; j< m; j++){
                answer[i][j] = numMinesNeighboring(i, j, n, m, matrix);
            }
        }
        return answer;
    }

   static int numMinesNeighboring(int i, int j, int n, int m, boolean[][] matrix){
        int rowUp,rowDown,colLeft = 0,colRight =0 ;
        if(i == 0  ){
            rowUp = i;
            rowDown = i+1;

        }
        else if(i == n -1){
            rowUp = i-1;
            rowDown = i;

        }
        else {
            rowUp = i -1;
            rowDown = i+1;
        }

       if(j == 0){
           colLeft = j;
           colRight = j+1;
       }else if (j == m -1){
           colLeft = j -1;
           colRight = j;
       }
       else{
           colLeft = j - 1;
           colRight = j+1;
       }

        int count =0;
        for(int k = rowUp ; k <= rowDown; k++){
            for(int l = colLeft; l <= colRight; l++){
                if(matrix[k][l] && (k != i || l != j))
                    count++;
            }
        }
        return count;
    }

    public static void main(String...args){

        System.out.println(Arrays.deepToString(minesweeper(new boolean[][]{{true, false, false},
                {false, true,  false},
                {false, false, false}})));

      // System.out.println(isIPv4Address("129380129831213981.255.255.255"));




    }

}
