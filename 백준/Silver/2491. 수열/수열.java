import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			
			int cntA = 1;
			

			int j = i;	
			while(j < N - 1) { // 연속해서 커질 때 길이
				if(num[j] > num[j+1]) {
					break;
				}
				j++; 
				cntA++;
			}
			if(cntA > max) max = cntA;
		}
		
		for(int i = 0; i < N; i++) {
			
			int cntD = 1;
			int k = i;
			while(k < N - 1) { // 연속해서 작아질 때 길이
								
				if(num[k] < num[k+1]) {
					break;
				}
				k++;
				cntD++;
			}				
			
			
			if(cntD > max) max = cntD;
			
		}
		
		System.out.println(max);
		
		
	}

}