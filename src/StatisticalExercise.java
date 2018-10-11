import java.util.Arrays;

public static int[] StatisticalExercise(int[] A) {
	int sum=0, i, mode=0, modCount=0, largest=0;
	int[] res = new int[3];
	int len = A.length;
    int[] counts;
	Arrays.sort(A);
	for(i=0; i < len; i++) {
		sum+=A[i];
			
		if((len%2!=0) && (i==len/2)) {
			res[2]=A[i];
		} else if (len%2==0) {
			res[2]=(A[(len/2)-1]+A[len/2])/2;
		}
			
		if(A[i]>largest)
			largest=A[i];
	}
	res[0] = sum/i;
		
	counts = new int[largest+1];
	for (i=0; i<len; i++) {
		counts[A[i]]++;
		if (modCount < counts[A[i]]) {
			modCount = counts[A[i]];
			res[1] = A[i];
		}
	}
	for(i=0; i<counts.length; i++) {
		if(counts[res[1]]==counts[i]) {
			mode++;
		}
			
		if(mode>=2) {
			res[1]=0;
		}
	}
		
	return res;
}
