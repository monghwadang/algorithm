import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] stairs = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = stairs[1];
		
		if(N>=2) {
			dp[2] = Math.max(stairs[2], dp[1] + stairs[2]);			
		}
		
		for(int i=3; i<=N; i++) {
			// 한 계단 또는 두 계단
			// 연속된 세 계단 밟을 수 없음
			dp[i] = Math.max(dp[i-3]+stairs[i-1]+stairs[i], dp[i-2]+stairs[i]);
		}
		
		System.out.println(dp[N]);
		
	}

}