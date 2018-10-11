
import java.util.Arrays;

/**
 * This method takes array of positive integer and sorted only even numbers.
 */
class SortOnlyOdds {

    SortOnlyOdds(int[] oddsAndEvenNumber) {

    }

    int[] sortIgnoringOdds(int[] givenArray) {
        int[] oddNumbersArray = Arrays.stream(givenArray).filter(value -> value % 2 != 0).sorted().toArray();
        for (int i = 0; i < givenArray.length; i++) {
            if (givenArray[i] % 2 != 0) {
                givenArray[i] = -1;
            }
        }
        for (int integer : oddNumbersArray) {
            for (int j = 0; j < givenArray.length; j++) {
                if (givenArray[j] == -1) {
                    givenArray[j] = integer;
                    break;
                }
            }
        }
        return givenArray;
    }
}
