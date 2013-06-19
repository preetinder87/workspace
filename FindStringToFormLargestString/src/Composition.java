import java.util.LinkedList;
import java.util.Stack;


public class Composition {
	public static void main(String[] arg){
		String[] str = {"the", "reaf","there","after", "thereafter","HenceForward"};
		findComposition(str);
	}

	private static void findComposition(String[] str) {
		for(int i = str.length-1;i>=0;i--){
			if(findComposition(str,str[i]))
				break;
		}
		
	}

	private static boolean findComposition(String[] str, String string) {
		//Stack<String> strStack = new Stack<String>();
		Stack<String> composition = new Stack<String>();
		//strStack.push(string);	
		if(findComposition(str, string,composition)){
			return true;
		}
		return false;
		
	}

	private static boolean findComposition(String[] str, String string,
			 Stack<String> composition
			) {
		if(string.length()==0){
			print(composition);
			return true;
		}
		boolean flag = false;
		char ch = string.charAt(0);
		LinkedList<String> list = getList(str,ch);
		for(String s: list){
			if(string.contains(s)){
				composition.push(s);
				//strStack.push(string.substring(s.length()));
				if(!findComposition(str, string.substring(s.length()),composition)){
					composition.pop();
					
				}
				else if(findComposition(str, string.substring(s.length()),composition)){
					flag =true;
					break;
				}
			}
		}
		return flag;
	}
	
	public static void print(Stack<String> com){
		while(!com.isEmpty()){
			System.out.println(com.pop());
		}
	}

	private static LinkedList<String> getList(String[] str, char ch) {
		LinkedList<String> list = new LinkedList<String>();
		for(int i = 0; i<str.length; i++){
			if(str[i].charAt(0)==ch)
				list.add(str[i]);
		}
		
		return list;
	}

}
