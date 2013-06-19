
public class Search {
	public static void main(String[] arg){
		int[] a = {1,2,1,2,3,4,3,2,3};
		int index = find(a,0,a.length-1,3);
		System.out.println(index+"  "+a[index]);
	}

	private static int find(int[] a, int start, int end, int num) {
		if(start>end)
			return -1;
		if(start==end){
			return (a[end]==num?end:-1);
		}
		if(start==end-1){
			return (a[start]==num?start:(a[end]==num?end:-1));
		}
		int mid = start+(end-start)/2;
		int tempIndex = find(a,start,mid,num);
		if(tempIndex!=-1){
			return tempIndex;
		}
		return find(a,mid,end,num);
	}

}
