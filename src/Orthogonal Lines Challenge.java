/*

Two lines ax + by + c = 0 and a'x + b'y + c' = 0 are orthogonal if and only if
a * a' + b * b' = 0.

Check if the two given lines are orthogonal.

Example

For line1 = [1, -1, 0] and line2 = [1, 1, 0], the output should be
ortogonalLines(line1, line2) = true.

Check out the image below for better understanding:
*/

boolean ortogonalLines(int[] line1, int[] line2) {

    int sum=0;
    for(int i =0; i<line1.length-1; i++)
    {
        sum += line1[i] * line2[i];
    }
    if (sum ==0 )
    {
        return true;
    }
    else
    {
        return false;
    }
}
