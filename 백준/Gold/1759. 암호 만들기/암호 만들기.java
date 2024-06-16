import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int L, C;
	static char[] alphabet, pw, res;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); // 암호의 길이
		C = Integer.parseInt(st.nextToken()); // 문자의 개수

		alphabet = new char[C];
		pw = new char[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alphabet);

		combi(0, 0);
		System.out.println(sb);

	}

	private static void combi(int idx, int sidx) {

		if (sidx == L) { // 4개의 암호가 완성

			if (check()) {
				sb.append(pw).append('\n');
			}
			return;
		}

		for (int i = idx; i <= C - L + sidx; i++) {
			pw[sidx] = alphabet[i];
			combi(i + 1, sidx + 1);
		}
	}

	private static boolean check() {

		int vCount = 0;
		int cCount = 0;

		for (char c : pw) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vCount++;
			} else {
				cCount++;
			}
		}

		return vCount >= 1 && cCount >= 2;
	}

}