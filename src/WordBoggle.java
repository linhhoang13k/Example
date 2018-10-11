package HackerRank;

import java.util.*;

/**
 * Created by POWERHOUSE on 5/21/2018.
 */
public class WordBoggle {
    Map<Character, Set<Integer>> map = new HashMap<>();
    Map<Integer, List<Integer>> neighbours = new HashMap<>();
    int len, tot;

    String[] wordBoggle(char[][] board, String[] words) {
        makeMap(board);
        len=board[0].length;
        tot=len*board.length;
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<words.length;i++) {
            if(checkPresence(words[i]))
                result.add(words[i]);
        }
        String[] arr = result.toArray(new String[result.size()]);
        Arrays.sort(arr);
        return arr;
    }

    boolean checkPresence(String word) {

        if(word.length()==0)
            return true;
        else {
            char c= word.charAt(0);
            if(map.containsKey(c)) {
                Set<Integer> key=map.get(c);
                for(int k:key) {
                    Set<Integer> visited=new HashSet<>();
                    visited.add(k);
                    if(recurse(word.substring(1), visited, k))
                        return true;
                    visited.remove(k);
                }
                return false;
            }
            else
                return false;
        }
    }

    boolean recurse(String word, Set<Integer> visited, int code) {
        if(word.length()==0)
            return true;
        else {
            char c= word.charAt(0);
            if(map.containsKey(c)) {
                Set<Integer> key=map.get(c);
                List<Integer> neigh;
                if(neighbours.containsKey(code))
                    neigh = neighbours.get(code);
                else
                    neigh = getNeighBours(code);
                for(int i:neigh) {
                    if(key.contains(i) && !visited.contains(i)) {
                        visited.add(i);
                        if(recurse(word.substring(1), visited, i))
                            return true;
                        visited.remove(i);
                    }

                }
                return false;
            }
            else
                return false;
        }
    }

    void makeMap(char[][] board) {
        int counter=0;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(map.containsKey(board[i][j])) {
                    Set<Integer> set = map.get(board[i][j]);
                    set.add(counter);
                }
                else {
                    Set<Integer> set = new HashSet<>();
                    set.add(counter);
                    map.put(board[i][j], set);
                }
                counter++;
            }
        }
    }

    List<Integer> getNeighBours(int i) {
        List<Integer> res = new ArrayList<>();
        int[] result = {i-len-1, i-1, i+len-1, i-len, i+len, i-len+1, i+1, i+len+1};

        int count=0;
        for(int k:result) {
            if(k>=0 && k<tot) {
                if (i % len == 0) {
                    if(count>2) {
                        res.add(k);
                    }
                }
                else if ((i + 1) % len == 0) {
                    if(count<5) {
                        res.add(k);
                    }
                }
                else {
                    res.add(k);
                }
            }
            count++;
        }
        neighbours.put(i,res);
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'R', 'L', 'D'},
                {'U', 'O', 'E'},
                {'C', 'S', 'O'}};

        String[] words = {"CODE", "SOLO", "RULES", "COOL"};
        WordBoggle obj = new WordBoggle();
        String[] result = obj.wordBoggle(board, words);
        for(String s:result)
            System.out.println(s);
    }

}
