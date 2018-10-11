/*absoluteValueSumMinimization.java
 *codefights
 *Arcade
 *Introduction
 *Through the Fog
 *#32
 *Created by Ian Feekes December 6th 2017
 */

int absoluteValuesSumMinimization(int[] a) 
{
    int min = 1500000000;
    int valHolder = 0;
    for(int i=0;i<a.length;i++)
    {
        int temp=0; 
        for(int j=0;j<a.length;j++)
        {
            temp+=Math.abs(a[j]-a[i]);
        }
        System.out.println("total formula with x val of "+a[i]+" is "+temp+" with min of "+min);
        if(temp<min)
        {
            min=temp;
            valHolder = i; 
        }
    }
    return a[valHolder];
}


