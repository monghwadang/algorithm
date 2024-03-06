import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] nodes;
	static boolean[] visited;
	static List<Integer>[] list; // List<Integer>[] 배열 선언
	static int k;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // n개의 정점
		k = Integer.parseInt(st.nextToken()); // 정점의 값이 k

		nodes = new int[n]; // 각 정점에 부여된 값
		visited = new boolean[n]; // 정점 방문 여부

		list = new ArrayList[n];
		for(int i=0; i<n; i++) { // 각 배열 요소를 ArrayList<Integer>로 초기화
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			nodes[i] = Integer.parseInt(st.nextToken());
		}
		
		
		dfs(0, 0);

	}

	static void dfs(int idx, int depth) {
		
		visited[idx] = true;
		
		if(nodes[idx] == k) {
			System.out.println(depth);
			return;
		}
		
		for(int c: list[idx] ) {
			
			if(!visited[c]) {
				dfs(c, depth+1);
			}
			
			
		}
		
		
	}

}