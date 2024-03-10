import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] square;
	static int max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		square = new int[N][M];
		max = 1;

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				square[r][c] = str.charAt(c) - '0';
			}
		}

		for (int a = 0; a < N; a++) {
			for (int b = 0; b < M; b++) {
				biggest(a, b);
			}
		}

		System.out.println(max);

	}

	static void biggest(int a, int b) {

		for (int c = b; c < M; c++) {
			if (square[a][c] == square[a][b]) {
				int r = a + c - b;
				int size = 0;
				
				if (r<N && square[r][b] == square[a][b] && square[r][c] == square[a][c]) {
					size = (r - a + 1) * (c - b + 1);
				}

				if (max < size) // 가장 큰 사이즈 저장
					max = size;

			}
		}


		for (int r = a; r < N; r++) {
			if (square[r][b] == square[a][b]) {
				int c = b + r - a;
				int size = 0;

				if (c<M && square[a][c] == square[a][b] && square[r][c] == square[r][b]) {
					size = (r - a + 1) * (c - b + 1);
					
				}

				if (max < size) // 가장 큰 사이즈 저장
					max = size;

			}
		}

	}
}
