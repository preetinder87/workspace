import java.util.ArrayList;


public class WGraph {
	class Node{
		char c;
		ArrayList<Integer> neighbour = new ArrayList<Integer>();
		public Node(char c){
			this.c = c;
		}
	}
	
	Node[]  nodes;
	int nodeCount = 0;
	int[] visited;
	
	public WGraph(char[][] array){
		nodes = new Node[array.length*array[0].length];
		visited = new int[nodes.length];
	}
	
	public void createGraph(char[][] a){
		for(int i = 0;i<a.length;i++){
			for(int j = 0; j<a[0].length; j++){
				nodes[nodeCount++] = new Node(a[i][j]);
			}
		}
		for(int i = 0;i<a.length;i++){
			for(int j = 0; j<a[0].length; j++){
				addNeighbour(a,i,j);
			}
		}
	}

	private void addNeighbour(char[][] a, int i, int j) {
		for(int iindex = i-1; iindex<=i+1; iindex++){
			if(iindex>=0&&iindex<a.length){
				for(int jindex = j-1; jindex<=j+1;jindex++){
					if(iindex*a[0].length+jindex ==i*a[0].length+j)
						continue;
					if(jindex>=0&&jindex<a[0].length)
						nodes[i*a[0].length+j].neighbour.add(iindex*a[0].length+jindex);
				}
			}
		}
		
	}
	
	public boolean wordPresent(String word){
		boolean result = false;
		for(int i=0; i<nodeCount;i++){
			if(nodes[i].c == word.charAt(0)){
				visited[i]=1;
				result |= DFS(i,word.substring(1));
			}
			if(result)
				return result;
		}
		return result;
	}

	public boolean DFS(int index, String word) {
		if(word.length()==0)
			return true;
		for(int i = 0; i<nodes[index].neighbour.size(); i++){
			int nextIndex = nodes[index].neighbour.get(i);
			if(word.charAt(0)==nodes[nodes[index].neighbour.get(i)].c && visited[i]==0){
				visited[nextIndex]=1;
				return DFS(nextIndex,word.substring(1));
			}
		}
		return false;
	}
	
	public static void main(String[] arg){
		char[][] array = {{'S','M','E','F'},
						{'R','A','T','D'},
						{'L','O','N','I'},
						{'K','A','F','B'}};
		WGraph graph = new WGraph(array);
		graph.createGraph(array);
		if(graph.wordPresent("SAND")){
			System.out.println("YES");
		}
		
		
	}
}
