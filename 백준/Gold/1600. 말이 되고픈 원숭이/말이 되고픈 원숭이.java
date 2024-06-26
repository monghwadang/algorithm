import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, W, H, res;
	static int[][] travel;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0, -2, -1, 1, 2, -2, -1, 1, 2 };
	static int[] dc = { 0, 0, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		travel = new int[H][W];
		visited = new boolean[H][W][K+1];

		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				travel[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(0, 0, 0, 0);
		if (res == Integer.MAX_VALUE)
			res = -1;

		System.out.println(res);

	}

	private static void bfs(int r, int c, int knight, int cnt) {

		Queue<int[]> q = new LinkedList<int[]>();
		int[] monkey = { r, c, knight, cnt };
		q.add(monkey);
		visited[r][c][knight] = true;
		res = Integer.MAX_VALUE;

		while (!q.isEmpty()) {

			int[] curr = q.poll();
			int currR = curr[0];
			int currC = curr[1];
			int currK = curr[2];
			int currCnt = curr[3];

			if(currCnt >= res) continue;
			
			if (currR == H - 1 && currC == W - 1) {
				res = Math.min(res, currCnt);
			}

			for (int d = 0; d < 12; d++) {

				int nr = currR + dr[d];
				int nc = currC + dc[d];

				// 인접하게 이동
				if (d>=0 && d<4 && check(nr, nc) && travel[nr][nc] == 0 && !visited[nr][nc][currK]) {
					int[] newMonkey = { nr, nc, currK, currCnt + 1 };
					q.add(newMonkey);
					visited[nr][nc][currK] = true;
				}
				
				// knight 이동
				if (d>=4 && d<12 && currK < K && check(nr, nc) && travel[nr][nc] == 0 && !visited[nr][nc][currK + 1]) {
					
					int[] newMonkey = { nr, nc, currK + 1, currCnt + 1 };
					q.add(newMonkey);
					visited[nr][nc][currK + 1] = true;
				}
			}

		}

	}

	private static boolean check(int nr, int nc) {
		return nr >= 0 && nr < H && nc >= 0 && nc < W;
	}

}