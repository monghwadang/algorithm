import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			
			String[] arrA = br.readLine().split(" ");
			String[] arrB = br.readLine().split(" ");
			
			int[] cntA = new int[4+1];
			int[] cntB = new int[4+1];
			
			for(int j=1; j<arrA.length; j++) {
				cntA[arrA[j].charAt(0)-'0']++;
			}
			
			for(int j=1; j<arrB.length; j++) {
				cntB[arrB[j].charAt(0)-'0']++;
			}
			
			// cnt 배열 비교
			
			String winner = "D"; // 무승부 일 때를 디폴트 값으로 설정
			
			for(int j=4; j>=1; j--) {
				
				if(cntA[j]==cntB[j]) {
					continue;
				} else if(cntA[j] > cntB[j]) {
					winner = "A";
					break;
				} else if (cntA[j] < cntB[j]) {
					winner = "B";
					break;
				}
			}
			
			System.out.println(winner);
			
			
		}
		
		
	}

}