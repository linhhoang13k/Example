package interviewioquestions;

/**
 * @author benmakusha
 */

public class ExpandString {
    /*
    Write a function that given a string would print the 'expanded' version of it.
    For example a2[bc2[c]]d would print out abcccbcccd

    Note:
    The number before the opening and closing square brackets is the multiplier for the characters within the square brackets
     */

    char open = '[';
    char closed = ']';

    public String findContentsBetweenBrackets(String str){
        String subString = "";
        int openCount = 1;
        int closedCount = 0;

        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);

            if (current == open) {
                openCount++;
            } else if (current == closed) {
                closedCount++;
            }

            if (openCount == closedCount) {
                break;
            } else {
                subString += current;
            }
        }

        return subString;
    }

    public String expanded(String str) {
        String retVal = "";
        int i = 0;

        while (i < str.length()) {
            char current = str.charAt(i);

            if (Character.isDigit(current)) {
                int number = Character.getNumericValue(current);
                i++;
                String contentsBtwnBrackets = findContentsBetweenBrackets(str.substring(i));
                i += contentsBtwnBrackets.length() + 1;

                for (int j = 0; j < number; j++) {
                    retVal += expanded(contentsBtwnBrackets);
                }
            } else {
                retVal += current;
            }
            i++;
        }
        return retVal;
    }



//    public String expanded(String str) {
//        ArrayList<Character> stack = new ArrayList<>();
//        String strFinal = "";
//        ArrayList<Integer> repeats = new ArrayList<>();
//        char[] charArray = str.toCharArray();
//
//        if (str.indexOf("[") == -1) {
//            return str;
//        } else {
//            for (char i : charArray) {
//                if (i == '[') {
//                    stack.add(i);
//                }
//                else if (Character.isDigit(i)) {
//                    repeats.add(Character.getNumericValue(i));
//                }
//                else if (Character.isAlphabetic(i) && !stack.contains(i)) {
//                    strFinal = strFinal + i;
//                }
//                else if (i == ']') {
//                    char startIndex = stack.get(stack.size() - 1);
//                    stack.remove(stack.size() - 1);
//                    if (stack.size() == 0) {
//                        String innerSub = str.substring(str.lastIndexOf(startIndex) - 1, str.lastIndexOf(i));
//                        String inner = expanded(innerSub);
//                        int repeatsChar = repeats.get(repeats.size() - 1);
//                        if (repeatsChar > 1) {
//                            for (int j = 1; j <= repeats.get(repeats.size() - 1); j++) {
//                                strFinal = strFinal + inner;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return strFinal;
//    }
}
