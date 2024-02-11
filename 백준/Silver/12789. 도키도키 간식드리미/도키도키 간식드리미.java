import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Queue<Integer> q = new LinkedList<>(); // 입력받을 큐

		for (int i = 0; i < N; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		} // 현재 줄 서 있는 곳

		Stack<Integer> s = new Stack<>(); // 한 명씩만 설 수 있는 공간
		Stack<Integer> snack = new Stack<>(); // 간식 받는 곳

		while (q.peek() != 1) {
			s.push(q.poll());
		}

		snack.push(q.poll()); // 1을 넣겠다.

		while (!q.isEmpty()) {

			if (snack.peek() + 1 == q.peek()) { // snack.peek()이 q.peek-1이면 snack에 push
				snack.push(q.poll());
			} else if (!s.isEmpty() && snack.peek() + 1 == s.peek()) { // snack.peek()이 s.pop-1이면 snack에 push
				snack.push(s.pop());
			} else { // 아니면 s에 push
				s.push(q.poll());
			}
		}

		while (!s.isEmpty()) {
			snack.push(s.pop());
		}

		boolean isPossible = true;

		for (int i = 0; i < N - 1; i++) {
			int a = snack.pop();
			int b = snack.peek();
			if (a != b + 1) {
				isPossible = false;
				break;
			}

		}

		System.out.println(isPossible ? "Nice" : "Sad");

	}

}