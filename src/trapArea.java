int trapArea(int n, double p, double r) {
    return (int)Math.round(n*r*r*Math.sin(2*Math.PI/n)/2 - p*p/4/n/Math.tan(Math.PI/n));
}
