package com.taidev198.game.CodingInterview.Array;

import org.omg.CORBA.INTERNAL;

import java.util.*;


/**
 * @author traig on 7/22/2018.
 * @project Codefights
 */
public class Array2 {

    static double shoppingList(String items) {
        int n = items.length();
        int i =0,j ;
        double result = 0.0;
        char ch;
        if (n == 0)
            return 0;
        while (i < n){
            ch = items.charAt(i);
            if (Character.toString(ch).matches("[0-9.]*")){
                j = i;
                while(Character.toString(ch).matches("[0-9.]*") && i < n ) {
                    ch = items.charAt(i);
                    i++;
                }
                if (items.charAt(j) != '.')
                result += Double.valueOf(items.substring(j,i -1));
                System.out.println(i);
            }else i++;
        }
        return result;
    }

   static boolean deliveryFee(int[] intervals, int[] fees, int[][] deliveries) {

        int intervalsLen = intervals.length;
        int feesLen = fees.length;

        if(intervalsLen == 1 && feesLen == 1)
            return true;
        double count = 0.0;
        List<Double> result = new ArrayList<>();
        int deliveriesLen = deliveries.length;
        int j =0;
        for(int i = 0; i < deliveriesLen  ; i++){
            if(deliveries[i][0] >= intervals[j] && deliveries[i][0] <= intervals[j +1] ){
                count ++;
            }else{
                result.add(fees[j] / count);
                if(fees[j]/ count  != Collections.max(result))
                    return false;
                count = 1.0;
                j++;
                if(j == intervalsLen)
                    break;
            }
        }
        return result.size() == 3;
    }


    static int higherVersion2(String ver1, String ver2) {
        String[] ver1Arr = ver1.split("\\.");
        String[] ver2Arr = ver2.split("\\.");
        for (int i = 0; i < ver1Arr.length; i++) {
            if (Double.valueOf(ver1Arr[i]) < Double.valueOf(ver2Arr[i])) return -1;
            if (Double.valueOf(ver1Arr[i]) > Double.valueOf(ver2Arr[i])) return 1;
        }
        return 0;
    }

    static int[][] rotateImage(int[][] a) {
        int n = a.length;
        int d =0;
        while (d < n /2){
            int up = d;
            int down = n -1 -d;
            while (up < n-1 -d&& down >d){
                int temp = a[up][n-1 -d];
                a[up][n-1-d] = a[d][up];
                a[d][up] = a[down][d];
                a[down][d] = a[n-1-d][down];
                a[n-1-d][down] = temp;
                up++;
                down--;
            }
            d++;
        }
        return a;
    }

    static int digitsProduct(int product) {
        if(product ==0) return 10;
        if(product == 1) return 1;
        for (int i = 1; i <=9; i++) {
            for (int j = 1; j <=9 ; j++) {
                for (int k = 1; k <=9 ; k++) {
                    for (int l = 1; l <=9 ; l++) {
                        if (i*j*l*k == product)
                       return Integer.valueOf((i + "" + j + "" + k + "" + l).replaceAll("1",""));
                    }
                }
            }
        }
        return 0;
    }

