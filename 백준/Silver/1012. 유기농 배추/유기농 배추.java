import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int K;
	static int[][] farm;
	static boolean[][] visited;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			farm = new int[N][M];
			visited = new boolean[N][M];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				farm[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}

			int cnt = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (!visited[r][c] && farm[r][c] == 1) {
						dfs(r, c);
						cnt++;
					}

				}
			}

			sb.append(cnt + "\n");

		}
		
		System.out.println(sb);

	}

	static void dfs(int r, int c) {
		
		visited[r][c] = true; // 방문체크

		for (int d = 0; d < 4; d++) {

			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && farm[nr][nc] == 1) {
				dfs(nr, nc);
			}

		}

	}

}