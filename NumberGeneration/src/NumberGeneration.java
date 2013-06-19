
public class NumberGeneration {
	public static void main(String[] ar){
		int high = 999999;
		int low = 0;
		int num = low;
		numberGenerate(num,low,high, 1, 2);
	}

	private static boolean numberGenerate(int num, int low, int high, int i, int j) {
		if(num>high)
			return false;
		
		if(num<high&&num>low)
			System.out.println(num);
		
		for(; i<10; i++){
			for(; j<10; j++){
				int third = j+i;
				if(third<=9){
					num = num*1000+i*100+j*10+third;
					numberGenerate(num, low, high, i+1, j+1);
					
				}
				
			}
		}
		return true;
	}

}
