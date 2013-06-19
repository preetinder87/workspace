
public class DLL {
	class Node{
		int value;
		Node next;
		Node pre;
		public Node(int v, Node next, Node pre){
			value =v;
			this.next = next;
			this.pre = pre;
		}
	}
	
	Node head;
	
	public void insert(int v){
		head = insert(head,null,v);
	}

	private Node insert(Node x, Node pre, int v) {
		if(x==null){
			return new Node(v,null,pre);
		}
		x.next = insert(x.next,x,v);
		return x;
	}
	
	public void print(){
		Node it = head;
		while(it!=null){
			if(it.pre==null)
				System.out.println("Null"+" "+it.value);
			else
				System.out.println(it.pre.value+" "+it.value);
			it = it.next;
		}
	}
	
	public void reverseDLL(){
		head = reverseDLL(head,null);
		head.pre = null;
	}
	
	private Node reverseDLL(Node x, Node pre) {
		if(x==null){
			return pre;
		}
		Node temp = reverseDLL(x.next, x);
		x.next = pre;
		if(pre!=null)
			pre.pre = x;
		return temp;
	}

	public static void main(String[] arg){
		DLL list = new DLL();
		int[] a = {1,2,3,4};
		for(int i:a){
			list.insert(i);
		}
		list.reverseDLL();
		list.print();
	}

}
