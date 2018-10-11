import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Arcade_Intro {

    public static void main(String[] args) {
        System.out.println(new Arcade_Intro().add(1, 2));
    }

    int add(int param1, int param2) {
        return param1 + param2;
    }

    int add2(int... args) {
        int sum = 0;
        for (int arg : args)
            sum += arg;
        return sum;
    }

    int centuryFromYear(int year) {
        return (year - 1) / 100 + 1;
    }

    boolean checkPalindrome(String inputString) {
        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.charAt(i) != inputString.charAt(inputString.length() - 1 - i)) return false;
        }
        return true;
    }

    int adjacentElementsProduct(int[] inputArray) {
        int max = inputArray[0] * inputArray[1];
        for (int i = 0; i < inputArray.length - 1; i++) {
            max = Math.max(max, inputArray[i] * inputArray[i + 1]);
        }
        return max;
    }

    int shapeArea(int n) {
        if (n == 1) return 1;
        else return shapeArea(n - 1) + (n - 1) * 4;
    }

    int makeArrayConsecutive2(int[] statues) {
        int max = statues[0], min = statues[0];
        for (int s : statues) {
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return max - min - statues.length + 1;
    }

    boolean almostIncreasingSequence(int[] sequence) {
        int counter = 0;
        for (int i = 0; i < sequence.length - 1; i++) {
            if (sequence[i] >= sequence[i + 1]) {
                counter++;
                if (i != 0 && i < sequence.length - 2 && sequence[i] >= sequence[i + 2] && sequence[i - 1] >= sequence[i + 1])
                    return false;
            }
        }
        return counter <= 1;
    }

    int matrixElementsSum(int[][] matrix) {
        //ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++)
            for (int[] aMatrix : matrix) {
                if (aMatrix[i] == 0) break;
                sum += aMatrix[i];
            }
        return sum;
    }

    String[] allLongestStrings(String[] inputArray) {
        ArrayList<String> list = new ArrayList<>();
        int max = inputArray[0].length();
        for (String string : inputArray) {
            max = Math.max(max, string.length());
        }
        for (String string : inputArray) {
            if (string.length() == max) list.add(string);
        }
        String[] longestStrings = new String[list.size()];
        longestStrings = list.toArray(longestStrings);
        return longestStrings;
    }

    int commonCharacterCount(String s1, String s2) {
        ArrayList<Character> c1 = new ArrayList<>();
        ArrayList<Character> c2 = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < s1.length(); i++) c1.add(s1.charAt(i));
        for (int i = 0; i < s2.length(); i++) c2.add(s2.charAt(i));
        for (Character c : c1)
            for (Character d : c2)
                if (c == d) {
                    counter++;
                    c2.remove(d);
                    break;
                }
        return counter;
    }

    boolean isLucky(int n) {
        String s = Integer.toString(n);
        if (s.length() % 2 != 0) return false;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < s.length() / 2; i++)
            sum1 += Character.getNumericValue(s.charAt(i));
        for (int i = s.length() / 2; i < s.length(); i++)
            sum2 += Character.getNumericValue(s.charAt(i));
        return sum1 == sum2;
    }

    int[] sortByHeight(int[] a) {
        int tmp;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) continue;
            for (int j = 0; j < a.length; j++) {
                if (a[j] > a[i]) {
                    tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
        return a;
    }

    String reverseParentheses(String s) {
        int brackets = 0;
        StringBuilder s2 = new StringBuilder(s);
        StringBuilder subS2 = new StringBuilder();

        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '(') {
                brackets++;
                i++;
            }
            while (brackets != 0 && s2.charAt(i) != ')') {
                if (s2.charAt(i) == '(')
                    brackets++;
                i++;
            }
            if (brackets != 0) {
                brackets--;
                int x = 0;
                while (s2.charAt(i - x) != '(') {
                    x++;
                }
                subS2.append(s2.substring(i - x + 1, i)).reverse();
                s2.deleteCharAt(i - x);
                s2.deleteCharAt(i - 1);
                s2.replace(i - x, i - 1, new String(subS2));
                subS2.delete(0, s2.length() - 1);
                i -= 2;
            }
        }
        return new String(s2);
    }

    int[] alternatingSums(int[] a) {
        int w1 = 0, w2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) w1 += a[i];
            else w2 += a[i];
        }
        return new int[]{w1, w2};
    }

    String[] addBorder(String[] picture) {
        String stars = "";
        for (int i = 0; i < picture[0].length() + 2; i++) stars += "*";
        String[] withBorder = new String[picture.length + 2];
        withBorder[0] = stars;
        for (int i = 0; i < picture.length; i++) withBorder[i + 1] = "*" + picture[i] + "*";
        withBorder[picture.length + 1] = stars;
        return withBorder;
    }

    boolean areSimilar(int[] a, int[] b) {
        int count = 0;
        int swap = 0;
        int x = 0;
        int y = 0;
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (count == 0) {
                    x = b[i];
                    y = a[i];
                } else if (a[i] == x && b[i] == y) {
                    count--;
                    swap++;
                }
                count++;
            }
        }
        if (swap <= 1 && count <= 1) return true;
        else return false;
    }

    int arrayChange(int[] inputArray) {
        int count = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i - 1] >= inputArray[i]) {
                count++;
                inputArray[i]++;
                i--;
            }
        }
        return count;
    }

    boolean palindromeRearranging(String inputString) {

//        Map<Character,List<Character>> distinctLetters = inputString.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c->c));
//        return distinctLetters.values()
//                .stream()
//                .filter(b->b.size()==1)
//                .count() <= 1;


        Map<Character, Integer> mapa = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            if (mapa.containsKey(c)) mapa.put(c, mapa.get(c) + 1);
            else mapa.put(c, 1);
        }

        int count = 0;
        for (Integer i : mapa.values())
            if (i % 2 != 0) count++;

        return count < 2;
    }

    boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {

        if (Math.max(yourLeft, yourRight) == Math.max(friendsLeft, friendsRight)
                && Math.min(yourLeft, yourRight) == Math.min(friendsLeft, friendsRight)) return true;

        else return false;
    }

    int arrayMaximalAdjacentDifference(int[] inputArray) {
        int max = 0;
        for (int i = 0; i < inputArray.length - 1; i++)
            max = Math.max(max, Math.abs(inputArray[i] - inputArray[i + 1]));
        return max;
    }

    boolean isIPv4Address(String inputString) {

        int number;
        for (String s : inputString.split("\\.")) {
            try {
                number = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }

            if (number > 255)
                return false;
        }
        return inputString.split("\\.").length == 4;
    }

    int avoidObstacles(int[] inputArray) {
        int count = 0;
        int x = 2;
        while (count != inputArray.length) {
            count = 0;
            x++;
            for (int i : inputArray)
                if (i % x != 0) count++;
        }
        return x;
    }

    int[][] boxBlur(int[][] image) {
        int sum = 0;
        int[][] matrix = new int[image.length - 2][image[0].length - 2];
        for (int k = 0; k < image.length - 2; k++)
            for (int l = 0; l < image[0].length - 2; l++) {
                for (int i = k; i < image.length && i < k + 3; i++) {
                    for (int j = l; (j < image[0].length) && (j < l + 3); j++)
                        sum += image[i][j];
                }
                matrix[k][l] = sum / 9;
                sum = 0;
            }
        return matrix;
    }

    int[][] minesweeper(boolean[][] matrix) {

        int[][] minesMatrix = new int[matrix.length][matrix[0].length];
        for (int k = 0; k < minesMatrix.length; k++)
            for (int l = 0; l < minesMatrix[0].length; l++)
                for (int i = k != 0 ? k - 1 : 0;
                     i < Math.min(k + 2, matrix.length);
                     i++)
                    for (int j = l != 0 ? l - 1 : 0;
                         j < Math.min(l + 2, matrix[0].length);
                         j++)
                        if (matrix[i][j] && !(k == i && l == j))
                            minesMatrix[k][l]++;

        return minesMatrix;
    }

    int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
