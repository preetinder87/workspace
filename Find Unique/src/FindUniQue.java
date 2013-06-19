
public class FindUniQue {
	public static void main(String[] arg){
		int[] a = {1,1,1,1,1,1,1,2,3,4};
		int cur = a[0];
		int pre = a[0];
		int flag = 0;
//		for(int i = 1; i<a.length; i++){
//			cur = a[i];
//			if(cur != pre){
//				if(flag==1){
//					System.out.println(cur);
//					break;
//				}
//				else{
//					cur = ((a[i+1]==cur)?pre:cur);
//					System.out.print(cur);
//					break;
//				}
//			}
//			else{
//				pre = cur;
//				flag = 1;
//			}
//		}
		
		for(int i = 0; i<a.length; i++){
			if(i==0){
				if(a[i]!=a[i+1])
					System.out.println(a[i]);
			}
			else if(i==a.length-1 && a[i-1]!=a[i])
				System.out.println(a[i]);
			else if(a[i]!=a[i-1]&&a[i]!=a[i+1])
				System.out.println(a[i]);
		}
	}

}
