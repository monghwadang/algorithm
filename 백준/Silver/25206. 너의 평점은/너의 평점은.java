import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0;
		double totalSum = 0;
		
		for(int i=0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String sub = st.nextToken();
			double module = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			if(!grade.equals("P")) sum += module;
			
			double gradescore = 0;
			
			switch(grade) {
			case("A+"): 
				gradescore = 4.5;
				totalSum += module * gradescore;
				break;
			case("A0"): 
				gradescore = 4.0;
				totalSum += module * gradescore;	
				break;
			case("B+"): 
				gradescore = 3.5;
				totalSum += module * gradescore;	
				break;
			case("B0"): 
				gradescore = 3.0;
				totalSum += module * gradescore;
				break;
			case("C+"): 
				gradescore = 2.5;
				totalSum += module * gradescore;
				break;
			case("C0"): 
				gradescore = 2.0;
				totalSum += module * gradescore;
				break;
			case("D+"): 
				gradescore = 1.5;
				totalSum += module * gradescore;
				break;
			case("D0"): 
				gradescore = 1.0;
				totalSum += module * gradescore;
				break;
			case("F"): 
				gradescore = 0.0;
				totalSum += module * gradescore;
				break;
			}
			
		}
		
		System.out.printf("%.6f", (double)totalSum/sum);

	}
	

}