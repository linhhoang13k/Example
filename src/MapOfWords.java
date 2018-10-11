package com.sleepsoft.challenges;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by agerm on 12/16/2016.
 */
public class MapOfWords {
    public Map<String, Long> fileWordCount(String originalText){

        String[] cleanTextArray = originalText.toLowerCase().split("\\W+");
        Map<String, Long> resultMap =
                Arrays.stream(cleanTextArray).collect(
                    Collectors.groupingBy(
                            Function.identity(), Collectors.counting()
                    )
                );

        Map<String, Long>finalMap=new LinkedHashMap<>();
        resultMap.entrySet().stream().sorted(
                Map.Entry.comparingByValue()).forEachOrdered(e->finalMap.put(e.getKey(), e.getValue())
        );
        return finalMap;
    }

    @Test
    public void test_1(){
        String string= new String("This, is a test; we are using. a to the test the test");
        System.out.println(fileWordCount(string));
    }
}
