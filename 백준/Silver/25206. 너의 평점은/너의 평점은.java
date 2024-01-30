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
		String gradeList[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
		 double gradeScore[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};
		
		for(int i=0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String sub = st.nextToken();
			double module = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();
			
			if(!grade.equals("P")) sum += module;
			
			for(int j=0; j<gradeList.length; j++) {
				if(grade.equals(gradeList[j])) {
					totalSum += module * gradeScore[j];
				}
			}
			
		}
		
		System.out.printf("%.6f", (double)totalSum/sum);

	}
	

}
