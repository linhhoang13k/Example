package com.codefights.arcade.intro;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zambro on 4/26/17.
 * You are given an array of desired filenames in the order of their creation. Since two files cannot have equal names, the one which comes later will have an addition to its name in a form of (k), where k is the smallest positive integer such that the obtained name is not used yet.

 Return an array of names that will be given to the files.

 Example

 For names = ["doc", "doc", "image", "doc(1)", "doc"], the output should be
 fileNaming(names) = ["doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"].
 */
public class FileNaming {

    public static String[] fileNaming(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i<names.length;i++){
            if(!map.containsKey(names[i])){
                map.put(names[i], 1);
            } else {
                int number = map.get(names[i]);
                String newName = names[i] + "("+ number+")";
                number++;
                while(map.containsKey(newName)){
                    newName = names[i] + "("+ number+")";
                    number++;
                }
                map.put(names[i],number);
                map.put(newName, 1);
                names[i] = newName;
            }
        }

        return names;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(fileNaming(new String[]{"doc", "doc", "image", "doc(1)", "doc"})));
        System.out.println(Arrays.toString(fileNaming(new String[]{"a(1)",  "a(6)",  "a",  "a",  "a",  "a",  "a",  "a",  "a",  "a",  "a",  "a"})));
        System.out.println(Arrays.toString(fileNaming(new String[]{"dd",  "dd(1)",  "dd(2)",  "dd",  "dd(1)",  "dd(1)(2)",  "dd(1)(1)",  "dd",  "dd(1)"})));
    }

}
