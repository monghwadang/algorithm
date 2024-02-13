import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int isBingo(boolean[][] flag) {

		int line = 0;

		for (int r = 0; r < 5; r++) {
			int cntR = 0;
			for (int c = 0; c < 5; c++) {
				if (flag[r][c])
					cntR++;
			}

			if (cntR == 5) {
				line++;
			}
		}

		for (int c = 0; c < 5; c++) {
			int cntC = 0;
			for (int r = 0; r < 5; r++) {
				if (flag[r][c])
					cntC++;
			}

			if (cntC == 5) {
				line++;
			}
		}

		int cntX1 = 0, cntX2 = 0;
		for (int i = 0; i < 5; i++) {

			if (flag[i][i])
				cntX1++;
			if (flag[i][4 - i])
				cntX2++;
		}
		if (cntX1 == 5) {
			line++;
		}
		
		if (cntX2 == 5) {
			line++;
		}

		return line;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] num = new int[5][5];
		for (int r = 0; r < num.length; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < num[r].length; c++) {
				num[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] flagInt = new int[5][5];
		boolean[][] flag = new boolean[5][5];
		int cnt = 0;
		int lineSum = 0;

		for (int r = 0; r < flagInt.length; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < flagInt[r].length; c++) {
				flagInt[r][c] = Integer.parseInt(st.nextToken());
				cnt++;

				for (int i = 0; i < num.length; i++) {
					for (int j = 0; j < num[i].length; j++) {
						if (num[i][j] == flagInt[r][c]) {

							flag[i][j] = true;

						}

					}
				}

				lineSum = isBingo(flag);

				if (lineSum >= 3) {
					System.out.println(cnt);
					return;
				}

			}

		}
	}

}