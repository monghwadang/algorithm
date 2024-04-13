import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 건물의 수
		int[] time = new int[N + 1];
		int[][] adj = new int[N + 1][N + 1]; // 인접행렬
		int[] degree = new int[N + 1]; // 진입차수 저장

		for (int i = 1; i <= N; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());

			int n;

			while ((n = Integer.parseInt(st.nextToken())) != -1) {

				adj[n][i] = 1;
				degree[i]++;

			}

		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				q.offer(i);
			}

		}

		int[] res = new int[N + 1];

		while (!q.isEmpty()) {

			int curr = q.poll();

			for (int i = 1; i <= N; i++) {

				if (adj[curr][i] == 1) {
					degree[i]--;
					
					// i번째 건물을 짓기 전까지 걸린 시간
					res[i] = Math.max(res[i], res[curr] + time[curr]);

					if (degree[i] == 0) {
						q.offer(i);
					}

				}

			}

		}

		for(int i=1; i<=N; i++) {
			System.out.println(res[i] + time[i]);
		}

	}

}