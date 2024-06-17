import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static char[][] princess = new char[5][5];
	static int[] sel = new int[7];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][] pick;
	static boolean[][] visited;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {

		input();
		group(0, 0);
		System.out.println(cnt);

	}

	private static void group(int idx, int sidx) {

		if (sidx == 7) { // 7명이 뽑혔다

			pick = new boolean[5][5];
			for (int i = 0; i < 7; i++) {
				pick[sel[i] / 5][sel[i] % 5] = true;
			}

			if (check()) {
				cnt++;
			}

			return;
		}

		for (int i = idx; i <= 25 - 7 + sidx; i++) {
			sel[sidx] = i;
			group(i + 1, sidx + 1);
		}

	}

	private static boolean check() {

		visited = new boolean[5][5];

		return checkConnect() == 7 && checkSom() >= 4;
	}

	private static int checkSom() {

		int som = 0;

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (pick[r][c] && princess[r][c] == 'S') {
					som++;
				}
			}
		}
		return som;
	}

	private static int checkConnect() {

		int connect = 0;

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (pick[r][c]) { // 여기서 한 번에 연결되어있어야 해
					connect = dfs(r, c);
					break;

				}
			}
			if (connect > 0) // 연결된 칸을 찾았으면 멈추기
				break;
		}
		return connect;
	}

	private static int dfs(int r, int c) {

		visited[r][c] = true;
		int connect = 1;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (checkRange(nr, nc) && pick[nr][nc] && !visited[nr][nc]) {
				connect += dfs(nr, nc);
			}
		}

		return connect;

	}

	private static boolean checkRange(int nr, int nc) {
		return nr >= 0 && nr < 5 && nc >= 0 && nc < 5;
	}

	private static void input() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int r = 0; r < princess.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < princess[r].length; c++) {
				princess[r][c] = str.charAt(c);
			}
		}

	}

}