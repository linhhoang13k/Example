/* Knowing whether a person is young, beautiful and loved, find out if they contradict Mary's belief.

A person contradicts Mary's belief if one of the following statements is true:

they are young and beautiful but not loved;
they are loved but not young or not beautiful.
Example

For young = true, beautiful = true and loved = true, the output should be
willYou(young, beautiful, loved) = false.

Young and beautiful people are loved according to Mary's belief.

For young = true, beautiful = false and loved = true, the output should be
willYou(young, beautiful, loved) = true.

Mary doesn't believe that not beautiful people can be loved. */

import java.io.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(willYou(true, false,true));
    }
    /**abstract
    they are young and beautiful but not loved;
    they are loved but not young or not beautiful.
    **/
    public static boolean willYou(boolean young, boolean beautiful, boolean loved) {
                if((young && beautiful && !loved) ||(loved && (!young || !beautiful))) return true;
                return false;
}
    
}
