import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parent;
	static int N;
	static boolean[] visited;
	static List<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1]; // 노드의 인덱스가 노드의 값
		parent = new int[N + 1]; // 부모 노드 정보
		visited = new boolean[N + 1]; // 부모 노드 정보

		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) { // 인접행렬 만들기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);

		}
		
		dfs(1,1);
		
		for(int i=2; i<parent.length; i++) {
			System.out.println(parent[i]);
		}

	}

	// cnt : 확인한 노드의 개수
	static void dfs(int idx, int cnt) {

		visited[idx] = true;

		if (cnt == N)
			return;

		for (int i : list[idx]) {
			if (!visited[i]) {
				parent[i] = idx;
				dfs(i, cnt + 1);
			}

		}

	}

}