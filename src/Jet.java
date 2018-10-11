package com.taidev198.game.CodingInterview.Companies.Jet;

import java.util.*;
import java.util.stream.Collectors;

public class Jet {

    static int packageBoxing(int[] pkg, int[][] boxes) {

        Arrays.sort(pkg);
        //sort each box.
        for(int i = 0; i< boxes.length; i++){
            Arrays.sort(boxes[i]);
        }
        int minVolume = -1;
        int minIdx  = -1;
        for (int i = 0; i <boxes.length ; i++) {
            if (boxes[i][0] < pkg[0])
                continue;
            boolean isValid = true;
            for (int j = 0; j < boxes[i].length; j++) {
                    if (boxes[i][j] < pkg[j]){
                        isValid = false;
                        break;
                    }
            }

            int volume =  boxes[i][0] * boxes[i][1] * boxes[i][2];
            if ((isValid  && minVolume ==-1) || (isValid && minVolume > volume)){
                minVolume = volume;
                minIdx = i;
            }
        }

        return  minIdx;
    }

    static String[][] catalogUpdate(String[][] catalog, String[][] updates) {
        int row = catalog.length;
        int col = catalog[0].length;
        int rowUpdate = updates.length;
        int colUpdate = updates[0].length;

        int[][] ans = new int[row + rowUpdate][ col + colUpdate];
        int c =0, r =0;



        return null;
    }

    static String[] shoppingCart(String[] requests) {
        String[] ans = new String[100];
        List<String> items = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < requests.length; i++) {
            String request = requests[i].substring(0, !requests[i].contains(" ") ? requests[i].length():
                    requests[i].indexOf(" "));
            String item = requests[i].substring(requests[i].indexOf(":")+2);
            if (request.equals("add")){
                items.add(item);
                values.add(1);
            }
            else if (request.equals("remove")){
                int index =  items.indexOf(item);
                items.remove(item);
                values.remove(index);
            }
            else if (request.equals("quantity_upd")){
                item = requests[i].substring(requests[i].indexOf(":")+2,requests[i].lastIndexOf(":")-1);
                int index =  items.indexOf(item);
                int valueOfItem = values.get(index);
                int value = 0;
                int pow =0;
                int j = requests[i].length()-1;
                while (requests[i].charAt(j) <='9' && requests[i].charAt(j) >='0'){
                    value = value + (requests[i].charAt(j)- '0')*(int)Math.pow(10, pow);
                    pow++;
                    j--;
                }
                if (requests[i].charAt(j) == '-')
                    value = -value;
                    values.set(index, valueOfItem+ value);
            }else {
                items.clear();
                values.clear();
            }
        }

       int i=0;
        for ( ; i < items.size(); i++) {
            ans[i] = items.get(i) + " : " + values.get(i);
        }
        return  Arrays.copyOfRange(ans, 0, i);
    }


    static double[][] jetDashboard(int[] orders, int n) {

        int window_sum = orders[orders.length - n ];
        List<Integer> list = new ArrayList<>();
        double standardDeviation = 0.0;
        list.add(orders[orders.length - n ]);
        //calculate standard deviation
        standardDeviation += Math.pow(orders[orders.length - n ] - (float)window_sum, 2);
        double[][] ans = new double[n][3];
        ans[0][0] = Collections.max(list);
        ans[0][1] = window_sum;
        ans[0][2] = -1;
        int row =1;
        for (int i = 0; i < n-1; i++) {
            list.add(orders[orders.length - n+i+1]);
            window_sum  += orders[orders.length - n+i+1];
            ans[row][0] = Collections.max(list);
            ans[row][1] = (float)window_sum/ (i+2);
            ans[row][2] = standardDeviation(orders, orders.length - n,
                    orders.length-n+i +1, ans[row][1], i+1);
            row++;
        }
        return ans;
    }

    static double standardDeviation(int[] arr, int start, int end, double midValue, int n){

        double res =0.0;
        for (int i = start; i <= end; i++) {
            System.out.println(res);
            res += Math.pow(arr[i] - midValue, 2);
        }
        return res/n;
    }


    public static void main(String...args){

        System.out.println(Arrays.deepToString(jetDashboard(new int[]{4, 2, 5, 9, 2}, 5)));
//        String temp = "remove : milk";
//        System.out.println(temp.substring(temp.indexOf(":")+1, temp.length()));
    }
}
