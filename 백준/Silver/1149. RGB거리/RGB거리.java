import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] RGB;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		RGB = new int[N][3];
		visited = new boolean[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < N; i++) {

			RGB[i][0] += Math.min(RGB[i - 1][1], RGB[i - 1][2]);
			RGB[i][1] += Math.min(RGB[i - 1][0], RGB[i - 1][2]);
			RGB[i][2] += Math.min(RGB[i - 1][0], RGB[i - 1][1]);

		}

		int min = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(Math.min(RGB[N - 1][0], RGB[N - 1][1]), RGB[N - 1][2]);
		}
		
		System.out.println(min);

	}

}