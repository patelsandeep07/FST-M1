package activities;

public class Activity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Method call with correct method
			Activity8.exceptionTest("Will print to console");
			// Method call with incorrect method
			Activity8.exceptionTest(null);// Exception is thrown here
			Activity8.exceptionTest("Won't Execute");
		} catch (CustomException cs) {
			System.out.println("Inside Catch Block: " + cs.getMessage());
		}
	}

	static void exceptionTest(String str) throws CustomException {
		if (str == null) {
			throw new CustomException("String value is null");
		} else {
			System.out.println(str);
		}
	}

}
