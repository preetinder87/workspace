
public class BNB {
	
	public  static void main(String[] arg){
		int a[] = {2,4,4,3,2,1};
		int pre = 0;
		int res = 0;
		for(int i=0;i<a.length;i++){
			res =pre^(1<<a[i]);
			//System.out.println(res+" "+pre);
			if(res>pre)
				//System.out.println("BEEP");
			//else
				//System.out.println("NO BEEP");
			pre = res;
		}
		System.out.println(swapBit(8));
		
	}
	
	public static int swapBit(int x){
		int a = ((x & 0xaaaaaaaa) >> 1);
		int b =((x & 0x55555555) << 1);
		System.out.println(a+" "+b);
		return(( ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1) ));
	}

}
