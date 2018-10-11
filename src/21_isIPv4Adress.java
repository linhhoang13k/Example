/*
An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a computer network that uses the Internet Protocol for communication. There are two versions of the Internet protocol, and thus two versions of addresses. One of them is the IPv4 address.

IPv4 addresses are represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255 inclusive, separated by dots, e.g., 172.16.254.1.

Given a string, find out if it satisfies the IPv4 address naming rules.

Example

    For inputString = "172.16.254.1", the output should be
    isIPv4Address(inputString) = true;

    For inputString = "172.316.254.1", the output should be
    isIPv4Address(inputString) = false.

    316 is not in range [0, 255].

    For inputString = ".254.255.0", the output should be
    isIPv4Address(inputString) = false.

    There is no first number.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string inputString

    Guaranteed constraints:
    1 ≤ inputString.length ≤ 30.

    [output] boolean

    true if inputString satisfies the IPv4 address naming rules, false otherwise.
*/

boolean isIPv4Address(String inputString) {
    String[] parsedString = inputString.split("\\.");
    boolean isIPv4 = false;
    if(parsedString.length == 4){
        for(int num = 0; num < 4; num++){
            try{
                Integer.parseInt(parsedString[num]);
            }
            catch(NumberFormatException e) { 
                return false; 
            } 
            catch(NullPointerException e) {
                return false;
            }
            
            int parsedNumber = Integer.parseInt(parsedString[num]);
            if( (parsedNumber >= 0) && (parsedNumber <= 255) ){
                isIPv4 = true;
            }else{
                isIPv4 = false;
                break;
            }
        }
    }
    return isIPv4;
}
