import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int[] s = new int[T];
		
		for(int i=0; i<T; i++) { // 스위치 받기
			s[i] = Integer.parseInt(st1.nextToken());
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			if(a==1) {
				for(int j=b-1; j<s.length; j += b) {
					s[j] = 1 - s[j];
				}
			} else if(a==2){
				
				s[b-1] = 1-s[b-1];
				
				int lft = b-2;
				int rgt = b;
				
				while(lft>=0 && rgt<T && s[lft]==s[rgt]) {
					s[lft]=1-s[lft];
					s[rgt]=1-s[rgt];
					lft--; rgt++;
				}

			}

		}
		
		for(int i=0; i<T; i++) {
			System.out.print(s[i]+" ");
			if((i+1)%20 == 0) {
				System.out.println();
			}
		}
		
		
	}

}