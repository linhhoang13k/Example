package codefights;

import java.util.Arrays;
import java.util.List;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class TuneUp {

    static List<String> l = Arrays.asList("b", "A", "Bb", "B" ,"C", "C#", "D" ,"Eb", "E", "F", "F#", "G");
    static String tuneUp2(double f) {
        return l.get((int) (Math.round(12 * (Math.log(f / 440) / Math.log(2)) + 49) % 12));
    }

    static String tuneUp(double f) {
        // 27.5    A
        // 38.8909 Eb
        // 48.9994 G
        // 58.2705 B
        // 87.3071 F
        // 130.813 C
        // 195.998 G
        // 261.62  C
        // 293.665 D
        // 440.000 A
        // 659.255 E
        // 466.164 Bb
        // 493.883 B
        // 523.251 C
        // 880     A
        // 1108.73 C#
        // 2349.32 D

        return "b A Bb B C C# D Eb E F F# G".split(" ")[(int) Math.round(12 * Math.log(f / 440) / Math.log(2) + 49) % 12];
    }

    public static void main(String[] args) {

        System.err.println(tuneUp(38.8909));
        System.err.println(tuneUp(48.9994));
        System.err.println(tuneUp(55));
        System.err.println(tuneUp(58.2705));
        System.err.println(tuneUp(87.3071));
        System.err.println(tuneUp(130.813));
        System.err.println(tuneUp(293.665));
        System.err.println(tuneUp(440));
        System.err.println(tuneUp(466.164));
        System.err.println(tuneUp(493.883));
    }

}
