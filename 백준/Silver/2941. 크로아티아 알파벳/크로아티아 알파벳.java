import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		String[] str = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String vocab = br.readLine();
		
		for(int i=0; i<str.length; i++) {
			if(vocab.contains(str[i])) {
				vocab = vocab.replace(str[i], "!");
			}
		}
		
		System.out.println(vocab.length());

	}

}