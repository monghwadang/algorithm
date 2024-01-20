import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		String[][] arr = new String[2*N-1][2*N];
		
		for(int r=0; r<2*N-1; r++) {
			for(int c=0; c<2*N; c++) {
				arr[r][c] = "*";
			}
		}
		
		for(int r=0; r<N-1; r++) {
			for(int c=r+1; c<2*N-1-r; c++) {
				arr[r][c] = " ";
			}
		}
		
		for(int r=N; r<2*N-1; r++) {
			for(int c=2*N-1-r; c<r+1; c++) {
				arr[r][c]=" ";
			}
		}
		
		for(int r=0; r<2*N-1; r++) {
			for(int c=0; c<2*N; c++) {
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
		
		
	}
	

}