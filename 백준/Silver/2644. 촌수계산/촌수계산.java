import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m, a, b, res;
	static int[][] family;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 전체 사람의 수
		StringTokenizer st = new StringTokenizer(br.readLine());

		// a, b 두 사람의 촌수 찾기
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine()); // 관계의 개수
		family = new int[n + 1][n + 1]; // 인접행렬
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			family[x][y] = 1;
			family[y][x] = 1;
		}

		bfs(a, b);
		
		if(res==0 || !visited[b]) res = -1;
		System.out.println(res);

	}

	private static void bfs(int a, int b) {

		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[n + 1];
		res = -1;
		q.add(a);
		visited[a] = true;
		int n = q.size();

		while (!q.isEmpty()) {

			res++;
			
			for (int i = 0; i < n; i++) {
				int curr = q.poll();

				if (curr == b)
					return;

				for (int c = 1; c < family[curr].length; c++) {
					if (family[curr][c] == 1 && !visited[c]) {
						q.add(c);
						visited[c] = true;
					}
				}

			}
			
			n = q.size();
		}

	}

}