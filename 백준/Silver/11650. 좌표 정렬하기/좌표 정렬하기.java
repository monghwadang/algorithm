import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class Site {
		int x;
		int y;
		
		public Site(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Site[] site = new Site[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			site[i] = new Site(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		
		Arrays.sort(site, new Comparator<Site>() {

			@Override
			public int compare(Site o1, Site o2) {
				if(o1.x == o2.x) {
					return o1.y - o2.y;
				}
				return o1.x - o2.x;
			}
		});
		
		for(Site s : site) {
			System.out.println(s.x+" " +s.y);
		}

	}
	

}