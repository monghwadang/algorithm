import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int max = Integer.MIN_VALUE;
	static int[][] egg;

	public static void main(String[] args) throws NumberFormatException, IOException {

		input();
		breakEgg(1, 0, 0);
		System.out.println(max);

	}

	// idx번째 계란을 든다.
	// total : 전 깨뜨린 계란
	// cnt : 이번 시행으로 깨뜨린 계란
	private static void breakEgg(int idx, int total, int cnt) {
		
		if (idx == N + 1) { // 제일 오른쪽 계란까지 들었을 때
			
			max = Math.max(total, max);
			return;

		}

		if (egg[idx][0] <= 0) { // 내구도가 0 이하
			breakEgg(idx + 1, total, 0);
			return;
		}

		boolean broken = false;
		for (int i = 1; i < egg.length; i++) {
			if (idx != i && egg[i][0] > 0) { // 자기 자신과 이미 깨져 있는 것은 제외

				cnt = 0;

				// 깨뜨리기
				egg[idx][0] -= egg[i][1];
				egg[i][0] -= egg[idx][1];

				if (egg[idx][0] <= 0)
					cnt++;
				if (egg[i][0] <= 0)
					cnt++;

				// 다음 계란 잡기
				broken = true;
				breakEgg(idx + 1, total + cnt, 0);

				// 원복
				egg[idx][0] += egg[i][1];
				egg[i][0] += egg[idx][1];

			}
		}

		// 잡을 계란이 없었다
		if (!broken)
			breakEgg(idx + 1, total, 0);

	}

	private static void input() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 계란의 개수

		egg = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 내구도
			int w = Integer.parseInt(st.nextToken()); // 무게

			egg[i][0] = s;
			egg[i][1] = w;
		}

	}

}