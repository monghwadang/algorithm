import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static char[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str="";
		while ((str=br.readLine())!=null && !str.isEmpty()) {
			StringBuilder sb = new StringBuilder();

			int N = Integer.parseInt(str);
			arr = new char[(int) Math.pow(3, N)];
			
			for(int i=0; i<arr.length; i++) {
				arr[i] = ' ';
			}

			cantor(0, arr.length-1, arr.length);

			for(int i=0; i<arr.length; i++) {
				sb.append(arr[i]);
			}
		
			System.out.println(sb);
			

		}
		
		br.close();
		

	}

	static void cantor(int first, int last, int range) {

		if (range == 1) {
			arr[first] = '-';
			return;
		}

		int tmp_range = range / 3;

		cantor(first, first + tmp_range-1, tmp_range);
		cantor(last - tmp_range + 1, last, tmp_range);

	}

}