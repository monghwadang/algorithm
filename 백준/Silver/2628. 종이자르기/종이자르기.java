import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int[][] paper = new int[M][N];

		int cut = Integer.parseInt(br.readLine());
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		for (int i = 0; i < cut; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			int dir = Integer.parseInt(st2.nextToken());
			int n = Integer.parseInt(st2.nextToken());
			if(dir==0) {
				list1.add(n);
			}else {
				list2.add(n);
			}
		}
		
		if(list1.size()==0) {
			list1.add(M);
		}
		
		if(list2.size()==0) {
			list2.add(N);
		}
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		ArrayList<Integer> p1 = part(list1, M);
		ArrayList<Integer> p2 = part(list2, N);
		
		
		int max = Integer.MIN_VALUE;
		
		for(int a : p1) {
			for(int b : p2) {
				if(max<a*b) max = a*b;
			}
		}
		
		System.out.println(max);
	}

	static ArrayList<Integer> part(ArrayList<Integer> list, int k) {

		ArrayList<Integer> p = new ArrayList<>();
		p.add(list.get(0));
		
		if(list.size()!=1) {
			
			for(int i=1; i<list.size(); i++) {
				p.add(list.get(i)-list.get(i-1));
			}

		}
		
		p.add(k - list.get(list.size()-1));
		
		return p;

	}

}