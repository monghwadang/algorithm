import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mod = 9901;

		// 한 칸도 안 넣는다, 첫 번째 칸에 넣는다, 두 번째 칸에 넣는다
		long[][] dp = new long[N + 1][3];

		dp[1][0] = dp[1][1] = dp[1][2] = 1;

		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
		}

		System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % mod);

	}

}