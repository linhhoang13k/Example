package program.java.random;

public class Challe {

	public static void main(String[] args) {
		int[] acc ={77367, 85558, 88570, 98242, 46552, 2772, 64226, 72128, 15176, 93254};
		String[] req =  {"deposit 11 6", 
		                 "transfer 2 6 91", 
		                 "deposit 10 58", 
		                 "transfer 5 3 49", 
		                 "withdraw 8 40", 
		                 "withdraw 6 67", 
		                 "transfer 7 6 44", 
		                 "withdraw 5 7", 
		                 "transfer 8 2 20", 
		                 "transfer 9 2 94"};
		int[] ans = bankRequests(acc, req);
		for(int i:ans){
			System.out.print(i+" ");
		}

	}
	static int[] bankRequests(int[] accounts, String[] requests) {
		for(int i=0;i<requests.length;i++){
			
			String request = requests[i];
			String[] reqSplit = request.split(" ");
			String state = reqSplit[0];
			switch (state) {
			case "withdraw":
				int to1 = Integer.valueOf(reqSplit[1])-1;
				int amount1 = Integer.valueOf(reqSplit[2]);
				if(!isCorrect(accounts, to1, amount1)){
					int r=-1*(i+1);
					int[] res = {r};
					return res;
				}
				accounts[to1]-=amount1;
				break;
			case "deposit":
				int to = Integer.valueOf(reqSplit[1])-1;
				int amount = Integer.valueOf(reqSplit[2]);
				if(to>=accounts.length){
					int r=-1*(i+1);
					int[] res = {r};
					return res;
				}
				accounts[to]+=amount;
				break;
				
			case "transfer":
				int from2 = Integer.valueOf(reqSplit[1])-1;
				int to2 = Integer.valueOf(reqSplit[2])-1;
				int amount2 = Integer.valueOf(reqSplit[3]);
				if(!isCorrect(accounts, from2, amount2)){
					int r=-1*(i+1);
					int[] res = {r};
					return res;
				}
				if(to2>=accounts.length){
					int r=-1*(i+1);
					int[] res = {r};
					return res;
				}
				accounts[from2]-=amount2;
				accounts[to2]+=amount2;
				break;
			default:
				int r=-1*(i+1);
				int[] res = {r};
				return res;
				
			}
		}
		return accounts;
	}
	static boolean isCorrect(int[] accounts,int index,int amount){
		if(index>=accounts.length){
			return false;
		}
		if(amount>accounts[index]){
			return false;
		}
		return true;
	}
}
