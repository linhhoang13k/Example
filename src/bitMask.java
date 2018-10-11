	public static int problem (int n, int k){
		return ((n & (1 << --k)) == (1 << k)) ? n - (1 << k) : n;
	}
	

	public static int bitMask (int n, int k){
		return n & ~(1 << --k);
	}