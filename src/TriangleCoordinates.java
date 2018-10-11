// https://codefights.com/challenge/TWwkcTmNh8S5QEWGo/solutions/RQ5Cxq4L4t6bYZ96u
double TriangleCoordinates(int[][] n) {
    double a = Math.sqrt(Math.pow(n[1][0] - n[0][0], 2) + Math.pow(n[1][1] - n[0][1], 2));
	double b = Math.sqrt(Math.pow(n[2][0] - n[1][0], 2) + Math.pow(n[2][1] - n[1][1], 2));
	double c = Math.sqrt(Math.pow(n[2][0] - n[0][0], 2) + Math.pow(n[2][1] - n[0][1], 2));
    double d = a + b + c;
	return Math.sqrt((d / 2) * (d / 2 - a) * (d / 2 - b) * (d / 2 - c));
}
