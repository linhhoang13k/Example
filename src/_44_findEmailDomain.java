package Arcade_Intro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _44_findEmailDomain {
    String findEmailDomain(String address) {
       return  address.substring(address.lastIndexOf("@") +1);
    }
}
