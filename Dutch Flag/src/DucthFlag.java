
public class DucthFlag {
	
	public static void main(String[] arg){
		int[] a = {1,2,3,1,1,1,2,2,3};
		dutchFlag(a);
		for(int i: a)
			System.out.println(i);
	}

	private static void dutchFlag(int[] a) {
		int low = 0; 
		int high = a.length-1;
		int mid = 0;
		
		while(mid<=high){
			switch(a[mid]){
			case 1:
				swap(a,low,mid);
				low++;
				mid++;
				break;
			case 2:
				mid++;
				break;
			case 3:
				swap(a,high,mid);
				high--;
				break;
			}
		}
		
		
	}

	private static void swap(int[] a, int low, int high) {
		int temp = a[low];
		a[low] = a[high];
		a[high] = temp;
	}

}
