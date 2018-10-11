package tiendm.codefight.introduction;

public class Level9 {
	int growingPlant(int upSpeed, int downSpeed, int desiredHeight)
	{
	    int count=upSpeed;
	    if(count<desiredHeight){
	        count=desiredHeight/(count-downSpeed);
	    }else{
	        count=1;
	    }
	        return count;
	}
	
	int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
	    if(weight1 + weight2 <= maxW) return value1 + value2;
	    else if(Math.min(weight1,weight2) > maxW) return 0;
	    else if(weight1 > maxW) return value2;
	    else if(weight2 > maxW) return value1;
	    else return Math.max(value1,value2);
	}
	
	public static void main(String[] args) {
		
	}
}
