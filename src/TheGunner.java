package tiendm.codefight.challenge.april;

import java.util.Arrays;

public class TheGunner {
	int theGunner(int[] bullets, int[] targets) {
		double sum = 0,  sumbullet = 0;
		for(int i : targets){
			sum += i;
		}
		Arrays.sort(bullets);
		for(int i = bullets.length - 1; i >= bullets.length - targets.length ; i--) {
			sumbullet += bullets[i];
		}
		return (int) Math.ceil(sum/sumbullet);
	}
	
	public static void main(String[] args) {
		TheGunner gun = new TheGunner();
//		int[] x = {9,10,9};
//		int [] y = {60,39};
		int[] x = {1,2,3};
		int [] y = {20};
		System.out.println(gun.theGunner(x, y));
	}
}
