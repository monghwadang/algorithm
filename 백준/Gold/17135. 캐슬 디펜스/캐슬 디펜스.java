import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {

	int x;
	int y;
	int dis;

	public Node(int x, int y, int dis) {
		super();
		this.x = x;
		this.y = y;
		this.dis = dis;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + ", dis=" + dis + "]";
	}

	@Override
	// dis로 오름차순 -> y로 오름차순
	public int compareTo(Node o) {

		if (this.dis == o.dis) {
			return this.y - o.y;
		}
		return this.dis - o.dis;
	}

}

public class Main {

	static int N, M, D, cnt;
	static int[][] castle;
	static int[] res;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		D = Integer.parseInt(st.nextToken()); // 거리

		castle = new int[N + 1][M + 1];
		res = new int[3];

		for (int r = 1; r < castle.length; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c < castle[r].length; c++) {
				castle[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		archer(1, 0);
		System.out.println(max);
	}

	static void archer(int idx, int sidx) {

		if (sidx == 3) { // 3명의 위치를 뽑았으면

			cnt = 0;
			attack(); // 공격
			max = Math.max(max, cnt);

			return;
		}

		for (int i = idx; i <= M + 1 - 3 + sidx; i++) {
			res[sidx] = i;
			archer(i + 1, sidx + 1);
		}
	}

	private static void attack() {

		visited = new boolean[N + 1][M + 1];

		int row = N + 1; // 궁수의 현재 위치
		Queue<Point> enemy = new LinkedList<>();

		while (row > 1) {

			for (int i = 0; i < 3; i++) {
				PriorityQueue<Node> pq = new PriorityQueue<>();
				for (int r = 1; r <= row - 1; r++) { // 궁수보다 위에 있을 때만 공격 가능
					for (int c = 1; c < M + 1; c++) {

						int dis = getDis(r, c, row, res[i]);
						if (castle[r][c] == 1 && !visited[r][c] && dis <= D) { // 적이 있는데 아직 방문을 안 했고 공격 범위 안에 있다면
							pq.offer(new Node(r, c, dis)); // 일단 우선순위 큐에 넣자
						}
					}
				}

				if (!pq.isEmpty()) {

					Node curr = pq.poll(); // 조건을 충족하는 적을 찾고
					Point candidate = new Point(curr.x, curr.y);
					if (!enemy.contains(candidate)) {
						enemy.add(new Point(curr.x, curr.y)); 
						// 공격 대상에 넣겠다 (다른 궁수와 같은 적을 공격할 수도 있으므로 바로 방문체크 안 함)
					}
				}

			} // 3명의 궁수의 목표물 찾기 완료

			cnt += enemy.size();

			while (!enemy.isEmpty()) {
				Point kill = enemy.poll();
				visited[kill.x][kill.y] = true; // 공격 대상 방문체크
			}

			row--; // 궁수를 이동시키기
		}
		
	}

	static int getDis(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}