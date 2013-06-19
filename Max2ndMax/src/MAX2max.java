
public class MAX2max {
	
	public static void main(String[] arg){
		int a[] = {7,543};
		int result[] = max2ndMax(a,0,a.length-1);
		System.out.println(result[0] + "   "+result[1]);
	}

	private static int[] max2ndMax(int[] a, int start, int end) {
		int result[] = new int[2];
		if(end==start){
			result[0] = a[start];
			result[1] = Integer.MIN_VALUE;
		}
		else{
			int mid = start+(end-start)/2;
			int result1[]= max2ndMax(a, start, mid);
			int result2[] = max2ndMax(a,mid+1,end);
			result = getResult(result1, result2);
		}
		return result;
	}

	private static int[] getResult(int[] a, int[] b) {
		int result[] = new int[2];
		if(a[0]>b[0]){
			result[0]=a[0];
			if(a[1]>b[0])
				result[1]=a[1];
			else
				result[1]=b[0];
		}
		else{
			result[0] = b[0];
			if(b[1]>a[0])
				result[1]=b[1];
			else
				result[1]=a[0];
		}
		return result;
	}

}
