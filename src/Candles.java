/* package whatever; // don't place package name! */
/**
When a candle finishes burning it leaves a leftover. makeNew leftovers can be combined to make 
a new candle, which, when burning down, will in turn leave another leftover.

You have candlesNumber candles in your possession. What's the total number of candles you 
can burn, assuming that you create new candles as soon as you have enough leftovers?

Example

For candlesNumber = 5 and makeNew = 2, the output should be
candles(candlesNumber, makeNew) = 9.

Here is what you can do to burn 9 candles:

burn 5 candles, obtain 5 leftovers;
create 2 more candles, using 4 leftovers (1 leftover remains);
burn 2 candles, end up with 3 leftovers;
create another candle using 2 leftovers (1 leftover remains);
burn the created candle, which gives another leftover (2 leftovers in total);
create a candle from the remaining leftovers;
burn the last candle.
Thus, you can burn 5 + 2 + 1 + 1 = 9 candles, which is the answer.
**/
import java.io.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(candles(5,2));
    }
    
    public static int candles(int candlesNumber, int makeNew) {
        int burnCandles=0;
        int leftOver=0;
        
         
        while(candlesNumber>0){
            burnCandles+=candlesNumber;
            leftOver+=candlesNumber;
            candlesNumber=leftOver/makeNew;
            leftOver%= makeNew;
        }
        return burnCandles;
    }
    
}