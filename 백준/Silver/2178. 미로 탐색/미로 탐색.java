import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = str.charAt(c)-'0';
			}
		}
		
		visited[0][0]=true;
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
		
		
	}

	private static void bfs(int r, int c) {
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		
		while(!q.isEmpty()) {
			
			Point now = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = now.x + dr[d];
				int nc = now.y + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M && !visited[nr][nc] && map[nr][nc]==1) { 
					// 범위 안에 있고, 방문하지 않았고, 그 값이 1
					
					q.add(new Point(nr,nc));
					map[nr][nc] = map[now.x][now.y]+1;
					visited[nr][nc]=true;

				}
				
				
			}
			
			
		}
		
		
	}
	
	
	
}