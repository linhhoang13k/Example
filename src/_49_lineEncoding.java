package Arcade_Intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _49_lineEncoding {

    String lineEncoding(String s){
        Matcher m = Pattern.compile("([a-z])\\1*").matcher(s);
        StringBuilder sb = new StringBuilder();
        while(m.find()){
            int len = m.group(0).length();
            char cha = m.group(0).charAt(0);
            sb.append(len == 1 ? "" : len).append(cha);
        }
        return sb.toString();
    }

    String lineEncodingVeryHeavy(String s) {
        if(s.length() == 1) return s;

        ArrayList<Integer> breakPoints = new ArrayList<>();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) != s.charAt(i)) breakPoints.add(i);
        }


        ArrayList<String> sl = new ArrayList<>();
        int lastBreakPoint = 0;
        for(Integer bp : breakPoints){
           sl.add(s.substring(lastBreakPoint, bp));
           lastBreakPoint = bp;
        }
        sl.add(s.substring(lastBreakPoint));

        StringBuilder stringBuilder = new StringBuilder();
        for(String elem : sl){
            if(elem.length() == 1) stringBuilder.append(elem);
            else{
                stringBuilder.append(elem.length());
                stringBuilder.append(elem.charAt(0));
            }
        }

        return stringBuilder.toString();
    }
}
