package challenge;

import java.util.*;

/**
 * Created by JavierSainz on 1/25/17.
 * Christmas is over, which means that production of next year’s toys has already begun. To make all these toys, the elves need raw materials. These raw materials arrive to the North Pole in constant streams during the month of January. Nowadays North Pole is known for its amazingly fast production system, and well developed urban infrastructure, but the route used to deliver raw materials is very obsolete. They are developing better traffic technology, but up until now, the raw materials traffic has been controlled by one traffic elf and his countdown watch.
 * <p>
 * The traffic elf has a watch that continually counts down, and when the watch gets to zero, the elf stops traffic from one way and starts the flow of traffic from the other way. The watch has two seven segment numbers, and starts at a number and will countdown to zero. This elf has had this watch for over 120 years, so it came to no surprise when the watch started acting weird, and the top half of each seven segment number disappeared. Now that the watch shows only the bottom three segments, it’s hard for the elf to direct traffic, but it’s a good thing Santa’s elves are magical and have high functioning brains that allow for actual multitasking. The elf wants to know what time the countdown starts at, so he can figure out when he should change traffic without having to stare directly at his watch.
 * <p>
 * Here's what a seven segment display of digit 8 used to look like vs how it looks now:
 * <p>
 * Seven Segment Display Broken Seven Segment Display
 * <p>
 * The numbers used in this challenge are in the following format:
 * <p>
 * <p>
 * You are given an array of strings with two digit seven segment numbers in descending order. The first string in the array represents the time when the timer started, and each of the following strings represent the number that goes after the previous during a countdown. The array does not necessarily contain all the numbers from the n to 0.
 * <p>
 * Your task is to return the first number in the countdown sequence. Obviously, it's not always possible to determine the answer, so if there are several possible starting numbers you should return them all in descending order.
 * <p>
 * Example
 * <p>
 * For countdown=["****_|","*****|","****_|","***|_*","*****|","***|_|"],
 * the output should be
 * northPoleTrafficClock(countdown) = [5].
 * <p>
 * Here's the sequence the given array represents:
 * Example 1 Explanation
 * <p>
 * For countdown=["**|**|","**||_|","**|**|"],
 * the output should be
 * northPoleTrafficClock(countdown) = [99, 79, 49, 19].
 * <p>
 * Input/Output
 * <p>
 * [time limit] 3000ms (java)
 * [input] array.string countdown
 * <p>
 * An array of strings representing pairs of seven segment numbers. Each digit is given as in the format edc, where letters stand for segments. Active segments a and c are denoted by |, and active segment d is denoted by _.
 * A disabled segment is denoted by *.
 * <p>
 * For example, number 88 will be formatted “|_||_|”, and number 19 will be given as “**|*_|”.
 * <p>
 * Constraints:
 * 1 ≤ countdown[i].length ≤ 99,
 * countdown[i].length = 6,
 * 0 ≤ number(countdown[i]) ≤ 99,
 * number(countdown[i]) = number(countdown[i+1]) + 1.
 * <p>
 * [output] array.integer
 * <p>
 * An array of possible starting points of the countdown in descending order.
 * <p>
 * It is guaranteed that the given countdown is valid, i.e. the output will contain at least one element.
 */
public class NorthPoleTrafficClock {
    int[] northPoleTrafficClockClean(String[] countdown) {
        Map<String, int[]> map = new HashMap<String, int[]>() {{
            put("|_|", new int[]{0, 6, 8});
            put("**|", new int[]{1, 4, 7, 9});
            put("|_*", new int[]{2});
            put("*_|", new int[]{3, 5});
            put("***", new int[]{0});
        }};
        List<Integer> initials = makeAllInitialCombinations(countdown[0], map);
        for (int i = 1; i < countdown.length; i++) {
            if (initials.size() == 1) {
                break;
            }
            for (Iterator<Integer> it = initials.iterator(); it.hasNext(); ) {
                int number = it.next() - i;
                String nextCountdownNumber = countdown[i];
                boolean stillValid = Arrays.binarySearch(map.get(nextCountdownNumber.substring(0, 3)), number / 10) > -1 &&
                        Arrays.binarySearch(map.get(nextCountdownNumber.substring(3)), number % 10) > -1;
                if (!stillValid) {
                    it.remove();
                }
            }
        }
        return initials.stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
    }

    List<Integer> makeAllInitialCombinations(String number, Map<String, int[]> map) {
        int[] firstNumbers = map.get(number.substring(0, 3));
        int[] secondNumbers = map.get(number.substring(3));
        List<Integer> values = new ArrayList<>(firstNumbers.length * secondNumbers.length);
        for (int i = 0; i < firstNumbers.length; i++) {
            for (int j = 0; j < secondNumbers.length; j++) {
                values.add(firstNumbers[i] * 10 + secondNumbers[j]);
            }
        }
        return values;
    }

    int[] northPoleTrafficClock(String[] c) {
        Map<String, int[]> m = new HashMap<String, int[]>() {{
            put("|_|", new int[]{0, 6, 8});
            put("**|", new int[]{1, 4, 7, 9});
            put("|_*", new int[]{2});
            put("*_|", new int[]{3, 5});
            put("***", new int[]{0});
        }};
        List<Integer> v = new ArrayList<>();
        for (int i : m.get(c[0].substring(0, 3)))
            for (int j : m.get(c[0].substring(3)))
                v.add(i * 10 + j);

        for (int i = 1, n; i < c.length; i++)
            for (Iterator<Integer> t = v.iterator(); t.hasNext(); )
                if (Arrays.binarySearch(m.get(c[i].substring(0, 3)), (n = t.next() - i) / 10) < 0 |
                        Arrays.binarySearch(m.get(c[i].substring(3)), n % 10) < 0)
                    t.remove();
        return v.stream().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();
    }

    //***Winner Solution
    int c, i = 100, s[] = new int[i];

    int[] northPoleTrafficClockWinner(String[] d) {
        String[] o = "|_| **| |_* *_| **| *_| |_| **| |_| **|                                                                                          *".split(" ");
        while (i-- > 0)
            s[i] = 99 - i;

        for (String q : d) {
            s = Arrays.stream(s).filter(x -> (x -= c) >= 0 &&
                    q.equals("***" + o[x]) |
                            q.equals(o[x / 10] + o[x % 10])).toArray();
            c++;
        }

        return s;
    }
    //***Winner Solution

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NorthPoleTrafficClock().northPoleTrafficClockWinner(new String[]{
                "**||_*",
                "**|**|"
        })));
    }
}
