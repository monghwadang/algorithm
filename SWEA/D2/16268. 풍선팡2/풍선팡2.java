import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] balloons = new int[N][M];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < M; c++) {
					balloons[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			int[] dr = { 0, 0, -1, 1 };
			int[] dc = { -1, 1, 0, 0 };
			int max = Integer.MIN_VALUE;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {

					int pang = balloons[r][c]; // 자기 자신 포함

					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (nr >= 0 && nr < N && nc >= 0 && nc < M) { // 범위 안에 들어있으면
							pang += balloons[nr][nc];
						}

					}
					
					max = Math.max(max, pang);

				}
			}
			
			System.out.printf("#%d %d%n", TC, max);

		}

	}

}