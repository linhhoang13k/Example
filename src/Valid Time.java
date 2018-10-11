boolean validTime(String time) {
    String[] strs = time.split(":");
    
    int hour = Integer.parseInt(strs[0]);
    int min = Integer.parseInt(strs[1]);
    
    return hour >= 0 && hour < 24 && min >= 0 && min < 60;
}
