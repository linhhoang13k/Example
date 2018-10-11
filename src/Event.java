import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


public class Event{
	int Eid;
	int locationX, locationY;
	ArrayList<Integer> price = new ArrayList<Integer>();
	int dist;

	public Event(int id,int X, int Y, ArrayList<Integer> pr){
		Eid = id;
		locationX = X;
		locationY = Y;
		price = pr;
	}

	public static void main(String[] args){
		int min = 0;
		Scanner sc = new Scanner(System.in);
		int nEvents = Integer.parseInt(sc.nextLine());
		if(nEvents == 0){
			System.out.println("no events available");
		}else{
	    ArrayList<Event> events = new ArrayList<Event>();
		for(int i=0; i<nEvents; i++){
			String temp = sc.nextLine();
			String[] t = temp.split(" ");
			int id = Integer.parseInt(t[0]);
			int X = Integer.parseInt(t[1]);
			int Y = Integer.parseInt(t[2]);
			ArrayList<Integer> price = new ArrayList<Integer>();
		    {
			  for(int i1=3; i1<t.length && t[i1]!=null; i1++){
				  price.add(Integer.parseInt(t[i1]));
			  }
			}
			Event e = new Event(id, X, Y, price);
			events.add(e);
		}
		int mBuyers = Integer.parseInt(sc.nextLine());
		System.out.println(mBuyers);
		ArrayList<Buyer> buyers = new ArrayList<Buyer>();
	    for(int i2=0; i2<mBuyers; i2++){
			String temp = sc.nextLine();
			System.out.println(temp);
			String t[] = temp.split(" ");
			int UX = Integer.parseInt(t[0]);
			int UY = Integer.parseInt(t[1]);
			Buyer b = new Buyer(UX, UY);
			buyers.add(b);
			System.out.println("Buyers Added with X and Y "+UX+" "+UY);
		}
	for(int m=0; m<buyers.size(); m++){
		for(int n=0; n<events.size(); n++){
			if(n==0){
				min = Math.abs(buyers.get(m).UX-events.get(n).locationX)+Math.abs(buyers.get(m).UY-events.get(n).locationY);
			    buyers.get(m).eid = events.get(n).Eid;
			    Collections.sort(events.get(n).price);
			    buyers.get(m).price = events.get(n).price.get(0);
			}
			else{
				int MD = Math.abs(buyers.get(m).UX-events.get(n).locationX)+Math.abs(buyers.get(m).UY-events.get(n).locationY);
			    if(MD < min){
			    	min = MD;
			    	 buyers.get(m).eid = events.get(n).Eid;
					 Collections.sort(events.get(n).price);
					 buyers.get(m).price = events.get(n).price.get(0);
			    }
			}
		}
		for(int i=0; i<events.size(); i++){
			if(buyers.get(m).eid == events.get(i).Eid){
				events.get(i).price.remove(0);
			}
			if(events.get(i).price.isEmpty()){
				events.remove(i);
			}
		}
	}
	for(int i=0; i<buyers.size(); i++){
		System.out.println("Buyer:"+(i+1)+" Event: "+buyers.get(i).eid+" Price: "+buyers.get(i).price);;
	}
		}
	System.out.println("Done");
	}	
	
}

class Buyer{
	int UX, UY, eid, price;
	public Buyer(int X, int Y){
		this.UX = X;
		this.UY = Y;
	}
}
