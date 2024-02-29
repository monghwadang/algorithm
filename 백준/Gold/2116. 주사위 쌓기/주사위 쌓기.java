import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int[][] dice;
	static int result = Integer.MIN_VALUE;
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dice = new int[N][6];

		map.put(0, 5);
		map.put(1, 3);
		map.put(2, 4);
		map.put(3, 1);
		map.put(4, 2);
		map.put(5, 0);

		for (int r = 0; r < N; r++) { // 주사위 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < 6; c++) {
				dice[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= 6; i++) {
			check(dice, i);
		}

		System.out.println(result);

	}

	static void check(int[][] dice, int n) {

		int[][] newDice = new int[dice.length][6];

		for (int r = 0; r < newDice.length; r++) {
			for (int c = 0; c < 6; c++) {
				newDice[r][c] = dice[r][c];
			}
		}

		int sum = 0;

		// 인덱스가 0<>5, 1<>3, 2<>4가 서로 마주 봄
		for (int r = 0; r < newDice.length; r++) {
			int max = Integer.MIN_VALUE;

			for (int c = 0; c < newDice[r].length; c++) {
				if (newDice[r][c] == n) {

					int k = map.get(c);
					n = newDice[r][k]; 

					newDice[r][c] = 0;
					newDice[r][k] = 0;

				}
			}

			for (int c = 0; c < newDice[r].length; c++) {
				max = Math.max(max, newDice[r][c]);
			}

			sum += max;

		}

		result = Math.max(result, sum);

	}

}