    static int mostFrequentDigitSum(int n) {

        if(n < 10) return n;
        List<Integer> result = new ArrayList<>();
        mostFrequentDigitSumHelper(n, result);
        int max = -1;
        int count = 1;
        int mostFrequent = 0;
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
            if (i < result.size()-1)
            if (result.get(i).equals(result.get(i + 1)))
                count++;
            else {
                if (count >= max){
                    if (count == max)
                    mostFrequent = result.get(i+1);
                    else mostFrequent = result.get(i);
                    max = count;
                }
                count = 1;
            }
        }
        return mostFrequent;
    }

    static void mostFrequentDigitSumHelper(int n, List<Integer> result){
        if(n != 0){
            int sumDigits  = sum(n);
            result.add(sumDigits);
             mostFrequentDigitSumHelper(n - sumDigits, result);
        }
    }
    static int sum(int n){
        if(n == 0) return 0;
        return n %10 + sum(n/10);
    }

    static int[] nextLarger(int[] a) {
        int n = a.length;
        if( n == 1) return new int[]{-1};
        for (int i = 0; i < n-1; i++) {
            int j = i+1;
            while (j < n){
                if (a[j] < a[i])
                    j++;
                else break;
            }
            if (j < n)
            a[i] = a[j];
            else a[i] = -1;
        }a[n-1] = -1;
        return a;
    }

   static int[] minimumOnStack(String[] operations) {
        int n = operations.length;
        int[] answer = new int[n];
        TheStack theStack = new TheStack();
        int j = 0;
        for(int i = 0; i< n; i++){
            if(operations[i].contains("push")){
                theStack.push(Integer.valueOf(operations[i].substring(
                        operations[i].indexOf(" ")+1, operations[i].length())));
            }else{
                if(operations[i].equals("pop"))
                    theStack.pop();
                else answer[j++] = theStack.minimum();
            }
        }
        return Arrays.copyOfRange(answer, 0, j);
    }

  static  class TheStack{
        private int[] theStackArr ;
        private int min;
        private int preMin ;
        private int top =-1;

         TheStack(){
            min = -1;
            preMin = -1;
            theStackArr = new int[10000];
        }

        boolean isEmpty(){return top == -1;}

        int pop(){
            if(!isEmpty()){
                if (theStackArr[top] == min){
                    min = preMin;
                }
                return theStackArr[top--];
            }
            return 0;
        }

        void push(int i){
            if(min == -1  || i < min){
                preMin = min;
                min = i;
            }
            theStackArr[++top] = i;}

        int minimum(){
            if(!isEmpty()) return min;
            return -1;
        }

    }

    public static void main(String...args){

        char[][] charArray= new char[][]{{'1','2','5','5'}};

        System.out.println(Arrays.toString(minimumOnStack(new String[]{"push 3","push 2","push 1","pop","pop","min"})));
    System.out.println("10".matches("[0-9]*"));

    Map<Integer, Boolean> map = new Hashtable<>();

    }
    static int missingNumber(int[] arr) {
        int n = arr.length;
        int[] p = new int[n +1];
        p[0] = arr[0];
        for(int i = 1;i < n+1;i++){
            p[i] = p[i -1] + arr[i ];
        }
        System.out.println(p[n]);
        return ((n +1) *n)/2 - p[n];

    }


    static int findFirstSubstringOccurrence(String s, String x) {

        int n = s.length();
        int index = s.indexOf(x.charAt(0));
        if(!s.contains(x)) return -1;
//        while(index != -1){
//            if(index + x.length() > n)
//                return -1;
//            if(s.substring(index, index+ x.length()).contains(x))
//                return index;
//
//            index =  s.indexOf(x.charAt(0), index+1);
//        }
        return s.indexOf(x);
    }


    static int numbersGrouping(int[] a) {

        Arrays.sort(a);
        int leftBounded = 1;
        int rightBounded = (int)Math.pow(10,4);
        int n = a.length;
        int bound = 10000;
        int numMems = 0;
        for (int i = 0; i < a.length-1; i++) {
              rightBounded = a[i] % bound == 0? a[i] : ((a[i]/ bound) +1 )*bound;
              leftBounded = a[i] % bound == 0?((a[i] / bound) -1) *bound +1: (a[i]/bound)*bound +1;
              int j = i+1;
              while (j <n){
                  if (a[j] >=leftBounded && a[j] <= rightBounded) j++;
                  else break;
              }
              i = j-1;
              numMems++;
        }
        if (a[n-1] > rightBounded)
            numMems ++;
        return a.length + numMems;//return length of array plus the number of groups
    }

        static int[] priceSuggestion(int[] contractData) {

            int n = contractData.length;
            if(n == 0) return new int[0];

            Arrays.sort(contractData);
            int left = n/2 == 0? (contractData[n/4] + contractData[ n/4 -1 ])/2  :contractData[(n/2 -1) /2 ];
            int right = n/2 == 0?(int) Math.ceil((contractData[n/4 + n/2 -1 ]
                    + contractData[ n/4 + n/2 ])/2 + 0.5) :contractData[n /2 + n /4 ];

            return new int[]{left, right};

        }

}
