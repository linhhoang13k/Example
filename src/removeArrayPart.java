/* 
Remove Array Part

Description:

Remove a part of a given array between given 0-based indexes l and r(inclusive).

Example

For inputArray = [2, 3, 2, 3, 4, 5], l = 2 and r = 4, the output should be
removeArrayPart(inputArray, l, r) = [2, 3, 5].

*/
import java.util.ArrayList;
import java.io.*;
 import java.util.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
       int[] a = {2, 3, 2, 3, 4, 5};
        
        int[] arr=removeArrayPart(a,2,4);
        for(int i=0; i< arr.length; i++){
        System.out.print(arr[i]+" ");
        }
    }
    public static int[] removeArrayPart(int[] inputArray, int l, int r) {
       
        List<Integer> result = new ArrayList<Integer>();
      
    for(int index=0;index<Math.min(l,r);index++) {
        result.add(inputArray[index]);
    }
   for(int index=Math.max(l,r)+1;index<inputArray.length;index++) {
        result.add(inputArray[index]);
    }
        
        int[] temp= new int[result.size()];
        for(int i=0; i<result.size();i++){
            temp[i]=result.get(i);
            
        }
    
    
    return temp;
}
    
}