import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int max = Integer.MIN_VALUE;
		List<Integer> maxList = new ArrayList<>();
		
		for (int i = N; i >= 1; i--) {
			List<Integer> list = new ArrayList<>();
			list.add(N); // 인덱스 0
			list.add(i); // 인덱스 1

			int idx = list.size() - 1;
			while (true) {

				int num = list.get(idx-1) - list.get(idx);
				if (num < 0) { // 음의 정수가 만들어지면 종료
					break;
				}
				
				list.add(num); // 양수이면 리스트에 추가
				idx++;

			}
			
			if(max<list.size()) { // 최댓값일 때 그 때의 리스트 갱신
				max = list.size();
				maxList = list;
			}

		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n"); // 최댓값 출력
		for(int c:maxList) {
			sb.append(c+" ");
		}
		System.out.println(sb);

	}

}