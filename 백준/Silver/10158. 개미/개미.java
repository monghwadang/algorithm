import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st1.nextToken());
        int h = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st2.nextToken());
        int q = Integer.parseInt(st2.nextToken());
        int t = Integer.parseInt(br.readLine());

        int a = (p + t) % (2 * w);
        int b = (q + t) % (2 * h);

        p = (a <= w) ? a : 2 * w - a;
        q = (b <= h) ? b : 2 * h - b;

        StringBuilder sb = new StringBuilder();
        sb.append(p).append(' ').append(q);
        System.out.println(sb);
    }
}