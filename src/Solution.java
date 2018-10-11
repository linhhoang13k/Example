package test;
import java.util.HashMap;
import java.util.Map;
// you can also use imports, for example:
// import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
 public boolean solution(int[] A) {
     // write your code in Java SE 8
     int dscIndex = 0;
     int ascIndex = 1;
  if (! isAsendingOrder(A)){
      for (int k = 0 ;k <A.length-1 ; k++)
      {
          if (A[k] > A[k+1])
          {
              dscIndex = k;
              break;
          }
      }
      
      for (int l = dscIndex ;l <A.length-1 ; l++)
      {
          if ( A[l] < A[l+1])
          {
              ascIndex = l;
              break;
          }
      }
      
    
      
      int temp = A[dscIndex];
      A[dscIndex] = A[ascIndex];
      A[ascIndex] = temp;
      
      return isAsendingOrder(A);
      
  }
  
  return true;
 }
 
 private boolean isAsendingOrder(int a[])
  {
      for (int i = 0 ; i<a.length ; i++){
          for (int j=i+1 ; j<a.length ; j++)
          {
              if (a[i] > a[j] )
              return false;
          }
      }
      return true;
  }
}