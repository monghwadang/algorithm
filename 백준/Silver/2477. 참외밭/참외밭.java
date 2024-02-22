import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int perCnt = Integer.parseInt(br.readLine());

		int[][] plant = new int[6][2];

		for (int r = 0; r < 6; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < 2; c++) {
				plant[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int maxA = 0;
		int maxB = 0;

		for (int r = 0; r < 6; r++) {
			if (plant[r][0] == 1 || plant[r][0] == 2) {
				maxA = Math.max(maxA, plant[r][1]);
			} else if (plant[r][0] == 3 || plant[r][0] == 4) {
				maxB = Math.max(maxB, plant[r][1]);
			}
		}

		int a = -1;
		int b = -1;

		if ((plant[0][0] == 4 && plant[5][0] == 2) || (plant[0][0] == 1 && plant[5][0] == 4)
				|| (plant[0][0] == 2 && plant[5][0] == 3) || (plant[0][0] == 3 && plant[5][0] == 1)) {
			a = plant[0][1];
			b = plant[5][1];
		}

		for (int r = 0; r < 5; r++) {
			if (plant[r][0] == 2 && plant[r + 1][0] == 4) {
				a = plant[r][1];
				b = plant[r + 1][1];
			} else if (plant[r][0] == 4 && plant[r + 1][0] == 1) {
				a = plant[r][1];
				b = plant[r + 1][1];
			} else if (plant[r][0] == 3 && plant[r + 1][0] == 2) {
				a = plant[r][1];
				b = plant[r + 1][1];
			} else if (plant[r][0] == 1 && plant[r + 1][0] == 3) {
				a = plant[r][1];
				b = plant[r + 1][1];
			}
		}

		System.out.println((maxA * maxB - a * b) * perCnt);

	}

}