import java.util.HashMap;
import java.util.Map;

public class APS {
	public static void main(String[] arg){
		int[] a = {12,1,2,4,5,7};
		int end = a.length;
		Map<String,Integer> map = new HashMap<String,Integer>();
		System.out.println(findNumOccurence(a,map,end-1,12));
	}

	public static int findNumOccurence(int[] a, Map<String, Integer> map, int end, int target){
		target = Math.abs(target);
		String key = Integer.toString(end)+Integer.toString(target);
		
		if(map.get(key)!=null)
			return map.get(key);
		
		else if(target==0)
			return 1;
		
		else if(end<0)
			return 0;

		int with = findNumOccurence(a,map,end-1,target-a[end]);
		int without = findNumOccurence(a, map, end-1, target);

		int value = with+without;

		map.put(key,value);

		return value;

	}
	
//	public static void main(String[] arg){
//		int a[] = {2,4,6,8};
//		int target = 8;
//		System.out.println(totalWay(a,target));
//	}
//
//	private static int totalWay(int[] a, int target) {
//		HashMap<String,Integer> map = new HashMap<String, Integer>();
//		return totalWay(a,a.length-1,target,map);
//	}
//
//	private static int totalWay(int[] a, int end, int target, HashMap<String, Integer> map) {
//		target = Math.abs(target);
//		String key = Integer.toString(end)+"."+Integer.toString(target);
//		if(map.get(key)!=null)
//			return map.get(key);
//		else if(target==0)
//			return 1;
//		else if(end<0)
//			return 0;
//		int withEnd = totalWay(a,end-1, target-a[end],map);
//		int withoutEnd = totalWay(a,end-1, target,map);
//		int value = withEnd+withoutEnd;
//		map.put(key,value);
//		return value;
//	}

}
