package com.codefight.arcade;


public class DeleteMe {

	private int a;
	private long b;
	private double c;
	private float d;
	private Number e;
	private Double f;
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + (int) (b ^ (b >>> 32));
		long temp;
		temp = Double.doubleToLongBits(c);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(d);
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + ((f == null) ? 0 : f.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeleteMe other = (DeleteMe) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (Double.doubleToLongBits(c) != Double.doubleToLongBits(other.c))
			return false;
		if (Float.floatToIntBits(d) != Float.floatToIntBits(other.d))
			return false;
		if (e == null) {
			if (other.e != null)
				return false;
		} else if (!e.equals(other.e))
			return false;
		if (f == null) {
			if (other.f != null)
				return false;
		} else if (!f.equals(other.f))
			return false;
		return true;
	}



	public static void main(String[] args)
    {
    	int i = 1;
    	System.out.println(i << 30);
    	
       // method((long)12);
    }
}
