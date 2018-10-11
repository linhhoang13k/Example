package Arcade_Core;

public class _009_reachnextlevel {
    boolean reachNextLevel(int experience, int threshold, int reward) {
        return experience + reward >= threshold;
    }
}
