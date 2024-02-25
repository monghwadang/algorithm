import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Map<Long, Integer> cards = new HashMap<>();

		for (int i = 0; i < N; i++) {
			Long n = Long.parseLong(br.readLine());
			if (!cards.containsKey(n)) {
				cards.put(n, 1);
			} else {
				int cnt = cards.get(n);
				cards.put(n, cnt + 1);
			}
		}

		int max = Integer.MIN_VALUE;
		long minKey = Long.MAX_VALUE;
		for (long n : cards.keySet()) {
			if (max < cards.get(n)) {
				max = cards.get(n);
				minKey = n;
			} else if (max == cards.get(n)) {
				if (n < minKey) {
					minKey = n;
				}
			}

		}

		System.out.println(minKey);

	}

}