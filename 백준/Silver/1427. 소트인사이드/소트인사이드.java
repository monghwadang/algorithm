import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] num = new int[str.length()];
		int[] output = new int[10];
		
		for(int i=0; i<num.length; i++) {
			num[i] = str.charAt(i)-'0';
			output[num[i]]++;
		}
		
		for(int i=output.length-1; i>=0; i--) {
			for(int j=0; j<output[i]; j++) {
				System.out.print(i);
			}
		}

	}
}