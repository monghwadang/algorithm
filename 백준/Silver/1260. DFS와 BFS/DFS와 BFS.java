import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int V;
	static int[][] arr;
	static boolean[] visited1;
	static boolean[] visited2;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		visited1 = new boolean[N + 1];
		visited2 = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}

		DFS(V);
		
		sb.append("\n");
		
		BFS(V);
		
		System.out.println(sb);

	}

	private static void DFS(int start) {

		visited1[start] = true; // 방문체크
		sb.append(start + " ");

		for (int i = 1; i < arr.length; i++) {

			if (!visited1[i] && arr[start][i] == 1) {

				DFS(i);

			}

		}

	}

	private static void BFS(int start) {

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited2[start] = true;

		while (!q.isEmpty()) {

			int n = q.poll();
			sb.append(n + " ");

			for (int i = 1; i < arr.length; i++) {

				if (!visited2[i] && arr[n][i] == 1) {
					q.add(i);
					visited2[i] = true;
				}
			}

		}

	}

}