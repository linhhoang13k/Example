/*
*author: @James Cain
*/
boolean checkPalindrome(String inputString) 
{
	//checks if a word remains unaltered when reversed
	
	//breaks input into an array of characters
    char[]array=inputString.toCharArray();
    int begin=0;
    int end=(inputString.length())-1;
    int mid=end+1/2;
	
	/*two markers, begin and end, swap values and iterate closer to the
	 *center of the array, until the swapped values are different(false)
	 *or they reach the center(true)
	 */ 
    while(begin<mid)
    {
        if(array[begin]!=array[end])
            return false;
        begin++;
        end--;
    }
    return true;
}