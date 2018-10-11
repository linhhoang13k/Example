int timedReading(int maxLength, String text) {
    int c = 0;
    for(int i = 0 ; i < text.length() ; i++){
        if((text.charAt(i) >= 'a' && text.charAt(i) <= 'z') || 
            (text.charAt(i) >= 'A' && text.charAt(i) <= 'Z')){
            String temp = "";
            for(int j = i ; j < text.length() ; j++){
                if((text.charAt(j) >= 'a' && text.charAt(j) <= 'z') || 
                    (text.charAt(j) >= 'A' && text.charAt(j) <= 'Z')){
                    temp += text.charAt(j);
                }
                else
                    break;
            }
            if(temp.length() <= maxLength)
                c++;
            i += temp.length();
        }
    }
    return c;
}
