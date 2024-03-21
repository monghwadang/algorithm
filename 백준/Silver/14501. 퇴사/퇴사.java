import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] office;
	static boolean[] sel;
	static int profit = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		office = new int[N][2];
		sel = new boolean[N];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < 2; c++) {
				office[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		schedule(0);
		System.out.println(profit);

	}

	public static void schedule(int idx) {

		if (idx >= N) {

			if (check()) {
				int sum = 0;
				for (int i = 0; i < sel.length; i++) {
					if (sel[i])
						sum += office[i][1];
				}

				profit = Math.max(profit, sum);
			}
			
			return;

		}

		sel[idx] = true;
		schedule(idx + 1);

		sel[idx] = false;
		schedule(idx + 1);

	}

	public static boolean check() {

		boolean flag = true;

		for (int i = 0; i < sel.length; i++) {

			if (sel[i]) {
				
				if(i + office[i][0] > N) {
					flag = false;
					break;
				}

				for (int j = 1; j < office[i][0]; j++) {
					if (sel[i + j]) {
						flag = false;
						break;
					}
				}

			}

			if (!flag) break;
		}

		return flag;

	}
}