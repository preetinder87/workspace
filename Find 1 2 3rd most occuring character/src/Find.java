import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Find {
	
	static class Node{
		char c;
		int frequency;
		public Node(char c, int freq){
			this.c = c;
			frequency = freq;
		}
	}
	
	public static void main(String[] arg){
		String str = "Aabra ka daabra";
		char c = getCharacter(str,1);
		System.out.println(c);
	}

	private static char getCharacter(String str, int ith) {
		Node[] heap=createHeap(str);
		return getith(heap,ith);
	}

	private static char getith(Node[] heap, int ith) {
		int i = 0;
		char c;
		int position = heap.length-1;
		while(true){
			c = heap[++i].c;
			if(i==ith){
				break;
			}
			else{
				Node temp = heap[position];
				heap[position]=heap[i];
				heap[i] = temp;
				position--;
				heapify(heap,position);
			}
		}
		return c;
	}

	private static Node[] createHeap(String str) {
		HashMap<Character, Node> map = new HashMap<Character, Node>();
		int unique = 0;
		for(int i = 0; i<str.length(); i++){
			char temp = str.charAt(i);
			if(map.get(temp)==null){
				Node node = new Node(temp,1);
				map.put(temp,node);
				unique++;
			}
			else{
				Node node = map.get(temp);
				node.frequency +=1;
				map.put(temp, node);
			}
		}
		
		Iterator it = map.entrySet().iterator();
		
		Node[] array = new Node[unique+1];
		int i = 0;
		while(it.hasNext()){
			Map.Entry<Character, Node> pair = (Entry<Character, Node>) it.next();
			array[++i] = pair.getValue();
		}
		
		array = heapify(array,array.length-1);
		return array;
		
	}

	private static Node[] heapify(Node[] array,int position) {
		int k = position;
		while(k!=1){
			sink(array,k/2, position);
			k--;
		}
		return array;
	}

	private static void sink(Node[] array, int i, int position) {
		while(2*i<=position){
			int j = 2*i;
			if(j<position && array[j+1].frequency>array[j].frequency)
				j=j+1;
			if(array[j].frequency<array[i].frequency)
				break;
			Node temp = array[j];
			array[j] = array[i];
			array[i] = temp;
			i = j;
		}
		
	}

}
