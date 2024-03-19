import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] area;
	static boolean[][] visited;
	static int[] res;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int M = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];

		for (int r = 0; r < area.length; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < area[r].length; c++) {

				area[r][c] = Integer.parseInt(st.nextToken());
				M = Math.max(area[r][c], M); // 최대 높이 저장하기
			}
		}

		res = new int[M + 1];

		for (int i = M; i >= 0; i--) { // 높이는 1부터 M까지

			visited = new boolean[N][N];
			int cnt = 0;

			for (int r = 0; r < area.length; r++) {
				for (int c = 0; c < area[r].length; c++) {

					if (area[r][c] > i && !visited[r][c]) {

						bfs(r, c, i);
						cnt++;

					}

				}
			}
			

			res[i] = cnt;

		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<M; i++) {
			max = Math.max(max, res[i]);
		}
		
		System.out.println(max);

	}

	public static void bfs(int r, int c, int M) {

		visited[r][c] = true; // 방문했당
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));

		while (!q.isEmpty()) {

			Point currP = q.poll();
			int currR = currP.x;
			int currC = currP.y;

			for (int d = 0; d < 4; d++) {

				int nr = currR + dr[d];
				int nc = currC + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && area[nr][nc] > M) {

					q.add(new Point(nr, nc));
					visited[nr][nc] = true;

				}
			}

		}

	}

}