package CodeWars;

public class JadenCasing {

    public static void main(String[] args) {
        System.out.println(toJadenCase("test test test"));
        System.out.println(toJadenCase("Capitalize each word in the sentence"));
        System.out.println(toJadenCase(null));
        System.out.println("");
    }
    public static String toJadenCase(String phrase) {

        if (phrase == null) {
            return null;
        } else if (phrase.equals("")) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        String[] words = phrase.split(" ");
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)));
            sb.append(w.substring(1));
            sb.append(" ");
        }

      return sb.toString().trim();
    }
}
