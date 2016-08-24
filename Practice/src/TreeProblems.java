import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

// binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val=val;
	}
}
class Node {
	int val;
	Node next;
	public Node(int val){
		this.val=val;
	}
}
public class TreeProblems {
	static void treeToLinkedLists(Node root){
		ArrayList<LinkedList<Node>> ar = new ArrayList<LinkedList<Node>>();
		Queue<Node> q = new LinkedList<Node>(); 
	}
	
	static int maxDepth(TreeNode root){
		if(root == null){
			return 0;
		} else {
			return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
		}
	}
	public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return minDepth(root.right)+1;
        }
        if(root.right == null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
	
	// leetcode
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = q.poll();
                level.add(head.val);
                if (head.left != null) {
                    q.add(head.left);
                }
                if (head.right != null) {
                    q.add(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }
	
	public static void printLevelOrder(List<List<Integer>> list){
		for(int i = 0; i < list.size(); i++){
			System.out.print("[");
			for(int j : list.get(i)){
				System.out.print(j + " ");
			}
			System.out.println("]");
		}
	}
	
	public static List<List<Integer>> levelOrderBackwards(TreeNode root) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = q.poll();
                level.add(head.val);
                if (head.left != null) {
                    q.add(head.left);
                }
                if (head.right != null) {
                    q.add(head.right);
                }
            }
            result.add(level);
        }

        // reverse result list
        for(int j = 0; j < result.size()/2; j++){
        	swap(result, j, result.size() - j - 1);
        }
        return result;
    }
	
	public static void swap(ArrayList<List<Integer>> list, int i, int j){
		List<Integer> tmp = list.get(j);
		list.set(i, list.get(j));
		list.set(j, tmp);
	} 
	// iteratively
	public static List<Integer> preorder(TreeNode root){
		List<Integer> traversal = new ArrayList<Integer>();
		if(root == null){
            return traversal;
        }
		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);
		while(!stk.isEmpty()){
			TreeNode tmp = stk.pop();
			//System.out.println(tmp.val);
			traversal.add(tmp.val);
			if(tmp.right != null){
				stk.push(tmp.right);
			}
			if(tmp.left != null){
				stk.push(tmp.left);
			}
		}
		return traversal;
	}
	
	// check if 2 binary trees are the same
	/*public static boolean isSameTree(TreeNode p, TreeNode q){
		List<Integer> ptraversal = preorder(p);
		List<Integer> qtraversal = preorder(q);
		System.out.println(ptraversal.size());
		System.out.println(qtraversal.size());
		if(ptraversal.size()!=qtraversal.size()){
			return false;
		}
		Iterator<Integer> pitr = ptraversal.iterator();
		Iterator<Integer> qitr = qtraversal.iterator();
		while(pitr.hasNext() && qitr.hasNext()){
			int i = pitr.next();
			int j = qitr.next();
			if(i != j){
				return false;
			}
		}
		return true;
	}*/
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        } else if(p == null || q == null){ // if not both equal null; else one of them equal null
            return false;
        }
        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(11);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(4);
		//System.out.println(minDepth(root));
		//printLevelOrder(levelOrder(root));
		//printLevelOrder(levelOrderBackwards(root));

		TreeNode p = new TreeNode(2);
		p.left = new TreeNode(3);
		p.left.left = new TreeNode(8);
		p.left.right = new TreeNode(7);
		p.right = new TreeNode(1);
		p.right.left = new TreeNode(9);
		p.right.right = new TreeNode(4);
		TreeNode q = new TreeNode(2);
		q.left = new TreeNode(3);
		q.left.left = new TreeNode(8);
		q.left.right = new TreeNode(7);
		q.right = new TreeNode(1);
		q.right.left = new TreeNode(9);
		q.right.right = new TreeNode(4);
		System.out.println(isSameTree(p,q));
	}
}
