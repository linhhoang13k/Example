public static boolean almostIncreasingSequence( int[] array )
{
    boolean hasIncreasingSequenceNature = false;
    for( int x = 0; x < array.length; x++ )
    {
        boolean almostIncreasingWithRemovedElement = assumeRemovedElement(x , array);
        System.out.println( "Removing " + array[x] + " would produce INCREASING SEQUENCE?: " + almostIncreasingWithRemovedElement);
        if( almostIncreasingWithRemovedElement )
        {
            hasIncreasingSequenceNature = true;
        }               
    }
    return hasIncreasingSequenceNature;
}

public static boolean assumeRemovedElement( int assumeRemovedIndex , int[] data )
{
    boolean isIncreasing = false;
    for( int x = 0; x < data.length - 1; x++ )
    {
        if( x == ( assumeRemovedIndex - 1 ) )
        {
            if( (x < data.length - 2 ) )
            {
                if( data[x] < data[x + 2] )
                {
                    isIncreasing = true;
                }
                else
                {
                    isIncreasing = false;
                    break;
                }
            }
        }
        else if( x != assumeRemovedIndex )
        {
            if( data[x] < data[x + 1] )
            {
                isIncreasing = true;
            }
            else
            {
                isIncreasing = false;
                break;
            }               
        }
    }
    return isIncreasing;
}