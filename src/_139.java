package me.cwuyi;

import java.util.List;

/**
 * Created by XIA on 2017/7/8.
 */
public class _139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[]  res = new boolean[s.length()+1];
        res[0] = true;

        for (int i = 1; i <=s.length(); i++) {
            res[i] = false;
            for (int j = 0; j < i; j++) {
                if (res[j] && wordDict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
}
