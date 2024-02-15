import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수

		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int[] card = new int[N];

		for (int i = 0; i < N; i++) { // 상근이의 숫자 카드 정수형 배열로 입력 받기
			card[i] = Integer.parseInt(st1.nextToken());
		}

		Map<Integer, Integer> cardCnt = new HashMap<>(); // 카드의 갯수를 세어보자
		for (int c : card) {
			if (!cardCnt.containsKey(c)) { // 카드를 안 가지고 있으면 카드 1장 입력
				cardCnt.put(c, 1);
			} else {
				int cnt = cardCnt.get(c); // 현재 카드 몇 장인지
				cardCnt.put(c, cnt + 1); // 카드 1장 추가
			}
		}

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {

			int num = Integer.parseInt(st2.nextToken());

			if (cardCnt.containsKey(num)) {
				sb.append(cardCnt.get(num)).append(" ");
			} else {
				sb.append(0).append(" ");
			}

		}

		System.out.println(sb);

	}

}