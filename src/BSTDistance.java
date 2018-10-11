package interview;

import java.util.ArrayList;
import java.util.List;

public class BSTDistance {
	BST root = null;

	public static void main(String[] args) {
		int[] values = {5,3,6,1,4,2};
		
		BSTDistance sol = new BSTDistance();
		
		for(int current: values){
			sol.root = sol.insert(sol.root, current);
		}
		
		System.out.println(sol.root);
		
		System.out.println(sol.distance2(sol.root,1,2));
	}

	
	public int distance2(BST root, int value1, int value2){
		if(root.value < value1 && root.value < value2){
			return distance2(root.right, value1, value2);
		}else if(root.value > value1 && root.value > value2){
			return distance2(root.left, value1, value2);
		}else{
			return distance(root, value1, value2);
		}
	}
	
	public int distance(BST root, int value1, int value2){
		List<Integer> node1 = route(root,value1);
		List<Integer> node2 = route(root,value2);
		
		if(node1 != null && node2 != null){
			List<Integer> result = new ArrayList<>(node1);
			result.removeAll(node2);
			node2.removeAll(node1);
			result.addAll(node2);
			return result.size();
		}else{
			return -1;
		}
	}
	
	public List<Integer> route(BST root, int value){
		ArrayList<Integer> result = new ArrayList<>();
		BST tmp = root;
		while(tmp != null && tmp.value != value){
			if(tmp.value > value){
				result.add(tmp.value);
				tmp = tmp.left;
			}else if(tmp.value < value){
				result.add(tmp.value);
				tmp = tmp.right;
			}
			
		}
		if(tmp != null){
			result.add(tmp.value);
		}else{
			result = null;
		}
		return result;
		
	}
	
	public BST insert(BST root, int value){
		if(root == null){
			root = new BST();
			root.value = value;
		}else if(root.value > value){
			root.left = insert(root.left, value);
		}else{
			root.right = insert(root.right, value);
		}
		return root;
	}
	
	public class BST{
		BST right;
		BST left;
		int value;
		
		public String toString(){
			return "[" + value + ":" + left + ", " + right + "]";
		}
	}
}
