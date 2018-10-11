package com.example.trungnguyen.interviewpratice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        rotateImage(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        boolean isValid = isCryptSolution(new String[]{"WASD", "IJKL", "OPAS"}, new char[][]{
                {'W', '2'},
                {'A', '0'},
                {'S', '4'},
                {'D', '1'},
                {'I', '5'},
                {'J', '8'},
                {'K', '6'},
                {'L', '3'},
                {'O', '7'},
                {'P', '9'}});

        Log.v(Main2Activity.class.getSimpleName(), "Ahhiih output: " + isValid);
    }

    int[][] rotateImage(int[][] a) {
        int[][] b = new int[a.length][a[0].length];
        int tempSize = a.length - 1;
        for (int parentIndex = 0; parentIndex < a.length; parentIndex++) {
            for (int childIndex = 0; childIndex < a[parentIndex].length; childIndex++) {
                a[parentIndex][childIndex] = b[tempSize - childIndex][parentIndex];
            }
        }
        return a;
    }

    boolean sudoku2(char[][] grid) {
        ArrayList<HashSet<Character>> colHashSet = new ArrayList<>();
        for (int hashIndex = 0; hashIndex < 9; hashIndex++) {
            colHashSet.add(hashIndex, null);
        }

        HashSet<Character> rowHashSet = new HashSet<>();
        //check 3x3 box exists
        for (int rowIndex = 0; rowIndex < 3; ++rowIndex) {
            for (int colIndex = 0; colIndex < 3; ++colIndex) {
                Set<Character> boxExists = new HashSet<>();
                for (int k = 0; k < 3; ++k) {
                    int row = rowIndex * 3 + k;
                    for (int k2 = 0; k2 < 3; ++k2) {
                        int col = colIndex * 3 + k2;
                        char tmpChar = grid[row][col];
                        if (tmpChar != '.') {
                            if (boxExists.contains(tmpChar)) {
                                return false;
                            }
                            boxExists.add(tmpChar);
                        }
                    }
                }
            }
        }

        //check row and column exists
        for (char[] aGrid : grid) {
            for (int childIndex = 0; childIndex < aGrid.length; childIndex++) {
                if (colHashSet.get(childIndex) == null)
                    colHashSet.set(childIndex, new HashSet<Character>());
                char tmpElement = aGrid[childIndex];
                if (tmpElement != '.') {
                    if (!rowHashSet.contains(tmpElement)) rowHashSet.add(tmpElement);
                    else return false;
                    if (colHashSet.get(childIndex).contains(tmpElement)) return false;
                    else colHashSet.get(childIndex).add(tmpElement);
                }
            }
            if (rowHashSet.size() > 0)
                rowHashSet.clear();
        }
        return true;
    }

    boolean isCryptSolution(String[] crypt, char[][] solution) {
        Map<Character, Character> characterMap = new HashMap<>();
        String[] cryptArray = new String[crypt.length];
        for (int cryptIndex = 0; cryptIndex < crypt.length; cryptIndex++) {
            cryptArray[cryptIndex] = "";
            for (int strIndex = 0; strIndex < crypt[cryptIndex].length(); strIndex++) {
                char tmpChar = crypt[cryptIndex].charAt(strIndex);
                if (characterMap.containsKey(tmpChar)) {
                    cryptArray[cryptIndex] += characterMap.get(tmpChar);
                } else {
                    for (char[] solutionElement : solution) {
                        char key = solutionElement[0];
                        char value = solutionElement[1];
                        if (tmpChar == key) {
                            cryptArray[cryptIndex] += value;
                        }
                        if (!characterMap.containsValue(tmpChar)) {
                            characterMap.put(key, value);
                        }
                    }
                }
            }
        }
        if ((cryptArray[0].charAt(0) == '0' && (cryptArray[0].length() > 1))
                || (cryptArray[1].charAt(0) == '0' && (cryptArray[1].length() > 1))
                || (cryptArray[2].charAt(0) == '0' && (cryptArray[2].length() > 1))) return false;
        else
            return Long.parseLong(cryptArray[0]) + Long.parseLong(cryptArray[1]) == Long.parseLong(cryptArray[2]);
    }

    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    ListNode<Integer> removeKFromList(ListNode<Integer> list, int removeValue) {
        ListNode<Integer> copiedList = list;
        ListNode<Integer> prevList = null;
        while (copiedList != null) {
            if (copiedList.value == removeValue) {
                if (prevList != null) {
                    prevList.next = copiedList.next;
                } else {
                    list = copiedList.next;
                }
            } else {
                prevList = copiedList;
            }
            copiedList = copiedList.next;
        }
        return list;
    }
}
