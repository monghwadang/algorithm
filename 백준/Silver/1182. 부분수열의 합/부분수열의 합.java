import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int S;
	static int[] nums;
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		powerSet(0, 0);
		if(S==0) cnt--;
		System.out.println(cnt);

	}

	public static void powerSet(int idx, int sum) {

		if (idx == N) {

			if (sum == S) {
				cnt++;		
			}
			
			return;

		}

		powerSet(idx + 1, sum + nums[idx]);
		powerSet(idx + 1, sum);

	}

}