
public class NSSC {
	
	public static void main(String[] arg){
		String str = "276";
		System.out.println(numString(str));
	}

	private static int numString(String str) {
		int count =0;
		
		if(str.length()==0){
			return 1;
		}
		
		if(str.length()==1){
			return numString(str.substring(1));
		}
		
		String s = (String) str.subSequence(0, 2);
		
		if(Integer.parseInt(s)<27){
			count += numString( str.substring(2));
		}
		
		count+=numString(str.substring(1));
		
		return count;
	}

}
