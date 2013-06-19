
public class RBTree {
	private final boolean RED = true;
	public final boolean BLACK = false;
	
	class Node{
		int value;
		Node left;
		Node right;
		boolean color;
		public Node(int value, boolean color){
			this.value = value;
			this.color = color;
		}
	}
	
	Node root;
	
	public void insert(int value){
		root = insert(root, value);
	}

	private Node insert(Node x, int value) {
		if(x==null)
			return new Node(value, RED);
		else if(x.value<value)
			x.right = insert(x.right,value);
		else
			x.right = insert(x.left, value);
		if(isRed(x.right)&&!isRed(x.left)) x = rotateleft(x);
		if(isRed(x.left)&&isRed(x.left.left)) x = rotateright(x);
		if(isRed(x.left)&&isRed(x.right)) x = flip(x);
		return x;
	}

	private Node rotateleft(Node x) {
		Node temp = x.right;
		x.right = temp.left;
		temp.left = x;
		temp.color = x.color;
		x.color = RED;
		return temp;
	}

	private Node rotateright(Node x) {
		Node temp = x.left;
		x.left = temp.right;
		temp.right = x;
		temp.color = x.color;
		x.color = RED;
		return temp;
	}

	private Node flip(Node x) {
		x.left.color = BLACK;
		x.right.color = BLACK;
		x.color = RED;
		return x;
	}

	private boolean isRed(Node x) {
		if(x==null)
			return false;
		return x.color == RED;
	}
	
	public void inOrder(){
		inorder(root);
	}

	private void inorder(Node x) {
		if(x!=null){
			inorder(x.left);
			System.out.println(x.value);
			inorder(x.right);
		}
	}
	
	public void maxHeight(){
		int height = maxHeight(root);
		System.out.println(height);
	}

	private int maxHeight(Node x) {
		if(x==null)
			return -1;
		
		int leftHeight = maxHeight(x.left);
		int rightHeight = maxHeight(x.right);
		
		return(Math.max(leftHeight+1, rightHeight+1));
	}
	
	public static void main(String[] str){
		RBTree tree = new RBTree();
		int[] a = {1,2,3,4,5,6,7,8};
		for(int i:a){
			tree.insert(i);
		}
		tree.maxHeight();
		tree.inOrder();
		
	}
	
	
	

}
