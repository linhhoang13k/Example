package evg.codefights.core;

import java.util.*;

public class LabyrinthOfNestedLoops {

    int isSumOfConsecutive2(int n) {
        int low = 1;
        int high = 2;
        int sum = low + high;
        int res = 0;
        while (low < high) {
            if (sum == n) {
                res++;
            }
            if (sum >= n) {
                sum -= low;
                low++;
            }
            if (sum < n) {
                high++;
                sum += high;
            }
        }
        return res;
    }

    int squareDigitsSequence(int a0) {
        int cur = a0;
        int sum = 0;
        int res = 1;
        Set<Integer> set = new HashSet<>();
        while (!set.contains(cur)) {
            set.add(cur);
            while (cur != 0) {
                int a = cur % 10;
                cur /= 10;
                sum += a * a;
            }
            cur = sum;
            sum = 0;
            res++;
        }

        return res;
    }

    int pagesNumberingWithInk(int current, int numberOfDigits) {
        int curLen = 0;
        int tmp = current;
        while (tmp != 0) {
            curLen++;
            tmp /= 10;
        }
        int res = current - 1;
        while (numberOfDigits >= String.valueOf(current).length()) {
            res++;
            numberOfDigits -= String.valueOf(current++).length();
        }

        return res;
    }

    int comfortableNumbers(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++) {
            int s = S(i);
            int a2 = i + s;
            for (int j = i + 1; j <= a2 && j <= R; j++) {
                if (isConf(i, j)) {
                    res++;
                }
            }
        }

        return res;
    }

    boolean isConf(int a, int b) {
        int s = S(b);
        return (b - s <= a) && (b + s >= a);
    }

    int S(int i) {
        int r = 0;
        while (i != 0) {
            r += i % 10;
            i /= 10;
        }
        return r;
    }

    int[] weakNumbers(int n) {
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        int prevWeak = 0;
        int prevWeakCount = 0;
        for (int i = 1; i <= n; i++) {
            int d = calcDividers(i);
            int weakness = map2.tailMap(d, false).entrySet().stream().mapToInt(Map.Entry::getValue).sum();
            if (weakness > prevWeak) {
                prevWeak = weakness;
                prevWeakCount = 1;
            } else if (weakness == prevWeak) {
                prevWeakCount++;
            }
            if (map2.containsKey(d)) {
                map2.put(d, map2.get(d) + 1);
            } else {
                map2.put(d, 1);
            }

        }
        return new int[]{prevWeak, prevWeakCount};
    }

    int calcDividers(int n) {
        int res = n == 1 ? 1 : 2;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int k = n / i;
                res++;
                if (k != i) {
                    res++;
                }
            }
        }
        return res;
    }

    int rectangleRotation(int a, int b) {
        int res = 0;
        for (int x = -a - b; x <= a + b; x++) {
            for (int y = -a - b; y <= a + b; y++) {
                if (2 * (x - y) * (x - y) <= a * a && 2 * (x + y) * (x + y) <= b * b) {
                    res++;
                }
            }
        }
        return res;
    }

    int crosswordFormation(String[] words) {
        return permutation(0, words);
    }

    int permutation(int k, String[] words) {
        int res = 0;
        for (int i = k; i < words.length; i++) {
            swap(words, k, i);
            res += permutation(k + 1, words);
            swap(words, k, i);
        }
        if (k == words.length - 1) {
            res += check(words);

        }

        return res;
    }

    int check(String[] words) {
        int result = 0;
        for (int v1 = 0; v1 < words[0].length(); v1++) {
            for (int h1 = 0; h1 < words[1].length(); h1++) {
                if (words[0].charAt(v1) != words[1].charAt(h1)) {
                    continue;
                }
                for (int h11 = h1 + 2; h11 < words[1].length(); h11++) {
                    for (int v2 = 0; v2 < words[2].length(); v2++) {
                        if (words[2].charAt(v2) != words[1].charAt(h11)) {
                            continue;
                        }
                        int diff = h11 - h1;
                        for (int v_all = 2; v_all < words[0].length() - v1 && v_all < words[2].length() - v2; v_all++) {
                            for (int z = 0; z < words[3].length() - diff; z++) {
                                char ch1 = words[3].charAt(z);
                                char ch2 = words[3].charAt(z + diff);
                                if (ch1 == words[0].charAt(v1 + v_all) && ch2 == words[2].charAt(v2 + v_all)) {
                                    result++;
                                }
                            }

                        }
                    }
                }
            }
        }
        return result;

    }

    void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
