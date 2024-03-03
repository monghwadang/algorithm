import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static char[][] candy;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		candy = new char[N][N];
		max = Integer.MIN_VALUE;

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < N; c++) {
				candy[r][c] = str.charAt(c);
			}
		}

		// 행부터
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N - 1; c++) {
				if (candy[r][c] != candy[r][c + 1]) {
					trial1(r, c);
				}
			}
		}

		// 열부터
		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N - 1; r++) {
				if (candy[r][c] != candy[r + 1][c]) {
					trial2(r, c);
				}
			}
		}

		System.out.println(max);

	}

	static void swap1(int r, int a, int b) {
		char tmp = candy[r][a];
		candy[r][a] = candy[r][b];
		candy[r][b] = tmp;
	}

	static void swap2(int c, int a, int b) {
		char tmp = candy[a][c];
		candy[a][c] = candy[b][c];
		candy[b][c] = tmp;
	}

	static void trial1(int r, int c) {

		swap1(r, c, c + 1);

		// 행부터
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N - 1; j++) {

				char curr = candy[i][j];
				if (candy[i][j + 1] == curr) {
					cnt++;
				} else {
					max = Math.max(max, cnt);
					curr = candy[i][j + 1];
					cnt = 1;
				}

			}

			max = Math.max(max, cnt);
		}

		// 열부터
		for (int j = 0; j < N; j++) {
			int cnt = 1;
			for (int i = 0; i < N - 1; i++) {

				char curr = candy[i][j];
				if (candy[i + 1][j] == curr) {
					cnt++;
				} else {
					max = Math.max(max, cnt);
					curr = candy[i + 1][j];
					cnt = 1;
				}

			}
			max = Math.max(max, cnt);

		}

		swap1(r, c, c + 1); // 원복

	}

	static void trial2(int r, int c) {

		swap2(c, r, r + 1);

		// 행부터
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N - 1; j++) {

				char curr = candy[i][j];
				if (candy[i][j + 1] == curr) {
					cnt++;
				} else {
					max = Math.max(max, cnt);
					curr = candy[i][j + 1];
					cnt = 1;
				}

			}

			max = Math.max(max, cnt);
		}

		// 열부터
		for (int j = 0; j < N; j++) {
			int cnt = 1;
			for (int i = 0; i < N - 1; i++) {

				char curr = candy[i][j];
				if (candy[i + 1][j] == curr) {
					cnt++;
				} else {
					max = Math.max(max, cnt);
					curr = candy[i + 1][j];
					cnt = 1;
				}

			}
			max = Math.max(max, cnt);

		}

		swap2(c, r, r + 1); // 원복

	}

}