package evg.codefights.core;

import java.util.*;
import java.util.regex.*;

public class SecretArchives {

    public static void main(String[] args) {
//        System.out.println(new SecretArchives().htmlTable("<table><tr><td>1</td><td>TWO</td></tr><tr><td>three</td><td>FoUr4</td></tr></table>", 1, 2));
//        System.out.println(new SecretArchives().chessNotation("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR"));
//        System.out.println(new SecretArchives().firstOperationCharacter("((2 + 2) * 2) * 3 + (2 + (2 * 2))"));
//        System.out.println(new SecretArchives().countElements("[\"[   -45,   95]   \", [ 87,  -655]]"));
//        System.out.println(Arrays.toString(new SecretArchives().treeBottom("(2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))")));
//        System.out.println(new SecretArchives().befunge93(new String[] {
//                ">25*\"!dlrow ,olleH\":v ",
//                "                 v:,_@",
//                "                 >  ^ "
//
//        }));
//        System.out.println(new SecretArchives().befunge93(new String[] {
//                "\"^a&EPm=kY}t/qYC+i9wHye$m N@~x+\"v",
//                "\"|DsY<\"-\"z6n<[Yo2x|UP5VD:\">:#v_@>",
//                "-:19+/\"0\"+,19+%\"0\"+,      ^  >39*"
//
//        }));
//        System.out.println(new SecretArchives().befunge93(new String[]{
//                "v>v>",
//                "v^v^",
//                "v^v^",
//                "v^v^",
//                ">^>^"
//        }));
//        Arrays.stream(new SecretArchives().cellsJoining(new String[]{
//                "+----+--+-----+----+",
//                "|abcd|56|!@#$%|qwer|",
//                "|1234|78|^&=()|tyui|",
//                "+----+--+-----+----+",
//                "|zxcv|90|77777|stop|",
//                "+----+--+-----+----+",
//                "|asdf|~~|ghjkl|100$|",
//                "+----+--+-----+----+"
//        }, new int[][]{{2, 0}, {1, 1}})).forEach(t -> System.out.println(t));

    }

    String[] lrc2subRip(String[] lrcLyrics, String songLength) {
        Pattern pattern = Pattern.compile("^\\[(\\d{2})\\:(\\d{2})\\.(\\d{2})\\]\\s*(.*)$");
        Pattern songLen = Pattern.compile("^(\\d{2})\\:(\\d{2})\\:(\\d{2})$");
        Matcher matcher = songLen.matcher(songLength);
        matcher.find();
        int HH = Integer.parseInt(matcher.group(1));
        int MM = Integer.parseInt(matcher.group(2));
        int SS = Integer.parseInt(matcher.group(3));
        int xxx = 0;
        String[] res = new String[lrcLyrics.length * 3 + lrcLyrics.length - 1];
        for (int i = lrcLyrics.length - 1; i >= 0; i--) {
            Matcher mat = pattern.matcher(lrcLyrics[i]);
            mat.find();
            int m = Integer.parseInt(mat.group(1));
            int s = Integer.parseInt(mat.group(2));
            int x = Integer.parseInt(mat.group(3)) * 10;
            int h = 0;
            if (m > 59) {
                h = 1;
                m = m % 60;
            }
            String str = mat.group(4);

            res[i * 4] = Integer.toString(i + 1);
            res[i * 4 + 1] = String.format("%02d:%02d:%02d,%03d --> %02d:%02d:%02d,%03d", h, m, s, x, HH, MM, SS, xxx);
            res[i * 4 + 2] = str;
            if (i != lrcLyrics.length - 1) {
                res[i * 4 + 3] = "";
            }
            HH = h;
            MM = m;
            SS = s;
            xxx = x;
        }
        return res;
    }


