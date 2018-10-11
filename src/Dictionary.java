package Testing;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Dict implements DictEntry {

    private Map<String, DictEntry> map;

    public  Dict(){

    }

    public Dict(Map<String, DictEntry> map) {
        this.map = map;
    }

    public Dict(String json) {
        //ex:{a:apple, b:{b:blueberry,c:{d:grape,e:tomato}}, c:{d:orange}}}
        map = new HashMap<String, DictEntry>();
        int[] stk = new int[json.length()/2];
        int idx=-1;
        char[] chars = json.toCharArray();
        for(int i=0;i<chars.length;i++){
            switch (chars[i]){
                case '{':
                    stk[++idx]=i;
                    break;
                case '}':
                    String[] strings = json.substring(stk[idx--]+1,i).split(",");
                    for(String str:strings){
                        int semi_colon_idx = str.indexOf(":");
                        DictEntry dictEntry;
                        if(chars[semi_colon_idx+1]=='{'){
                            dictEntry = new Dict(str.substring(semi_colon_idx+1));
                        } else {
                            dictEntry = new StringWrapper(str.substring(semi_colon_idx+1));
                        }
                        map.put(str.substring(0,semi_colon_idx)
                                ,dictEntry);
                    }
                default:
                    break;
            }
        }
    }


    public void Dict2(String json){


        //ex:{a:apple, b:{b:blueberry,c:{d:grape,e:tomato}}, c:{d:orange}}}
        //{b:{c:apple}}
        map = new HashMap<String, DictEntry>();
        Stack<String> stack = new Stack<String>();
        StringBuffer buffer = new StringBuffer();
        String key="";
        String value="";
        for (int i=1;i<json.length()-1;i++){
            char c =json.charAt(i);
            switch (c){
                case '{':
                    stack.push("{");//start of dictionary
                    break;
                case  '}':
                    stack.pop();
                    if (stack.empty()){//create a dict entry
                        value = "{"+buffer.toString()+"}";
                        map.put(key,new Dict(value));
                    }
                    buffer = new StringBuffer();
                    break;
                case ':': //buffer is the key
                    if(stack.empty()) {
                        key = buffer.toString();
                        buffer = new StringBuffer();
                    } else {
                        buffer.append(c);
                    }
                    break;
                case ','://buffer is the value
                    if(stack.empty()) {
                        value = buffer.toString();
                        map.put(key, new StringWrapper(value));
                        buffer=new StringBuffer();
                    } else {
                        buffer.append(c);
                    }
                    break;
                default:
                    buffer.append(c);
            }
        }

        if(buffer.length()>0){
            map.put(key,new StringWrapper(buffer.toString()));
        }
        Pattern pattern = Pattern.compile("");
        Matcher matcher=pattern.matcher("abcxyz");
        while (matcher.find()){
            System.out.println(""+matcher.start()+"-"+matcher.end());
        }
    }

    public boolean isDict() {
        return true;
    }

    public Set<String> getKeys() {
        return map.keySet();
    }

    public DictEntry get(String key) {
        return map.get(key);
    }

    public void addEntry(String key, DictEntry val){
        map.put(key,val);
    }

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        for (Map.Entry<String,DictEntry> entry:map.entrySet()){
            buffer.append(String.format("%s:%s,",entry.getKey(),entry.getValue().toString()));
        }
        buffer.deleteCharAt(buffer.length()-1);
        buffer.append("}");
        return buffer.toString();
    }

}

interface DictEntry {
    public boolean isDict();
    public String toString();
}

class StringWrapper implements DictEntry {

    private String str;

    public StringWrapper(String str) {
        this.str = str;
    }

    public boolean isDict() {
        return false;
    }

    public String toString() {
        return str;
    }
}

class Solution {
/*
* Complete the functions below.
*/

    static String dictionaryToJson(Dict dictionary) {
        return dictionary.toString();
    }

    static Dict jsonToDictionary(String json) {
        //ex:{a:apple, b:{b:blueberry,c:cranberry}}
        return new Dict(json);
    }
}
