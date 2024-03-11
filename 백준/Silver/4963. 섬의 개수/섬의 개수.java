import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int w; // 너비
	static int h; // 높이
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[] dc = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		while (!(str = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(str, " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			visited = new boolean[h][w];

			for (int r = 0; r < map.length; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < map[r].length; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;

			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					if (!visited[r][c] && map[r][c] == 1) {
						cnt++;
						dfs(r, c);
					}
				}
			}

			sb.append(cnt + "\n");

		}
		System.out.println(sb);

	}

	static void dfs(int r, int c) {

		visited[r][c] = true; // 방문체크

		for (int d = 0; d < 8; d++) {

			int nr = r + dr[d];
			int nc = c + dc[d];

			// 1. 배열이 범위 안에 있고
			// 2. 아직 방문하지 않았고
			// 3. 값이 1일 때
			if (nr >= 0 && nr < h && nc >= 0 && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {

				dfs(nr, nc);
			}

		}

	}

}