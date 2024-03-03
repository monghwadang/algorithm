import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String king = st.nextToken(); // 1
		String stone = st.nextToken(); // -1

		int[][] board = new int[8][8];
		int kr = board.length - (king.charAt(1) - '0');
		int kc = king.charAt(0) - 'A';
		int sr = board.length - (stone.charAt(1) - '0');
		int sc = stone.charAt(0) - 'A';

		int N = Integer.parseInt(st.nextToken());

		Map<String, Integer> map = new HashMap<>();
		map.put("R", 0);
		map.put("L", 1);
		map.put("B", 2);
		map.put("T", 3);
		map.put("RT", 4);
		map.put("LT", 5);
		map.put("RB", 6);
		map.put("LB", 7);

		int[] dr = { 0, 0, 1, -1, -1, -1, 1, 1 };
		int[] dc = { 1, -1, 0, 0, 1, -1, 1, -1 };

		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();

			int nkr = kr + dr[map.get(cmd)];
			int nkc = kc + dc[map.get(cmd)];

			int nsr = sr + dr[map.get(cmd)];
			int nsc = sc + dc[map.get(cmd)];

			if (nkr >= 0 && nkc >= 0 && nkr < board.length && nkc < board.length) {

				if (nkr == sr && nkc == sc && nsr >= 0 && nsc >= 0 && nsr < board.length && nsc < board.length) {
					// 돌과 킹이 만나고 범위 안에 있을 때

					kr += dr[map.get(cmd)];
					kc += dc[map.get(cmd)];

					sr += dr[map.get(cmd)];
					sc += dc[map.get(cmd)];

				} else if (nkr != sr || nkc != sc) {
					kr += dr[map.get(cmd)];
					kc += dc[map.get(cmd)];
				}
			}

		}

		System.out.println((char) ('A' + kc) + String.valueOf(board.length - kr));
		System.out.println((char) ('A' + sc) + String.valueOf(board.length - sr));

	}

}