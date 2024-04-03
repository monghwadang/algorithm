import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, num;
	static int[][] room;
	static boolean[][] visited;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {

			N = Integer.parseInt(br.readLine());
			room = new int[N][N];
			visited = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					room[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			int max = Integer.MIN_VALUE;
			int minRoom = Integer.MAX_VALUE;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					int n = bfs(r, c);

					if (max < n || (max == n && minRoom > room[r][c])) { // 업데이트
						max = n;
						minRoom = room[r][c];
					}

				}
			}

			sb.append("#" + TC + " " + minRoom + " " + max + "\n");

		}

		System.out.println(sb);

	}

	private static int bfs(int r, int c) {

		// 매 번 visited 초기화
		visited = new boolean[N][N];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		visited[r][c] = true;
		int cnt = 0;

		while (!q.isEmpty()) {

			Point curr = q.poll();
			int value = room[curr.x][curr.y];
			cnt++;

			for (int d = 0; d < 4; d++) {

				int nr = curr.x + dr[d];
				int nc = curr.y + dc[d];

				if (check(nr, nc) && !visited[nr][nc] && room[nr][nc] == value + 1) {

					q.add(new Point(nr, nc));
					visited[nr][nc] = true;
					break;

				}

			}

		}

		return cnt;
	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
