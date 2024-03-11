import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int N; // 컴퓨터의 수
    static int pair; // 컴퓨터 쌍의 수
    static int[][] virus;
    static boolean[] visited;
    static int cnt = 0;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());
        virus = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        for(int i=0; i<pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 인접행렬 만들기
            virus[a][b] = virus[b][a] = 1;
            
        }
        
        dfs(1);
        System.out.println(cnt);
        
    }
    
    public static void dfs(int start) {
        
        visited[start] = true;
        
        for(int i=0; i<N+1; i++) {
        	if(!visited[i] && virus[start][i]==1) { // 방문 안 했고 인접행렬의 값이 1이면
        		visited[i] = true; // 방문체크
        		dfs(i);
        		cnt++; // 바이러스 걸림
        	}
        }

        
    }

}