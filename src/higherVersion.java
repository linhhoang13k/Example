boolean higherVersion(String ver1, String ver2) {
    String[] a = ver1.split("\\.");
    String[] b = ver2.split("\\.");
    
    for(int i = 0 ; i < a.length ; i++){
        if(Integer.parseInt(a[i]) > Integer.parseInt(b[i]))
            return true;
        if(Integer.parseInt(a[i]) < Integer.parseInt(b[i]))
            return false;
        else
            continue;
    }
    return false;
}
