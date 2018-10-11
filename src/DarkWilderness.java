public class DarkWilderness {
    int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        int i = 0;
        int aw = 0;
        while (aw < desiredHeight) {
            aw = aw + upSpeed;
            i++;
            if (aw >= desiredHeight) break;
            aw -= downSpeed;
        }
        return i;
    }

    int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        if (weight1 + weight2 > maxW) {
            if (weight1 > maxW) value1 = 0;
            if (weight2 > maxW) value2 = 0;
            return Math.max(value1, value2);
        } else return value1 + value2;
    }

    String longestDigitsPrefix(String inputString) {
        int i = 0;
        String o = "";
        while (i < inputString.length() && Character.isDigit(inputString.charAt(i))) {
            o += inputString.charAt(i);
            i++;
        }
        return o;
    }

    int digitDegree(int n) {
        int sum = 0;
        int tmp = 0;
        while (n > 9) {
            sum = 0;
            for (int i = 0; i < Integer.toString(n).length(); i++) {
                sum += Integer.parseInt(Character.toString(Integer.toString(n).charAt(i)));
            }
            n = sum;
            tmp++;
        }
        return tmp;
    }

    boolean bishopAndPawn(String bishop, String pawn) {
        if (Math.abs(bishop.charAt(0) - pawn.charAt(0)) == Math.abs(bishop.charAt(1) - pawn.charAt(1))) return true;
        else return false;
    }
}
