String stolenLunch(String note) {
    String x = "";
    for(int i = 0 ; i < note.length() ; i++){
        if(note.charAt(i) <= 'j' && note.charAt(i) >= 'a')
            x += (note.charAt(i) - 'a') + "";
        else if(note.charAt(i) >= '0' && note.charAt(i) <= '9')
            x += (char)(note.charAt(i) - '0' + 97);
        else
            x += note.charAt(i);
    }
    return x;
}
