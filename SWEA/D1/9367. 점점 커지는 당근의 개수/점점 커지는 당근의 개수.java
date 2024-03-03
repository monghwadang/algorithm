import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int TC=1; TC<=T; TC++) {
			int C = Integer.parseInt(br.readLine());
			int[] carrots = new int[C];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<C; i++) {
				carrots[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 1;
			int max = Integer.MIN_VALUE;
			for(int i=0; i<C-1; i++) {
				if(carrots[i]<carrots[i+1]) {
					cnt++;
				} else {
					if(max<cnt) max = cnt;
					cnt = 1;
				}
			}
			
			if(max<cnt) max = cnt; // 마지막에 한 번 더 확인
			
			System.out.printf("#%d %d%n", TC, max);
		}
		
	}

}