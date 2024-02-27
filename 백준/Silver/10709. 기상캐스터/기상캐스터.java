import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		char[][] cloud = new char[H][W];

		for (int r = 0; r < cloud.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < cloud[r].length; c++) {
				cloud[r][c] = str.charAt(c);
			}
		}

		int[][] weather = new int[H][W];
		for (int r = 0; r < weather.length; r++) {
			int n = -1;
			for (int c = 0; c < weather[r].length; c++) {
				if (cloud[r][c] == 'c') { // 구름이 떠있었던 경우
					weather[r][c] = 0;
					n=-1;
					++n;
				} else {
					if (n != -1) {
						weather[r][c] = ++n;
					} else {
						weather[r][c] = n;
					}
				}
			}
		}

		for (int r = 0; r < weather.length; r++) {
			for (int c = 0; c < weather[r].length; c++) {
				System.out.print(weather[r][c] + " ");
			}
			System.out.println();
		}

	}

}