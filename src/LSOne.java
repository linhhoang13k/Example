import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {
  public static void main(String[] args) {
     System.out.println(LSOne(12));
    
    }
    
  public static int LSOne(int N){
    String bin ="";
    
    int aux = N;
    
    
    
    
    while(aux >= 2){
      int resto = 0;
      
      resto = aux%2;
      aux = aux/2;
      
      
      bin = Integer.toString(resto) + bin;
      
    }
    
    bin = Integer.toString(aux) + bin;
   
    
    int i;
    for(i = bin.length()-1; i >= 0; i--){
      if(bin.charAt(i) == '1'){
       return (int)Math.pow(2,Math.abs(bin.length()-1-i));
      
      }
    }
    return 0;
  }
  
  
}
