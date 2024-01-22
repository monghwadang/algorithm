import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] arr = new int[N+1];
		arr[1] = 1;
		int cnt = 0;
		int idx = 1;
		
		while(true) {
			
			if(arr[idx] == M) break;
				
			if(arr[idx] % 2 == 1) {
				idx = (idx + L) % N;
				arr[idx] += 1;
				cnt++;
			} else {
				
				if(idx>L) {
					idx = (idx - L) % N;
					arr[idx] += 1;
					cnt++;
					
				} else {
					
					idx = (idx + N - L) % N;
					arr[idx] += 1;
					cnt++;
				}

			}
			
		}
		
		System.out.println(cnt);
		
		
		
	}

}