import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int TC=1; TC<=T; TC++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 자연수 갯수
			int Q = Integer.parseInt(st.nextToken()); // 시행 횟수
			int[] nums = new int[N+1];
			
			for(int i=1; i<=Q; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				
				for(int j=L; j<=R; j++) {
					nums[j] = i;
				}
				
			}
			
			sb.append("#"+TC+" ");
			
			for(int i=1; i<nums.length; i++) {
				sb.append(nums[i]+" ");
			}
			
			sb.append("\n");
			
			
			
		}
		
		System.out.println(sb);
		
	}

}