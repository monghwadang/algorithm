import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] stadium = new int[N][M]; // 공연장의 크기

		int audience = Integer.parseInt(br.readLine()); // 관객 대기번호

		if (audience > M * N) { // 좌석 배정 불가능인 경우 0 출력하고 종료
			System.out.println(0);
			return;
		}

		// 상 우 하 좌 델타배열 만들기
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		// 출발지점
		int r = stadium.length - 1;
		int c = 0;
		int num = 0;
		int d = 0;

		while (true) {
			

			stadium[r][c] = ++num;

			if (num == audience) {
				break;
			}

			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= stadium.length || nc < 0 || nc >= stadium[r].length || stadium[nr][nc] != 0) {
				d = (d + 1) % 4;
			}

			r += dr[d];
			c += dc[d];


		}

		// 배열 -> 좌석으로 변환

		System.out.println(c + 1 + " " + (stadium.length - r));

	}

}