package program.java.stringprogram;

public class KMPalgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		patternSearching("AAABAAA".toCharArray(),"AAABAACAAABAAA".toCharArray());
	}

	public static int patternSearching(char[] pat,char[] text){
		
		int patLen = pat.length;
		int[] lps = new int[pat.length];
		// Find proper prefix of suffix
		
		lps[0] = 0;
		int index = 0;
		for(int i=1;i<patLen;i++){
			
			if(pat[index]==pat[i]){
				lps[i]=++index;
			}else{
				int preIndex = (lps[i-1]-1) > 0 ? lps[i-1]-1 : 0;
				
				index = lps[preIndex];
				
				if(pat[index]==pat[i]){
					lps[i]=++index;
				}else{
					index = 0;
					lps[i]=index;
				}
				
			}
			
		}
		
		
		int a=0;
		int b=0;
		int N = text.length;
		while(a<N){
			
			if(text[a]==pat[b]){
				a++;
				b++;
			}
			if(b==patLen){
			   return a-b;
			
			}
			else if(a<N && text[a]!=pat[b]){
				
				if(b != 0){
					b = lps[b-1];
				}else{
					a+=1;
				}
			}
		}
		return -1;
	}
	
	public static void printIntArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	
}
