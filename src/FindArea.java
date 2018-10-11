package test;

public class FindArea {
	
	int shapeArea(int n) {
    int temp = 0;
    
    while(n>0)
    {
        temp = temp+ (n*n);
        n--;
    }
    
    return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindArea g = new FindArea();
		System.out.println(g.shapeArea(4));
	}

}
