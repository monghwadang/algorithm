import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Score{
	
	String name;
	int Korean;
	int English;
	int Math;
	
	Score(String name, int Korean, int English, int Math){
		
		this.name = name;
		this.Korean = Korean;
		this.English = English;
		this.Math = Math;
	}
	
}

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Score[] scores = new Score[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			scores[i] = new Score(st.nextToken(),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(scores, new Comparator<Score>() {

			@Override
			public int compare(Score o1, Score o2) {
				
				if(o1.Korean==o2.Korean && o1.English == o2.English && o1.Math == o2.Math) {
					return o1.name.compareTo(o2.name);
				} else if (o1.Korean==o2.Korean && o1.English == o2.English) {
					return o2.Math - o1.Math;
					
				} else if(o1.Korean==o2.Korean) {
					return o1.English-o2.English;
				}
			
				return o2.Korean-o1.Korean;
			}

		});
		
		for(int i=0; i<N; i++) {
			
			System.out.println(scores[i].name);
		}
		
	}
	

}