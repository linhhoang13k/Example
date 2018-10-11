package evg.codefights.core;

import java.util.*;
import java.util.stream.*;

public class CliffsOfPain {

    public static void main(String[] args) {
        printArray(new CliffsOfPain().game2048(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 2, 2},
                {0, 0, 2, 4},
                {2, 2, 4, 8}
        }, "DD"));
    }

    static void printArray(int[][] grid) {
        for (int[] ints : grid) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("");
    }

    int pipesGame(String[] state) {
        Deque<Node> queue = new LinkedList<>();
        Map<Integer, Set<Character>> allowDirection = new HashMap<>();
        allowDirection.put(0, Stream.of('1', '3', '4', '7').collect(Collectors.toSet()));
        allowDirection.put(1, Stream.of('1', '5', '6', '7').collect(Collectors.toSet()));
        allowDirection.put(2, Stream.of('2', '3', '6', '7').collect(Collectors.toSet()));
        allowDirection.put(3, Stream.of('2', '4', '5', '7').collect(Collectors.toSet()));
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length(); j++) {
                char ch = state[i].charAt(j);
                if (ch >= 'a' && ch <= 'z') {
                    queue.add(new Node(i, j, 0, ch, -1));
                }
            }
        }
        Set<Node> water = new HashSet<>();
        int lastLevel = 0;
        boolean[] processed = new boolean[26];
        int currentLevel = 0;
        int total = 0;
        boolean isPoison = false;
        while (!queue.isEmpty()) {
            Node node = queue.removeFirst();
            isPoison = node.x == -1;
            if (lastLevel != node.level) {
                total += currentLevel;
                currentLevel = 0;
            }
            if (isPoison) {
                break;
            }
            lastLevel = node.level;

            char ch = state[node.x].charAt(node.y);
            if (ch >= '1' && ch <= '7') {
                boolean isAdded = water.add(node);
                if (isAdded) {
                    currentLevel++;
                }
            }
            if (ch >= 'A' && ch <= 'Z') {
                if (ch - 'A' == node.pipe - 'a') {
                    if (!processed[node.pipe - 'a']) {
                        processed[node.pipe - 'a'] = true;
                    }
                } else {
                    queue.addFirst(new Node(-1, -1, node.level, node.pipe, node.direction));
                }
            } else if (ch >= 'a' && ch <= 'z') {
                if (node.x - 1 >= 0 && allowDirection.get(0).contains(state[node.x - 1].charAt(node.y))) {
                    queue.addLast(new Node(node.x - 1, node.y, node.level + 1, node.pipe, 0));
                }
                if (node.x + 1 < state.length && allowDirection.get(1).contains(state[node.x + 1].charAt(node.y))) {
                    queue.addLast(new Node(node.x + 1, node.y, node.level + 1, node.pipe, 1));
                }
                if (node.y - 1 >= 0 && allowDirection.get(2).contains(state[node.x].charAt(node.y - 1))) {
                    queue.addLast(new Node(node.x, node.y - 1, node.level + 1, node.pipe, 2));
                }
                if (node.y + 1 < state[node.x].length() && allowDirection.get(3).contains(state[node.x].charAt(node.y + 1))) {
                    queue.addLast(new Node(node.x, node.y + 1, node.level + 1, node.pipe, 3));
                }
            } else if (ch == '0') {
                queue.addFirst(new Node(-1, -1, node.level, node.pipe, node.direction));
            } else if (ch == '1') {
                if (node.direction == 1) {
                    if (node.x + 1 < state.length) {
                        queue.addLast(new Node(node.x + 1, node.y, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 0) {
                    if (node.x - 1 >= 0) {
                        queue.addLast(new Node(node.x - 1, node.y, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }

            } else if (ch == '2') {
                if (node.direction == 3) {
                    if (node.y + 1 < state[node.x].length()) {
                        queue.addLast(new Node(node.x, node.y + 1, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 2) {
                    if (node.y - 1 >= 0) {
                        queue.addLast(new Node(node.x, node.y - 1, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            } else if (ch == '3') {
                if (node.direction == 0) {
                    if (node.y + 1 < state[node.x].length()) {
                        queue.addLast(new Node(node.x, node.y + 1, node.level + 1, node.pipe, 3));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 2) {
                    if (node.x + 1 < state.length) {
                        queue.addLast(new Node(node.x + 1, node.y, node.level + 1, node.pipe, 1));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            } else if (ch == '4') {
                if (node.direction == 3) {
                    if (node.x + 1 < state.length) {
                        queue.addLast(new Node(node.x + 1, node.y, node.level + 1, node.pipe, 1));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 0) {
                    if (node.y - 1 >= 0) {
                        queue.addLast(new Node(node.x, node.y - 1, node.level + 1, node.pipe, 2));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            } else if (ch == '5') {
                if (node.direction == 3) {
                    if (node.x - 1 >= 0) {
                        queue.addLast(new Node(node.x - 1, node.y, node.level + 1, node.pipe, 0));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 1) {
                    if (node.y - 1 >= 0) {
                        queue.addLast(new Node(node.x, node.y - 1, node.level + 1, node.pipe, 2));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            } else if (ch == '6') {
                if (node.direction == 2) {
                    if (node.x - 1 >= 0) {
                        queue.addLast(new Node(node.x - 1, node.y, node.level + 1, node.pipe, 0));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 1) {
                    if (node.y + 1 < state[node.x].length()) {
                        queue.addLast(new Node(node.x, node.y + 1, node.level + 1, node.pipe, 3));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            } else if (ch == '7') {
                if (node.direction == 1) {
                    if (node.x + 1 < state.length) {
                        queue.addLast(new Node(node.x + 1, node.y, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 0) {
                    if (node.x - 1 >= 0) {
                        queue.addLast(new Node(node.x - 1, node.y, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 3) {
                    if (node.y + 1 < state[node.x].length()) {
                        queue.addLast(new Node(node.x, node.y + 1, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
                if (node.direction == 2) {
                    if (node.y - 1 >= 0) {
                        queue.addLast(new Node(node.x, node.y - 1, node.level + 1, node.pipe, node.direction));
                    } else {
                        queue.addLast(new Node(-1, -1, node.level + 1, node.pipe, node.direction));
                    }
                }
            }
        }
        return isPoison ? -total : total;
    }

    int[][] game2048(int[][] grid, String path) {
        char[] paths = path.toCharArray();
        for (char c : paths) {
            boolean isRow = c == 'R' || c == 'L';
            int start = c == 'R' || c == 'D' ? 3 : 0;
            int end = c == 'R' || c == 'D' ? 0 : 3;
            int add = start < end ? 1 : -1;
            for (int i = 0; i < grid.length; i++) {
                int posx = isRow ? i : start;
                int posy = isRow ? start : i;
                int v1x = -1;
                int v1y = -1;
                for (int j = start; add == -1 ? j >= end : j <= end; j += add) {
                    int x, y;
                    if (isRow) {
                        x = i;
                        y = j;
                    } else {
                        x = j;
                        y = i;
                    }
                    if (grid[x][y] != 0) {
                        if (v1y == -1) {
                            v1x = x;
                            v1y = y;
                            continue;
                        }
                        if (grid[v1x][v1y] == grid[x][y]) {
                            int tmp = grid[x][y];
                            grid[v1x][v1y] = 0;
                            grid[x][y] = 0;
                            grid[posx][posy] = tmp * 2;
                            if (isRow) {
                                posy += add;
                            } else {
                                posx += add;
                            }
                            v1y = -1;
                        } else {
                            int tmp = grid[v1x][v1y];
                            grid[v1x][v1y] = 0;
                            grid[posx][posy] = tmp;
                            if (isRow) {
                                posy += add;
                            } else {
                                posx += add;
                            }
                            tmp = grid[x][y];
                            grid[x][y] = 0;
                            grid[posx][posy] = tmp;
                            v1y = posy;
                            v1x = posx;
                        }
                    }
                }
                if (v1y != -1) {
                    int tmp = grid[v1x][v1y];
                    grid[v1x][v1y] = 0;
                    grid[posx][posy] = tmp;
                }
            }
        }
        return grid;
    }

    static class Node {
        int x;
        int y;
        int level;
        int direction; //0 up, 1 down, 2 left, 3 right
        char pipe;

        Node(int x, int y, int level, char pipe, int direction) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.pipe = pipe;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


}
