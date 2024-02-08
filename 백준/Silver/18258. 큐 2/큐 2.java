import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String cmd = new String(br.readLine());

			if (cmd.contains("push")) {
				int n = Integer.parseInt(cmd.substring(5));
				q.offer(n);
			} else if (cmd.equals("pop")) {
				bw.write(String.valueOf(q.isEmpty() ? -1 : q.poll()));
				bw.newLine();
			} else if (cmd.equals("size")) {
				bw.write(String.valueOf(q.size()));
				bw.newLine();
			} else if (cmd.equals("empty")) {
				bw.write(String.valueOf(q.isEmpty() ? 1 : 0));
				bw.newLine();
			} else if (cmd.equals("front")) {
				bw.write(String.valueOf(q.isEmpty() ? -1 : q.peek()));
				bw.newLine();
			} else if (cmd.equals("back")) {
				bw.write(String.valueOf(q.isEmpty() ? -1 : ((LinkedList<Integer>) q).getLast()));
				bw.newLine();
			}


		}
		
		bw.flush();
		
		br.close();
		bw.close();

	}

}