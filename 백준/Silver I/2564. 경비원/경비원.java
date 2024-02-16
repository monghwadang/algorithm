import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st1.nextToken());
		int b = Integer.parseInt(st1.nextToken());

		int n = Integer.parseInt(br.readLine());
		int[][] store = new int[n + 1][2]; // 마지막은 동근이 위치

		for (int r = 0; r < store.length; r++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < store[r].length; c++) {
				store[r][c] = Integer.parseInt(st2.nextToken()); // 상점과 동근이의 정보

			}

		}

		// 동근이의 위치
		int x = store[n][0];
		int y = store[n][1];

		int currD = curr(x, y, a, b);

		int sum = 0;
		for (int i = 0; i < n; i++) {
			int currS = curr(store[i][0], store[i][1], a, b);
			int l = Math.abs(currD - currS);
			
			sum += Math.min(l, 2 * a + 2 * b - l);
		}

		System.out.println(sum);

	}

	static int curr(int dir, int k, int a, int b) {
		int output = 0;
		if (dir == 1) {
			output = k;
		} else if (dir == 2) {
			output = 2 * a + b - k;
		} else if (dir == 3) {
			output = 2 * a + 2 * b - k;
		} else if (dir == 4) {
			output = a + k;
		}
		return output;
	}

}