/*Define an n-interesting polygon
1<= n <= 10^4
input -> integer n
output -> the area of the n-interesting polygon
*/

int shapeArea(int n) {
    int squareNumber = (n*n) + (n-1)*(n-1);
    return squareNumber;
}