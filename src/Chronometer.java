package util;

/**
 * Created by JavierSainz on 11/6/16.
 */
public class Chronometer {
    long start;
    long end;
    final int MILLISECONDS_DIVISOR = 1_000_000;

    private Chronometer() {
        reset();
    }

    public Chronometer reset() {
        start = System.nanoTime();
        return this;
    }

    public static Chronometer start() {
        return new Chronometer();
    }

    public long time() {
        end = System.nanoTime();
        return end - start;
    }

    public String toMilli() {
        return String.format("%d milli", (end - start) / MILLISECONDS_DIVISOR);
    }
}
