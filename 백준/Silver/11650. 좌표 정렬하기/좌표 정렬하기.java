import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class Coordinate {
		int x;
		int y;
		
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Coordinate[] c = new Coordinate[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			c[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		
		Arrays.sort(c, new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate o1, Coordinate o2) {
				if(o1.x == o2.x) {
					return o1.y - o2.y;
				}
				return o1.x - o2.x;
			}
		});
		
		for(Coordinate coor : c) {
			System.out.println(coor.x+" " +coor.y);
		}

	}
	

}
