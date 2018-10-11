int lateRide(int n) {
    int hours = n/60;
    int min = n%60;
    
    return hours/10 + hours%10 + min/10 + min%10;
}
