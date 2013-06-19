
public class ExceptionHandling {
	public static void main(String[] arg) throws MyException{
		int i = 0;
		
		if(i == 0){
			throw new MyException("Yes I can throw it");
		}
		else
			System.out.println("No you can not");
	}

}

class MyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException(){
		super();
	}
	
	public MyException(String error){
		super(error);
	}
}

