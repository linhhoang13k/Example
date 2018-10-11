package com.paigeruppel.codefights.challenges;

import java.util.HashMap;
import java.util.Map;

public class PersonLocation {

    /*
    * A person is moving along a straight line. Initially he is at point A.
    * He goes to point B from A with speed equal to 1 meter per second.
    * Immediately after reaching B he turns around and heads to A from B with the same speed.
    * After reaching point A he turns around once again and heads to B. etc.
    * We need an algorithm that identifies the location of the person at any given moment in time.
    * It's guaranteed that A and B are two different points.
    */

    public int toAndFro(int a, int b, int t) {
        int d = a - b;
        int p = ((t / d) % 2 == 0 ) ? a: b;
        int r = (p == a || a > b )? t % d : -(t % d);
        return p + r;
    }

}
