/*
Ratiorg got statues of different sizes as a present from CodeMaster for his 
birthday, each statue having an non-negative integer size. Since he likes to 
make things perfect, he wants to arrange them from smallest to largest so 
that each statue will be bigger than the previous one exactly by 1. He may 
need some additional statues to be able to accomplish that. Help him figure 
out the minimum number of additional statues needed.

Guaranteed constraints
1 ≤ statues.length ≤ 10,
0 ≤ statues[i] ≤ 20.
*/

int makeArrayConsecutive2(int[] statues) {
    int[] statuesArray= statues.clone();
    int minStatueSize = 20;
    int maxStatueSize = 1;
    int additionalStatues = 0;
    int arrayLength = statuesArray.length;
    
    // Find lowest and highest statue value in the array
    for(int index = 0; index < arrayLength; index++){
        if(statuesArray[index] < minStatueSize){
            minStatueSize = statuesArray[index];
        }
        if(statuesArray[index] > maxStatueSize){
            maxStatueSize = statuesArray[index];
        }
    }
    additionalStatues = (maxStatueSize - minStatueSize) + 1 - arrayLength;
    return additionalStatues;
}


