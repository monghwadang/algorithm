import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int K;
	static int[][] puzzle;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			puzzle = new int[N][N];

			for (int r = 0; r < N; r++) { // puzzle 입력받기
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					puzzle[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			int voca = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					if (checkR(r, c))
						voca++;
					if (checkC(r, c))
						voca++;
				}

			}

			System.out.printf("#%d %d%n", TC, voca);

		}

	}

	static boolean checkR(int a, int b) {

		int[] dr = { 0, 0 };
		int[] dc = { -1, 1 };

		int cnt = 0; // a, b에서 출발
		int d = 0;

		int nr = a + dr[d];
		int nc = b + dc[d];

		if (nr >= 0 && nr < N && nc >= 0 && nc < N && puzzle[nr][nc] == 1) { // 범위 안에 있고 흰색이면 false
			return false;
		} else { // 범위 안에 있고 검은색 or 범위 안에 없다면 확인 시작
			d++; // a, b로 돌아온다
			nr += dr[d];
			nc += dc[d];
		}

		while (nr >= 0 && nr < N && nc >= 0 && nc < N) {

			if (puzzle[nr][nc] == 1) {
				cnt++;
				nr += dr[d];
				nc += dc[d];
			} else {
				break;
			}

		}

		return cnt == K;

	}

	static boolean checkC(int a, int b) {

		int[] dr = { -1, 1 };
		int[] dc = { 0, 0 };

		int cnt = 0; // a, b에서 출발
		int d = 0;

		int nr = a + dr[d];
		int nc = b + dc[d];

		if (nr >= 0 && nr < N && nc >= 0 && nc < N && puzzle[nr][nc] == 1) { // 범위 안에 있고 흰색이면 false
			return false;
		} else { // 범위 안에 있고 검은색 or 범위 안에 없다면 확인 시작
			d++; // a, b로 돌아온다
			nr += dr[d];
			nc += dc[d];
		}

		while (nr >= 0 && nr < N && nc >= 0 && nc < N) {

			if (puzzle[nr][nc] == 1) {
				cnt++;
				nr += dr[d];
				nc += dc[d];
			} else {
				break;
			}

		}

		return cnt == K;

	}

}