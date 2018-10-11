/*
You are given an array of desired filenames in the order of their creation. Since two files cannot have equal names, the one which comes later will have an addition to its name in a form of (k), where k is the smallest positive integer such that the obtained name is not used yet.

Return an array of names that will be given to the files.

Example

For names = ["doc", "doc", "image", "doc(1)", "doc"], the output should be
fileNaming(names) = ["doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"].

Input/Output

    [execution time limit] 3 seconds (java)

    [input] array.string names

    Guaranteed constraints:
    5 ≤ names.length ≤ 15,
    1 ≤ names[i].length ≤ 15.

    [output] array.string
*/

String[] fileNaming(String[] names) {
    
    String[] files = names.clone();
    int fileNum = files.length;
    int copyIndex = 0;
    
    // For every file
    for(int fileIndex = 1; fileIndex < fileNum; fileIndex++){
        String defaultValue = files[fileIndex];
        
        // Check the previous names
        for(int checkIndex = 0; checkIndex < fileIndex; checkIndex++){
            if(files[fileIndex].equals(files[checkIndex])){
                copyIndex++;
                files[fileIndex] = defaultValue + "(" + Integer.toString(copyIndex)+ ")";
                checkIndex = -1;
            }
        }
        
        copyIndex = 0;
    }
    
    return files;
}
