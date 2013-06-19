
public class Max {
	
	public static void main (String[] arg){
		int a[] = {40,2,4,9,11,2};
		findMax(a);
	}

	private static void findMax(int[] a) {
		int currentMin = a[0];
		int currentMax = 0;
		for(int i = 1; i<a.length;i++){
			currentMin = Math.min(currentMin, a[i]);
			currentMax = Math.max(currentMax, a[i]-currentMin);
		}
		System.out.println(currentMax);
	}

}
