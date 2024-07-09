import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] forest;
	static int[][] dp;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		forest = new int[n][n];
		dp = new int[n][n];

		for (int r = 0; r < n; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				forest[r][c] = Integer.parseInt(st.nextToken());
				dp[r][c] = -1; // dp 배열 초기화
			}
		}

		int max = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				max = Math.max(max, dfs(r, c));
			}
		}

		System.out.println(max);
	}

	private static int dfs(int r, int c) {
		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		dp[r][c] = 1; // 기본적으로 자기 자신만 있는 경우

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && forest[nr][nc] > forest[r][c]) {
				dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
			}
		}

		return dp[r][c];
	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < n && nc >= 0 && nc < n;
	}
}