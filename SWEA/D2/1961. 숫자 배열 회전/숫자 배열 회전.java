import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {

			int N = Integer.parseInt(br.readLine());
			int[][] nums = new int[N][N];

			for (int r = 0; r < N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					nums[r][c] = Integer.parseInt(st.nextToken());

				}
			}
			
			System.out.printf("#%d%n", TC);
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					System.out.print(nums[N-1-c][r]);
				}
				System.out.print(" ");
				for(int c=0; c<N; c++) {
					System.out.print(nums[N-1-r][N-1-c]);
				}
				System.out.print(" ");
				for(int c=0; c<N; c++) {
					System.out.print(nums[c][N-1-r]);
				}
				System.out.println();
			}

		}

	}

}