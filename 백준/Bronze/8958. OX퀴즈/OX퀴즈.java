import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			
			String input = sc.next();
			char[] quiz = new char[input.length()];
			
			for(int j=0; j<input.length(); j++) {
				
				quiz[j] = input.charAt(j);
				
			}
			
			int t=0;
			int T=0;
			
			for(int j=0; j<quiz.length; j++) {
				if(quiz[j]=='O') {
					t += 1;
					T += t;
				} else {
					t=0;
				}
				
			}
			
			System.out.println(T);
			
		}

	}

}