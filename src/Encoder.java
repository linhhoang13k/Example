package exercise49;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Encoder {

	public String lineEncoding(String s) {
	    Matcher m = Pattern.compile("([a-z])\\1*").matcher(s);
	    String result = "";
	    while(m.find()){
	        int len = m.group(0).length();
	        char cha = m.group(0).charAt(0);
	        result += (len==1?"":len) + "" + cha;
	    }
	    return result;
	}

}
