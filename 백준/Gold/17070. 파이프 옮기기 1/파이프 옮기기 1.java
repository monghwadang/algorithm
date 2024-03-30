import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] pipe;
	static boolean[][] visited;
	static int cnt = 0;
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 1, 0 };

	static int[] dirR = {0,-1,0};
	static int[] dirC = {0,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pipe = new int[N][N];
		visited = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				pipe[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0][0] = true;
		visited[0][1] = true;
		move(0, 1, 0);
		System.out.println(cnt);

	}

	private static void move(int r, int c, int dir) {

		if (r == N - 1 && c == N - 1) {
			cnt++;

			return;
		}

		if (dir == 0) { // 가로

			action(0, 1, r, c);

		} else if (dir == 1) { // 대각선

			action(0, 2, r, c);

		} else { // 세로

			action(1, 2, r, c);

		}

	}

	public static boolean check(int r, int c) {

		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void action(int start, int end, int r, int c) {

		for (int d = start; d <= end; d++) {

			int nr = r + dr[d];
			int nc = c + dc[d];

			if(d==1 && !canMove(nr,nc)) continue;
			if (check(nr, nc) && !visited[nr][nc] && pipe[nr][nc]==0) {

				visited[nr][nc] = true;
				move(nr, nc, d);

				visited[nr][nc] = false; // 원복

			}

		}

	}

	public static boolean canMove(int r, int c) { // 벽 확인

		boolean flag = true; // 벽 아니다

		for (int d = 0; d <= 2; d++) {

			int nr = r + dirR[d];
			int nc = c + dirC[d];

			if (check(nr, nc) && pipe[nr][nc] == 1) {
				flag = false;
			}

		}

		return flag;

	}

}