package com.sleepsoft.challenges;

import org.junit.Test;

import java.util.*;

/**
 * Created by agermenos on 10/2/2016.
 */
/*
You're given an array of names, where each name is given as a string. Your task is to link these names into a chain, so that the ith name starts with the same letter the (i - 1)th name ends, and return this chain as a list.

All names should be used. It is guaranteed that each name starts with a unique letter. It is also guaranteed that there is only one solution.

Example

For

names = ["Raymond",  "Nora", "Daniel",
         "Louie", "Peter", "Esteban"]
the output should be

chainNames(names) = ["Peter", "Raymond", "Daniel",
                     "Louie", "Esteban", "Nora"]
Input/Output

[time limit] 3000ms (java)
[input] array.string names

Array of names, where each name starts with a unique letter.

Constraints:
1 ≤ names.length ≤ 15,
1 ≤ names[i].length ≤ 10.

[output] array.string

Array of chained names.
 */
public class NameChainer {
    public String[] chainNames(String[] names){
        LinkedList<String> deque = new LinkedList<>();
        deque.add(names[0]);
        deque = getList(names[0], names, deque);
        return deque.toArray(new String[]{});
    }

    public LinkedList<String> getList(String name, String[] names, LinkedList<String> deque){
        ArrayList<String> rudeList = new ArrayList<>(Arrays.asList(names));
        rudeList.remove(name);
        Optional<String> oStartName = rudeList.stream().filter(sName -> sName.endsWith(Character.toLowerCase(name.charAt(0))+"")).findAny();
        Optional<String> oEndName = rudeList.stream().filter(sName->sName.startsWith(Character.toUpperCase(name.charAt(name.length()-1)) + "")).findAny();
        if (oStartName.isPresent()) {
            deque.addFirst(oStartName.get());
            // try getting something above?
            deque = getList(oStartName.get(), rudeList.toArray(new String[]{}), deque);
        }
        if (oEndName.isPresent()) {
            deque.addLast(oEndName.get());
            // try getting something below?
            deque = getList(oEndName.get(), rudeList.toArray(new String[]{}), deque);
        }
        return deque;
    }

    private void prepare(String[] input){
        System.out.println ("INPUT:");
        System.out.println(Arrays.toString(input));
        System.out.println("\nchainNames:");
        System.out.println(Arrays.toString(chainNames(input)));
    }

    @Test
    public void test_1(){
        String[] input = new String[] {"Raymond",  "Nora", "Daniel",
                "Louie", "Peter", "Esteban"};
        prepare(input);
    }
}

