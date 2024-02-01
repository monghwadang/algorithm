import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int n = 1;
		int C = 0;
		
		while(n<N) {
			
			if(N == constructor(n)) {
				C = n;
				break;
			}
			n++;
			
		}
		
		System.out.println(C);
		
		
	}
	
	public static int constructor(int n) {
		
		char[] charArr = Integer.toString(n).toCharArray();
		int sum = n;
		
		for(char c : charArr) {
			sum += c - '0';
		}
		return sum;
	}
}