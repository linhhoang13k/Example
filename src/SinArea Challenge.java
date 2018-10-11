/*
You guys should probably know the simple y = sin(x) equation.

Given a range of x [start, end], your mission is to calculate the total signed area of the region in the xy-plane that is bounded by the sin(x) plot, the x-axis and the vertical lines x = start and x = end. The area above the x-asix should be added to the result, and the area below it should be subtracted.

Example

For start = 0 and end = 10, the output should be
sinArea(start, end) = 1.83907.



For start = 4 and end = 6, the output should be
sinArea(start, end) = -1.61381.


*/

double sinArea(int s, int e) {

   
    return Math.cos(s) - Math.cos(e);
}

/*reference http://www.mathwords.com/a/area_under_a_curve.htmd