import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] card = new int[N];
		
		for(int i = 0; i<N; i++) {
			card[i] = sc.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int size = 0;
		int[] arr = new int[N*N*N];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				for(int k = 0; k<N; k++) {
					
					if((i != j) && (j != k) && (k != i)) {
						sum = card[i] + card[j] + card[k]; 
						size++;
									
						arr[size] = sum;
						
					}

				}
			}
			
		}
		
			 
		for(int n =0; n<N*N*N; n++) {
			if(arr[n]<= M && arr[n] > max) {
				max = arr[n];
			}
			
		}
				
			
			
		System.out.println(max);
		

	}
	
}