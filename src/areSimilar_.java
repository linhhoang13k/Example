/*areSimilar?.java
 *codefights
 *Arcade
 *Introduction
 *Exploring the Waters
 *#16
 *Created by Ian Feekes December 6th 2017
 */

boolean areSimilar(int[] a, int[] b)
{
    boolean flag = false; 
    for(int i=0;i<a.length;i++)
    {
        if(a[i]!=b[i])
        {
            if(flag)
            {
                System.out.println("Returning false because of flag");
                return false; 
            }
            flag = true; 
            for(int j=i+1;j<a.length;j++)
            {
                if(a[j]!=b[j])
                {
                    int temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                    if(a[i]!=b[i]) 
                {
                    System.out.println("Returning false beccause post swap doesn't line up. a[i], b[i] "+a[i]+" "+b[i]);
                    for(int k=0;k<a.length;k++)
                    {
                        System.out.print(a[k]+" ");
                    }
                    return false; 
                }
                }
                
            }
        }
    }
    /*
    for(int i=0;i<a.length;i++)
    {
        System.out.print(a[i]+" ");
    }
    System.out.println();
    for(int i=0;i<a.length;i++)
    {
        System.out.print(b[i]+" ");
    }
    */
    return true; 
}


