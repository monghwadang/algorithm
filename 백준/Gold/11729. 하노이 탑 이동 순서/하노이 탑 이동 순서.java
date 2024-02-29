import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 원판의 개수

		hanoi(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.println(sb);

	}

	static void hanoi(int N, int start, int mid, int end) {

		if (N == 0)
			return;

		hanoi(N - 1, start, end, mid);
		sb.append(start + " " + end+"\n");
		cnt++;
		hanoi(N - 1, mid, start, end);

	}

}