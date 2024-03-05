import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> qq = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			q.add(i);
		}
		
		while(qq.size()!=N){
			
			for(int i=0; i<K-1; i++) {
				q.add(q.poll());				
			}
			qq.add(q.poll());

		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
		while(qq.size()!=1) {
			sb.append(qq.poll()+", ");
		}
		
		sb.append(qq.poll());
		sb.append('>');
		
		System.out.println(sb);
		
	}

}