package CodeWars;

public class VowelCount {

    public static void main(String[] args) {
        System.out.println(vowelCounter("smoothie"));
    }
    public static int vowelCounter(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
                 count += 1;
            }
        }
        return count;
    }
}
