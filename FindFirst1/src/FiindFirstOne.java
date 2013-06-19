
public class FiindFirstOne {
	
	public static void main(String[] ar){
		int[] a = {};
		findOneIndex(a);
	}

	private static void findOneIndex(int[] a) {
		if(a.length<1){
			System.out.println("Not Possible");
			return;
		}
		int low = 0;
		int high = low+1;
		while(high<a.length){
			if(a[high]==1)
				break;
			if(high>1)
				high*=high;
			else
				high*=2;
		}
		
		if(high>=a.length){
			high = a.length-1;
		}
		
		int result = -1;
		if((result =findOne(a, low, high))!=-1)
			System.out.println("Yes "+result);
		else
			System.out.println("No 1");
		
	}

	private static int findOne(int[] a, int low, int high) {
		int mid = low+(high-low)/2;
		int index = -1;
		if(high<low)
			return index;
		if(high==low)
			return (a[high]==1)?high:-1;
		if(high==low+1){
			index = (a[high]==1)?high:(a[low]==1)?low:-1;
			return index;
		}
		
		if((index=findOne(a,low,mid))!=-1){
			return index;
		}
		else{
			return findOne(a,mid,high);
		}
	}

}
