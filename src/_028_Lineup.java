package Arcade_Core;

public class _028_Lineup {
    int lineUp(String commands) {
        int counter = 0;
        boolean inSync = true;
        for(char c : commands.toCharArray()){
            if (c != 'A')
                inSync = !inSync;
            if(inSync)
                counter++;
        }
        return counter;
    }
}
