/*isInfiniteProcess?.java
 *created by Ian Feekes December 7th 2017
 *Codefights
 *The Core
 *At The Crossroads
 *#12
 */

boolean isInfiniteProcess(int a, int b) 
{
    if((a>b)||((a!=b)&&(a%2!=b%2)))return true;
    return false; 
}


