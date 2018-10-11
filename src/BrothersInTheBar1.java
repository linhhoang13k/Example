package tiendm.codefight.challenge.july;

import java.util.ArrayList;

public class BrothersInTheBar1 {
	int brothersInTheBar(int[] a) {
        ArrayList<Integer> list = toArrays(a);
        return check(list);
    }
    
    ArrayList<Integer> toArrays(int[] a){
        ArrayList<Integer> ls = new ArrayList<>();
        for(int x : a){
            ls.add(x);
        }
        return ls;
    }

    private int check(ArrayList<Integer> a) {
        if(a.size() < 3) return 0;
        if(a.size() == 3) {
            if(a.get(0).equals(a.get(1)) && a.get(1).equals(a.get(2))){
                return 1;
            }
            return 0;
        }
        ArrayList<Integer> aNew = new ArrayList<>();
        for(int i = 0; i < a.size()-2; i++){
            if(a.get(i).equals(a.get(i+1)) && a.get(i+1).equals(a.get(i+2))){
                for(int j = i+3; j < a.size(); j++){
                    aNew.add(a.get(j));
                }
                return 1 + check(aNew);
            }else{
                aNew.add(a.get(i));
            }
        }
        return 0;
    }
}
