/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missingpermutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author epiercy
 */
public class MissingPermutations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] s = {"abcd", "dbac"};
        String[] s2 = missingPermutations(s);
        for(String a : s2)
            System.out.println(a);
    }
    
    public static String[] missingPermutations(String[] pL) {
        String s = pL[0];
        ArrayList<String> p = pP(s);
        String[] sn = cD(pL, p);
        Arrays.sort(sn);
        return sn;
    }
    public static String[] cD(String[] p, ArrayList<String> as){
        for(int i = 0; i < p.length; i++){
            Iterator asi = as.iterator();
            while(asi.hasNext()){
                if(asi.next().equals(p[i]))
                    asi.remove();
            }
        }
        String[] sa = new String[as.size()];
        sa = as.toArray(sa);
        return sa;
    }
    public static ArrayList<String> pP(String s){
        ArrayList<String> aL = new ArrayList<String>();
        if (s == null) {
            return null;
        }
        else if (s.length() == 0) {
            aL.add("");
            return aL;
        }
        else {
            for (int i = 0; i < s.length(); i++) {
                ArrayList<String> remaining = pP(s.substring(0, i) + s.substring(i + 1));
                for (int j = 0; j < remaining.size(); j++) {
                    aL.add(s.charAt(i) + remaining.get(j));
                }
            }
            return aL;
        }
    }
    
}
