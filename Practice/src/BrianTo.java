import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BrianTo {
	static void swapSides(TreeNode root){
	    if(root == null) return;
	    Stack<TreeNode> stk = new Stack<TreeNode>();
	    stk.push(root);
	    while(!stk.isEmpty()){
	        TreeNode swap = stk.pop();
	        TreeNode leftSwap = swap.left;
	        swap.left = swap.right;
	        swap.right = leftSwap;
	        if(swap.right != null){
	            stk.push(swap.right);
	        }
	        if(swap.left != null){
	            stk.push(swap.left);
	        }
	    }
	}
	
	static void printLevels(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode tmp = queue.poll();
			System.out.println(tmp.val);
			if(tmp.left != null){
				queue.add(tmp.left);
			}
			if(tmp.right != null){
				queue.add(tmp.right);
			}
		}
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		//printLevels(root);
		swapSides(root);
		printLevels(root);
	}
}
/*
@Data
final class TreeNode<Tasdf> {
    private final Tasdf obj;
    private final TreeNode<Tasdf> left;
    private final TreeNode<Tasdf> right;
    private final int sdfkljsladkfjdasf;

}

TreeNode<String> a = new TreeNode<String>(null, null, null);

a.getLeft();

new TreeNode<String>();

void swapSides(TreeNode root) throws Exception {
    if(root == null){
        return;
    }
    boolean isCycle = checkCycle(root);
    if (isCycle){
        // https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalStateException.html
        throw new Exception("The given node has a cycle");
    }
    
    Stack<TreeNode> stk = new Stack<TreeNode>();
    stk.push(root);
    
    Set<TreeNode> visited = new HashSet<TreeNode>();
    while(!stk.isEmpty()){
        TreeNode swap = stk.pop();
        TreeNode leftSwap = swap.left;
        swap.left = swap.right;
        swap.right = leftSwap;
        
        if(swap.right != null){
            stk.push(swap.right);
        }
        if(swap.left != null){
            stk.push(swap.left);
        }
    }
    
}


class TreeNodeWrapper {
    TreeNode root;
    TreeNode originalLeft;
    TreeNode originalRight;
}

Set<TreeNodeWrapper> wrappers = ...;

static void swapSides(final @NonNull TreeNode root) {

    root = new TreeNode<>();
    TreeNode left = root.left;
    TreeNode right = root.right;
    
    if (wrappers.contains(root)) {
        throw new IllegalStateException(...);
    }
    
    wrappers.add(new TreeNodeWrapper(root, left, right));
    
    root.left = right;
    root.right = left;
}

for (TreeNodeWraper w : wrappers) {
    // Swap if originals' left/right match current left/right.
}

Map<Integer,String> stuff = Stream
    .of("hi", "my", "name", "is", "karl")
    .map(String::toUpperCase)
    .collect(Collectors.groupingBy(s -> s.contains("i"), toList());
   
   // true => "hi is"
   // false => "my name karl"
   
doStuff() // takes a long time to complete, may fail

ComputableFuture.supplyAsync(this::doStuff) // invokes doStuff
//    .thenRun(result -> /* do stuff with result of function *///)
//    .exceptionally(exception -> /* do stuff with exception */)
//    ;
//*/