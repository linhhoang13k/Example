int appleBoxes(int k) {
    int redApples = 0;
    int yellowApples = 0;
    int m = 1;
    
    while (m <= k) {
        if (m%2 == 0) {
            redApples += m*m;
        }
        else {
            yellowApples += m*m;
        }
        
        m++;
    }
    
    return redApples - yellowApples;
}
