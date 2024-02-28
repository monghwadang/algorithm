import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int sumW = 0;
	static int sumB = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[N][N];

		// 하얀색 0, 파란색 1
		for (int r = 0; r < paper.length; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < paper[r].length; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		check(paper, N);

		System.out.println(sumW);
		System.out.println(sumB);

	}

	static void check(int[][] paper, int N) {

		if (N == 1) { // 기저조건
			if (paper[0][0] == 0)
				sumW++;
			else
				sumB++;
			return;
		}

		int sum = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sum += paper[r][c];
			}
		}

		if (sum == 0) {
			sumW++;
		} else if (sum == N * N) {
			sumB++;
		} else {

			int M = N / 2;
			int[][] paper1 = new int[M][M];
			int[][] paper2 = new int[M][M];
			int[][] paper3 = new int[M][M];
			int[][] paper4 = new int[M][M];

			for (int r = 0; r < M; r++) { // paper1
				for (int c = 0; c < M; c++) {
					paper1[r % M][c % M] = paper[r][c];
				}
			}
			check(paper1, M);

			for (int r = 0; r < M; r++) { // paper2
				for (int c = M; c < N; c++) {
					paper2[r % M][c % M] = paper[r][c];
				}
			}
			check(paper2, M);

			for (int r = M; r < N; r++) {
				for (int c = 0; c < M; c++) {
					paper3[r % M][c % M] = paper[r][c];
				}
			}
			check(paper3, M);

			for (int r = M; r < N; r++) {
				for (int c = M; c < N; c++) {
					paper4[r % M][c % M] = paper[r][c];
				}
			}
			check(paper4, M);

		}

	}

}