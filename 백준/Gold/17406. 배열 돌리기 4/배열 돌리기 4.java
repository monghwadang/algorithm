import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[][] arr; // 배열
	static int[][] copyArr; // 배열 복사
	static int[][] op; // 연산 정보
	static int[] order;
	static boolean[] visited;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M + 1];
		copyArr = new int[N + 1][M + 1];
		op = new int[K][3];
		order = new int[K];
		visited = new boolean[K];

		for (int r = 1; r < arr.length; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c < arr[r].length; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < op.length; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < op[r].length; c++) {
				op[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;
		operate(0);

		System.out.println(min);

	}

	static void operate(int idx) { //

		if (idx == K) { // 연산 순서 정했다

			copy(); // 배열 복사

			for (int i = 0; i < K; i++) { // 복사한 배열로 회전
				snail(order[i]);
			}

			min = Math.min(min, sum()); // 행별 합 최솟값 구하기

			return;
		}

		for (int i = 0; i < K; i++) {

			if (visited[i])
				continue;

			visited[i] = true; // 방문
			order[idx] = i;
			operate(idx + 1);

			visited[i] = false; // 원복
		}

	}

	private static void copy() {

		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < M + 1; c++) {
				copyArr[r][c] = arr[r][c];
			}
		}

	}

	static void snail(int idx) { // i번째 연산을 수행

		int r = op[idx][0];
		int c = op[idx][1];
		int s = op[idx][2];

		for (int i = 0; i < s; i++) {

			// 출발점
			int startR = r - s + i;
			int startC = c - s + i;

			// 경계
			int borderR = r + s - i;
			int borderC = c + s - i;

			// 현재 위치
			int currR = r - s + i;
			int currC = c - s + i;
			int tmp = copyArr[currR][currC];
			int d = 0;

			// 한 바퀴 달팽이 돌리면서 한 칸씩 옮기기
			while (true) {

				int currV = tmp;

				int nr = currR + dr[d];
				int nc = currC + dc[d];

				if (nr > borderR || nr < startR || nc > borderC || nc < startC) { // 범위를 벗어나면
					d++; // 방향을 바꿔주기
				}

				tmp = copyArr[currR + dr[d]][currC + dc[d]];

				copyArr[currR + dr[d]][currC + dc[d]] = currV;

				if (nr == startR && nc == startC)
					break; // 한 바퀴 다 돌았다

				currR += dr[d];
				currC += dc[d];

			}

		}

	}

	static int sum() {

		int minSum = Integer.MAX_VALUE;
		for (int r = 1; r < N + 1; r++) {
			int sum = 0;
			for (int c = 1; c < M + 1; c++) {
				sum += copyArr[r][c]; // 행별 합 계산
			}

			minSum = Math.min(sum, minSum);
		}

		return minSum;

	}

}