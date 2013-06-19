
public class RD {
	
	public static void main(String[] str){
		int a[] = {4,3,5,4,5,9,9};
		int tail = 1;
		for(int i=0;i<a.length;i++){
			int j;
			for(j=0;j<tail;j++){
				if(a[i]==a[j]){
					break;
				}
			}
			if(j==tail){
				a[tail]=a[i];
				tail++;
			}
		}
		for(int i =0;i<tail;i++)
			System.out.println(a[i]);
	}

}
