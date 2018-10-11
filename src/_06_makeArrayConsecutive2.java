package Arcade_Intro;

import java.util.Arrays;

public class _06_makeArrayConsecutive2 {
    int makeArrayConsecutive2(int[] statues) {
        Arrays.sort(statues);
        return statues[statues.length -1] - statues[0] - statues.length +1;
    }
}
