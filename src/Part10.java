package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Part10 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		ArrayList<Integer> values = new ArrayList<>();
		String line;
		while ((line = r.readLine()) != null) {
			try{
				values.add(Integer.parseInt(line));
			} catch(NumberFormatException e){

			}
		}
		int[] S = find(true, values);
		for(int i = 0; i < S.length; i++){
			w.println(S[i] + "");
		}
	}

	public static int[] find(boolean decline, ArrayList<Integer> values){
		int[] P = new int[values.size()];
		int[] M = new int[values.size()+1];
		int L = 0;
		for(int i = 0; i < values.size()-1; i++){

			int low = 1;
			int high = L;
			while(low <= high){
				int mid = (int) Math.ceil((low+high)/2.0);
				if(values.get(M[mid]) <= values.get(i)){
					low = mid+1;
				}
				else {
					high = mid-1;
				}
			}
			int newL = low;
			P[i] = M[newL-1];
			M[newL] = i;

				if(newL > L){
					L = newL;
				}

		}
		int[] S = new int[L];
		int k = M[L];
		for(int i = L-1; i > -1; i--){
			S[i] = values.get(k);
			k = P[k];
		}
		return S;

	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
