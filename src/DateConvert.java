package arcade;

public class DateConvert {


    public static void main(String[] args) {
        convert();

    }

    public static void convert() {
        Long start = 1519862887000L;
        Long end = 1522278487000L;

        long daylightPeriod = (end - start) % 86400000;
        System.out.println(daylightPeriod);
        float daysfull = (float) (end - start) / 86400000;
        System.out.println(daysfull);
        int daysFull1 = Math.round(daysfull);
        System.out.println(daysFull1);

        System.out.println("Final" + daysFull1);
    }
}