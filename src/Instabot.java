package codeFights.companyBots;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Instabot {
	

	public static boolean[] delivery(int[] order, int[][] shoppers) {
		boolean[] shopperDel = new boolean[shoppers.length];		
		double deliverTime = 0;
		int distance = order[0];
		
		for(int i=0;i<shoppers.length;i++) {
			deliverTime = (double)(distance + shoppers[i][0])/shoppers[i][1] + shoppers[i][2];
			if(deliverTime > (order[1] + order[2])) {
				shopperDel[i] = false;
			} else if(deliverTime < order[1]) {
				shopperDel[i] = false;
			} else {
				shopperDel[i] = true;
			}
		}
		
		return shopperDel;
	}
	
	public static boolean isAdmissibleOverpayment(double[] prices, String[] notes, double x) {
		
		double sum = 0;
		double price = 0;
		double percent = 0;
		String[] note = new String[2];
		java.text.NumberFormat nf = java.text.NumberFormat.getPercentInstance();
		
		for(int i=0;i<prices.length;i++) {
			price = prices[i];
			note = notes[i].split(" ");
			
			if(!note[0].toLowerCase().equals("same")) {
				try {
					percent = nf.parse(note[0]).doubleValue();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
			if(note[1].toLowerCase().equals("higher")) {
				sum += price/(percent + 1)*percent;
			} else if(note[1].toLowerCase().equals("lower")) {
				sum -= price/(1 - percent)*percent;
			}
		}
		
		if(sum > x) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param shoppers
	 * @param orders
	 * @param leadTime
	 * @return
	 * @throws ParseException
	 */
	public static boolean busyHolidays(String[][] shoppers, String[][] orders, int[] leadTime) throws ParseException {
			
		class toolClass {
			
			List<Integer> plan = new ArrayList<>();
			int count = 0;
			boolean can = false;
			
			class Order {
				Date from, to, latestFrom, earliestTo;
				List<Integer> canShopper = new ArrayList<>();
				int needTime = 0;
				boolean deliverable = false;
				public void addShopper(int i) {
					canShopper.add(i);
				}
			}
			
			class Shopper {
				Date from, to;
				int workMinutes = 0;
			}
						
			public toolClass(String[][] s, String[][] o, int[] l) throws ParseException {
				orderList = createOrders(o, l);
				shopperList = createShoppers(s);
			}
			
			public Order createOrder(String[] order, int leadTime) throws ParseException {
					
					Order o = new Order();
					
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");
					Calendar cal = Calendar.getInstance();
					o.from = df.parse(order[0]);
					o.to = df.parse(order[1]);
					cal.setTime(o.to);
					cal.add(Calendar.MINUTE, 0-leadTime);
					o.latestFrom = cal.getTime();
					
					cal.setTime(o.from);
					cal.add(Calendar.MINUTE, leadTime);
					o.earliestTo = cal.getTime();
					o.needTime = leadTime;
					return o;
				}
				
			public Order[] createOrders(String[][] orders, int[] leadTimes) throws ParseException {
					int orderNo = orders.length;
					Order[] orderList = new Order[orderNo];
					
					for(int i=0;i<orderNo;i++) {
						orderList[i] = this.createOrder(orders[i], leadTimes[i]);
					}
					
					return orderList;
				}
				
			public Shopper createShopper(String[] shoppers) throws ParseException {
					Shopper s = new Shopper();
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");
					s.from = df.parse(shoppers[0]);
					s.to = df.parse(shoppers[1]);
					s.workMinutes = (int)(s.to.getTime() - s.from.getTime())/60000;
					return s;
				}
				
			public Shopper[] createShoppers(String[][] shoppers) throws ParseException {
					int shopperNo = shoppers.length;
					Shopper[] shopperList = new Shopper[shopperNo];
					
					for(int i=0;i<shopperNo;i++) {
						shopperList[i] = this.createShopper(shoppers[i]);
					}
					
					return shopperList;
				}
			
			public void reverseOrder(int index) {
				int i = index;
				
				if(i == 0 && orderList.length == 1) {
					
					if(findShopper(orderList[i], count) == false) can = false;
					else can = true;
				}
				else if(i == orderList.length - 1) {
					if(findShopper(orderList[i], 0) == true) {
						can = true;
						} else {
							reverseOrder(--i);}
				} else if (i == 0) {
					count++;
					plan.clear();
					if(findShopper(orderList[i], count) == false) {can = false;}
					else
						reverseOrder(++i);
				} else {
					if(findShopper(orderList[i], 0) == true) {
						reverseOrder(++i);
				} 	else {
						reverseOrder(--i);
					}
				}
			}
			
			public boolean findShopper(Order o, int c) {
				o.deliverable = false;
				
				if(c > 0) c = c - 1;
				
				if(c == orderList.length) {return false;}
				else {
					for(int j=c;j<o.canShopper.size();j++) {
					int i = o.canShopper.get(j);
					if(!plan.contains(i)) {
						plan.add(i);
						o.deliverable = true;
						break;
					}
				}
			}
				return o.deliverable;
		}
					
			public void fillOrder() {
				
				for(int i=0;i<orders.length;i++) {
					for(int j=0;j<shoppers.length;j++) {			
						if((shopperList[j].to.compareTo(orderList[i].earliestTo) >=0) && 
						(shopperList[j].from.compareTo(orderList[i].latestFrom) <= 0) &&
						shopperList[j].workMinutes >= orderList[i].needTime) {
						orderList[i].addShopper(j);
						} 
					}
				}
			
			}
		
			Order[] orderList;
			Shopper[] shopperList;
		}
		
		toolClass t = new toolClass(shoppers, orders, leadTime);
		t.fillOrder();
		t.reverseOrder(0);
		return t.can;
		
	}
	
	public static void main(String[] args) throws ParseException {

//		String[][] orders = {{"14:30","15:00"}};
//		String[][] shoppers = {{"15:10","16:00"}, {"17:50","22:30"}, {"13:00","14:40"}};
//		int[] leadTime = {15};
		
		String[][] orders = {{"00:00","01:00"}, {"01:00","01:10"}, {"00:00","02:00"}};
		String[][] shoppers = {{"00:00","02:00"}, {"00:00","02:00"}, {"00:00","01:00"}, {"01:00","02:00"}};
		int[] leadTime = {0, 0, 120};
		
		boolean r = busyHolidays(shoppers, orders, leadTime);
		System.out.println((String.valueOf(r)));
	}
		
}
