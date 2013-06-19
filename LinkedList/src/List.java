
public class List {
	class Node{
		int value;
		Node next;
		public Node(int x){
			value = x;
			next = null;
		}
	}
	Node head;
	
	public void insertFront(int x){
		head = insertFront(head,x);
	}
	
	public Node insertFront(Node x,int value){
		if(x==null)
			return new Node(value);
		else{
			Node n =  new Node(value);
			n.next = x;
			return n;
		}	
	}
	
	public void insertBack(int value){
		head = insertBack(head, value);
	}
	
	public Node insertBack(Node x, int value){
		if(x==null)
			return new Node(value);
		else
			x.next = insertBack(x.next, value);
		return x;	
	}
	
	public void printall(){
		Node x =  head;
		while(x!=null){
			System.out.println(x.value);
			x = x.next;
		}
	}
	
	public void rotate(int k){
		
	}
	
	public static void main(String[] arg){
		List  l =  new List();
		l.insertBack(20);
		l.insertFront(10);
		l.insertBack(30);
		l.insertBack(50);
		l.printall();
	}
}
