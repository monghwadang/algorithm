import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	static int T;
	static StringBuilder sb = new StringBuilder();
	static int temp = 1;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			// temp는 전역변수로 설정
			// 여기에 해당하지 않는다면 바로 다음 if문으로 이동
			for (; temp <= N; temp++) {
				stack.push(temp);
				sb.append("+").append("\n");
			}

			if (stack.peek() == N) {
				stack.pop();
				sb.append("-").append("\n");
			} else { // 시도할 수 있는 것이 없다
				flag = true;
			}
		}

		if (flag)
			System.out.println("NO");
		else
			System.out.println(sb);
	}
}