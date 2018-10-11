/*
Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to rearrange the people by their heights in a non-descending order without moving the trees.

Example

For a = [-1, 150, 190, 170, -1, -1, 160, 180], the output should be
sortByHeight(a) = [-1, 150, 160, 170, -1, -1, 180, 190].

Input/Output

    [time limit] 3000ms (java)

    [input] array.integer a

    If a[i] = -1, then the ith position is occupied by a tree. Otherwise a[i] is the height of a person standing in the ith position.

    Guaranteed constraints:
    5 ≤ a.length ≤ 15,
    -1 ≤ a[i] ≤ 200.

    [output] array.integer

    Sorted array a with all the trees untouched.
*/

int[] sortByHeight(int[] a) {
    
    int[] peopleAndTrees = a.clone();
    ArrayList<Integer> peopleList = new ArrayList<Integer>();
    // Insert the non-tree elements into an array list
    for(int element = 0; element < peopleAndTrees.length; element++){
        if(peopleAndTrees[element] > -1){
            peopleList.add(peopleAndTrees[element]);
            continue;
        }
    }

    // Sort the array list into a new array
    Integer[] peopleArray = peopleList.stream().toArray(Integer[]::new);
    Arrays.sort(peopleArray);

    // Put the sorted array back to the old one
    int peopleCount = 0;
    for(int element = 0; element < peopleAndTrees.length; element++){
        if(peopleAndTrees[element] > -1){
            peopleAndTrees[element] = peopleArray[peopleCount];
            peopleCount++;
        }
    }
    
    return peopleAndTrees;
}
