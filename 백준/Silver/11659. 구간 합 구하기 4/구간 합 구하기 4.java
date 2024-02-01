import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int[] num = new int[N];
		int[] prefixSum = new int[N+1];
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st2.nextToken());
			prefixSum[i+1] = prefixSum[i] + num[i];
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st3.nextToken());
			int b = Integer.parseInt(st3.nextToken());
			
			int sum = prefixSum[b] - prefixSum[a-1];
			
			sb.append(sum).append('\n');
		}
		
		System.out.println(sb);
		
	}

}