package activities;

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// lambda expression without return keywords
		Addable ad1 = (a, b) -> (a + b);
		System.out.println("Without return keywords: " + ad1.add(10, 20));

		// lambda expression with return
		Addable ad2 = (int a, int b) -> {
			return (a + b);
		};

		System.out.println("With return keywords: " + ad2.add(20, 30));

	}

}
