import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Nodes {

	int r;
	int c;
	int isBreak;
	int cnt;

	public Nodes(int r, int c, int isBreak, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.isBreak = isBreak;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "Nodes [r=" + r + ", c=" + c + ", isBreak=" + isBreak + ", cnt=" + cnt + "]";
	}

}

public class Main {

	static int N;
	static int M;
	static int[][] wall;
	static boolean[][][] visited;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		wall = new int[N][M];
		visited = new boolean[N][M][2];

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				wall[r][c] = str.charAt(c) - '0';
			}
		}

		min = Integer.MAX_VALUE;

		bfs(0, 0);

		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);

	}

	private static void bfs(int r, int c) {

		Queue<Nodes> q = new LinkedList<>();
		q.offer(new Nodes(r, c, 0, 1));
		visited[r][c][0] = true;

		while (!q.isEmpty()) {

			Nodes curr = q.poll();
			int currR = curr.r;
			int currC = curr.c;
			int currB = curr.isBreak; // 벽 부수기 여부

			if (currR == N - 1 && currC == M - 1) {

				min = Math.min(min, curr.cnt);

				return;

			}

			for (int d = 0; d < 4; d++) {
				int nr = currR + dr[d];
				int nc = currC + dc[d];

				if (check(nr, nc)) { // 범위 안에 있을 때

					// 부쉈든 안 부쉈든
					if (!visited[nr][nc][currB] && wall[nr][nc] == 0) {
						q.offer(new Nodes(nr, nc, currB, curr.cnt + 1));
						visited[nr][nc][currB] = true;
					}

					// 아직 안 부쉈다
					if (currB == 0 && !visited[nr][nc][currB + 1] && wall[nr][nc] == 1) {
						q.offer(new Nodes(nr, nc, currB + 1, curr.cnt + 1));
						visited[nr][nc][currB + 1] = true;
					}

				}

			}

		}

	}

	private static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}