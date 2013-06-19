import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BST {
	class Node{
		int value;
		Node left;
		Node right;
		Node nextSibling;
		public Node(int v){
			value = v;
			left = null;
			right = null;
		}
	}
	
	Node root;
	
	public void insert(int v){
		root = insert(root, v);
	}
	
	public Node insert(Node x, int v){
		if(x==null){
			return new Node(v);
		}
		else{
			if(x.value>v){
				x.left = insert(x.left, v);
			}
			else
				x.right = insert(x.right,v);
		}
		return x;
	}
	
	public void inorder(){
		inorder(root);
	}
	
	public void inorder(Node x){
		if(x==null)
			return;
		else{
			inorder(x.left);
			System.out.println(x.value);
			inorder(x.right);
		}
	}
	
	public void preorder(){
		preorder(root);
	}
	
	public void preorder(Node x){
		if(x==null)
			return;
		else{
			System.out.println(x.value);
			preorder(x.left);
			preorder(x.right);
		}
	}
	
	public void min(){
		Node min = min(root);
		System.out.println(min.value);
	}
	
	public Node min(Node x){
		if(x.left==null)
			return x;
		else
			return min(x.left);
	}
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	
	public Node deleteMin(Node x){
		if(x.left == null)
			return x.right;
		else
			x.left = deleteMin(x.left);
		return x;
	}
	
	public void delete(int v){
		root = delete(root,v);
	}
	
	public Node delete(Node x, int v){
		if(x==null)
			return null;
		else if(x.value>v)
			x.left = delete(x.left, v);
		else if(x.value>v)
			x.right = delete(x.right, v);
		else{
			if(x.right == null)
				x = x.left;
			else{
				Node t = x;
				x = min(t.right);
				x.right = deleteMin(t.right);
				x.left = t.left;
			}
		}
		return x;
	}
	
	public int height(){
		return height(root);
	}
	
	public int height(Node x){
		if(x == null)
			return 0;
		else{
			int lh = height(x.left);
			int rh = height(x.right);
			return Math.max(lh+1, rh+1);
		}
	}
	static int sum = 0;
	public void leafSum(){
		leafSum(root);
		System.out.println(sum);
	}
	
	public void leafSum(Node x){
		if(x==null)
			return;
		else if(isLeaf(x)){
			sum+= x.value;
			return;
		}
		else
		{
			leafSum(x.left);
			leafSum(x.right);
		}
	
	}
		
	public boolean isLeaf(Node x){
		if(x.left==null&&x.right==null)
			return true;
		return false;
	}
	
	public void floor(int v){
		Node x = floor(root, v);
		System.out.println(x.value);
	}
	
	public Node floor(Node x, int v){
		if(x==null)
			return null;
		else if(x.value>v)
			return floor(x.left,v);
		else if(x.value==v)
			return x;
		Node t = floor(x.right,v);
		if(t!=null)
			return t;
		else
			return x;
	}
	
	/*public BST reverse(){
		BST tree = new BST();
		tree.root = reverse(root);
		return tree;
	}*/
	
	public void reverse(){	
		root = reverse(root);
	}
	
	public Node reverse(Node x){
		if(x==null)
			return null;
		else{
			Node temp1= reverse(x.left);
			Node temp2 = reverse(x.right);
			x.right = temp1;
			x.left = temp2;
		}
		return x;
	}
	
	//Binary Tree from preorder O(n) time
	
	public void createTree(int[] a){
		root  = createTree(a, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public Node createTree(int[]a, int i, int min, int max){
		if(i>=a.length){
			return null;
		}
		else if(!(a[i]<max && a[i]>min))
			return null;
		Node x = new Node(a[i]);
		i++;
		x.left = createTree ( a, i, min , x.value);
		x.right = createTree ( a, i, x.value , max);
		return x;
	}
	
	public void diameter(){
		int value  = diameter(root);
		System.out.println(value);
	}
	
	public int diameter(Node x){
		if(x==null){
			return 0;
		}
		int lh = height(x.left);
		int rh = height(x.right);
		
		int ld = diameter(x.left);
		int rd = diameter(x.right);
		return Math.max((lh+rh+2),Math.max(ld,rd));
	}
	
	public void search(int v){
		System.out.println(search(root,v));	
	}
	
	public int search(Node x, int val){
		if(x==null)
			return -1;
		if(x.value==val)
			return x.value;
		int v = search(x.left,val);
		if(v==-1)
			return(search(x.right,val));
		return v;
	}
	
	public void size(){
		System.out.println(size(root));
	}
	
	public int size(Node x){
		if(x==null)
			return 0;
		int ls = size(x.left);
		int rs = size(x.right);
		return(ls+rs+1);
	}
	
	Stack<Integer> st = new Stack<Integer>();
	Queue<Node> q = new LinkedList<Node>();
	
	public void printRevese(){
		printReverse(root);
	}
	
	public void printReverse(Node x){
		if(x==null)
			return;
		q.add(x);
		while(!q.isEmpty()){
			Node temp = q.remove();
			if(temp.right!=null)
				q.add(temp.right);
			if(temp.left!=null)
				q.add(temp.left);
			st.push(temp.value);
		}
		while(!st.empty())
			System.out.println(st.pop());
	}
	
	Node deepest;
	public void deepest(){
		int h = height(root);
		deepest(root, h);
	}
	
	public void deepest(Node x, int h){
		if(x!=null && h == 1){
			System.out.println(x.value);
			return;
		}
		if(x==null)
			return;
		deepest(x.left,h-1);
		deepest(x.right,h-1);
	}
	
	int []  path;
	public void printPath(){
		path = new int[height(root)];
		printpath(root, path,0);
	}
	
	public void printpath(Node x, int[] path, int i){
		if(x==null)
			return;
		if(isLeaf(x)){
			path[i] = x.value;
			print(path,i);
			return;
		}
		path[i] = x.value;
		//int[] path1=path;
		//int[]path2=path;
		printpath(x.left,path,i+1);
		printpath(x.right,path,i+1);
	}
	
	public void print(int [] pahth,int in){
		for(int i = 0; i<=in;i++)
			System.out.print(path[i]+" ");
		System.out.println();
	}
	
	public void sumOnPath(int sum){
		path = new int[height(root)];
		sumOnPath(root,sum,path,0);
	}
	
	public void sumOnPath(Node x, int sum, int [] path, int level){
		if(x==null)
			return;
		path[level]=x.value;
		int temp = sum;
		for(int i=level;i>-1;i--){
			temp=temp-path[i];
			if(temp==0)
				print(path, level,i);
		}
		sumOnPath(x.left,sum,path,level+1);
		sumOnPath(x.right,sum,path,level+1);
	}
	
	public void print(int [] path,int level,int k){
		for(int i = level; i>=k;i--)
			System.out.print(path[i]+" ");
		System.out.println();
	}
	
	public void setSibling(){
		setSibling(root);
	}
	
	public void setSibling(Node x){
		if(x==null)
			return;
		if(x.left!=null)
			x.left.nextSibling = x.right;
		if(x.right!=null)
			x.right.nextSibling = (x.nextSibling.left!=null)?x.nextSibling.left:null;
		setSibling(x.left);
		setSibling(x.right);
	}
	
	public void siblingOrder(){
		sOrder(root);
	}
	
	public void sOrder(Node x){
		if(x==null){
			return;
		}
		System.out.println(x.value);
		sOrder(x.nextSibling);
		if(x.left!=null)
			sOrder(x.left);
		
	}
	
	public void nrinOrder(){
		nonRInOrder(root);
	}
	
	public void nonRInOrder(Node x){
		Stack<Node> st = new Stack<Node>();
		while (true){
			while(x!=null){
				st.push(x);
				x=x.left;
			}
			if(st.isEmpty())
				break;
			else{
				x = st.pop();
				System.out.println(x.value);
				x=x.right;
			}
		}
	}
	
	public void nrpreOrder(){
		nonRpreOrder(root);
	}
	
	private void nonRpreOrder(Node x) {
		Stack<Node> st = new Stack<Node>();
		while (true){
			while(x!=null){
				System.out.println(x.value);
				st.push(x);
				x=x.left;
			}
			if(st.isEmpty())
				break;
			else{
				x = st.pop();
				x=x.right;
			}
		}
		
	}
	
	public void maxNoOfNode(){
		maxNoNode(root,1);
	}
	


	private void maxNoNode(Node x, int i) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(x);
		q.add(null);
		int currentLevel=0;
		int max = 0;
		int nextLevelElement = 0;
		int maxLevel=0;
		while(true){
			Node temp = q.remove();
			if(temp==null){
				currentLevel++;
				if(nextLevelElement>max){
					max=nextLevelElement;
					maxLevel = currentLevel; 
				}
				nextLevelElement=0;
				if(q.isEmpty())
					break;
				
				q.add(null);
			}
			else{ 
			if(temp.left!=null){
				q.add(temp.left);
				nextLevelElement++;
			}
			if(temp.right!=null){
				q.add(temp.right);
				nextLevelElement++;
			}
			}
		}
		System.out.println(max+"  "+maxLevel);
		
	}

	public void nrpostOrder(){
		nonRpostOrder(root);
	}

	private void nonRpostOrder(Node x) {
		Stack<Node> st = new Stack<Node>();
		while(true){
			
		}
		
	}
	
	public void morrisTravesal(){
		morrisTraversal(root);
	}

	private void morrisTraversal(Node x) {
		if(x==null)
			return;
		Node current = x;
		while(current!=null){
			if(current.left==null){
				System.out.println(current.value);
				current = current.right;
			}
			else{
				Node pre = current.left;
				while(pre.right!=null&&pre.right!=current){
					pre=pre.right;
				}
				if(pre.right==null){
					pre.right=current;
					current=current.left;
				}
				else if(pre.right==current){
					pre.right=null;
					System.out.println(current.value);
					current = current.right;
				}
			}
		}
		
	}
	
	boolean  flag = false;
	
	public void printNextBig(int value){
		
		printNextBig(root,value);
	}
	
	public void printNextBig(Node x, int value){
		if(x!=null){
			printNextBig(x.left,value);
			if(flag==true){
				System.out.println(x.value);
				flag=false;
			}
			if(x.value==value){
				flag=true;
			}
			printNextBig(x.right,value);
		}
	}
	
	public void sumAllChild(){
		root = sumAllChildren(root);
	}

	private Node sumAllChildren(Node x) {
		if(x==null)
			return null;
		
		Node left = sumAllChildren(x.left);
		Node right = sumAllChildren(x.right);
		
		x.value = x.value+getValue(left) + getValue(right);
		
		return x;
		
	}
	
	

	private int getValue(Node x) {
		if(x==null)
			return 0;
		return x.value;
	}
	
	public void greaterSum(){
		greaterSum(root);
	}
	
	int sum1 = 0;
	private void  greaterSum(Node x) {
		if(x!=null)
		{	
		 greaterSum(x.right);
		x.value +=sum1;
		sum1 = x.value;
		greaterSum(x.left);
		
		}
	}
	
	public void trim(int low, int high){
		root = trim(root, low, high);
	}

	private Node trim(Node x, int low, int high) {
		if(x==null)
			return x;
		if(x.value>high)
			return trim(x.left,low,high);
		if(x.value<low)
			return trim(x.right,low,high);
		x.left = trim(x.left,low,high);
		x.right = trim(x.right,low,high);
		return x;
	}
	
	public void updateArray(){
		int[][] array = new int[5][5];
		ArrayList<Integer> list = new ArrayList<Integer>();
		updateArray(root,array,list);
		
		for(int i = 0; i<array.length;i++){
			for(int j=0; j<array[0].length; j++){
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}

	private void updateArray(Node x,int[][] array, ArrayList<Integer> list) {
		if(x==null)
			return;
		list.add(x.value);
		ArrayList<Integer>list1 = (ArrayList<Integer>)list;
		updateArray(x.left,array,list1);
		ArrayList<Integer>list2 = (ArrayList<Integer>)list;
		updateArray(x.right,array,list2);
		
		for(int i: list){
			array[i-1][x.value-1] = 1;
		}
	}
	
	Node cur;	
	
	public boolean hasNext(){
		return (cur!=null);
	}
	
	public int next(){
		int value = cur.value;
		cur = ceiling(root,null,value);
		return value;
	}
	
	public void range(int low, int high){
		range(root, low, high);
	}
	

	private void range(Node x, int low, int high) {
		if(x==null)
			return;
		if(x.value>=low)
			range(x.left, low, high);
		if(x.value<=high&&x.value>=low){
			System.out.println(x.value);
		}
		if(x.value<=high){
			range(x.right, low,high);
		}
	}

	private Node ceiling(Node x, Node pre, int value) {
		if(x==null)
			return pre;
		if(x.value<=value){
			return ceiling(x.right,pre,value);
		}
		if(x.value>value){
			return ceiling(x.left,x,value);
		}
		return null;
	}

	public static void main(String[] arg){
		BST tree = new BST();
		/*tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		//tree.preorder();
		//tree.floor(3);
		//System.out.println(tree.height());
		tree.reverse();
		tree.inorder();*/
		tree.insert(3);
		tree.insert(2);
		tree.insert(1);
		tree.insert(4);
		tree.insert(5);
		tree.cur = tree.min(tree.root);
		//tree.updateArray();
		while(tree.hasNext()){
			System.out.println(tree.next());
		}
		//tree.greaterSum();
		//tree.trim(5, 13);
		//tree.sumAllChild();
		//tree.inorder();
		//tree.printNextBig(11);
		//tree.morrisTravesal();
		//tree.maxNoOfNode();
		//tree.nrpreOrder();
		//tree.setSibling();
		//tree.printPath();
		//tree.sumOnPath(36);
		//tree.deepest();
		//tree.size();
		//tree.printRevese();
		//tree.search(9);
		//int[] a = {5,3,4,7};
		//tree.createTree(a);
		//tree.inorder();
		//tree.leafSum();
		//tree.diameter();
		//System.out.println(tree.height());
		
	}
}
