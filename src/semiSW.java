double semiSW(double a) {
    double r = Math.sqrt(a / Math.PI) * 2;
    double perimeter = 2 * Math.PI * r + r*2;
    return (perimeter / 2) + (2/3 * r*2);
}
