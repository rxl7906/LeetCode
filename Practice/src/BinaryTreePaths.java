import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BinaryTreePaths {
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> lst = new ArrayList<String>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        while(!stk.isEmpty()){
            TreeNode tn = stk.pop();
            // add tn to path
            path.add(tn.val);
            // check if tn is a leaf node
            if(tn.left == null && tn.right == null){
                // save the list and make a new one
                paths.add(path);
                path = new ArrayList<Integer>();
                path.add(root.val);
            } else {
                // add neighbor
                if(tn.right != null){
                    stk.add(tn.right);
                }
                if(tn.left != null){
                    stk.add(tn.left);
                }
            }
        }
        for(ArrayList<Integer> ar : paths){
        	StringBuilder sb = new StringBuilder();
            for(int i = 0; i < ar.size(); i++){
            	if(i == ar.size()-1){
            		sb.append(ar.get(i));
            	} else {
            		sb.append(ar.get(i)+"->");
            	}
            }
            lst.add(sb.toString());
            System.out.println(sb.toString());
        }
        return lst;
    }
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		binaryTreePaths(root);
	}
}
