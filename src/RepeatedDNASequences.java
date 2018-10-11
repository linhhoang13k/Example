package interviewpractice.commonTechniquesAdvanced;

import java.util.*;

/**
 * @author benmakusha
 */
public class RepeatedDNASequences {

    String[] repeatedDNASequences(String s) {
        ArrayList<String> tempResult = new ArrayList<>();
        if (s.length() < 10){
            return new String[]{};
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> temp = new HashSet<>();
        Set<Integer> added = new HashSet<>();
        int hash = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < 9) {
                hash = (hash << 2) + map.get(s.charAt(i));
            } else {
                hash = (hash << 2) + map.get(s.charAt(i));

                hash = hash & (1 << 20) - 1;

                if (temp.contains(hash) && !added.contains(hash)){
                    tempResult.add(s.substring(i - 9, i + 1));
                    added.add(hash);
                } else {
                    temp.add(hash);
                }
            }
        }

        String[] result = tempResult.toArray(new String[tempResult.size()]);
        Arrays.sort(result);

        return result;
    }

}
