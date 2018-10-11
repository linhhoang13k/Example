package Arcade_Intro;

public class _21_isIPv4Address {
    boolean isIPv4Address(String inputString) {
       String[] splittedParts = inputString.split("[.]");
       if(splittedParts.length != 4) return false;
       for(String part : splittedParts){
           if(part.isEmpty()) return false;
           if(!part.matches("[0-9]{1,3}")) return false;
           if(!(Integer.parseInt(part) >= 0 && Integer.parseInt(part) <= 255)) return false;
       }
       return true;
    }
}
