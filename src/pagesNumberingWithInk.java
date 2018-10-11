int pagesNumberingWithInk(int current, int numberOfDigits) {
    while(numberOfDigits >= 0){
        int temp = current;
        int chars = 0;
        while(temp > 0){
            temp /= 10;
            chars++;
        }
        if(numberOfDigits - chars >= 0){
            numberOfDigits -= chars;
            current++;
        }
        else
            break;
    }
    return current-1;
}
