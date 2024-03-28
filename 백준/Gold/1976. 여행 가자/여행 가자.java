import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N; // 도시의 수
	static int M; // 여행 계획에 속한 도시들의 수
	static int[][] conn;
	static int[] plan;
	static int[] p;
	static int[] cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		conn = new int[N + 1][N + 1];
		plan = new int[M];
		p = new int[N + 1];

		for (int r = 1; r < conn.length; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c < conn[r].length; c++) {
				conn[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < plan.length; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < p.length; i++) { // makeSet
			p[i] = i;
		}

		for (int r = 1; r < conn.length; r++) {
			for (int c = 1; c < conn[r].length; c++) {
				if (conn[r][c] == 1) {

					union(r, c); // 합집합,,

				}
			}
		}

		// 합집합을 다 했을 때 여행계획에 있는 섬들이 다 같은 집합에 있는지 확인

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < plan.length; i++) {
			set.add(findSet(plan[i]));
		}

		if (set.size() == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	static int findSet(int x) {
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

}