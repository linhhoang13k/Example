package interviewpractice.DFSAndBFS;

import interviewpractice.trees.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author benmakusha
 */
public class TreeDigitSum {

    long digitTreeSum(Tree<Integer> t) {
        List<List<Integer>> list = new ArrayList<>();
        sumUpPath(t, list, new ArrayList<>());
        long result =0;
        for(List<Integer> sub : list){
            StringBuilder num = new StringBuilder();
            for(int i : sub){
                num.append(i);
            }
            result = result + Long.parseLong(num.toString());
        }
        return result;
    }

    void sumUpPath(Tree<Integer> t, List<List<Integer>> list, List<Integer> listTemp){
        if(t == null) return;
        listTemp.add(t.value);
        if(t.left == null && t.right == null){
            list.add(new ArrayList<>(listTemp));
        }
        sumUpPath(t.left, list, listTemp);
        sumUpPath(t.right, list, listTemp);
        listTemp.remove(listTemp.size() - 1);
    }

}
