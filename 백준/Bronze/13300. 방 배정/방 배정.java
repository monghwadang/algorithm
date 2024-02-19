import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int total = Integer.parseInt(st1.nextToken());
		int max = Integer.parseInt(st1.nextToken());

		Map<Integer, Integer> girl = new HashMap<>();
		Map<Integer, Integer> boy = new HashMap<>();

		for (int i = 0; i < total; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st2.nextToken());
			int grade = Integer.parseInt(st2.nextToken());

			add(girl, boy, s, grade);
		}


		int sum = 0;

		for (int i = 1; i <= 6; i++) {

			if (girl.containsKey(i)) {

				if (girl.get(i) % max == 0) {
					sum += girl.get(i) / max;
				} else {
					sum += girl.get(i) / max + 1;
				}
			}

			if (boy.containsKey(i)) {

				if (boy.get(i) % max == 0) {
					sum += boy.get(i) / max;
				} else {
					sum += boy.get(i) / max + 1;
				}
			}

		}

		System.out.println(sum);

	}

	static void add(Map<Integer, Integer> girl, Map<Integer, Integer> boy, int s, int grade) {

		if (s == 0) {

			if (!girl.containsKey(grade)) {
				girl.put(grade, 1);
			} else {
				int n = girl.get(grade);
				girl.put(grade, n + 1);

			}

		} else {

			if (!boy.containsKey(grade)) {
				boy.put(grade, 1);
			} else {
				int n = boy.get(grade);
				boy.put(grade, n + 1);

			}

		}

	}

}