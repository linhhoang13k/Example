package Arcade_Intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class _33_stringsRearrangement {
    boolean stringsRearrangement(String[] inputArray) {
        ArrayList<String> originalList = new ArrayList<String>(Arrays.asList(inputArray));
        LinkedList<String> solutionList = new LinkedList<>();

        // Add Starting element and remove from original list.
        solutionList.add(inputArray[0]);
        originalList.remove(0);

        while(originalList.size() > 0) { // Until we have values to insert into the solutionList
            boolean successfullyInserted = false;
            for(int currentlyInsertingElemIndex = 0; currentlyInsertingElemIndex < originalList.size(); currentlyInsertingElemIndex++)
            {
                String currentlyInsertingElemValue = originalList.get(currentlyInsertingElemIndex);
                // Try to put it front
                if(differOnlyByOneChar(solutionList.getFirst(), currentlyInsertingElemValue)){
                    solutionList.addFirst(originalList.get(currentlyInsertingElemIndex));
                    originalList.remove(currentlyInsertingElemIndex);
                    successfullyInserted = true;
                    break;
                }
                // Try to put it in the back
                else if (differOnlyByOneChar(solutionList.getLast(), currentlyInsertingElemValue)) {
                    solutionList.addLast(currentlyInsertingElemValue);
                    originalList.remove(currentlyInsertingElemIndex);
                    successfullyInserted = true;
                    break;
                }
                // Try to squeeze it into the list.
                else{
                    for(int k = 0; k < solutionList.size() -1; k++){
                        if(differOnlyByOneChar(solutionList.get(k), currentlyInsertingElemValue) &&
                                differOnlyByOneChar(solutionList.get(k+1), currentlyInsertingElemValue)){
                            solutionList.add(k+1, currentlyInsertingElemValue);
                            originalList.remove(currentlyInsertingElemIndex);
                            successfullyInserted = true;
                            break;
                        }
                    }
                }
            }
            if(!successfullyInserted) return false;
        }
        return true;
    }

    boolean differOnlyByOneChar(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int diffCounter = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) diffCounter++;
        }
        return diffCounter == 1;
    }
}
