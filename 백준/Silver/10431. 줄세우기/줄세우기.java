import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());

		for (int i = 0; i < P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[] students = new int[20];

			for (int j = 0; j < 20; j++) {
				students[j] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int j = 1; j < students.length; j++) {
				int key = students[j];
				int k;
				for (k = j - 1; k >= 0 && students[k] > key; k--) {
					students[k+1] = students[k];
					cnt++;
				}
				
				students[k+1] = key;
			}
			
			System.out.printf("%d %d%n", N, cnt);
		}

	}

}