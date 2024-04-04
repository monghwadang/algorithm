import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] RGB = new int[N+1][3];
		int[][] dp = new int[N + 1][3];

		for (int r = 1; r <= N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < 3; c++) {
				RGB[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][0] = RGB[1][0];
		dp[1][1] = RGB[1][1];
		dp[1][2] = RGB[1][2];
		
		for(int i=2; i<=N; i++) {			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RGB[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + RGB[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + RGB[i][2];
		}
		
		System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
		
	}

}