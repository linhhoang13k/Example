package arcade.nestedLoops;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by JavierSainz on 11/3/16.
 */
public class RectanguleRotation {

    class Rectangle {
        int width;
        int height;
        Coordinate a;
        Coordinate b;
        Coordinate c;
        Coordinate d;
    }

    class Coordinate {
        double x;
        double y;

        Coordinate() {

        }

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Coordinate center = new Coordinate(0, 0);
    double theta = Math.PI / 4;

    int rectangleRotation(int a, int b) {
        int maxDimension = (int) (Math.max(a, b) * 1.44);
        Rectangle r = calculateRectangle(a, b);
        int count = 0;
        for (int x = 0 - maxDimension; x <= maxDimension; x++) {
            for (int y = 0 - maxDimension; y <= maxDimension; y++) {
                if (isCoordinateInsideRectangle(r, new Coordinate(x, y))) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean isCoordinateInsideRectangle(Rectangle r, Coordinate p) {
        //Let P(x,y)P(x,y), and rectangle A(x1,y1),B(x2,y2),C(x3,y3),D(x4,y4)
        //sum areas △APD,△DPC,△CPB,△PBA
        double sum = calculateTriangleArea(r.a, p, r.d);
        sum += calculateTriangleArea(r.d, p, r.c);
        sum += calculateTriangleArea(r.c, p, r.b);
        sum += calculateTriangleArea(p, r.b, r.a);
        /*
        If this sum is greater than the area of the rectangle, then P(x,y)P(x,y) is outside the rectangle.
        Else if this sum is equal to the area of the rectangle (observe that this sum can not be less than the later),
            if area of any of the triangle is 00, then P(x,y)P(x,y) is on the rectangle (in fact on that line corresponding to the triangle of area=0=0). Observe that the equality of the sum is necessary, only area=0=0 is not sufficient),
            else P(x,y)P(x,y) is is inside the rectangle.
         */
        //because double precision, Can use BigDecimal instead
        sum = new BigDecimal(sum).setScale(5, RoundingMode.HALF_UP).doubleValue();
        double rectangleArea = r.height * r.width;
        if (sum == rectangleArea) {
            System.out.println(p.x + "," + p.y);
            return true;
        }
        return false;
    }

    double calculateTriangleArea(Coordinate a, Coordinate b, Coordinate c) {
        //area=(Ax(By−Cy)+Bx(Cy−Ay)+Cx(Ay−By)) / 2
        return Math.abs(((a.x * (b.y - c.y)) + (b.x * (c.y - a.y)) + (c.x * (a.y - b.y))) / 2);
    }

    Rectangle calculateRectangle(int a, int b) {
        Rectangle r = calculateOriginalRectangle(a, b);
        rotateRectangle(r);
        return r;
    }

    void rotateRectangle(Rectangle r) {
        rotateCoordinate(r.a, center, theta);
        rotateCoordinate(r.b, center, theta);
        rotateCoordinate(r.c, center, theta);
        rotateCoordinate(r.d, center, theta);
    }

    void rotateCoordinate(Coordinate coordinate, Coordinate center, double degrees) {
        //X = x*cos(θ) - y*sin(θ)
        //Y = x*sin(θ) + y*cos(θ)

        // cx, cy - center of square coordinates
        // x, y - coordinates of a corner point of the square
        // theta is the angle of rotation

        //this step can be avoided because the center is 0
        // translate point to origin
        double tempX = coordinate.x - center.x;
        double tempY = coordinate.y - center.y;

        // now apply rotation
        double rotatedX = tempX * Math.cos(degrees) - tempY * Math.sin(degrees);
        double rotatedY = tempX * Math.sin(degrees) + tempY * Math.cos(degrees);

        // translate back
        //this step can be avoided because the center is 0
        coordinate.x = rotatedX + center.x;
        coordinate.y = rotatedY + center.y;
    }

    Rectangle calculateOriginalRectangle(int a, int b) {
        Rectangle original = new Rectangle();
        original.width = a;
        original.height = b;
        original.a = new Coordinate(-a / 2, b / 2);
        original.b = new Coordinate(a / 2, b / 2);
        original.c = new Coordinate(a / 2, -b / 2);
        original.d = new Coordinate(-a / 2, -b / 2);
        return original;
    }

    public static void main(String[] args) {
        System.out.println(new RectanguleRotation().rectangleRotation(8, 6));
    }

}
