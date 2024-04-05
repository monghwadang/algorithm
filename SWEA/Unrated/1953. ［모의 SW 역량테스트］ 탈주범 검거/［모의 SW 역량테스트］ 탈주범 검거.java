import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, R, C, L, cnt;
	static int[][] pipe;
	static Queue<Point> q;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] type = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			pipe = new int[N][M];
			visited = new boolean[N][M];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < M; c++) {
					pipe[r][c] = Integer.parseInt(st.nextToken());
				}

			}

			cnt = 0; // 탈주 가능 거리
			run(R, C);

			sb.append("#" + tc + " " + cnt + "\n");
		}
		System.out.println(sb);

	}

	private static void run(int r, int c) {

		q = new LinkedList<>();
		q.offer(new Point(r, c));
		visited[r][c] = true; // 방문체크

		for (int time = 1; time <= L; time++) {

			int n = q.size();
			cnt += n;

			for (int i = 0; i < n; i++) {
				Point curr = q.poll();

				connect(curr.x, curr.y, pipe[curr.x][curr.y]);

			}

		}

	}

	private static void connect(int r, int c, int i) {

		for (int n : type[i]) {

			int nr = r + dr[n];
			int nc = c + dc[n];

			if (check(nr, nc) && !visited[nr][nc] && pipe[nr][nc] != 0) {

				// nr에서도 r, c로 올 수 있는지 확인해야 한다..
				for (int t : type[pipe[nr][nc]]) {

					int tr = nr + dr[t];
					int tc = nc + dc[t];

					if (tr == r && tc == c) {

						q.offer(new Point(nr, nc));

						visited[nr][nc] = true;

					}

				}

			}

		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}