
public class IntervalTree {
	class Node{
		int low;
		int high;
		int max;
		Node left;
		Node right;
		
		public Node(int low, int high, int max){
			this.low = low;
			this.high = high;
			this.max = max;
		}
	}
	
	Node root;
	
	public void insert(int low, int high){
		root = insert(root, low, high);
	}
	
	public Node insert(Node x, int low, int high){
		if(x==null)
			return new Node(low, high, high);
		if(x.low<low){
			x.right = insert(x.right, low, high);
		}
		else{
			x.left = insert(x.left, low, high);
		}
		if(high>x.max)
			x.max = high;
		return x;
	}
	
	public void search(int low, int high){
		search(root,low,high);
	}

	private void search(Node x, int low, int high) {
		if(x==null)
			return;
		if(insersect(x,low,high)){
			System.out.println(x.low + " "+x.high + " "+ x.max);
			return;
		}
		else{
			if(low<= x.left.max)
				search(x.left, low, high);
			search(x.right,low, high);
		}
		
	}

	private boolean insersect(Node x, int low, int high) {
		if(x.low<=low&&x.high>=low)
			return true;
		if(low<=x.low&&x.low<=high)
			return true;

		return false;
	}
	
	private void inorder() {
		inorder(root);
		
	}
	
	private void inorder(Node x) {
		if(x!=null){
			inorder(x.left);
			System.out.println(x.low+" "+ x.high + " "+x.max);
			inorder(x.right);
		}
	}

	public static void main(String[] arg){
		IntervalTree tree = new IntervalTree();
		tree.insert(17, 19);
		tree.insert(5, 8);
		tree.insert(21, 24);
		tree.insert(4, 8);
		tree.insert(15,18);
		tree.insert(7, 10);
		tree.insert(16, 22);
		//tree.inorder();
		tree.search(21, 23);
	}

	
	

}
