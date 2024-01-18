import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		while(true) {
			
			String str = br.readLine();
			
			if(str == null) {
				break;
			} else {
				System.out.println(str);
			}
			
		}
		
	}
	
	
}