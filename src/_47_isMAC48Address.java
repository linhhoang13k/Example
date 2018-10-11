package Arcade_Intro;

public class _47_isMAC48Address {
    boolean isMAC48Address(String inputString) {
        return inputString.matches("^(([\\dA-F]){2}-){5}([\\dA-F]){2}");
    }

}