//        return Arrays.stream(inputArray)
//                .map(i->i==elemToReplace? substitutionElem : i)
//                .toArray();

        for (int i = 0; i < inputArray.length; i++)
            if (inputArray[i] == elemToReplace) inputArray[i] = substitutionElem;
        return inputArray;
    }

    boolean evenDigitsOnly(int n) {
//        return Stream.of(String.valueOf(n)
//                .split(""))
//                .allMatch(s -> Integer.parseInt(s) % 2 == 0);

        for (char s : String.valueOf(n).toCharArray())
            if (s % 2 != 0) return false;
        return true;
    }

    boolean variableName(String name) {
        // return name.chars().
        //    allMatch(c -> (Character.isDigit(c) || Character.isLetter(c) || c == '_'))
        //    && !Character.isDigit(name.charAt(0));


        if (Character.isDigit(name.charAt(0))) return false;
        for (char c : name.toCharArray())
            if (!(Character.isDigit(c) || Character.isLetter(c) || c == '_')) return false;
        return true;
    }

    String alphabeticShift(String inputString) {
        // return inputString.chars().
        //                 mapToObj(i->(char)(((i-'a'+1)%26)+'a')).
        //                 map(c->""+c).reduce((s1, s2) -> s1 + s2).
        //                 get();

        String s = "";
        for (char c : inputString.toCharArray())
            s += (char) (((c - 'a' + 1) % 26) + 'a');
        return s;
    }

    boolean chessBoardCellColor(String cell1, String cell2) {
        return (cell1.charAt(0) + cell1.charAt(1)) % 2 == (cell2.charAt(0) + cell2.charAt(1)) % 2;
    }

    int circleOfNumbers(int n, int firstNumber) {
        return (firstNumber + n / 2) % n;
    }

    int depositProfit(int deposit, int rate, int threshold) {
        int x = 0;
        double deposit2 = (double) deposit;
        while (threshold > deposit2) {
            deposit2 *= 1 + (double) rate / 100;
            x++;
        }
        return x;
    }

    int absoluteValuesSumMinimization(int[] a) {
        int sum = 0;
        int min = Arrays.stream(a)
                .map(Math::abs)
                .sum() + 1;

        int x = a[0];
        for (int i : a) {
            for (int j : a) {
                sum += Math.abs(j - i);
            }
            if (sum < min) {
                min = sum;
                x = i;
            }
            sum = 0;
        }
        return x;
    }

    boolean stringsRearrangement(String[] inputArray) {
        int stringLength = inputArray[0].length();
        boolean[][] matrix = new boolean[inputArray.length][inputArray.length];
        boolean[] visited = new boolean[inputArray.length];
        ArrayList<Integer> list = new ArrayList<>();
        int[] tab = new int[inputArray.length];
        int differ = 0;
        int similar = 0;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                for (int c = 0; c < stringLength; c++)
                    if (inputArray[i].charAt(c) != inputArray[j].charAt(c))
                        differ++;
                if (differ == 1) {
                    matrix[i][j] = true;
                    similar++;
                }
                differ = 0;
            }
            tab[i] = similar;
            similar = 0;
        }

        int idMin = 0;
        for (int i = 1; i < tab.length; i++)
            if (tab[i] < tab[idMin])
                idMin = i;

        visited[idMin] = true;
        while (idMin != -1) {
            for (int j = 0; j < inputArray.length; j++)
                if (matrix[idMin][j] && !visited[j]) list.add(j);
            if (!list.isEmpty()) {
                idMin = list.get(0);
                for (Integer l : list)
                    if (tab[l] < tab[idMin]) idMin = l;
                visited[idMin] = true;
                list.clear();
            } else idMin = -1;
        }

        for (boolean b : visited)
            if (!b) return false;

        return true;
    }

    Integer[] extractEachKth(int[] inputArray, int k) {
        ArrayList<Integer> tabb = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) if (i % k != k - 1) tabb.add(inputArray[i]);

        return tabb.toArray(new Integer[tabb.size()]);
    }

    char firstDigit(String inputString) {

        for (char c : inputString.toCharArray())
            if (Character.isDigit(c)) return c;

        return 0;
    }

    int differentSymbolsNaive(String s) {
        //return (int) s.chars().distinct().count();

        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : s.toCharArray())
            if (charMap.containsKey(c)) charMap.computeIfPresent(c, (k, v) -> v + 1);
            else charMap.put(c, 1);
        return charMap.size();
    }

    int arrayMaxConsecutiveSum(int[] inputArray, int k) {
        int max = 0;
        int sum = 0;

        for (int i = 0; i <= inputArray.length - k; i++) {
            for (int j = i; j < inputArray.length && j < i + k; j++) {
                sum += inputArray[j];
            }
            max = Math.max(max, sum);
            sum = 0;
        }
        return max;
    }

    int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        int height = 0;
        int x = 0;
        while (height <= desiredHeight) {
            x++;
            height += upSpeed;
            if (height >= desiredHeight) break;
            height -= downSpeed;
        }
        return x;
    }

    int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        if (weight1 + weight2 <= maxW) return value1 + value2;
        else if (weight1 <= maxW && weight2 <= maxW) return value1 > value2 ? value1 : value2;
        else if (weight1 <= maxW) return value1;
        else if (weight2 <= maxW) return value2;
        else return 0;
    }


    String longestDigitsPrefix(String inputString) {
        StringBuilder digitsPrefix = new StringBuilder();
        String longest = "";

        for (char c : inputString.toCharArray()) {
            if (Character.isWhitespace(c)) break;
            if (Character.isDigit(c)) digitsPrefix.append(c);
            else {
                if (digitsPrefix.length() > longest.length()) longest = digitsPrefix.toString();
                digitsPrefix.setLength(0);
            }
            if (digitsPrefix.length() > longest.length()) longest = digitsPrefix.toString();

        }
        return longest;
    }

    int digitDegree(int n) {
        int count = 0;
        int sum = 0;
        StringBuilder nn = new StringBuilder("" + n);

        while (nn.length() > 1) {
            for (char c : nn.toString().toCharArray()) {
                sum += Integer.parseInt("" + c);
            }
            nn.setLength(0);
            nn.append(sum);
            sum = 0;
            count++;
        }
        return count;
    }

    boolean bishopAndPawn(String bishop, String pawn) {
//         int a = 1 + pawn.charAt(0) - 'a';
//         int b = Integer.parseInt("" + pawn.charAt(1));

//         for (int c = 1 + bishop.charAt(0) - 'a', i = Integer.parseInt("" + bishop.charAt(1)); c <= 8 && i <= 8; c++, i++)
//             if (c == a && i == b)
//                 return true;
//         for (int c = 1 + bishop.charAt(0) - 'a', i = Integer.parseInt("" + bishop.charAt(1)); c >= 1 && i >= 1; c--, i--)
//             if (c == a && i == b) return true;
//         for (int c = 1 + bishop.charAt(0) - 'a', i = Integer.parseInt("" + bishop.charAt(1)); c <= 8 && i >= 1; c++, i--)
//             if (c == a && i == b) return true;
//         for (int c = 1 + bishop.charAt(0) - 'a', i = Integer.parseInt("" + bishop.charAt(1)); c >= 1 && i <= 8; c--, i++)
//             if (c == a && i == b) return true;

//         return false;
//
        return Math.abs(bishop.charAt(0) - pawn.charAt(0)) == Math.abs(bishop.charAt(1) - pawn.charAt(1));
    }

    boolean isBeautifulString(String inputString) {
        int[] tab = new int[26];

        for (char c : inputString.toCharArray()) tab[c - 'a']++;

        for (int i = 1; i < 26; i++)
            if (tab[i] > tab[i - 1]) return false;

        return true;
    }

    String findEmailDomain(String address) {
        String[] mail = address.split("@");
        return mail[mail.length - 1];
    }

    String buildPalindrome(String st) {
        StringBuilder normal = new StringBuilder(st);
        StringBuilder substring = new StringBuilder();

        for (int i = 0; i < st.length(); i++) {
            substring.setLength(0);
            substring.append(normal.substring(0, i));
            if (checkPalindrome(normal.append(substring.reverse()).toString())) return normal.toString();
            normal.delete(st.length(), st.length() + substring.length());
        }

        return "";
    }

    int electionsWinners(int[] votes, int k) {
        int max = Arrays.stream(votes)
                .max()
                .getAsInt();

        if (k == 0)
            return (int) Arrays.stream(votes)
                    .filter(i -> i == max)
                    .count() == 1 ? 1 : 0;

        return (int) Arrays.stream(votes)
                .filter(i -> i + k > max)
                .count();
    }

    boolean isMAC48Address(String inputString) {
        // if(inputString.charAt(0)=='-'||inputString.charAt(inputString.length()-1)=='-') return false;
        // String[] split = inputString.split("-");
        // if (split.length != 6) return false;
        // for (String s : split) if (!s.matches("[0-9A-F][0-9A-F]")) return false;
        // return true;
        //
        return inputString.matches("^([0-9A-F]{2}-){5}[0-9A-F]{2}$");
    }

    boolean isDigit(char symbol) {
        return Character.isDigit(symbol);
    }

    String lineEncoding(String s) {
        char current = s.charAt(0);
        int count = 0;
        StringBuilder encodingString = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == current)
                count++;
            else {
                if (count > 1) encodingString.append(count);
                encodingString.append(current);
                current = c;
                count = 1;
            }
        }
        if (count > 1) encodingString.append(count);
        encodingString.append(current);

        return encodingString.toString();
    }

    int chessKnight(String cell) {
        int count = 0;
        for (int i = 1; i <= 8; i++)
            for (int j = 1; j <= 8; j++)
                if (Math.abs(1 + cell.charAt(0) - 'a' - i) == 1 && Math.abs(Integer.parseInt("" + cell.charAt(1)) - j) == 2 || Math.abs(1 + cell.charAt(0) - 'a' - i) == 2 && Math.abs(Integer.parseInt("" + cell.charAt(1)) - j) == 1)
                    count++;
        return count;
    }


    int deleteDigit(int n) {
        int max = 0;
        StringBuilder deleted = new StringBuilder("" + n);
        int length = deleted.length();
        for (int i = 0; i < length; i++) {
            max = Math.max(max, Integer.parseInt(deleted.deleteCharAt(i).toString()));
            deleted.setLength(0);
            deleted.append("" + n);
        }
        return max;
    }

    String longestWord(String text) {
        int max = 0;
        String lWord = "";
        Matcher m = Pattern.compile("[a-zA-Z]*").matcher(text);
        while (m.find()) {
            if (max < m.group().length()) {
                max = m.group().length();
                lWord = m.group();
            }
        }
        return lWord;
    }

    boolean validTime(String time) {
        String[] split = time.split(":");
        return (Integer.parseInt(split[0]) < 24 && Integer.parseInt(split[1]) < 60);

        //return time.matches("(([0-1][0-9])|([2][0-4])):(([0-4][0-9])|([5][0-9]))");
    }

    int sumUpNumbers(String inputString) {
        int sum = 0;
        String[] numbers = inputString.split("\\D+");
        for (String s : numbers) if (s.length() > 0) sum += Integer.parseInt(s);
        return sum;
    }

    int differentSquares(int[][] matrix) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                String s = "";
                s += matrix[i][j] + "." + matrix[i][j + 1] + "." + matrix[i + 1][j] + "." + matrix[i + 1][j + 1];
                set.add(s);
            }
        }
        return set.size();
    }

    int digitsProduct(int product) {
        List<Integer> list = new ArrayList<>();
        String st = "";
        boolean f;
        if (product == 0) return 10;
        while (("" + product).length() > 1) {
            f = false;
            for (int i = 0; i < 8; i++) {
                if (product % (9 - i) == 0) {
                    product /= (9 - i);
                    list.add(9 - i);
                    f = true;
                    break;
                }
            }
            if (!f) return -1;
        }
        list.add(product);
        Collections.sort(list);
        for (int i : list) st += i;
        return Integer.parseInt(st);
    }

    String[] fileNaming(String[] names) {
        Map<String, Integer> map = new LinkedHashMap<>();
        String[] fileNames = new String[names.length];
        for (String s : names) {
            String tmp;
            if (!map.containsKey(s))
                map.put(s, 1);
            else {
                int i = map.get(s) - 1;
                do {
                    i++;
                    tmp = s + "(" + i + ")";

                } while (map.containsKey(tmp));

                map.put(tmp, 1);
                map.computeIfPresent(s, (k, v) -> v + 1);

            }
        }
        map.keySet().toArray(fileNames);
        return fileNames;
    }

    String messageFromBinaryCode(String code) {
        String s = "";
        for (int i = 0; i < code.length(); i += 8) {
            String substring = code.substring(i, i + 8);
            s = s + (char) Integer.parseInt(substring, 2);
        }
        return s;
    }

    int[][] spiralNumbers(int n) {
        int[][] matrix = new int[n][n];
        int i = 0, j = -1;
        int x = 0;
        int tmp = n;
        while (x != n * n) {
            for (int a = 0; a < tmp; a++) {
                matrix[i][++j] = ++x;
                if (x == n * n) return matrix;
            }
            for (int b = 0; b < tmp - 1; b++) {
                matrix[++i][j] = ++x;
                if (x == n * n) return matrix;
            }
            for (int c = 0; c < tmp - 1; c++) {
                matrix[i][--j] = ++x;
                if (x == n * n) return matrix;
            }
            for (int d = 0; d < tmp - 2; d++) {
                matrix[--i][j] = ++x;
                if (x == n * n) return matrix;
            }
            tmp -= 2;
        }
        return matrix;
    }

    boolean sudoku(int[][] grid) {
        int[] tmpRow = new int[9];
        int[] tmpCol = new int[9];
        int[] tmp = new int[9];
        int x = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tmpCol[j] = grid[j][i];
                tmpRow[j] = grid[i][j];
            }
            Arrays.sort(tmpCol);
            Arrays.sort(tmpRow);
            for (int j = 0; j < 9; j++)
                if (tmpCol[j] != j + 1 || tmpRow[j] != j + 1)
                    return false;
        }

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                for (int i = 3 * k; i < 3 * k + 3; i++) {
                    for (int j = 3 * l; j < 3 * l + 3; j++) {
                        tmp[x++] = grid[i][j];
                    }
                }
                x = 0;
                Arrays.sort(tmp);
                for (int m = 0; m < 9; m++)
                    if (tmp[m] != m + 1)
                        return false;
            }

        }
        return true;
    }

}
