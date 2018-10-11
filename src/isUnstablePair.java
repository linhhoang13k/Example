boolean isUnstablePair(String filename1, String filename2) {
    if(filename2.compareTo(filename1) > 0)
        return filename2.toUpperCase().compareTo(filename1.toUpperCase()) < 0;     
    else 
        return filename2.toLowerCase().compareTo(filename1.toLowerCase()) > 0;
}
