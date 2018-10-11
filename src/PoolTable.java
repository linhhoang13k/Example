package tiendm.codefight.challenge.august;

public class PoolTable {
	int poolTableBounce(int width, int height) {
		int gcd = gcd(width / 2, height);
		if (height % (2 * gcd) != 0) {
			if ((width / (2 * gcd)) % 2 == 0) {
				return 5;
			} else {
				return 2;
			}
		}
		if (height / (2 * gcd) % 2 == 0) {
			if (width / (2 * gcd) % 2 == 0) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (width / (2 * gcd) % 2 == 0) {
				return 4;
			} else {
				return 3;
			}
		}
	}

	int gcd(int a, int b) {
		while (a % b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return b;
	}

	public static void main(String[] args) {
		PoolTable p = new PoolTable();
		System.out.println(p.poolTableBounce(628, 237));
	}
}
