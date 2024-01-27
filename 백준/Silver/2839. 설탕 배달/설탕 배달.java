import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = Integer.MAX_VALUE;
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(3 * i + 5 * j == N) {
					sum = i + j;
					if(sum < cnt) {
						cnt = sum;
					}
				} 
				
			}
		}
		
		if(cnt != Integer.MAX_VALUE) {
			System.out.println(cnt);	
		} else {
			System.out.println(-1);
		}
		
		
		
	}

}