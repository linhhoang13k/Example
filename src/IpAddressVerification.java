package exercise21;

public class IpAddressVerification {

	public boolean isIPv4Address(String inputString) {
		String[] check = inputString.split("\\.");

		int meetsReq = 0;
		int value = 0;
		
		for (int i = 0; i < check.length; i++) {
			try {
				value = Integer.parseInt(check[i]);
			} catch (NumberFormatException ex) {
				break;
			}

			if (value >= 0 && value <= 255) {
				meetsReq = meetsReq + 1;
			}
		}

		if (meetsReq == 4) {
			return true;
		}

		return false;
	}

}
