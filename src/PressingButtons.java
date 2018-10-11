package interviewpractice.counting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author benmakusha
 */
public class PressingButtons {

    String[] pressingButtons(String buttons) {
        if(buttons.isEmpty())
            return new String[0];
        String [] map = new String[]{"_", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        char [] result = new char[buttons.length()];
        List<String> combs = new ArrayList();
        doPress(buttons, map, result, combs, 0);
        return combs.toArray(new String[0]);
    }

    void doPress(String buttons, String [] map, char [] result, List<String> resultList, int level){
        if(level == result.length){
            resultList.add(new String(result));
            return;
        }
        for(char ch : map[buttons.charAt(level) - '1'].toCharArray()){
            result[level] = ch;
            doPress(buttons, map, result, resultList, level + 1);
        }
    }
}
