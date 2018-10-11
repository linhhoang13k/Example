package comp2402a1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.*;

public class Part8 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		HashMap<String, Integer> strings = new HashMap<>();
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			if(strings.containsKey(line)) {
				strings.put(line, strings.get(line)+ 1);
			}
			else {
				strings.put(line, 0);
			}
		}
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(strings.entrySet());

		Collections.sort(list, new MyComparator());
		for(int i = list.size()-1; i > -1; i--){
			w.println(list.get(i).getKey());
		}


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

class MyComparator implements Comparator<Entry<String, Integer>> {
  public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		if(o1.getValue().compareTo(o2.getValue()) == 0){
			return o2.getKey().compareTo(o1.getKey());
		}
    return o1.getValue().compareTo(o2.getValue());
  }
}
