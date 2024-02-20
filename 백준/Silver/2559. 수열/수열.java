import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st1.nextToken());
		int K = Integer.parseInt(st1.nextToken());
		
		int[] arr = new int[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N-K+1; i++) {
			int sum = 0;
			for(int j=i; j<i+K; j++) {
				sum += arr[j];
			}
			if(max<sum) max = sum;
		}
		
		System.out.println(max);
		
		
	}

}