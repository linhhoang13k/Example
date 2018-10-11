
public class GroupedBits{
//someone much cooler than me though this up    
//return Long.bitCount(-n& n*2);

    public static int GroupedBits(int n) {
        String string = Integer.toBinaryString(n);

        int groups = (int) string.charAt(0) - 48;

        for(int i = 2; i < string.length(); i++)
            if(string.charAt(i) == '1' && string.charAt(i - 1) == '0')
                groups++;

        return groups;
    }
}
