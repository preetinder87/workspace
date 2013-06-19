
public class program {
	public static void main(String[] arg){
		
		int a[] = {4,-2,-3};
		int b[] = {7,3,1};
		
		int firsta = 0;
		int firstb = 0;
		int i = 1;
		int j = 1;
		int result[] = new int[a.length*b.length];
		result[0] = a[firsta]+b[firstb];
		//int index = 1;
		for(int m = 1; m<result.length; m++){
			if(i>a.length-1 && j>b.length-1){
				firsta = firsta+1;
				firstb = firstb+1;
				i=firsta+1;
				j=firstb+1;
				if(firsta>a.length-1&&firstb>b.length-1)
					break;
				if(firsta>a.length-1||firstb>b.length-1)
					continue;
				result[m] = a[firsta]+b[firstb];
			}
			else if(i>a.length-1){
				firstb = firstb+1;
				i=firsta+1;
			}
			else if(j>b.length-1){
				firsta = firsta+1;
				j=firstb+1;
			}
			if(i>a.length-1){
				result[m] = a[firsta]+b[j];
				j++;
			}
			else if(j>b.length-1){
				result[m] = b[firstb] + a[i];
				i++;
			}
			else{
				if(a[firsta]+b[j]>b[firstb]+a[i]){
					result[m] = a[firsta]+b[j];
					j++;
				}
				else{
					result[m] = b[firstb]+a[i];
					i++;
				}	
			}
		}
		
		for(int k=0;k<result.length;k++)
			System.out.println(result[k]);
	}

}
