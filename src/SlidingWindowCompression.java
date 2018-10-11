package Dropbot;

/**
 * Created by ThanhND37 on 12/13/2016.
 */

/**
 * Consider characters one by one. Let the current character index be i.
 * Take the last width characters before the current one (i.e. s[i - width, i - 1],
 * where s[i, j] means the substring of s from index i to index j, both inclusive), and call it the window.
 * Find such startIndex and length that:
 *  s[i, i + length - 1] = s[startIndex, startIndex + length - 1]
 *  and s[startIndex, startIndex + length - 1] is contained within the window. If there are several such pairs, choose the one with the largest length. If there still remains more than one option, choose the one with the smallest startIndex.
 * If the search was successful, append "(startIndex,length)" to the result and move to the index i + length.
 * Otherwise, append the current character to the result and move on to the next one.
 */
public class SlidingWindowCompression {


    static String losslessDataCompression(String inputString, int width) {
        String out = "";
        for (int i = 0; i < inputString.length();) {
            String window = "";
            int startSub = 0;
            int endSub = 0;
            if (i == 0)
                window = "";
            else if (i < width) {
                startSub = 0;
                endSub = i;
                window = inputString.substring(startSub, endSub);
            }
            else {
                startSub = i - width;
                endSub = i;
                window = inputString.substring(startSub, endSub);
            }
            String against = inputString.substring(i, Math.min(i + window.length(), inputString.length()));

            System.out.println("\nIndex: "+ i +  " / Window: " + window + " / Against: " + against);
            int[] matchInfo = findLargestSubString(window, against);
            if (matchInfo[1] == 0)
            {
                out = out + inputString.charAt(i);
                System.out.println("No match found. Result: " + out);
                i++;
            }
            else
            {
                int start = matchInfo[0] + startSub;
                out = out + "(" + start+ "," + matchInfo[1] + ")";
                System.out.printf("match %s found. Result: %s\n", inputString.substring(i, i + matchInfo[1]), out);
                i+=matchInfo[1];
            }
        }
        return out;
    }


    /**
     * Constraints: p1.length <= p2.
     * Returns index from which the match is started on p1 and length of the match
     * The matching sub must start from start
     */
    static int[] findLargestSubString(String p1, String p2)
    {
        String match = "";
        int start = p1.length();
        int length = 0;
        for (int i = 1; i <= p2.length(); i++)
        {
                String cur = p2.substring(0, i);
                int indexFound = p1.indexOf(cur);
                // largest, at smallest index
                if (indexFound != -1
                        && ((cur.length() > length
                            || cur.length() == length && (indexFound < start))))
                {
                    match = cur;
                    start = indexFound;
                    length = cur.length();
                    System.out.printf("     biggest match found: %s at index %d of p1, length %d\n", cur, start, cur.length());
                }
            }
        System.out.printf("     Match: %s\n", match.isEmpty() ? "NULL" : match);
        return new int[] {start, length};
    }

}
