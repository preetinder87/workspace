package snippet;

public class SortedArraySearch {
	
	public static void main(String[] arg){
		int a[][] = {{1,2,3},{5,6,7}};
		int element = 9;
		int column = a[0].length;
		int row = a.length;
		int i = 0, j= column-1; 
		while(i<row && j>0){
			if(a[i][j]==element)
				break;
			else if(a[i][j]>element)
				j--;
			else
				i++;
		}
		System.out.println(i + "  " + j);
	}

}
