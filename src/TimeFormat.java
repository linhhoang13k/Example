package in.mkp.challenges;

/**
 * Created by mkumar on 4/13/17.
 */
public class TimeFormat {

    public static void main(String[] args) {
        TimeFormat timeFormat = new TimeFormat();
        System.out.println("31626061001, %y %d %h %m %s %ms "+timeFormat.timeFormat(31626061001L, "%y %d %h %m %s %ms"));
        System.out.println("31626061001, %y %d %h %m %s %ms "+timeFormat.timeFormat(31626061001L, "%d %h %m %s %ms"));
        System.out.println("31626061001, %ms "+timeFormat.timeFormat(31626061001L, "%ms"));

    }

    String timeFormat(long value, String f) {
        if (f.length() == 0) f="%y %d %h %m %s %ms";
        DateFormat df = populateDateFormat(f);

        StringBuffer sb = new StringBuffer();
        long div = 31536000000L;
        value = calc(value, sb, div, df.y, df.py, "y");

        div = 86400000L;
        value = calc(value, sb, div, df.d, df.pd,"d");

        div = 3600000L;
        value = calc(value, sb, div, df.h, df.ph, "h");

        div = 60000L;
        value = calc(value, sb, div, df.m, df.pm, "m");

        div = 1000L;
        value = calc(value, sb, div, df.s, df.ps, "s");

        div=1L;
        calc(value, sb, div, df.ms, df.pms, "ms");

        return sb.toString();
    }

    private long calc(long value,
                      StringBuffer sb,
                      long div,
                      boolean t,
                      boolean pt,
                      String type) {
        if (t) {
            long d=(value/div);
            if (sb.length() > 0) sb.append(" ");
            sb.append(d);
            if (pt) sb.append(type);
            value=value % div;
        }
        return  value;
    }

    DateFormat populateDateFormat(String f) {
        String t[] = f.split(" ");
        DateFormat df = new DateFormat();
        for (int i=t.length-1; i >= 0; --i) {
            boolean p = t[i].startsWith("%");
            if (t[i].endsWith("ms")) {
                df.ms=true;
                df.pms=p;
            }
            if (t[i].equals("s") || t[i].equals("%s")) {
                df.s=true;
                df.ps=p;
            }
            if (t[i].equals("m") || t[i].equals("%m")) {
                df.m=true;
                df.pm=p;
            }
            if (t[i].endsWith("h")) {
                df.h=true;
                df.ph=p;
            }
            if (t[i].endsWith("d")) {
                df.d=true;
                df.pd=p;
            }
            if (t[i].endsWith("y")) {
                df.y=true;
                df.py=p;
            }
        }
        return df;

    }

    class DateFormat {
        boolean y,d,h,m,s,ms,py,pd,ph,pm,ps,pms;
    }

}
