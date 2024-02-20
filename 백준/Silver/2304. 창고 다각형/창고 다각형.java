import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] roof = new int[1001];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int highest = Integer.MIN_VALUE;
		int highestC = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			roof[L] = H;
			if(L<min) min = L;
			if(L>max) max = L;
			if(H>highest) {
				highest = H;
				highestC = L;
			}
		}
		
		for(int i=min; i<=highestC-2; i++) {
			if(roof[i]>=roof[i+1]) {
				roof[i+1] = roof[i];
			}
		}
		
		for(int i=max-1; i>=highestC+1; i--) {
			if(roof[i]<=roof[i+1]) {
				roof[i] = roof[i+1];
			}
		}
		
		int sum = 0;
		for(int i=min; i<=max; i++) {
			sum += roof[i];
		}

		System.out.println(sum);
		
	}

}