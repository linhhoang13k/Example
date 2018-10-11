package tiendm.codefight.challenge.sep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestComponent {
	int smallestComponent(String[] matrix) {
		Character[][] charMatrix= new Character[matrix.length][matrix[0].length()];
		for(int i = 0; i < matrix.length;i++){
			String s = matrix[i];
			for(int j = 0; j < s.length(); j++){
				charMatrix[i][j] = s.charAt(j);
			}
		}
		Integer min = matrix.length * matrix[0].length();
		List<ArrayList<String>> ls = new ArrayList<>();
		Map<String, Integer> traceMap = new HashMap<>();
		for(int i = 0; i < charMatrix.length; i++){
			for(int j = 0; j < charMatrix[0].length; j++){
				check(charMatrix, ls, traceMap, i, j);
			}
		}
		for(ArrayList<String> s : ls){
			if(s.size() < min){
				min = s.size();
			}
		}
		return min;
	}
	
	
	private void check(Character[][] charMatrix, List<ArrayList<String>> ls, Map<String, Integer> traceMap, 
			int i, int j) {
		int a = i-1;
		int b = j-1;
		String posistion = buildKey(i, j);
		String posistion1 = buildKey(i, b);
		String posistion2 = buildKey(a, j);
		boolean c1 = isValid(charMatrix, i, b) && charMatrix[i][b].equals(charMatrix[i][j]);
		boolean c2 = isValid(charMatrix, a, j) && charMatrix[a][j].equals(charMatrix[i][j]);
		if(!c1 && !c2){
			ArrayList<String> lsComponent = new ArrayList<>();
			lsComponent.add(posistion);
			ls.add(lsComponent);
			traceMap.put(posistion, ls.size()-1);
		}else if(c1 && c2){
			Integer component1 = traceMap.get(posistion1);
			Integer component2 = traceMap.get(posistion2);
			if(component2 > component1){
				ls.get(component1).addAll(ls.get(component2));
				traceMap.put(posistion, component1);
				for(String s : ls.get(component2)){
					traceMap.put(s, component1);
				}
				ls.remove(component2.intValue());
				ls.get(component1).add(posistion);
				for(int x = component2; x < ls.size(); x++){
					ArrayList<String> lsComp = ls.get(x);
					for(String str : lsComp){
						Integer value = traceMap.get(str);
						traceMap.put(str, value-1);
					}
				}
			}else if (component2 < component1) {
				ls.get(component2).addAll(ls.get(component1));
				traceMap.put(posistion, component2);
				for(String s : ls.get(component1)){
					traceMap.put(s, component2);
				}
				ls.remove(component1.intValue());
				ls.get(component2).add(posistion);
				for(int x = component1; x < ls.size(); x++){
					ArrayList<String> lsComp = ls.get(x);
					for(String str : lsComp){
						Integer value = traceMap.get(str);
						traceMap.put(str, value-1);
					}
				}
			}else{
				ls.get(component2).add(posistion);
				traceMap.put(posistion, component2);
			}
		}else if (c1){
			Integer component = traceMap.get(posistion1);
			if(component != null){
				ls.get(component).add(posistion);
				traceMap.put(posistion, component);
			}else{
				ArrayList<String> lsComponent = new ArrayList<>();
				lsComponent.add(posistion);
				ls.add(lsComponent);
				traceMap.put(posistion, ls.size()-1);
			}
		}else{
			Integer component = traceMap.get(posistion2);
			if(component != null){
				ls.get(component).add(posistion);
				traceMap.put(posistion, component);
			}else{
				ArrayList<String> lsComponent = new ArrayList<>();
				lsComponent.add(posistion);
				ls.add(lsComponent);
				traceMap.put(posistion, ls.size()-1);
			}
		}
	}
	
	boolean isValid(Character[][] charMatrix, int i, int j){
		return (i >= 0 && i < charMatrix.length && j >= 0 && j < charMatrix[0].length);
	}
	
	String buildKey(int i, int j){
		return i + "-" + j;
	}
	
	public static void main(String[] args) {
		SmallestComponent s = new SmallestComponent();
		String[] str = { "1111111111111111", 
						 "1000111111100011", 
						 "0001111111101111", 
						 "1101111111001111", 
						 "1100011110000001", 
						 "1111000100100111", 
						 "1110000001100111", 
						 "1100110111110011", 
						 "1001100011111001", 
						 "1011001000111111", 
						 "1011111110001111", 
						 "1111111111111111"};
		System.out.println(s.smallestComponent(str));
	}
}
