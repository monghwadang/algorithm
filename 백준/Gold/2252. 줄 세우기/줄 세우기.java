import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken()); // 학생의 수
		int E = Integer.parseInt(st.nextToken()); // 비교횟수

		int[] students = new int[V + 1];
		ArrayList<Integer>[] adj = new ArrayList[V + 1];
		int[] degree = new int[V + 1]; // 진입차수

		for (int i = 0; i < V + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			adj[A].add(B);
			degree[B]++;
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < V + 1; i++) {
			if (degree[i] == 0) {
				q.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!q.isEmpty()) {

			int curr = q.poll();
			sb.append(curr + " ");

			for (int i : adj[curr]) {
				degree[i]--;

				if (degree[i] == 0) {
					q.offer(i);
				}

			}

		}

		System.out.println(sb);

	}

}