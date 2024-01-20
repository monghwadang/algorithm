import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<r; c++) {
				System.out.print(" ");
			}
			for(int c=r; c<2*N-1-r; c++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}