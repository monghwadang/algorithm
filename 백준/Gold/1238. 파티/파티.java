import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class road implements Comparable<road> {

    int end;
    int value;

    public road(int end, int value) {
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(road o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "road [end=" + end + ", value=" + value + "]";
    }
}

public class Main {

    static int N, M, X;
    static List<road>[] town;
    static int[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        town = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            town[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            town[s].add(new road(e, v));
        }

        int max = Integer.MIN_VALUE;

        // X에서 각 지점으로 가는 최단 거리
        int[] distFromX = dijkstra(X);

        for (int i = 1; i <= N; i++) {
            if (i == X) continue;

            int[] distToX = dijkstra(i);
            max = Math.max(max, distToX[X] + distFromX[i]);
        }

        System.out.println(max);
    }

    private static int[] dijkstra(int start) {

        PriorityQueue<road> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new road(start, 0));

        while (!pq.isEmpty()) {
            road curr = pq.poll();

            if (visited[curr.end]) {
                continue;
            }

            visited[curr.end] = true;

            for (road r : town[curr.end]) {
                if (!visited[r.end] && dist[r.end] > dist[curr.end] + r.value) {
                    dist[r.end] = dist[curr.end] + r.value;
                    pq.add(new road(r.end, dist[r.end]));
                }
            }
        }

        return dist;
    }
}