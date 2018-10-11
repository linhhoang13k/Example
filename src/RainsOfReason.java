import java.util.regex.Pattern;

public class RainsOfReason {
    int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == elemToReplace) inputArray[i] = substitutionElem;
        }
        return inputArray;
    }

    boolean evenDigitsOnly(int n) {
        Pattern compiledPattern = Pattern.compile("([0,2,4,6,8]{1,})");
        return compiledPattern.matcher(Integer.toString(n)).matches();
    }

    boolean variableName(String name) {
        Pattern compiledPattern = Pattern.compile("([a-z|_]{1,})[a-zA-Z0-9|_]{0,}");
        return compiledPattern.matcher(name).matches();
    }

    String alphabeticShift(String inputString) {
        String n = "";
        for (int i = 0; i < inputString.toCharArray().length; i++) {
            if (inputString.charAt(i) == 'z') n += 'a';
            else n += (char) (inputString.charAt(i) + 1);
        }
        return n;
    }

    boolean chessBoardCellColor(String cell1, String cell2) {
        return ((Math.abs(cell1.charAt(0) - cell2.charAt(0)) % 2 == 0 && Math.abs(cell1.charAt(1) - cell2.charAt(1)) % 2 == 0) || (Math.abs(cell1.charAt(0) - cell2.charAt(0)) % 2 == 1 && Math.abs(cell1.charAt(1) - cell2.charAt(1)) % 2 == 1));
    }

}
