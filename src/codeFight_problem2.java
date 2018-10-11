**/
You found two items in a treasure chest! The first item weighs weight1 and is worth value1, and the second item weighs weight2 and is worth value2. What is the total maximum value of the items you can take with you, assuming that your max weight capacity is maxW and you can't come back for the items later?

/**
int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
    int value=0;
    if(maxW>= (weight1+weight2)) return (value1 +value2);
    if(maxW>= weight1){
        
        value= value1;
    }
    if(maxW>= weight2 && value<value2){
        value= value2;
    }
    return value;
}