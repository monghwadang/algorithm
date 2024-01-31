import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int binarySearch(int[] arr, int key) {
		
		int lft = 0;
		int rgt = arr.length-1;
		
		while(lft <= rgt) {
			
			int mid = (lft + rgt) / 2;
			if(arr[mid] == key) {
				return 1;
			} else if(arr[mid] > key) {
				rgt = mid - 1;
			} else if(arr[mid] < key) {
				lft = mid + 1;
			}
		
		}
		
		return 0;

	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<card.length; i++) {
			card[i] = Integer.parseInt(st1.nextToken());
		}
		
		Arrays.sort(card);
		
		int M = Integer.parseInt(br.readLine());
		int[] num = new int[M];
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<num.length; i++) {
			num[i] = Integer.parseInt(st2.nextToken());
		}
		
		for(int i=0; i<num.length; i++) {
			
			int key = num[i];
			int output = binarySearch(card, key);
			
			System.out.print(output+" ");
		}

	}
	
}