package Arcade_Intro;

public class _53_validTime {
    boolean validTime(String time) {
        return time.matches("([0-1][0-9]:[0-5][0-9])|(2[0-3]:[0-5][0-9])");
    }
}
