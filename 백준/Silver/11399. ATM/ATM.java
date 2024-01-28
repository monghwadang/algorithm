import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] atm = new int[N];
		
		for(int i=0; i<N; i++) {
			atm[i] = sc.nextInt();
		}
		
		Arrays.sort(atm);
		
		int sum = 0;
		int output = 0;
		
		for(int i=0; i<N; i++) {
			sum += atm[i];
			output += sum;
		}
		
		
		System.out.println(output);
	}

}