import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class TempFile {
	static int n = 2;

	public static void main(String[] ar){
		int[] a = {1,2,3,4,5,6,7,8};
		
		int[] result = new int[n];
		
		setOftwo(a,result, 0, n, a.length);
	}

	private static void setOftwo(int[] a, int[] result, int start, int k, int length) {
		
		if(k==0){
			for(int i: result)
				System.out.print(i+ " ");
			System.out.println();
			return;
		}
		
		for(int i = start; i<length;i++){
			result[n-k] = a[i];
			setOftwo(a,result,i+1,k-1,length);
		}
		
		
	}

}
