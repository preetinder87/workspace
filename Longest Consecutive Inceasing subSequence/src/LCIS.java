import java.util.HashMap;


public class LCIS {
	public static int findLongestConsequence(int[] a) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int max = 1;
	    for (int i : a) {
	        if (map.containsKey(i)) continue;
	        map.put(i, 1);
	        if (map.containsKey(i - 1)) {
	            max = Math.max(max, merge(map, i-1, i));
	        }
	        if (map.containsKey(i + 1)) {
	            max = Math.max(max, merge(map, i, i+1));
	        }
	    }
	    return max;
	}

	private static int merge(HashMap<Integer, Integer> map, int left, int right) {
	    int upper = right + map.get(right) - 1;
	    int lower = left - map.get(left) + 1;
	    int len = upper - lower + 1;
	    map.put(upper, len);
	    map.put(lower, len);
	    return len;
	}
	
	public static void main(String[] as){
		int a[] = {6,3,4,9,7,8};
		System.out.println(findLongestConsequence(a));
	}

}
