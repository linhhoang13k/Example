package Arcade_Intro;

import java.util.ArrayList;

public class _57_fileNaming {
    String[] fileNaming(String[] names) {
        ArrayList<String> solution = new ArrayList<>();
        for(String elem: names){
            if(!solution.contains(elem)){
                solution.add(elem);
                continue;
            }
            String origElem = elem;
            int index = 1;
            while(solution.contains(elem)){
                elem = origElem + "(" + index + ")";
                index++;
            }
            solution.add(elem);
        }
        return solution.toArray(new String[solution.size()]);
    }
}
