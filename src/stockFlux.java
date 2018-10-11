double stockFlux(double[] p) {
    double x = 100;
    for(var i:p)
        x *= 1+i/100;
    return x-100;
}
