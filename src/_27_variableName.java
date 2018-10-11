package Arcade_Intro;

import java.util.regex.Pattern;

public class _27_variableName {
    boolean variableName(String name) {
        return Pattern.compile("^[a-zA-z_][\\w\\d]*$").matcher(name).matches();
    }
}
