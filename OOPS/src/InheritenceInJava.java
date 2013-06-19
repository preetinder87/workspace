import java.util.ArrayList;


public class InheritenceInJava extends supClass {

	@Override
	void fun(int a) {
		System.out.println("OverRidden");
	}
	
	public static void println(){
		System.out.println("Inherited Class");
	}
	
	public static void main(String[] arg){
		supClass obj = new InheritenceInJava();
		supClass.pritln();
		InheritenceInJava.println();
		obj.fun(1);
		ArrayList<Integer> ar = new ArrayList<Integer>();
		
	}

}

abstract class supClass{
	abstract void fun(int a);
	public static void pritln(){
		System.out.println("Yes it has");
	}
	
}
