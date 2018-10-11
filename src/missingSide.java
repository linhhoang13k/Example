// https://codefights.com/challenge/TAArsiSECsw4NeG87/solutions/fr4RGxnHr87tNPpYH
int missingSide(int x, int y, int a) {
    return (int) Math.sqrt(x * x + y * y - (2 * x * y * Math.cos(Math.toRadians(Math.toDegrees(Math.asin(a / (0.5 * x * y)))))));

}
