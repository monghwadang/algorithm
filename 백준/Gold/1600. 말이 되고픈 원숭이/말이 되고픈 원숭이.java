import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Monkey {
    int r, c, knight, cnt;

    public Monkey(int r, int c, int knight, int cnt) {
        this.r = r;
        this.c = c;
        this.knight = knight;
        this.cnt = cnt;
    }
}

public class Main {

    static int K, W, H, res;
    static int[][] travel;
    static boolean[][][] visited;
    static int[] dr = { -1, 1, 0, 0, -2, -1, 1, 2, -2, -1, 1, 2 };
    static int[] dc = { 0, 0, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        travel = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int r = 0; r < H; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < W; c++) {
                travel[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0, 0, 0);
        if (res == Integer.MAX_VALUE)
            res = -1;

        System.out.println(res);

    }

    private static void bfs(int r, int c, int knight, int cnt) {

        Deque<Monkey> dq = new ArrayDeque<>();
        dq.add(new Monkey(r, c, knight, cnt));
        visited[r][c][knight] = true;
        res = Integer.MAX_VALUE;

        while (!dq.isEmpty()) {

            Monkey curr = dq.poll();
            int currR = curr.r;
            int currC = curr.c;
            int currK = curr.knight;
            int currCnt = curr.cnt;

            if (currCnt >= res)
                continue;

            if (currR == H - 1 && currC == W - 1) {
                res = Math.min(res, currCnt);
            }

            // 나이트 이동
            if (currK < K) {
                for (int d = 4; d < dr.length; d++) {
                    int nr = currR + dr[d];
                    int nc = currC + dc[d];

                    if (check(nr, nc) && travel[nr][nc] == 0 && !visited[nr][nc][currK + 1]) {
                        dq.addFirst(new Monkey(nr, nc, currK + 1, currCnt + 1));
                        visited[nr][nc][currK + 1] = true;
                    }
                }
            }

            // 인접하게 이동
            for (int d = 0; d < 4; d++) {
                int nr = currR + dr[d];
                int nc = currC + dc[d];

                if (check(nr, nc) && travel[nr][nc] == 0 && !visited[nr][nc][currK]) {
                    dq.addLast(new Monkey(nr, nc, currK, currCnt + 1));
                    visited[nr][nc][currK] = true;
                }
            }
        }
    }

    private static boolean check(int nr, int nc) {
        return nr >= 0 && nr < H && nc >= 0 && nc < W;
    }
}