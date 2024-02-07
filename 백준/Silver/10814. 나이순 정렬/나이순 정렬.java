import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[][] user = new String[N][2];
		
		for(int r=0; r<user.length; r++) { // 회원에 대한 Nx2 문자열 배열 만들기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<user[r].length; c++) {
				user[r][c] = st.nextToken();

			}
		}
		
		Arrays.sort(user, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0].equals(o2[0])) {
					return 0;
				} else {
					return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]); // 양수이면 swap 음수이면 그대로
				}

			}
		});
		

		for(int r=0; r<user.length; r++) {
			for(int c=0; c<user[r].length; c++) {
				System.out.print(user[r][c] + " ");
			}
			System.out.println();
		}
	}

}