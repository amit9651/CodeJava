package problems;

public class ExceptionHandling {
	
	public static void main(String[] args) {
		
		checkedExceptionArithmetic();
		checkedExceptionNumberFormat();
		throwException();
		throwsException();
	}
	
	
	static void checkedExceptionArithmetic() {
		
		int a = 0;
		int b = 1;
		
		try {
			int c = b/a;
		}
		catch(ArithmeticException e){
			System.out.println("Exception caused due to: "+e.getMessage());
		}
		finally {
			System.out.println("Finally block executed");
		}
	}
	
	static void checkedExceptionNumberFormat() throws NumberFormatException {
		
		String s = "amitsingh";
		
		try {
			int num = Integer.parseInt(s);
		}
		catch(NumberFormatException e){
			System.out.println("Exception caused due to: "+e.getMessage());
		}
		finally {
			System.out.println("Finally block executed");
		}
		
	}
	
	static void throwException() {
		
		throw new IllegalArgumentException("String cannot be converted into integer");
	}
	
	static void throwsException() throws NumberFormatException {
			
		String s = "amitsingh";
				
				
			
		}
	

}
