import java.util.LinkedList;


public class LS {
	
	static int max = 0;
	static LinkedList<Integer> list = new LinkedList<Integer>();
	
	public static void main(String[] arg){
		int[][] a = {{4,7,9,8},
					 {5,6,5,4},
					 {6,7,8,5},
					 {10,9,7,6}};
		
		int[][] visited = new int[a.length][a[0].length];
		
		longestSnack(a,visited);
		
		for(int i : list)
			System.out.println(i);
	}

	private static void longestSnack(int[][] a, int[][] visited) {
		for(int i = 0; i<a.length;i++){
			for(int j = 0; j<a[0].length; j++){
				if(visited[i][j]==0){
					LinkedList<Integer> snack = new LinkedList<Integer>();
					snack(a,i,j,visited,snack);
				}
			}
		}
		
	}



	private static void snack(int[][] a, int i, int j, int[][] visited,LinkedList<Integer> snack) {
		
		visited[i][j] = 1;
		snack.add(a[i][j]);
		
		for(int k = i-1; k<=i+1; k++){
			if(k<0||k>a.length-1)
				continue;
			for(int m = j-1; m<=j+1; m++){
				if(m<0||m>a[0].length-1)
					continue;
				if(m==j&&k==i)
					continue;
				if(visited[k][m]==0&&(a[k][m]==a[i][j]+1||a[k][m] == a[i][j]-1)){
					snack(a,k,m,visited,snack);
				}
			}
		}
		
		if(snack.size()>max){
			list.removeAll(list);
			for(int l: snack)
				list.add(l);
			max = snack.size();
		}
		
		snack.removeLast();
	}
	
}
