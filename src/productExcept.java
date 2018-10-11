package Apple;

public class productExcept {
	
	public static int productExceptSelf(int[] nums, int m){
		int product = 1;
		int[] f = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
                product = product * nums[i];
                System.out.print(product + " ");
        }
        
        
        for(int i = 0; i < nums.length; i++){
        	f[i] = (product/nums[i]);
        }
        
//        for(int i = 0; i<nums.length; i++){
//        	System.out.println(f[i]);
//        }
        
        int sum = 0;
        for(int i = 0; i < f.length; i++){
        	sum += f[i];
        }
        
        return sum%m;

	}
	
	
	public static void main(String[] args) {
		int[] nums = {37, 50, 50, 6, 8, 54, 7, 64, 2, 64, 67, 59, 22, 73, 33, 53, 43, 77, 56, 76, 59, 96, 64, 100, 89, 38, 64, 73, 85, 96, 65, 50, 62, 4, 82, 57, 98, 61, 92, 55, 80, 53, 80, 55, 94, 9, 73, 89, 83, 80};
		int m = 67;
		System.out.println(productExceptSelf(nums, m));
	}
}
