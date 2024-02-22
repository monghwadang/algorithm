import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[1001][1001];

		for (int t = 1; t <= N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int nc = Integer.parseInt(st.nextToken());
			int nr = Integer.parseInt(st.nextToken());
			int r = 1001 - k - 1;

			for (int i = r; i >= r - nr + 1; i--) {
				for (int j = c; j < c + nc; j++) {
					paper[i][j] = t;
				}
			}

		}

		int[] cnt = new int[N + 1];
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[i].length; j++) {
				cnt[paper[i][j]]++;
			}
		}

		for (int t = 1; t <= N; t++) {
			System.out.println(cnt[t]);
		}

	}

}