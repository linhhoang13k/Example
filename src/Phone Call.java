iint phoneCall(int min1, int min2_10, int min11, int s) {
    if (s < min1) return 0;
    int mins = 0;
    
    mins++;
    s -= min1;
    
    while (mins < 10) {
        if (s - min2_10 < 0) return mins;
        s -= min2_10;
        mins++;
    }
    
    while (s >= 0) {
        if (s - min11 < 0) return mins;
        s -= min11;
        mins++;
    }
    
    return mins;
}
