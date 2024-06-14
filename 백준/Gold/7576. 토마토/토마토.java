import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N, res;
	static int[][] tomato;
	static Queue<Point> q;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		tomato = new int[N][M];
		q = new LinkedList<>();
		visited = new boolean[N][M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				tomato[r][c] = Integer.parseInt(st.nextToken());
				if(tomato[r][c]==1) {
					q.add(new Point(r,c));
				}
				
			}
		}
		
		bfs();
		storage();
		System.out.println(res);
	
	}

	private static void storage() {
		
		res = Integer.MIN_VALUE;
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				
				if(tomato[r][c]==0) { // 토마토가 모두 익지는 못하는 상황
					res = -1;
					return;
				}
				
				res = Math.max(res, tomato[r][c]);
			}
		}
		
		if(res==1) { // 모든 토마토가 익어있을 때
			res = 0;
		} else { // 처음 토마토의 상태가 1이므로
			res--;
		}
		
	}

	private static void bfs() {
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			
			int[] dr = {1,-1,0,0};
			int[] dc = {0,0,-1,1};
			
			for(int d=0; d<4; d++) {
				int nr = curr.x + dr[d];
				int nc = curr.y + dc[d];
				
				if(check(nr,nc)) { // 범위 안에 있고 0이면
					tomato[nr][nc] = tomato[curr.x][curr.y] + 1;
					q.add(new Point(nr,nc));
				}
			}
		}
		
	}

	private static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M && tomato[nr][nc]==0;
	}

}