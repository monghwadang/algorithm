import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] game = new int[N + 1][3];
		int[][] maxDP = new int[N + 1][3];
		int[][] minDP = new int[N + 1][3];

		for (int r = 1; r <= N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < 3; c++) {
				game[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 3; i++) {
			maxDP[1][i] = game[1][i];
			minDP[1][i] = game[1][i];
		}

		for (int i = 2; i <= N; i++) {
			maxDP[i][0] = Math.max(maxDP[i - 1][0], maxDP[i - 1][1]) + game[i][0];
			maxDP[i][1] = Math.max(Math.max(maxDP[i - 1][0], maxDP[i - 1][1]), maxDP[i - 1][2]) + game[i][1];
			maxDP[i][2] = Math.max(maxDP[i - 1][1], maxDP[i - 1][2]) + game[i][2];

			minDP[i][0] = Math.min(minDP[i - 1][0], minDP[i - 1][1]) + game[i][0];
			minDP[i][1] = Math.min(Math.min(minDP[i - 1][0], minDP[i - 1][1]), minDP[i - 1][2]) + game[i][1];
			minDP[i][2] = Math.min(minDP[i - 1][1], minDP[i - 1][2]) + game[i][2];

		}
		
		int max = Math.max(Math.max(maxDP[N][0], maxDP[N][1]), maxDP[N][2]);
		int min = Math.min(Math.min(minDP[N][0], minDP[N][1]), minDP[N][2]);
		
		System.out.print(max+" "+min);

	}

}