package codeFightSmallProblems;

public class RectangleIntersection {

	int rectanglesIntersection(int[] a, int[] b, int[] c, int[] d) {

	     int intersection[]=new int[2];
	     for (int i = 0; i < 2; i++) {
		        if (a[i] > b[i]) {
		            int t = a[i];
		            a[i] = b[i];
		            b[i] = t;
		        }
		        if (c[i] > d[i]) {
		            int t = c[i];
		            c[i] = d[i];
		            d[i] = t;
		        }
		        if (b[i] < c[i] || d[i] < a[i]) {
		            return 0;
		        }
		        intersection[i]=Math.min(b[i], d[i]) - Math.max(a[i], c[i]);
		    }
		    return intersection[0] * intersection[1];
	}

}
