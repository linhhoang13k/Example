/* package whatever; // don't place package name! */

/**
A little boy is studying arithmetics. He has just learned how to add two integers, written one below another, 
column by column. But he always forgets about the important part - carrying.

Given two integers, find the result which the little boy will get.

Note: the boy used this site as the source of knowledge, feel free to check it out too if you are not familiar
 with column addition.

Example

For param1 = 456 and param2 = 1734, the output should be
additionWithoutCarrying(param1, param2) = 1180.

   456
  1734
+ ____
  1180
The little boy goes from right to left:

6 + 4 = 10 but the little boy forgets about 1 and just writes down 0 in the last column
5 + 3 = 8
4 + 7 = 11 but the little boy forgets about the leading 1 and just writes down 1 under 4 and 7.
There is no digit in the first number corresponding to the leading digit of the second one, so the little
 boy imagines that 0 is written before 456. Thus, he gets 0 + 1 = 1.
**/
import java.io.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(additionWithoutCarrying(456,1734));
    }
    public static int additionWithoutCarrying(int param1, int param2) {
        String result="";
        while(param1>=1 || param2>=1){
           
            int temp= param1%10 +param2%10;
            param1=param1/10;
            param2=param2/10;
            if(temp<10) result=result+temp;
            else result=result+temp%10;
           
            
        }
         
        int k=Integer.parseInt(reverse(result)) ;
       
        return k;
         
    }
    public static String reverse(String input){
    char[] in = input.toCharArray();
        int temp=in.length-1;
        for(int i=0; i<=in.length-1;i++){
            in[i]=input.charAt(temp);
            temp--;
        }
        input=String.valueOf(in);
        return input;
    }
}