import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int a;
	static int b;
	static int c;
	static int d;
	static int min;
	static int[] schedule;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());

			schedule = new int[13];
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= 12; i++) {
				schedule[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			select(1, 0);
			
			sb.append("#"+TC+" "+min+"\n");

		}
		System.out.println(sb);

	}

	private static void select(int idx, int cost) {

		if (idx > 12) {
			if (cost < min)
				min = cost;
			return;
		}
		
		select(idx+12,cost+d);
		select(idx+3,cost+c);
		select(idx+1,cost+b);
		select(idx+1,cost+a * schedule[idx]);

	}

}