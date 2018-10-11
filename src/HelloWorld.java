import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class HelloWorld {
	
	List<Integer> plan = new ArrayList();
	
	class factory {
		
		public class order {
			
			int currentLeaf;
			int[] leaves;
			
			public order(int[] i) {
				leaves = i;
				currentLeaf = 0;
			}
		}
		
		public order[] createOrder(int[][] orderList) {
			int l = orderList.length;
			order[] orders = new order[l];
			for(int i=0;i<l;i++) {
				orders[i] = new order(orderList[i]);
			}
			return orders;
		}
		
	}
	

	public static void main(String[] args) {
		
//		factory f= new factory();
//		int[][] ints = new int[][]{{0,1,2},{0,2},{1,3}};
//		order[] orders = f.createOrder(ints);
//		
//		int[] o = new int[] {0,1,2};
//		order o1 = new order(o);
//		
//		order o2 = new order({0,2});
//		order[] orders = new order[]{(new order({0,1,2})}; 
//		
//		for(int i=0;i<orders.length;i++) {
//			traverse(orders[i]);
//		}
		
		
	}

}
