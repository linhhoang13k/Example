import java.util.regex.Pattern;

public class IPV4Address 
{
	static private final String IPV4_REGEX = "(([0-1]?[0-9]{1,2}\\.)|(2[0-4][0-9]\\.)|(25[0-5]\\.)){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))";
	static private Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);
	public static void main(String v[])
	{
		String s = "172.16.4.";
		System.out.println(isIPv4Address(s));
	}
	static boolean isIPv4Address(String inputString) 
	{
		return IPV4_PATTERN.matcher(inputString).matches();
	}
}
