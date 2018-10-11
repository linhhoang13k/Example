package CodeWars;

public class MiddleCharacter {

    public static void main(String[] args) {
        System.out.println(getMiddle("Toast"));
        System.out.println(getMiddle("Test"));
        System.out.println(getMiddle("Middle"));
    }

    public static String getMiddle(String word) {
        StringBuilder sb = new StringBuilder();
        if (word.length() % 2 == 0 ) {
            sb.append(word.charAt(word.length()/2 - 1));
            sb.append(word.charAt(word.length()/2));
        } else {
            sb.append(word.charAt(word.length()/2));
        }
        return sb.toString();
    }
}
