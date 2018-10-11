boolean checkPalindrome(String inputString) {
    if (inputString.length() == 1)
        return true;
    int index_min = 0;
    int index_max = inputString.length() - 1;
    char inputArray[] = inputString.toCharArray();
    
    boolean result = false;
    while (index_min <= index_max)
    {
        if(inputArray[index_min] == inputArray[index_max])
        {
            result = true;
            index_min++;
            index_max--;
        }
        else
        {
            result = false;    
            break;
        }
            
    }
        return result;
}