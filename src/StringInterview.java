package com.taidev198.game.CodingInterview.String;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author traig on 7/25/2018.
 * @project Codefights
 */
public class StringInterview {


    static String amendTheSentence(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                if (i ==0 ) result.append(Character.toLowerCase(ch));
                else result.append(" ").append(Character.toLowerCase(ch));
            }
            else  result.append(Character.toLowerCase(ch));
        }

        return result.toString();
    }

    static int findFirstSubstringOccurrence(String s, String x) {

        int n = s.length();
        int index = s.indexOf(x.charAt(0));
        while(index != -1){

            if(index + x.length() > n)
                return -1;
            if(s.substring(index, index+ x.length()).contains(x))
                return index;
            index =  s.indexOf(x.charAt(0), index+1);
        }
        return -1;
    }

    static boolean isMAC48Address(String inputString) {

        String[] result = inputString.split("\\-");
        System.out.println(result.length);
        if (result.length != 6) return false;
        for (int i = 0; i < result.length; i++) {
            if (!result[i].matches("[0-9A-F]*"))
                return false;
        }
        return true;
    }

    static String buildPalindrome(String st) {
        StringBuilder result = new StringBuilder(st);
        String temp = result.reverse().toString();
        int n = st.length();
        int i =n-1;
        String temp1 = st;
        while(!isPalindrome(temp1) && i > 0){
            System.out.println(isPalindrome(temp1));
            temp1 = st + temp.substring(i,n);
            System.out.println(temp1);
            i--;
        }

        return temp1;
    }

    static boolean isPalindrome(String s){
        int n = s.length();
        int i = 0;
        while (i < n/2){
            if (s.charAt(i) != s.charAt(n -i-1))
                return false;
            i++;
        }
        return true;
    }

    static String lineEncoding(String s) {
        int n = s.length();
        int i = 0;
        int count =1;
        String result = "";
        while (i< n){
            if (i< n-1){
                if (s.charAt(i) == s.charAt(i+1))
                    count++;
                else{
                    result += count == 1? s.charAt(i) : String.valueOf(count) + s.charAt(i);
                    count = 1;
                }
            }
            i++;
        }
        i--;
        result += count == 1? s.charAt(i) : String.valueOf(count) + s.charAt(i);
        return result;
    }

    static String reverseParentheses(String s) {
        StringBuilder result = new StringBuilder(s);

        int i = 0;
        int n = s.length();
        List<Integer> position = new ArrayList<>();
        char ch;
        while (i < n){
            ch = s.charAt(i);
            if (ch == '(')
                position.add(i);
            if (ch == ')'){
                StringBuilder temp = new StringBuilder(result.substring(
                        position.get(position.size() -1)+1,i));
               // System.out.println(temp);

                result = result.replace(position.get(position.size() -1)+1, i,temp.reverse().toString());
               // System.out.println(result);
                position.remove(position.size() -1);
            }
            i++;
        }
        return result.toString().replaceAll("[()]*","");
    }

    static int deleteDigit(int n) {
        String s = Integer.toString(n);
//        List<String> list = Arrays.asList(s.split(""));
//        Collections.sort(list);
//        int min = s.indexOf(list.get(0));
//
//        return Integer.parseInt(s.substring(0,min) + s.substring(min +1, s.length()));
        int i =0;
        int len = s.length();
        while (i < len-1){
            if (Integer.parseInt(Character.toString(s.charAt(i)))
                    < Integer.parseInt(Character.toString(s.charAt(i+1))))
               return Integer.parseInt(s.substring(0,i) + s.substring(i+1 , s.length()));
            i++;
        }

        return n/10;
    }

    static String longestWord(String text) {

        String[] result = text.replaceAll("[^A-Za-z0-9]"," ")
                .split(" ");//replace special characters with white space
        if (result.length == 1)
            result = text.split(",");
        if (result.length == 1)
            result = text.split(".");
        if (result.length == 1)
            return text;
        List<String> temp = Arrays.asList(result);
        String longest = "";
        for (int i = 1; i < temp.size(); i++) {
            temp.set(i, temp.get(i).replaceAll(",", ""));
            if(temp.get(i).contains("[]"))
                temp.set(i, temp.get(i).replaceAll("", ""));
            if (temp.get(i).matches("[A-z]*") && temp.get(i).length() > longest.length())
                longest = temp.get(i);
        }
        return longest;
    }

    static int sumUpNumbers(String inputString) {

        int value = 0;

//        String[] result = inputString.split(" ");
//        for (int i = 0; i < result.length; i++) {
//            if (result[i].matches(".*\\d+.*")){
//                value += Integer.parseInt(result[i].replaceAll("[^A-Za-z0-9]","")
//                        .replaceAll("[A-Za-z]", ""));
//            }
//        }
        int n = inputString.length();
        int i =0;
        while (i < n) {
            char ch = inputString.charAt(i);
            if (Character.toString(ch).matches("[0-9]*")){
                int j = i+1;
                while (j < n){
                    ch = inputString.charAt(j);
                    if (Character.toString(ch).matches("[0-9]*"))
                        j++;
                    else break;
                }
                value +=  Integer.parseInt(inputString.substring(i, j));
                i = j;
            }
            i++;
        }
        return value;
    }


    static String classifyStrings(String s) {
        String vowels = "ueoai";
        int n = s.length();
        if(n == 1) return "good";

        for (int i = 0; i < n; i++) {
            if (Character.toString(s.charAt(i)).matches("[^euoia]")){
                if (n - 3 -i< 0) return "good";
                if(s.substring(i, i+3).matches("[^euoia]")) return "bad";
            }else if (!Character.toString(s.charAt(i)).matches("[^euoia]")){
                if (n - 5 -i< 0)
                return "good";
                if(!s.substring(i, i+5).matches("[^euoia]")) return "bad";
            }
        }
        return "mixed";
    }

    static int stringsConstruction(String a, String b) {

        int nA = a.length();
        int nB = b.length();
        if(nA > nB ) return 0;
        int count =0;
        StringBuilder temp = new StringBuilder(b);
        int i =0;
        int index = temp.indexOf(String.valueOf(a.charAt(i)));
        while (index != -1 ){
            temp = temp.deleteCharAt(index);
            i = (i +1) % nA;
            if (i < nB)
                index = temp.indexOf(String.valueOf(a.charAt(i)));
            if(i % nA == 0) count++;
        }
        return count;
    }
    static boolean isSubstitutionCipher(String string1, String string2) {
        char[] charArray = string1.toCharArray();
        string1 = Arrays.toString(charArray);
        Arrays.sort(charArray);
        System.out.println(string1);
//        for (int i = 0; i < string1.length(); i++) {
//
//        }
        return true;
    }

    static int createAnagram(String s, String t) {
        StringBuilder temp = new StringBuilder(t);
        int count =0;
        for(int i = 0; i< s.length(); i++){
            int index = temp.indexOf(String.valueOf(s.charAt(i)));
            if ( index != -1){
                temp.deleteCharAt(index);
            }else
                count ++;
        }
        return count;

    }

    static String[] recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {
        String[] answer = new String[n];
        int len = daysOfTheWeek.length;
        int[][] DayOfMonth = new int[][]{{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                                        {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
         String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday",
                "Friday", "Saturday" };
        List<String> listDayOfWeeks = Arrays.asList(strDays);
        List<String> list = Arrays.asList(daysOfTheWeek);
        int l =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < len; j++) {
                int index = list.indexOf(strDays[DayOfWeeks(firstDate) -1]);
                if ( index != -1){
                    answer[l++] = firstDate;
                }else {
                    if (listDayOfWeeks.indexOf(calDayOfWeeks(firstDate))
                            - listDayOfWeeks.indexOf(daysOfTheWeek[0]) < 0){

                    }
                }
            }
        }
        return answer;
    }
    static String calDayOfWeeks(String input_date){

        SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
        Date dt1= null;
        try {
            dt1 = format1.parse(input_date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2=new SimpleDateFormat("EEEE");
        return format2.format(dt1);
    }

    static int DayOfWeeks(String input){

        SimpleDateFormat t = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(t.parse("29/07/2018"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (calendar.get(Calendar.DAY_OF_WEEK));

    }

    static boolean isLeapYear(String date){
        int year = Integer.parseInt(date.substring(date.length() - 4, date.length()));
        if (year % 400 == 0)
            return true;

        // Else If a year is muliplt of 100,
        // then it is not a leap year
        if (year % 100 == 0)
            return false;
        // Else If a year is muliplt of 4,
        // then it is a leap year
        if (year % 4 == 0)
            return true;
        return false;
    }

    static String questionCorrectionBot(String question) {
        System.out.println(question);
        question = question.trim();//delete white space in left and right

        StringBuilder temp = new StringBuilder(question);
        temp.replace(0,1, String.valueOf(Character.toUpperCase(temp.charAt(0))));//toUppercase the first char
        int index = temp.indexOf("?");
        //end with a single question mark
        if (index == -1)
            temp.append('?');
        else {
            if (index != temp.length() -1) temp.replace(index, temp.length() , "?");
        }
        StringBuilder result = new StringBuilder();
        result.append(temp.charAt(0));
        for (int i = 1; i < temp.length(); i++) {
            if (temp.charAt(i) == ' '){
                int j = i+1;
                while (temp.charAt(j) == ' ')
                    j++;
                if (temp.charAt(j) == ',')
                result.append(question.toCharArray(), i,0);
                else result.append(question.toCharArray(), i,1);
                i = j-1;
            }
            else result.append(temp.charAt(i));
            System.out.println(result);
        }

        index = result.indexOf(",");
        while (index != -1){
            if (index +1 < result.length())
            if (result.charAt(index+1) != ' ')
                result.insert(index, ' ');
            index = result.indexOf(",", index+1);
        }
        return   result.toString();
    }

    static boolean isCryptSolution(String[] crypt, char[][] solution) {

        String characters = "";
        for (int i = 0; i < solution.length; i++) {
            characters += solution[i][0];
        }
        BigInteger[] integers = new BigInteger[3];

        for(int i =0; i< 3; i++){
            String num = "";
            for(int j = 0; j < crypt[i].length(); j++){
                int row = characters.indexOf(Character.toString(crypt[i].charAt(j)));
                if(solution[row][1] == '0' && j == 0)
                    return false;
                num +=  solution[row][1];
            }
            integers[i] = new BigInteger(num);
        }

        return integers[0].add(integers[1]).equals(integers[2]);

    }

    static String[] fileNaming(String[] names) {
        int n = names.length;

        String[] result = new String[n];
        result[0] = names[0];
        List<String> list = new ArrayList<>();
        for(int i = 0; i< n ;i++){
            int index = list.indexOf(names[i]);
            if(list.size() == 0 || index == -1)
                list.add(names[i]);
            else{
                int level  =1;
                names[i] = names[i]+"("+ Integer.toString(level) +")";
                while (list.indexOf(names[i]) != -1){
                    int lastIndex = names[i].lastIndexOf("(");
                    names[i] = names[i].substring(0, lastIndex) +"(" +Integer.toString(level++) +")";
                }
                list.add(names[i]);
            }
            result[i] = names[i];
        }

        return result;
    }

    static String messageFromBinaryCode(String code) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < code.length() ; i+=8) {
            char ch = (char) getBinaryNumberal(code.substring(i, i+8));
            result.append(ch);
        }
        return result.toString();
    }

    static int getBinaryNumberal(String input){

        if (input.length() == 1)
            return Character.getNumericValue( input.charAt(0));
        return (int) Math.pow(2, input.length()-1) *Character.getNumericValue( input.charAt(0))
                + getBinaryNumberal(input.substring(1,input.length()));

    }

    static String messageFromBinaryCode1(String code) {
        return new String(new BigInteger(code, 2).toByteArray());

    }

    static boolean stringsRearrangement(String[] inputArray) {
        int n = inputArray.length;
        if(n == 1) return false;
        Arrays.sort(inputArray);
        return permuteHelper(inputArray, 0);
    }

    static boolean permuteHelper(String[] inputArray, int index){

        if (index >= inputArray.length -1){
                return diffOneCharacter(inputArray[0], inputArray[1]);
        }

        for(int i = index; i < inputArray.length; i++){ //For each index in the sub array arr[index...end]

            //Swap the elements at indices index and i
            String t = inputArray[index];
            inputArray[index] = inputArray[i];
            inputArray[i] = t;

            //Recurse on the sub array arr[index+1...end]
            permuteHelper(inputArray, index+1);

            //Swap the elements back
             t = inputArray[index];
            inputArray[index] = inputArray[i];
            inputArray[i] = t;
        }
        return diffOneCharacter(inputArray[0], inputArray[1]);

    }
    static boolean diffOneCharacter(String s1, String s2){
        int count = 0, i= 0;
        while(i < s1.length()){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
            if(count == 2) return false;
            i++;
        }
        return true;
    }
    static String minSubstringWithAllChars(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if(sLength == 0 && tLength == 0)
            return "";
        String result ="";
        int max=0;
        for (int i = 0; i < sLength; i++) {
            if (t.contains(Character.toString(s.charAt(i)))){
                 max = i;
                int j = 0;
                while (j < tLength){
                    max = max <t.indexOf(Character.toString(t.charAt(j)),i+1)
                            ?max:t.indexOf(Character.toString(t.charAt(j)), i+1);
                    j++;
                }
                i = j;
            }
            if (max > result.length())
            result = s.substring(i, max);
        }
        return "";
    }

    static int constructSquare(String s) {
        int n = s.length();
        for (int i = (int) Math.sqrt(Math.pow(10, n))-1; i >= (int) Math.sqrt(Math.pow(10, n))/2; i--) {
            List<Integer> list = calDifChars(s);
            List<Integer> list1 = calDifChars(Integer.toString(i*i));
            if (compareList(list, list1)){
//                for (int j = 0; j < list.size(); j++) {
//                    System.out.println(list.get(j));
//                }
//                for (int j = 0; j < list.size(); j++) {
//                    System.out.println(list1.get(j));
//                }
                return i*i;
            }

        }
        return -1;
    }

    static List<Integer> calDifChars(String inputString){
        StringBuilder temp = new StringBuilder(inputString);
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while ( i< temp.length() ){
            int count =0;
            int index = temp.indexOf(Character.toString(inputString.charAt(i)),i+1);
            while (index != -1){
                temp.delete(index, index+1);
                index = temp.indexOf(Character.toString(temp.charAt(i)),i+1);
                count++;
            }
            list.add(count);
            i++;
        }
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
        Collections.sort(list);

        return list;
    }

    static List<Integer> calDifChars1(String input){
        List<String> temp = Arrays.asList(input.split(""));
        List<Integer> list = new ArrayList<>();
        Collections.sort(temp);
        int count =1;
        int n = temp.size();
        for (int j = 0; j < n-1; j++) {
            if (temp.get(j).equals(temp.get(j+1)))
                    count++;
            else{
                list.add(count);
                count = 1;
            }
        }
        if (!temp.get(n - 2).equals(temp.get(n - 1)))
            list.add(1);
        else list.add(count);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
        Collections.sort(list);
        return list;
    }
     static boolean compareList(List<Integer> ls1, List ls2){
        return ls1.equals(ls2);
    }

    static List<String> calFrequentChars(String input){
        String[] temp = input.split("");
        List<String> list = Arrays.asList(temp);
        for (int i = 0; i < input.length(); i++) {
            int frequency = Collections.frequency(list, Character.toString(input.charAt(i)));
        }
        return list;
    }

    static String[] taskMaker(String[] source, int challengeId) {
        int n = source.length;
        String[] result = new String[n];
        int j = 0;
        for(int i = 0 ; i < n; i++){
            if (!source[i].contains("//"))
                result[j++] = source[i];
            else {
                int left = source[i].indexOf("DB");
                int right = source[i].indexOf("/",left);
                int id = Integer.valueOf(source[i].substring(left+3, right));
                System.out.println(id);
                if (id == challengeId){
                    result[j-1] = source[i].substring(0,left-2)+source[i].substring(right+2, source[i].length());
                }
            }
        }

        for (int i = 0; i < j; i++) {
            System.out.println(result[i]);
        }
        return Arrays.copyOfRange(result, 0,j);
    }

    static int shortestSolutionLength(String[] source) {
        int total = 0;
        int n = source.length;
        for (int i = 0; i < n; i++) {
            if (!source[i].contains("/*") && !source[i].contains("//"))
                total += source[i].replace(" ","").length();
            else {
                StringBuilder temp = new StringBuilder(source[i]);

                    int left = temp.indexOf("/*");
                    int right = temp.indexOf("*/");
                    if (right == -1 && left != -1){
                        int j = i+1;
                        right = source[j].indexOf("*/");
                        while (right ==-1){
                            j++;
                            right = source[j].indexOf("*/");
                        }
                        i =j;
                        continue;
                    }else {
                        while (left != -1 && temp.indexOf("//") != -1 &&temp.indexOf("//")> right){
                            temp = temp.delete(left, right+2);
                            left = temp.indexOf("/*",left);
                        }
                    }
                int index = temp.indexOf("//");
                while (index != -1){
                    temp = temp.delete(index, temp.length());
                    index = temp.indexOf("//", index+1);
                }

                total += temp.toString().replace(" ","").length();
            }
        }
        return total;
    }

   static String[] campusCup(String[] emails) {
        for (int i = 0; i < emails.length; i++) {
            emails[i] = emails[i].substring(emails[i].indexOf("@")+1, emails[i].length());
        }
       Arrays.sort(emails);
        int points = 20;
        List<Integer> listFrequency = new ArrayList<>();
        List<String> listDomains = new ArrayList<>();
        int n = emails.length;
       for (int i = 0; i < emails.length-1; i++) {
            if (emails[i].equals(emails[i + 1])){
                points += 20;
            }
            else {
                if(points >= 100 && points < 200)
                    listFrequency.add(3);
               else if(points >= 200 && points < 300)
                    listFrequency.add(8);
                else if(points >= 300 && points < 500)
                    listFrequency.add(15);
                else if (points >= 500)
                    listFrequency.add(25);
                else listFrequency.add(points);
                points = 20;
                listDomains.add(emails[i]);
            }
       }
       if (emails[n-2].equals(emails[n-1])){
           points += 20;
           if(points >= 100 && points < 200)
               listFrequency.add(3);
           else if(points >= 200 && points < 300)
               listFrequency.add(8);
           else if(points >= 300 && points < 500)
               listFrequency.add(15);
           else if (points >= 500)
               listFrequency.add(25);
           else listFrequency.add(points);
           listFrequency.add(points);
           listDomains.add(emails[n-1]);
       }else {
           listDomains.add(emails[n-1]);
           listFrequency.add(20);
       }

       for (int i = 0; i < listFrequency.size()-1; i++) {
           int max = Integer.valueOf(listDomains.get(i));
           for (int j = i+1; j < listDomains.size(); j++) {


           }
       }
        return emails;
    }

    static int[][] opponentMatching(int[] xp) {
        int n = xp.length;
        boolean[] isValid = new boolean[n];
        if ( n ==1)
            return new int[0][];
        if(n == 2)
            return new int[][]{{0,1}};
        int radius = 0;
//        List<Integer> arr = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            arr.add(xp[i]);
//        }
        int j = 0;
     for(int i = 0; i < n -1; i++){
         for (int k = i; k < n; k++) {
             int left = xp[i] - radius;
             int right = xp[i] + radius;
//             if (xp[j] + radius )
         }


     }
        return new int[0][];

    }


    public static void main(String...args) {

   //     System.out.println(minSubstringWithAllChars("adobecodebanc", "abc"));
       // System.out.println(constructSquare("abcbbbcdcd"));

       // System.out.println(calDifChars1("999950884").equals(calDifChars1("aaaabbcde")));
        //System.out.println(constructSquare("abcdefghi"));
//       System.out.println(shortestSolutionLength(new String[]{"//1//1",
//               "/*2*/",
//               "x = 2//*/"}));
      // System.out.println("/**/*/".substring(0,"/**/*/".lastIndexOf("*/")+2));



        System.out.println(Arrays.toString(campusCup(new String[]{"john.doe@mit.edu", "admin@rain.ifmo.ru", "aoname@mit.edu"})));
}
}
