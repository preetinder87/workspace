
public class RLA {
	
	public static void main(String[] ae){
		int a [] = {1};
		int i =1;
		int pre = a[0];
		int counter = 1;
		while(i!=a.length){
			if(a[i]!=pre){
				System.out.print(counter+" "+pre+" ");
				counter = 1;
				pre = a[i];
			}
			else{
				counter++;
			}
			i++;
		}
		System.out.print(counter+" " + pre);
	}

}
