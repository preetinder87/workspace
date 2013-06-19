
public class BH {
	int position = 0 ;
	
	int[]a;
	
	public BH(int cp){
		a = new int[cp+1];
	}
	
	public void insert(int v){
		
		if(position+1<a.length){
			a[position] = v;
		}
		else if(a[1]<v){
			a[1] = v;
			sink(1);
		}
	}
		
	public void sink(int k){
		while(2*k<=position){
			int j = 2*k;
			if((a[j]>a[j+1])&&(j<position))
				j = j+1;
			if(a[k]<a[j])
				break;
			int temp = a[j];
			a[j] = a[k];
			a[k] = temp;
			k= j;
		}
	}
	
	public void createheap(int[] array){
		for(int i = 0; i<a.length-1; i++){
			position++;
			a[i+1] = array[i];
		}
		heapify();
	}
	
	public void heapify(){
		int k = position;
		while(k!=1){
			sink(k/2);
			k--;
		}
	}
	
	public static void main(String[] arg){
		BH heap = new BH(3);
		int a[] =  {2,4,1,3,4};
		heap.createheap(a);
		int i = 3;
		while(i<a.length){
			heap.insert(a[i]);
			i++;
		}
		for(int k= 1; k<heap.a.length; k++)
			System.out.println(heap.a[k]);
	}
	

}
