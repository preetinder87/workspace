
public class Program {
	public class Node{
		int value;
		Node next;
		Node(int value){
			this.value = value;
			next = null;
		}
	}
	
	Node head = new Node(0);
	
	public void incrementCounter(){
		updateValue(head);
	}
	
	public void updateValue(Node x){
		if(x.value<9999){
			x.value = x.value+1;
			return;
		}
		else{
			if(x.next==null){
				x.value = 0;
				x.next = new Node(0);
				updateValue(x.next);
			}
			else{
				x.value = 0;
				updateValue(x.next);
			}
		}
	}
	
	public String showValue(){
		return showValue(head);
	}
	
	public String showValue(Node x){
		if(x.next==null){
			return Integer.toString(x.value);
		}
		else{
			return showValue(x.next)+pro(x.value);
		}
	}
	
	public String pro(int v){
		if(v<10){
			return("000"+Integer.toString(v));
		}
		else if(v<100){
			return("00"+Integer.toString(v));
		}
		else if(v<1000) {
			return("0"+Integer.toString(v));
		}
		else{
			return Integer.toString(v);
		}
	}
	
	public static void main(String[] arg){
		Program obj = new Program();
		for(int i = 0; i<100001111; i++)
			obj.incrementCounter();
		System.out.println(obj.showValue());
	}
	
	
	

}
