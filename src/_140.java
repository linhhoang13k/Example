package me.cwuyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XIA on 2017/7/8.
 */
public class _140 {
    private List<String> list;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordBreakHelper(s, wordDict, new HashMap<>());


        return null;
    }

    private List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> map) {

        List<String> res = new ArrayList<>();

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = wordBreakHelper(s.substring(word.length()), wordDict, map);
                for (String sub : subList) {

                }
            }
        }



    }

}
