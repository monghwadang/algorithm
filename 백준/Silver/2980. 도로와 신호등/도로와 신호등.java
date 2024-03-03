import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int curr = 0; // 현재 위치
		int time = 0; // 전체 시간 계산

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int D = Integer.parseInt(st.nextToken()); // 신호등의 위치
			int R = Integer.parseInt(st.nextToken()); // 빨간색 시간
			int G = Integer.parseInt(st.nextToken()); // 초록색 시간

			time += D - curr;
			curr = D; // 현재 위치가 신호등의 위치
			
			// 얼마나 머물러야 하는지 계산
			if(time % (R+G) < R) time += R - time % (R+G);
		}
		
		time += L - curr; // 마지막 이동
		
		System.out.println(time);

	}

}