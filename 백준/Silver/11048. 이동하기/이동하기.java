import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] room = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c <= M; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				dp[r][c] = Math.max(Math.max(dp[r - 1][c - 1], dp[r - 1][c]), dp[r][c - 1]) + room[r][c];
			}
		}
		
		System.out.println(dp[N][M]);

	}

}