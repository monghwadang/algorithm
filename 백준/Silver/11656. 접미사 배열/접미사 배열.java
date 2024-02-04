import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr = br.readLine().toCharArray();
		String[] charArrSort = new String[charArr.length];
		
		for(int i=0; i<charArrSort.length; i++) {
			String vocab = "";
			for(int j=i; j<charArrSort.length; j++) {
				vocab += String.valueOf(charArr[j]);
			}
			charArrSort[i] = vocab;	
		}
		
		Arrays.sort(charArrSort);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<charArrSort.length; i++) {
			sb.append(charArrSort[i]).append('\n');
		}
		
		System.out.println(sb);

	}
}