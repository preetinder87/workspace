import java.util.HashMap;


public class BMMatching {
	
	static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	
	public static int BoyerMoor(String text, String pattern){
		builtMap(pattern);
		int n = text.length();
		int m = pattern.length();
		int i = m-1;
		int j = m-1;
		int val = -1;
		if(i>n-1)
			return -1;
		do{
			val =-1;
			if(text.charAt(i)==pattern.charAt(j)){
				if(j==0)
					return i;
				else{
					i--;
					j--;
				}
			}
			else{
				if(map.get(text.charAt(i))!=null)
					val = map.get(text.charAt(i));
				 i = i+m-Math.min(j,1+val);
				 j=m-1;
			}
		}while(i<=n-1);
		return -1;
	}
	
	public static void builtMap(String str){
		for(int i =0; i<str.length();i++){
				map.put(str.charAt(i), i);
		}
	}
	
	public static void main(String[] str){
		String text = "ccdab";
		String pattern = "cd";
		System.out.println(BoyerMoor(text,pattern));
		
	}
	

}
