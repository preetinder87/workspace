
public class ASOFA {
	
	public static void main(String[] arg){
		int a[] = {1,2,3,4};
		int n = 2;
		int aux[] = new int [n]; 
		generateAllSubSet1(a,0,0,aux);
		
	}

	private static void generateAllSubSet(int[] a, int length, int n, int[] aux) {
		if(length+1<n)
			return;
		
		if(n==0){
			for(int i: aux)
				System.out.print(i+" ");
			System.out.println();
			return;
		}
		
		aux[n-1] = a[length];
		//generateAllSubSet(a, 0, n-1, aux);
			
		
	}

	private static void generateAllSubSet1(int[] a, int length, int n, int[] aux) {
		if(n==aux.length||length<0){
			for(int i: aux)
				System.out.print(i+" ");
			System.out.println();
			return;
		}
		for(int i = length; i<a.length; i++){
			aux[n] = a[i];
			generateAllSubSet1(a,i+1,n+1,aux);
		}
		
	}

}
