import java.util.*;
import java.awt.*;

class game {
    
    int r;
    int c;
    int cnt;
    
    game(int r, int c, int cnt){
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
    
}

class Solution {
    
    static int[][] maps;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        
        this.maps = maps;
        
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        
        int answer = bfs(0, 0, 1, n, m);
        
        
        return answer;
    }
    
    public int bfs(int r, int c, int cnt, int n, int m){
        
        Queue<game> q = new LinkedList<>();
        q.add(new game(r, c, cnt));
        visited[r][c] = true;
            
        while(!q.isEmpty()){
            
            game curr = q.poll();
            
            if(curr.r == n-1 && curr.c == m-1){
                return curr.cnt;
            }
            
            
            for(int d=0; d<4; d++){
                
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];
                
                if(check(nr, nc, n, m) && !visited[nr][nc] && maps[nr][nc] == 1){
                    q.add(new game(nr, nc, curr.cnt+1));
                    visited[nr][nc] = true;
                }
                
            }
            
        }
        
        return -1;
    }
        
        
    public boolean check(int r, int c, int n, int m){
        return r>=0 && r<n && c>=0 && c<m;
    }    
    
}