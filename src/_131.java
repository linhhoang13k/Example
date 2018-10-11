package me.cwuyi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XIA on 2017/7/5.
 */
public class _131 {
    private List<List<String>> resList;
    private List<String> nowList;
    public List<List<String>> partition(String s) {
        resList = new ArrayList<>();
        nowList = new ArrayList<>();



        return null;
    }

    private void partitionHelper(String s, int from) {
        for (int i = from; i < s.length(); i++) {
            partitionHelper(s, i);
        }




    }

    private boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }


}
