package test;

public class Animal {
	
	public void animal()
	{
		System.out.println("in parent class");
		dog d = new dog();
		int x = d.dog1;
		int y = d.dog2;
		}
	
	private class dog{
		int dog1;
		int dog2;
	}

}
