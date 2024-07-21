import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class frequency implements Comparable<frequency> {

	int n;
	int idx;
	int cnt;

	public frequency(int n, int idx, int cnt) {
		super();
		this.n = n;
		this.idx = idx;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "frequency [n=" + n + ", idx=" + idx + ", cnt=" + cnt + "]";
	}

	@Override
	public int compareTo(frequency o) {

		if (this.cnt == o.cnt) {
			return this.idx - o.idx;
		}
		return o.cnt - this.cnt;
	}

}

public class Main {

	static int N, C;
	static ArrayList<frequency> list;
	static Map<Integer, frequency> map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			msg(Integer.parseInt(st.nextToken()), i);

		}

		list.addAll(map.values());
		Collections.sort(list);
		
		decode();

	}

	private static void msg(int n, int idx) {

		if (map.containsKey(n)) { // n이 이미 등장한 적 있다면
			frequency curr = map.get(n);
			curr.cnt++;

		} else { // n이 새로 등장
			map.put(n, new frequency(n, idx, 1));
		}

	}

	private static void decode() {

		for(frequency f : list) {
			for(int i=0; i<f.cnt; i++) {
				sb.append(f.n + " ");
			}
		}

		System.out.println(sb);

	}
}