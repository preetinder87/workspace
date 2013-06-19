import java.util.Stack;


public class NextMax {
	public static void main(String[] ar){
		int [] a = {4,2,131,3,25};
		printNextMax(a);
	}

	private static void printNextMax(int[] a) {
		Stack<Integer> min = new Stack<Integer>();
		min.push(-1);
		
		for(int i = a.length-1; i>=0; i--){
			while(min.peek()!=-1){
				if(a[i]<min.peek()){
					System.out.println(min.peek());
					min.push(a[i]);
					break;
				}
				else
					min.pop();
			}
			if(min.peek()==-1){
				System.out.println(min.peek());
				min.push(a[i]);
			}
		}
		
	}

}
