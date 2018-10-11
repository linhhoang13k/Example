package tiendm.codefight.challenge.april;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopycatKeeper {
	String[][] copycatKeeper(String[][] books) {
		int n = books.length, c = 0, m = 0;
		for(int i=0; i< n; i++){
			if(books[i].length > m) m = books[i].length;
		}
		List<String> l = new ArrayList<>();
		for(int i = 0; i < m; i++){
			l.clear();c = 0;
			for(int j = 0; j < n; j++){
				try {
					l.add(books[j][i]) ;
				} catch(Exception e){
				}
			}
			Collections.sort(l);
 			for(int j = 0; j < n; j++){
				try {
					books[j][i] = l.get(c++);
				}catch(Exception e){
				}
			}
		}
		return books;
	}
	public static void main(String[] args) {
		
	}
}
