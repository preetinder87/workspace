
public class Palindrom {
	public static void main(String[] arg){
		String str = "ab;;;;, cc;  b;  a";
		if(isPalindrome(str)){
			System.out.println("Yess");
		}
	}

	private static boolean isPalindrome(String str) {
		int length = str.length()-1;
		int start = 0;
		int end = length;
		while(start<end){
			while(notCharacter(str.charAt(start))){
				start++;
			}
			while(notCharacter(str.charAt(end))){
				end--;
			}
			if(str.charAt(start)!=str.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	private static boolean notCharacter(char c) {
		if(c>='a'&&c<='z'||c<='Z'&&c>='A')
			return false;
		return true;
	}

}
