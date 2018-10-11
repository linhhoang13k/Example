import java.util.HashMap;
import java.util.Map;

public class Cryptarithm {

    static HashMap<Character, Character> solutionMap = new HashMap<>();
    static int rowCount;

    static boolean isCryptSolution(String[] crypt, char[][] solution) {
        rowCount = solution.length;

        fillSolutionMap(solution);
        performSubstitution(crypt);

        return isValidCrypt(crypt);
    }

    private static boolean isValidCrypt(String[] crypt) {
        for (String decodedCrypt : crypt
                ) {
            if (isFirstCharacterLeadingZero(decodedCrypt)) return false;
        }

        long firstDecodedCrypt = Long.parseLong(crypt[0]);
        long secondDecodedCrypt = Long.parseLong(crypt[1]);
        long thirdDecodedCrypt = Long.parseLong(crypt[2]);

        return firstDecodedCrypt + secondDecodedCrypt == thirdDecodedCrypt;
    }

    private static boolean isFirstCharacterLeadingZero(String decodedCrypt) {
        if (decodedCrypt.length() > 1) {

            char firstCharacter = decodedCrypt.charAt(0);
            if (firstCharacter == '0') {
                return true;
            }
        }
        return false;
    }

    private static void fillSolutionMap(char[][] solution) {
        for (int i = 0; i < rowCount; i++) {
            solutionMap.put(solution[i][0], solution[i][1]);
        }
    }

    private static void performSubstitution(String[] crypt) {
        int cryptIdleNumber = 0;
        for (String word : crypt
                ) {
            for (Map.Entry<Character, Character> entry : solutionMap.entrySet()
                    ) {
                if (word.contains(entry.getKey().toString())) {
                    word = word.replace(entry.getKey(), entry.getValue());
                    crypt[cryptIdleNumber] = word;
                }

            }
            cryptIdleNumber++;
        }
    }

}
