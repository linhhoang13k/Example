boolean adaNumber(String line) {
    if(line.charAt(0) == '_' || line.charAt(line.length() - 2) == '_')
        return false;
    line = line.toLowerCase();
    line = line.replaceAll("_" , "");
    if(line.indexOf("#") == -1){
        for(int i = 0 ; i < line.length() ; i++){
            if(!(line.charAt(i) >= '0' && line.charAt(i) <= '9'))
                return false;
        }
        return true;
    }
    if(line.charAt(line.length() - 1) != '#')
        return false;
    String b = "0123456789abcdef";
    String[] x = line.split("#");
    if(x.length != 2 || x[0] == "" || x[1] == "")
        return false;
    if(Integer.parseInt(x[0]) < 2 || Integer.parseInt(x[0]) > 16)
        return false;
    String base = b.substring(0 , Integer.parseInt(x[0]));
    for(int i = 0 ; i < x[1].length() ; i++){
        if(base.indexOf(x[1].charAt(i)) == -1)
            return false;
    }
    return true;
}
