/*
n children have got m pieces of candy. They want to eat as much candy as they can, but each child must eat exactly the same amount of candy as any other child.
 Determine how many pieces of candy will be eaten by all the children together. Individual pieces of candy cannot be split.
*/
int candies(int n, int m) 
{
    //formula (m/n) * n remove all decimal places
    // no need for rounding up etc
return (int)Math.floor(m/n) * n;
}
    