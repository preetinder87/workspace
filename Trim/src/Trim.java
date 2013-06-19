
public class Trim {
	
	public static void main(String[] arg){
		char[] ch = {'1',' ',' ','e','m',' '};
		char temp=' ';
		boolean ws = false;
		int count = 0;
		for(int i =0;i<ch.length;i++){
			if((ch[i]==' ')&& ws){
				count++;
				continue;
			}
			if(ch[i]==' '){
				count++;
				temp = ch[i];
				ws = true;
			}
			else if(ws){
				ch[i-count] = temp;
				ws = false;
			}
			else{
				ch[i-count] = ch[i];
			}
				
		}
		
		for(int i = 0; i<ch.length;i++)
			System.out.print(ch[i]);
	}

}
