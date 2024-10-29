import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int k = Integer.MIN_VALUE;
	static int[] tree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tree = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			k = Math.max(k, tree[i]);
		}

		long start = 0;
		long end = k;
		long res = 0;

		while (start <= end) {

			long mid = (start + end) / 2;
			long sum = 0;

			for (int i = 0; i < N; i++) {

				if (tree[i] >= mid) {
					sum += Math.abs(tree[i] - mid);
				}
			}

			if (sum >= M) {

				res = Math.max(res, mid);
				start = mid + 1;

			} else {
				end = mid - 1;
			}

		}

		System.out.println(res);

	}

}