    String htmlTable(String table, int row, int column) {
        int curRow = -1;
        int curCol = -1;
        int index = -1;
        while (curRow != row && (index = table.indexOf("<tr>", index + 1)) != -1) {
            curRow++;
        }
        if (index == -1) {
            return "No such cell";
        }
        int endIndex = table.indexOf("</tr>", index);
        index--;
        while (curCol != column && (index = table.indexOf("<td>", index + 1)) != -1) {
            curCol++;
        }
        if (index == -1 || index > endIndex) {
            return "No such cell";
        }
        int beginIndex = index + 4;
        return table.substring(beginIndex, table.indexOf("</", index));
    }

    String chessNotation(String notation) {
        char[][] board = new char[8][8];
        int i = 0;
        int j = 0;
        for (int k = 0; k < notation.length(); k++) {
            char ch = notation.charAt(k);
            if (ch == '/') {
                i++;
                j = 0;
                continue;
            }
            if (Character.isDigit(ch)) {
                j += ch - '0';
                continue;
            }
            board[i][j++] = ch;
        }
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < board.length; col++) {
            if (col != 0) {
                sb.append('/');
            }
            int n = 0;
            for (int row = board[col].length - 1; row >= 0; row--) {
                char ch = board[row][col];
                if (ch == 0) {
                    n++;
                } else {
                    if (n != 0) {
                        sb.append(n);
                        n = 0;
                    }
                    sb.append(ch);
                }
            }
            if (n != 0) {
                sb.append(n);
            }
        }
        return sb.toString();
    }

    String[] cellsJoining(String[] table, int[][] coords) {
        int row = -1;
        int startIndex = -1;
        int endIndex = -1;
        int startNum = -1;
        int endNum = -1;
        for (int i = 0; i < table.length; i++) {
            if (table[i].charAt(0) == '+') {
                row++;
            }
            if (row == coords[1][0] && startIndex == -1) {
                startIndex = i;
            }

            if (row - 1 == coords[0][0] && endIndex == -1) {
                endIndex = i;
            }
        }
        int col = -1;
        String str = table[startIndex];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+') {
                col++;
            }
            if (col == coords[0][1] && startNum == -1) {
                startNum = i;
            }

            if (col - 1 == coords[1][1] && endNum == -1) {
                endNum = i;
            }
        }
        for (int i = startIndex; i <= endIndex; i++) {
            char[] chars = table[i].toCharArray();
            for (int j = startNum; j <= endNum; j++) {
                if (i == startIndex && j == startNum || i == startIndex && j == endNum || i == endIndex && j == startNum || i == endIndex && j == endNum) {
                    continue;
                }
                if (i == startIndex || i == endIndex) {
                    if (i == 0 || i == table.length - 1) {
                        chars[j] = '-';
                    }
                    continue;
                }
                if (j == startNum || j == endNum) {
                    if (j == 0 || j == chars.length - 1) {
                        chars[j] = '|';
                    }
                    continue;
                }
                if (chars[j] == '+' || chars[j] == '|' || chars[j] == '-') {
                    chars[j] = ' ';
                }
            }
            table[i] = new String(chars);
        }

        return table;
    }

    int firstOperationCharacter(String expr) {
        int brackets = 0;
        int resultPlus = -1;
        int resultMult = -1;
        int indexPlus = -1;
        int indexMult = -1;
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(') {
                brackets++;
            }
            if (ch == ')') {
                brackets--;
            }
            if (ch == '+') {
                if (brackets > resultPlus) {
                    resultPlus = brackets;
                    indexPlus = i;
                }
            }
            if (ch == '*') {
                if (brackets > resultMult) {
                    resultMult = brackets;
                    indexMult = i;
                }
            }
        }
        if (resultPlus > resultMult) {
            return indexPlus;
        } else {
            return indexMult;
        }
    }

    int countElements(String inputString) {
        Pattern p = Pattern.compile("((\".*?\\\")|(true)|(false)|(\\d+))");
        Matcher matcher = p.matcher(inputString);
        int res = 0;
        while (matcher.find()) {
            res++;
        }
        return res;
    }

    int[] treeBottom(String tree) {
        tree = tree.replaceAll("\\(\\)", "");
        Stack<Integer> stack = new Stack<Integer>();
        int height = 0;
        List<Integer> res = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < tree.length(); i++) {
            char ch = tree.charAt(i);
            if (ch == '(' || ch == ' ') {
                if (cur != 0) {
                    stack.push(cur);
                    cur = 0;
                }
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                cur = cur * 10 + (ch - '0');
            }
            if (ch == ')') {
                int curHeight = stack.size();
                int s = stack.pop();
                if (curHeight == height) {
                    res.add(s);
                } else if (curHeight > height) {
                    res.clear();
                    ;
                    height = curHeight;
                    res.add(s);
                }
            }
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    String befunge93(String[] program) {
        Stack<Integer> stack = new Stack<>();
        int row = 0;
        int col = 0;
        int a = 0;
        int b = 0;
        int colDirection = 1;
        int rowDirection = 0;
        boolean isString = false;
        StringBuilder sb = new StringBuilder();
        boolean isRunning = true;
        int totalCommands = 0;
        while (isRunning && sb.length() < 100 && totalCommands++ < 100000) {
            char ch = program[row].charAt(col);

            if (isString) {
                if (ch == '"') {
                    isString = false;
                } else {
                    stack.push((int) ch);
                }
            } else {
                switch (ch) {
                    case '>':
                        colDirection = 1;
                        rowDirection = 0;
                        break;
                    case '<':
                        colDirection = -1;
                        rowDirection = 0;
                        break;
                    case 'v':
                        colDirection = 0;
                        rowDirection = 1;
                        break;
                    case '^':
                        rowDirection = -1;
                        colDirection = 0;
                        break;
                    case '#':
                        col += colDirection;
                        row += rowDirection;
                        break;
                    case '_':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        rowDirection = 0;
                        if (a == 0) {
                            colDirection = 1;
                        } else {
                            colDirection = -1;
                        }
                        break;
                    case '|':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        colDirection = 0;
                        if (a == 0) {
                            rowDirection = 1;
                        } else {
                            rowDirection = -1;
                        }
                        break;
                    case '+':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        b = stack.isEmpty() ? 0 : stack.pop();
                        stack.push(a + b);
                        break;
                    case '-':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        b = stack.isEmpty() ? 0 : stack.pop();
                        stack.push(b - a);
                        break;
                    case '*':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        b = stack.isEmpty() ? 0 : stack.pop();
                        stack.push(a * b);
                        break;
                    case '/':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        b = stack.isEmpty() ? 0 : stack.pop();
                        stack.push(b / a);
                        break;
                    case '%':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        b = stack.isEmpty() ? 0 : stack.pop();
                        stack.push(b % a);
                        break;
                    case '!':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        stack.push(a == 0 ? 1 : 0);
                        break;
                    case '`':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        b = stack.isEmpty() ? 0 : stack.pop();
                        stack.push(b > a ? 1 : 0);
                        break;
                    case ':':
                        a = stack.isEmpty() ? 0 : stack.peek();
                        stack.push(a);
                        break;
                    case '\\':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        b = stack.isEmpty() ? 0 : stack.pop();
                        stack.push(a);
                        stack.push(b);
                        break;
                    case '$':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        break;
                    case '.':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        sb.append(a).append(' ');
                        break;
                    case ',':
                        a = stack.isEmpty() ? 0 : stack.pop();
                        sb.append((char) a);
                        break;
                    case ' ':
                        break;
                    case '"':
                        isString = !isString;
                        break;
                    case '@':
                        isRunning = false;
                        break;
                    default:
                        a = ch - '0';
                        stack.push(a);
                }
            }
            col += colDirection;
            row += rowDirection;
            if (col < 0) {
                col = program[0].length() - 1;
            }
            if (col >= program[0].length()) {
                col = 0;
            }
            if (row < 0) {
                row = program.length - 1;
            }
            if (row >= program.length) {
                row = 0;
            }
        }
        return sb.toString();
    }


}
