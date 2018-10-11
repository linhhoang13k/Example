package com.pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zambro on 5/15/17.
 *
 * input:  dict = {
 Key1 : 1,
 Key2 : {
 a : 2,
 b : 3,
 c : {
 d : 3,
 e : 1
 }
 }
 }

 output: {
 Key1: 1,
 Key2.a: 2,
 Key2.b : 3,
 Key2.c.d : 3,
 Key2.c.e : 1
 }
 Important: when you concatenate keys, make sure to add the dot character between them. For instance contacting Key2, c and d the result key would be Key2.c.d.
 */
public class FlattenDictionary {

    public static Map<String,Integer> flatten(Map<Object, Object> map) {
        if(map == null) return  null;
        Map<String, Integer> resultMap = new HashMap<>();
        flatten(map, "", resultMap);
        return resultMap;
    }

    private static void flatten(Map<Object, Object> map, String prefix, Map<String, Integer> resultMap) {
        for(Map.Entry<Object, Object> entry:map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if(value instanceof Integer){
                resultMap.put(prefix == ""?(String)key:prefix+"."+key, (Integer)value);
            } else {
                flatten((Map<Object, Object>) value, prefix == ""?(String)key:prefix+"."+key, resultMap);
            }
        }
    }

    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        map.put("Key1", 1);
        Map<Object, Object> key2 = new HashMap<>();
        key2.put("a", 2);
        key2.put("b", 3);
        Map<Object, Object> c = new HashMap<>();
        c.put("d", 3);
        c.put("e", 1);
        key2.put("c", c);
        map.put("Key2",key2);
        map.put("x", 100);
        Map<String, Integer> resultMap = flatten(map);
        System.out.println(resultMap);
        for(Map.Entry<String, Integer> entry:resultMap.entrySet())
            System.out.println(entry.getKey()+":"+entry.getValue());
    }


    /**
     *
     * for(K,V:map)
     *      Check if value is null or intance of integer
     *          add K.prefix, value to result Map
     *
     *      If value is instance of map
     *          prefix = prefix.K
     *          recursive call => (value as map, prefix)
     *
     *
     *
     */

}
