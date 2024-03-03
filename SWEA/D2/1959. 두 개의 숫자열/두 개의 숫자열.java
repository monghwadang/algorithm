import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int TC=1; TC<=T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			int L = 0; // 길이가 긴 배열
			int S = 0; // 길이가 짤은 배열
			int[] arrL;
			int[] arrS;
			
			if(N>=M) {
				L = N;
				S = M;
				arrL = A;
				arrS = B;
			} else {
				L = M;
				S = N;
				arrL = B;
				arrS = A;
			}
			
			int max = Integer.MIN_VALUE;
			for(int i=0; i<=L-S; i++) {
				int sum = 0;
				for(int j=i; j<i+S; j++) {
					sum += arrS[j-i]*arrL[j];
				}
				
				max = Math.max(max, sum);
			}
			
			System.out.printf("#%d %d%n", TC, max);
			
			
			
			
		}
		
		
		
	}

}