String cipher26(String message) {
    String d = "" + message.charAt(0);
    int s = message.charAt(0) - 'a';
    for(int i = 1 ;  i < message.length() ; i++){
        for(int j = 0 ; j < 26 ; j++){
            if((s + j) % 26 == message.charAt(i) - 'a'){
                s = message.charAt(i) - 'a';
                d += (char)(j + 'a');
                break;
            }
        }
    }
    return d;
}
