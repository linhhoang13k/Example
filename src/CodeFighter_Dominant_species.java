/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefighter_dominant_species;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author raliclo
 */
public class CodeFighter_Dominant_species {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] A;
        int[] A2 = {1, 2, 1, 3, 3, 1, 0, 1, 1, 9, 1};
        int[] A3 = {45, 17, 80, 14, 17, 60, 17, 17, 21, 17, 18, 17, 17};
        int n = 20;
        A = new int[n];
        int i = 0;
        for (int a : A) {
            a = (int) (n * Math.random());
            A[i] = a;
            i++;
            System.out.print(a + " ");
        }
        System.out.println();
        long speedX = System.currentTimeMillis();
        System.out.println("The dominant species is ->" + Dominant_species(A3));
        System.out.println("Time spent :" + (System.currentTimeMillis() - speedX));

        long speedX2 = System.currentTimeMillis();
        System.out.println("The dominant species is ->" + Dominant_species2(A3));
        System.out.println("Time spent :" + (System.currentTimeMillis() - speedX2));
    }

    //##Method-1 Using Object for comparable / comparator
    public static int Dominant_species(int[] A) {
        class H implements Comparable, Comparator {

            int K, V;

            public int compareTo(Object o) {
                return this.compare(this, (Object) o);
            }

            public int compare(Object o1, Object o2) {
                if (((H) o1).K == ((H) o2).K) {
                    return 0;
                }
                return ((H) o1).K > ((H) o2).K ? 1 : -1;
            }

        }
        // Mapping
        ArrayList<H> a = new ArrayList();
        int i, j;
        for (i = 0; i < A.length; i++) {
            H b = new H();
            b.K = A[i]; // keyw
            b.V = 1;//value}
            a.add(b);
        }
//         Sorting
        a.sort(null);
//        for (H h1 : a) {
//            System.out.print(h1.K + ":" + h1.V + " ");
//        }
//        System.out.println();
        // Combining
        for (i = 0; i < a.size() - 1; i++) {
            for (j = 0; j < a.size(); j++) {
                if (a.get(i).K == a.get(j).K) {
                    H tmp = a.get(i);
                    tmp.V += 1;
                    a.set(i, tmp);
                    a.remove(i + 1);
                }
            }
        }
        // FindMax
        int max = 0, maxK = 0;
//        int maxI;
        for (i = 0; i < a.size(); i++) {
            if (max < a.get(i).V) {
                max = a.get(i).V;
                maxK = a.get(i).K;
//                maxI = i;
            }
        }
        for (H h1 : a) {
            System.out.print(h1.K + ":" + h1.V + " ");
        }
        return maxK;
    }
    //##Method-1 Using HashMap
    // HashMap solution. -- Simplified code

    public static int Dominant_species2(int[] A) {
        int i;
        HashMap<Integer, Integer> a = new HashMap();
        for (i = 0; i < A.length; i++) {
            a.put(A[i], 0);
        }
//        System.out.println(a.toString() + ":Initialized.");
        int c;
        for (Map.Entry<Integer, Integer> e1 : a.entrySet()) {
            c = 0;
            for (i = 0; i < A.length; i++) {
                if (e1.getKey() == A[i]) {
                    c++;
                    e1.setValue(c);
                }
            }
        }
        System.out.println(a.toString() + ":SetValues Done.");
        int[] V = new int[a.size()];
        int[] K = new int[a.size()];
        int mxV = 0, mxI = 0;
        i = 0;
        for (Map.Entry<Integer, Integer> e2 : a.entrySet()) {
            V[i] = e2.getValue();
            K[i] = e2.getKey();
            if (mxV < V[i]) {
                mxV = V[i];
                mxI = i;
            }
            i++;
        }
        return K[mxI];
    }

    // HashMap solution. -- Raw codes
    public static int Dominant_species3(int[] A) {

        int i;
        // Initial Keys in HashMap
        HashMap<Integer, Integer> a = new HashMap();

        for (i = 0; i < A.length; i++) {
            a.put(A[i], 0);
        }
        System.out.println(a.toString() + ":Initialized.");

        // Set Key-Values pairs in HashMap
        //#0 Interator         Iterator<Map.Entry<Integer, Integer>> iH = a.entrySet().iterator();
        //#0 Iterator    Map.Entry<Integer, Integer> e;
        int count;
        //#1 Iterator       for (e = iH.next();; e = iH.next()) {
        //#2 Iterator      while (iH.hasNext()) {
        for (Map.Entry<Integer, Integer> e1 : a.entrySet()) {
//            e = iH.next();
            count = 0;
//            System.out.println("Begin K :" + e.getKey() + "V :" + e.getValue());
            for (i = 0; i < A.length; i++) {
//                System.out.print(e.getKey() + "=" + A[i] + "?");
                if (e1.getKey() == A[i]) {
                    count++;
                    e1.setValue(count);
                }
//                System.out.println("End K :" + e.getKey() + "V :" + e.getValue());
            }
            //if (!iH.hasNext()) {break; } // if we use forloop
        }

//        System.out.println(a.toString() + ":SetValues Done.");
        // Find MAX
        //#0 Interator            iH = a.entrySet().iterator();
        int[] mapV = new int[a.size()];
        int[] mapK = new int[a.size()];
        int maxV = 0, maxI = 0;
        i = 0;
        for (Map.Entry<Integer, Integer> e2 : a.entrySet()) {
            mapV[i] = e2.getValue();
            mapK[i] = e2.getKey();
            if (maxV < mapV[i]) {
                maxV = mapV[i];
                maxI = i;
            }
            i++;
        }
        return mapK[maxI];
    }
}


/*
There are a lot of species on planet Tazenda, and we know there is a dominant one.
The dominant species constitute more than half of the total living creatures on the planet.
You know that each species has a unique integer number, their ID.
Each creature has the ID of the species it belongs to.
So, tell me, what ID the dominant species have?

Example:

Dominant_species([1,2,1,3,3,1,0,1,1,9,1]) = 1

[input] array.integer A

The "species number" of each creature on the planet.
[output] integer

The dominant species number.
 */
