import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class LandOfLogic {
    String longestWord(String text) {
        StringBuilder s = new StringBuilder("" + text);
        String result = "";
        String tmp = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            if (!Character.isAlphabetic(text.charAt(i)) ^ text.charAt(i) == ' ') {
                //s.deleteCharAt(i);
                s.replace(i, i + 1, " ");
            }
        }
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) != ' ') {
                tmp += s.charAt(i);
                i++;
            }
            if (tmp.length() > result.length()) result = tmp;
            tmp = "";
        }
        return result;
    }

    boolean validTime(String time) {
        String s[] = time.split(Pattern.quote(":"));
        return (Integer.parseInt(s[0]) > 0 && Integer.parseInt(s[0]) < 24 && Integer.parseInt(s[1]) > 0 && Integer.parseInt(s[1]) < 60);
    }

    int sumUpNumbers(String inputString) {
        String digit = "";
        int sum = 0;
        for (int i = 0; i < inputString.length(); i++) {
            while (i < inputString.length() && Character.isDigit(inputString.charAt(i))) {
                digit += inputString.charAt(i);
                i++;
            }
            if (digit != "") {
                sum += Integer.parseInt(digit);
                digit = "";
            }
        }
        return sum;
    }

    int differentSquares(int[][] matrix) {
        int ssum = 0;
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                ssum += (matrix[i][j]) * Math.pow(10, 3);
                ssum += (matrix[i][j + 1]) * Math.pow(10, 2);
                ssum += (matrix[i + 1][j]) * Math.pow(10, 1);
                ssum += (matrix[i + 1][j + 1]) * Math.pow(10, 0);
                s.add(ssum);
                ssum = 0;
            }
        }
        return s.size();
    }

    int digitsProduct(int product) {
        StringBuilder s = new StringBuilder("");
        int p2 = product;
        if (p2 == 0) return 10;
        if (p2 == 1) return 1;
        for (int i = 9; i > 1; i--) {
            if (p2 % i == 0) {
                p2 /= i;
                s.append(i);
                i = 10;
            }
        }
        if (p2 == 1) return Integer.parseInt(s.reverse().toString());
        else return -1;
    }

    String[] fileNaming(String[] names) {
        Set<String> s = new LinkedHashSet<>();
        String pom = "";
        int k = 1;
        for (int i = 0; i < names.length; i++) {
            k = 1;
            pom = names[i];
            while (!s.add(pom)) {
                pom = names[i] + "(" + k + ")";
                k++;
            }
            names[i] = pom;
        }
        return names;
    }

    String messageFromBinaryCode(String code) {
        int j = 0;
        String result = "";
        for (int i = 0; i < code.length(); i += 8) {
            result += Character.toString((char) Integer.parseInt(code.substring(i, i + 8), 2));
        }
        return result;
    }

    int[][] spiralNumbers(int n) {
        int i = 1;
        int[][] s = new int[n][n];
        int m = s.length;
        int p = 0;

        while (i <= Math.pow(n, 2)) {
            for (int j = p; j < m; j++) s[p][j] = i++;
            p++;
            for (int j = p; j < m; j++) s[j][m - 1] = i++;
            m--;
            for (int j = m - 1; j >= p; j--) s[m][j] = i++;
            for (int j = m; j >= p; j--) s[j][p - 1] = i++;
        }
        return s;
    }

    boolean sudoku(int[][] grid) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < grid.length; i += 3) {
            for (int j = 0; j < grid.length; j += 3) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        s.add(grid[k][l]);
                    }
                }
                if (s.size() != 9) return false;
            }
            s.clear();
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                s.add(grid[i][j]);
            }
            if (s.size() != 9) return false;
            s.clear();
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                s.add(grid[j][i]);
            }
            if (s.size() != 9) return false;
            s.clear();
        }

        return true;
    }
}
