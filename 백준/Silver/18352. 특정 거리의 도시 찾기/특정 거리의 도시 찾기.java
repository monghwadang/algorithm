import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {

	int v;
	int dis;

	public Node(int v, int dis) {
		super();
		this.v = v;
		this.dis = dis;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.dis, o.dis);
	}

}

public class Main {

	static int N;
	static int M;
	static int K;
	static int X;
	static ArrayList<Node>[] list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) { // 인접리스트
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(new Node(B, 1));
		}

		city(X);

	}

	public static void city(int start) {

		boolean[] check = new boolean[N + 1];
		int[] dist = new int[N + 1];
		int INF = Integer.MAX_VALUE;

		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {

			int nowV = pq.poll().v;

			if (check[nowV])
				continue;
			
			check[nowV] = true;

			for (Node next : list[nowV]) {
				

				if (dist[next.v] > dist[nowV] + next.dis) {

					dist[next.v] = dist[nowV] + next.dis;

					pq.offer(new Node(next.v, dist[next.v]));
					

				}

			}

		}

		int cnt = 0;
		
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] == K) {
				sb.append(i+"\n");
				flag = true;
			}
		}
		
		if(!flag) {
			sb.append(-1);
		}
		
		System.out.println(sb);
		
	}

}