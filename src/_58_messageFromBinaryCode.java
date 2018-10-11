package Arcade_Intro;

import java.util.ArrayList;

public class _58_messageFromBinaryCode {
    String messageFromBinaryCode(String code) {
        StringBuilder sb = new StringBuilder();
        for(int i = 8; i <= code.length(); i += 8) {
            sb.append((char)Integer.parseInt(code.substring(i-8,i),2));
        }
        return sb.toString();
    }
}
