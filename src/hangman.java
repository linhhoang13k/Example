package codefights;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class Hangman {

    public static boolean hangman(String word, String letters) {
        return word.chars().filter(c -> letters.contains(c+"")).sum() == word.length();
    }

    public static boolean hangman2(String word, String letters) {
        int miss = 0;
        for (char c : letters.toCharArray()) {
            int i = word.indexOf(c);
            if (i >= 0) {
                word = new StringBuffer(word).deleteCharAt(i).toString();
                if (word.isEmpty()) return miss < 6;
            } else {
                miss++;
            }
        }
        return miss < 6 && word.isEmpty();
    }

    public static void main(String[] args) {
        //System.err.println(hangman2("hangman", "etaoisnhr"));
//        System.err.println(hangman2("hangman", "ehadngvpz"));
        System.err.println(hangman2("hello", "aenmrolhtg"));
//        System.err.println(hangman2("hello", "aenmrolhtg"));

//        "hello".chars().filter(c -> !"aenmrolhtg".contains(c+"")).forEach(i -> {
//            System.err.println(i);
//        });

//        "fantastic".chars().filter(i -> !"aenmrolhtg".contains(Character.toString((char) i))).forEach(c -> {
//            System.err.println(c);
//        });

        String s = "c";
        s = s.replace('c', '\0');

        System.out.printf("s: " + s + ": " + s.isEmpty());

    }
}
