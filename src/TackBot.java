package CodeFight;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by tranpham on 3/13/18.
 */
public class TackBot {

    public Integer[] ratingThreshold(double threshold, int[][] ratings) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<ratings.length;i++){
            double avg=Arrays.stream(ratings[i]).sum()/(double)ratings[i].length;
            if (avg<threshold)
                res.add(i);
        }
        Integer[] r = new Integer[res.size()];
        return res.toArray(r);
    }

    String[][][] proCategorization(String[] pros, String[][] preferences) {
        HashMap<String,List<String>> hm = new HashMap<>();
        for(int i=0;i<pros.length;i++){
            String[] pref=preferences[i];
            for(String det:pref){
                if(!hm.containsKey(det)){
                    List<String> lst = new ArrayList<String>();
                    hm.put(det,lst);
                }
                List<String> proLst= hm.get(det);
                proLst.add(pros[i]);
            }
        }
        String[][][] res = new String[hm.size()][2][];
        int i=0;
        List<Map.Entry> lst= hm.entrySet().stream().sorted((o1,o2)->{
            return o1.getKey().compareTo(o2.getKey());
        }).collect(Collectors.toList());
        for(Map.Entry entry:lst){
            List<String> val = (List<String>)entry.getValue();
            Collections.sort(val);
            String key = (String)entry.getKey();
            res[i][1]= new String[val.size()];
            res[i][0]=new String[]{key};
            val.toArray(res[i][1]);
            i++;
        }
        return res;

    }

    public String addDigits(int a, int b, int n) {
        while(n-->0){
            int temp=a;
            int i=0;
            for(;i<=9;i++){
                temp=a*10+i;
                if(temp%b==0){
                    a=temp;
                    break;
                }
            }

            if(i==10)
                break;
        }
        return a+"";
    }
}
