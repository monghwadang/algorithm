import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N-1; i++) {
			
			if(dp[i+1]==0) {
				dp[i+1] = dp[i] + 1; 
			} else {
				dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
			}
			
			if(2*i<=N) {
				
				if(dp[2*i]==0) {
					dp[2*i] = dp[i] + 1; 
				} else {
					dp[2*i] = Math.min(dp[2*i], dp[i] + 1);
				}
			}
			
			if(3*i<=N) {
				if(dp[3*i]==0) {
					dp[3*i] = dp[i] + 1; 
				} else {
					dp[3*i] = Math.min(dp[3*i], dp[i] + 1);
				}
			}
			
			
		}
		
		System.out.println(dp[N]);
	}

}