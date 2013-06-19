
public class Program {
	public static void main(String[] arg){
		int a[] = {1,2,4,6};
		int b[] = {1,4,6,7};
		int i = 0, j= 0;
		while(true){
			if(i>a.length-1||j>b.length-1)
				break;
			if(a[i]==b[j]){
				System.out.println(a[i]);
				i++;
				j++;
			}
			else if(a[i]<b[j])
				i++;
			else
				j++;
		}
	}
}
