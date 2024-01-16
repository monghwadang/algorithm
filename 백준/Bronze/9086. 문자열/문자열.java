import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String output = null;
		
		for(int i=0; i<T; i++) {
			String test = sc.next();
			System.out.println(test.charAt(0)+""+test.charAt(test.length()-1));
		}

	}

}