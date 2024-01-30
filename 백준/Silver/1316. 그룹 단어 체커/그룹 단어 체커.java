import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int group = 0;
		
		for(int i=0; i<N; i++) {
			char[] vocab = sc.next().toCharArray(); 
			int[] alphabet = new int[26];
			
			for(int j=0; j<vocab.length; j++) {
				alphabet[vocab[j]-'a']++;
			}
			
			int cnt1 = 0;
			int cnt2 = 1;
			
			for(int j=0; j<alphabet.length; j++) {
				if(alphabet[j]!=0) cnt1++;
			}
			
			for(int j=0; j<vocab.length-1; j++) {
				if(vocab[j]!=vocab[j+1]) cnt2++;
			}
			

			if(cnt1 == cnt2) group++;

		}
		
		System.out.print(group);
		

	}

}