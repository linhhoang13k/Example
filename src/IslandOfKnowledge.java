import java.util.Arrays;
import java.util.regex.Pattern;

public class IslandOfKnowledge {
    boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        if (yourLeft == friendsLeft && yourRight == friendsRight || yourLeft == friendsRight && yourRight == friendsLeft)
            return true;
        else return false;

    }

    int arrayMaximalAdjacentDifference(int[] inputArray) {
        int max = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (Math.abs(inputArray[i] - inputArray[i - 1]) > max) max = Math.abs(inputArray[i] - inputArray[i - 1]);
        }
        return max;
    }

    boolean isIPv4Address(String inputString) {
        Pattern compiledPattern = Pattern.compile("([0-9]{1,3}\\.){3}[0-9]{1,3}");
        if (compiledPattern.matcher(inputString).matches() == false) return false;

        int sum = 0;
        int i = 0;

        for (char c : new StringBuilder(inputString).reverse().toString().toCharArray()) {
            if (c == '.' || i == 3) {
                if (sum < 0 || sum > 255) return false;
                sum = 0;
                i = 0;
            } else {
                sum += Integer.parseInt(String.valueOf(c)) * Math.pow(10, i);
                i++;
            }
        }
        if (sum > 255) return false;
        return true;
    }

    int avoidObstacles(int[] inputArray) {
        boolean t = true;
        for (int j = 2; j <= Arrays.stream(inputArray).max().getAsInt() + 1; j++) {
            t = true;
            for (int i : inputArray) {
                if (i % j == 0) {
                    t = false;
                    break;
                }
            }
            if (t == true) return j;
        }

        return 1;
    }

    int[][] boxBlur(int[][] image) {
        int[][] nb = new int[image.length - 2][image[0].length - 2];
        for (int i = 1; i < image.length - 1; i++) {
            for (int j = 1; j < image[0].length - 1; j++) {
                int s = 0;
                for (int k = j - 1; k < j + 2; k++) {
                    s += image[i - 1][k];
                    s += image[i][k];
                    s += image[i + 1][k];
                }
                nb[i - 1][j - 1] = s / 9;
            }
        }
        return nb;
    }

    int[][] minesweeper(boolean[][] matrix) {
        int a;
        int b;
        int g;
        int h;
        int ile;
        int[][] n = new int[matrix.length][matrix[0].length];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                ile = 0;
                if ((x - 1) >= 0) a = x - 1;
                else a = x;
                if ((y - 1) >= 0) b = y - 1;
                else b = y;
                if ((x + 1) <= matrix.length - 1) g = x + 1;
                else g = x;
                if ((y + 1) <= matrix[0].length - 1) h = y + 1;
                else h = y;
                for (int k = a; k <= g; k++) {
                    for (int l = b; l <= h; l++) {
                        if (matrix[k][l] == true) {
                            if ((k == x && l == y)) {
                            } else ile++;
                        }
                    }
                }
                n[x][y] = ile;
            }
        }
        return n;
    }
}
