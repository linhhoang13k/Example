String decipher(String cipher) {
    String x = "" , t = "";
    for(int i = 0 ; i < cipher.length() ; i++){
        if(!t.equals("") 
           && Integer.parseInt(t) >= 97 && Integer.parseInt(t) <= 122){
            x += (char)(Integer.parseInt(t));
            i--;
            t = "";
        } 
        else
            t += cipher.charAt(i);
    }
    x += (char)(Integer.parseInt(t));
    return x;
}
