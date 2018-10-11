package trees;

public class IsTreeSymetric {
	
	private boolean isMirror(TreeNode<Integer> t, TreeNode<Integer> t1) {
		if(t == null && t1 == null) return true;
		if(t == null || t1 == null) return false;
		
		if(!t.value.equals(t1.value)) return false;
		
		return isMirror(t.left, t1.right) && isMirror(t.right, t1.left);
	}
	
	public boolean isTreeSymetric(TreeNode<Integer> t) {
		if(t == null) return true;
		
		return isMirror(t.left, t.right);
	}
}
