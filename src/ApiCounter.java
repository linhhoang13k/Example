package companyBots.Wizelinebot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ApiCounter {

	class P {
		
		private String name;
		private int counter;
		private Map<String,P> p = new LinkedHashMap<>();
		
		/**
		 * @param name
		 */
		public P(String name) {
			super();
			this.name = name;
		}
		
		/**
		 */
		void increment() {
			counter++;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getCounter() {
			return counter;
		}

		public void setCounter(int counter) {
			this.counter = counter;
		}

		public Map<String, P> getP() {
			return p;
		}

		/**
		 * @param pp
		 * @return
		 */
		P updateP(String pp) { 
			P local = p.get(pp);
			if(local!=null && local.getName().equals(pp)) {
				local.increment();
			} else {
				local = new P(pp);
				local.increment();
				p.put(pp, local);
			}
			return local;
		}
		
	}
	/**
	 * @param calls
	 * @return
	 */
	String[] countAPI(String[] calls) {
		Map<String,P> map = new LinkedHashMap<>();
		for (String call : calls) {
			String[] apis = call.split("/");
			String project = apis[1];
			String subProject = apis[2];
			String method =  apis[3];
			P p = map.get(project);
			if(p == null) {
				p = new P(project); 
				map.put(project,p);
			}
			p.increment();
			//
			P pp = p.updateP(subProject);
			pp.updateP(method);
		}
		Set<String> apis = map.keySet();
		List<String> resultsList = new ArrayList<>();
		int i = 0;
		for(String api : apis) {
			P p = map.get(api); 
			int pCount = p.getCounter();
			resultsList.add("--" + p.getName() + " (" + pCount + ")");
			Map<String,P> subPMap = p.getP();
			Set<String> pps = subPMap.keySet();
			for(String ppKey : pps) {
				P pp = subPMap.get(ppKey);
				int ppCount = pp.getCounter();
				i++;
				resultsList.add("----" + pp.getName() + " (" + ppCount + ")");
				Map<String,P> methodMap = pp.getP();
				Set<String> mms = methodMap.keySet();
				for(String mmKey : mms) {
					P ppp = methodMap.get(mmKey);
					int pppCount = ppp.getCounter();
					i++;
					resultsList.add("------" + ppp.getName() + " (" + pppCount + ")");
				}
			}
			i++;
		}
		return resultsList.toArray(new String[0]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[] calls = {
				"/project1/subproject1/method1", 
				 "/project2/subproject1/m"
				 + "ethod1", 
				 "/project1/subproject1/method1", 
				 "/project1/subproject2/method1", 
				 "/project1/subproject1/method2", 
				 "/project1/subproject2/method1", 
				 "/project2/subproject1/method1", 
				 "/project1/subproject2/method1"
		};
		ApiCounter apiCounter = new ApiCounter();
		String[] results =apiCounter.countAPI(calls);
		System.out.println(Arrays.toString(results));
	}

}
