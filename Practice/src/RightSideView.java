import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
	public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        if(root == null) return lst;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode tn = q.poll();
            lst.add(tn.val);
            if(tn.right != null){
                q.add(root.right);
            } else {
                q.add(root.left);
            }
        }
        return lst;
    }
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);
		List<Integer> lst = rightSideView(root);
		for(int i : lst){
			System.out.println(i);
		}
	}
}
