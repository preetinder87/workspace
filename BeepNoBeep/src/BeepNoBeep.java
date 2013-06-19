
public class BeepNoBeep {
	public static void main(String[] arg){
		int[] a = {1,1,1,2,2,2,2,2,2,4};
		beepNoBeep(a);
	}

	public static void beepNoBeep(int[] a){
		if(a==null)
			return;
		int indicator = 0;
		for(int i = 0; i<a.length; i++){
			if((indicator ^ 1<<a[i])>0)
				System.out.println("Beep");
			else{
				System.out.println("No beep");
				indicator = indicator | 1<<a[i];
			}
		}
	}

}
