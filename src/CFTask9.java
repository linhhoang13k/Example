package CodeFightsTasks;

/**
 * Created by Pasha on 23.01.2018.
 */
public class CFTask9 {
    String[] allLongestStrings(String[] inputArray) {
        String words = "";
        int maxLength = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].length() == maxLength)
                words += inputArray[i] + " ";
            else if (inputArray[i].length() > maxLength) {
                words = inputArray[i] + " ";
                maxLength = inputArray[i].length();
            }
        }
        String allLongestString[] = words.split(" ");
        for (int i = 0; i < allLongestString.length; i++)
            System.out.println(allLongestString[i] + "");
        return allLongestString;
    }
}
