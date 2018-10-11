package com.taidev198.game.CodingInterview.Companies.Instacart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Instacart {


    static double shoppingList(String items) {
        double result = 0.0;
        int n = items.length();
        if(n == 0)
            return 0;
        for(int i = 0 ; i < n ; i++){
            char ch = items.charAt(i);
            if(ch <='9' && ch >= '0'){
                int j = i;
                while(j < n  ){
                    if ((items.charAt(j) <='9'
                            && items.charAt(j) >= '0'
                           )  || items.charAt(j) == '.')
                    j++;
                    else break;
                }
                String temp = items.substring(i,j);
                if (!temp.equals(""))
                result += Double.valueOf(temp);
                i=j;
            }
        }
        return result;
    }


    static boolean deliveryFee(int[] intervals, int[] fees, int[][] deliveries) {

        int intervalsLen = intervals.length;
        int feesLen = fees.length;
        if(intervalsLen == 1 && feesLen == 1)
            return true;
        List<Double> result = new ArrayList<>();
        int deliveriesLen = deliveries.length;
        for(int i = 0; i < intervals.length   ; i++){
             double count = 0.0;
            for (int j = 0; j < deliveriesLen; j++) {
                if ( i < intervals.length-1 && deliveries[j][0] >= intervals[i] && deliveries[j][0] <= intervals[i+1]-1)
                    count++;
                else if (i == intervals.length-1 && deliveries[j][0] >= intervals[i+1] && deliveries[j][0] <= 23)
                    count++;
            }
            if (result.size() == 0 )
            result.add(fees[i] / count);
            else if (!result.contains(fees[i] / count))
                return false;
        }
        return true;
    }

    static boolean busyHolidays(String[][] shoppers, String[][] orders, int[] leadTime) {
        for(int i=0;i< shoppers.length;i++){
            int[] startTime = getTime(shoppers[i][0]);
            int[] endTime = getTime(shoppers[i][1]);
            for(int j=0;j< orders.length;j++){
                int[] startTimeForOrder = getTime(orders[j][0]);
                int[] endTimeForOrder = getTime(orders[j][1]);
                if((startTime[0] <= startTimeForOrder[0] && endTime[0] >=startTimeForOrder[0])
                        && endTimeForOrder[0] <= endTime[0]){
                    startTimeForOrder[1]  = (startTimeForOrder[1] + leadTime[j]) %60;
                    startTimeForOrder[0] = startTimeForOrder[0] +(startTimeForOrder[1] + leadTime[j]) /60;
                        if (startTimeForOrder[0] > endTimeForOrder[0] ||
                                (startTimeForOrder[1] == endTimeForOrder[1] && startTimeForOrder[0] == endTimeForOrder[0]))
                            continue;
                        if(startTimeForOrder[0] <endTime[0] ||
                                (startTimeForOrder[0] == endTime[0] && endTimeForOrder[1] <= endTime[1]))
                            return true;

                }
            }
        }
        return false;
    }
   static int[] getTime(String time){

        int[] ans = new int[2];
        ans[0] = Integer.valueOf(time.substring(0,2));
        ans[1] = Integer.valueOf(time.substring(3,5));
        return ans;
    }

    public static void main(String...args){

        System.out.println(busyHolidays(new String[][]{{"23:00", "23:59"},
                {"22:30", "23:30"}}, new  String[][]{{"23:15", "23:35"}, {"23:00", "23:31"}}, new int[]{20, 31}));

    }
}
