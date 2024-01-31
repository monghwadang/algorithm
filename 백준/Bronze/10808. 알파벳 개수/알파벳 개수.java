import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String vocab = sc.next();
		
		int[] alphabet = new int[26];
		
		for(int i=0; i<vocab.length(); i++) {
			alphabet[vocab.charAt(i)-'a']++;
		}
		
		for(int i=0; i<alphabet.length; i++) {
			System.out.print(alphabet[i] + " ");
		}
				
		
	}

}