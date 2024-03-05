import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] q = new int[N][3];
		
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<3; c++) {
				q[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] answer = new int[1000]; // 0부터 999까지의 인덱스에서 세자리 수의 인덱스들을 생각

		for(int r=0; r<N; r++) {
			for(int i=100; i<1000; i++) {
				
				int s = strike(q[r][0], i);
				int b = ball(q[r][0], i);
				
				if(s==q[r][1] && b==q[r][2]) answer[i]++; 				
			}
		}
		
		int result = 0;
		
		for(int i=100; i<1000; i++) {
			if(answer[i]==N) {
				
				// 0이 아닌..서로 다른 세 수로 구성되어 있는 경우만 찾기..
				char[] c = new char[3];
				for(int j=0; j<3; j++) {
					c[j] = String.valueOf(i).charAt(j);
				}
				
				if(c[0]!=c[1] && c[1]!=c[2] && c[0]!=c[2] && c[1]!='0' && c[2]!='0') {
					
					result++;
				}
				
				
			}
		}
		
		System.out.println(result);
		
		
	}

	static int strike(int a, int b) {

		char[] aa = new char[3];
		char[] bb = new char[3];

		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			aa[i] = String.valueOf(a).charAt(i);
			bb[i] = String.valueOf(b).charAt(i);

			if (aa[i] == bb[i])
				cnt++;
		}

		return cnt;

	}

	static int ball(int a, int b) {

		char[] aa = new char[3];
		char[] bb = new char[3];

		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			aa[i] = String.valueOf(a).charAt(i);
			bb[i] = String.valueOf(b).charAt(i);
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (i != j && aa[i] == bb[j])
					cnt++;

			}
		}

		return cnt;

	}

}