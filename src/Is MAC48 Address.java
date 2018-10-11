boolean isMAC48Address(String inputString) {
    String[] st = inputString.split("-");
    for (String s : st) {
        if (!isValid(s) || s.length() != 2) {
            return false;
        }
    }
    
    return inputString.length() - inputString.replace("-", "").length() == 5 && st.length == 6;
}

boolean isValid(String s) {
    for (int i=0;i<s.length();i++) {
        int ascii = (int)s.charAt(i);
        if(!((ascii>=48 && ascii <= 57) || (ascii>=65 && ascii<=70))) return false;
    }
    
    return true;
}
