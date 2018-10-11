package CodeFighters;

public class AmendTheSentence {

    public static void main(String[] args) {


        String s = "CodefightsIsAwesome";
        AmendTheSentence ats = new AmendTheSentence();
        System.out.println("Approach 1: " + ats.amendTheSentence(s));
        System.out.println("Approach 2: " + ats.amendTheSentenceWithJoin(s));

    }

//1. Iterate through the string
//2. If Uppercase letter is found, add it to the result string with a space before the character and
//          converting the character to lower case
//3. Else just concatenate the character to the result string
//4. Return the trimmed string

    public String amendTheSentence(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                result = result.concat(" " + Character.toLowerCase(c));
            } else {
                result = result.concat(c + "");
            }
        }
        return result.trim();
    }

//Using Regex
//1.Split the entire string whenever an Uppercase letter is found
//2.Join the elements of string array with a space
//3. Convert all the string to lowercase before returning
    public String amendTheSentenceWithJoin(String s)
    {
        String[] str = s.split("(?=[A-Z])");

        return String.join(" ",str).toLowerCase();
    }

}
