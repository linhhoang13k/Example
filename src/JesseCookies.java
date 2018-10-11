
/*
   Jesse loves cookies. He wants the sweetness of all his cookies to be greater than value . To do this, Jesse repeatedly mixes two cookies with the least sweetness. He creates a special combined cookie with:

sweetness  Least sweet cookie   2nd least sweet cookie).

He repeats this procedure until all the cookies in his collection have a sweetness . 
You are given Jesse's cookies. Print the number of operations required to give the cookies a sweetness . Print  if this isn't possible.

Input Format

The first line consists of integers , the number of cookies and , the minimum required sweetness, separated by a space. 
The next line contains  integers describing the array  where  is the sweetness of the  cookie in Jesse's collection.

Constraints

 
 

Output Format

Output the number of operations that are needed to increase the cookie's sweetness . 
Output  if this isn't possible.
*/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class JesseCookies {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        
        PriorityQueue<Integer> queue = new PriorityQueue();
        int countOperations = 0;
        for(int i=0; i<A.length; i++){
            queue.add(A[i]);
        }
        while(queue.size()>1 && queue.peek() < k){
            int leastSweet = queue.poll();
            int secondLeastSweet = queue.poll();
            
            int newSweetness = (1*leastSweet)+(2*secondLeastSweet);
            queue.add(newSweetness);
            countOperations++;
        }
        
        if(queue.peek()<k){
            return -1;
        }else{
            return countOperations;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
