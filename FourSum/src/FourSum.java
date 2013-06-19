import java.util.ArrayList;


public class FourSum {
	public static void main(String[] arg){
		int[] a = {1,-2,-2,3,5,0,2};
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 1;
		findSum(a,a.length-1,sum,list);
	}

	private static void findSum(int[] a, int end, int sum, ArrayList<Integer> list) {
		if(list.size()==4){
			int currentSum=0;
			for(int i: list)
				currentSum +=i;
			if(currentSum==sum){
				for(int i: list)
					System.out.print(i+" ");
				System.out.println();
			}	
			return;
		}
		if(end<0){
			return;
		}
		ArrayList<Integer> list1 = (ArrayList<Integer>) list.clone();
		ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
		findSum(a,end-1,sum,list1);
		list2.add(a[end]);
		findSum(a,end-1,sum,list2);
	}

}
