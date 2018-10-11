int lateRide(int n) {
      
    int hour = n / 60;
    hour %= 24;
    int min = n %60;
    return hour %10 + hour/10 + min %10 + min /10;
}
