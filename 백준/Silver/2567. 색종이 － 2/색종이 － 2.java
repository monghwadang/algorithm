import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] paper = new int[102][102];
		
		
		for(int i=0; i<T; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int r=x; r<x+10; r++) {
				for(int c=y; c<y+10; c++) {
					paper[r][c] = 1;
				}
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int l = 0;
		
		for(int r=0; r<102; r++) {
			for(int c=0; c<102; c++) {
				
				if(paper[r][c]==1) {
					
					for(int i=0; i<4; i++) {
						
						int nr = r + dr[i];
						int nc = c + dc[i];
						
						
						if(paper[nr][nc] == 0) {
							l += 1;
						}
						
						
					}
					
					
					
				}
				
			}
		}
		
		System.out.println(l);
		
		
	}

}