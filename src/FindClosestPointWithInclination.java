/*

Consider a slider that has several integer points sorted in ascending order. A user can drag the control (a button) to a specific point to choose the desired value.

If the control is dropped between the points, it should automatically move to the value that is immediately before or after its current position. The control should move all the way towards the next value if it has covered at least threshold distance to it from the previous integer point, or jump back to the previous integer if the covered distance is less than the threshold.

Given the lastPoint of the control that allows you to determine its direction, the value of the threshold and the final inputPosition of the control, return the point on the slider that the control should jump to.

Example

For lastPoint = 5, threshold = 0.3 and inputPosition = 2.4,
the output should be
FindClosestPointWithInclination(lastPoint, threshold, inputPosition) = 2.

The control was dragged to the left and has covered the distance from 3 to 2 equal to 0.6, which is greater than 0.3. Thus, it should move all the way to 2.
*/

int FindClosestPointWithInclination(int lastPoint, double threshold, double inputPosition) {
   
    String dest = "";
    double diff=inputPosition - (double)lastPoint;
        
    if(diff>=0.0)
    {
        dest="right";
        if((double)( inputPosition -(int)(inputPosition) ) +0.00000001  < threshold)
        {
            return (int)inputPosition;
        }
        else
        {
            return (int)(inputPosition+1);
        }
    }
    else
    {
       dest="left";
        if((double)( (int)(inputPosition)+1 - inputPosition ) +0.00000001  < threshold)
        {
            return (int)inputPosition+1;
        }
        else
        {
            return (int)(inputPosition);
        } 
    }
   
}
