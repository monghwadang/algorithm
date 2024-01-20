import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String[][] arr = new String[N][N];
		
		
		for(int r=0; r<N; r++) {
			for(int c=r; c<N; c++) {
				arr[r][c] = "*";
			}
		}
		
		for(int r=0; r<N-1; r++) {
			for(int c=0; c<N; c++) {
				
				if(arr[r][c] == null) {
					System.out.print(" ");
				} else {
					System.out.print(arr[r][c]);
				}
				
			}
			System.out.println();
		}
		
		for(int c=0; c<N-1; c++) {
			System.out.print(" ");
		}
		System.out.print("*");
		
		
	}

}