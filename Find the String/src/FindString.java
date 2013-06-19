
public class FindString {
	public static void main(String[] arg){
		String[][] str = new String[4][3];
		String cS = "abc";
		for(int i =0; i<3; i++){
			for(int j=0;j<3;j++)
				str[i][j] = "";
		}
		for(int i =0; i<3; i++){
			for(int j=i;j<3;j++){
				if(isWord(cS.subSequence(i, j+1))){
					str[i][j] += " "+cS.subSequence(i, j+1);
					continue;
				}
				if(i==0&&j==0)
					continue;
				else if(i==0)
					str[i][j] = str[i][j-1];
				else 
					str[i][j] = str[i][j-1]+str[i-1][j];
			}
		}
		
	}
	
	public static boolean isWord(CharSequence charSequence){
		if(charSequence.equals("a")||charSequence.equals("bc"))
			return true;
		return false;
	}
}
