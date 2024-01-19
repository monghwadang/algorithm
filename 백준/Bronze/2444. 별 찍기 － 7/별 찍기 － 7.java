import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n-1; i++) {
			for(int r=0; r<n-1-i; r++) {
				System.out.print(" ");
			}
			for(int c=0; c< 2*i+1; c++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		for(int i=0; i<2*n-1; i++) {
			System.out.print("*");
		}
	
		
		for(int i=0; i<n-1; i++) {
			System.out.println();
			for(int r=0; r<i+1; r++) {
				System.out.print(" ");
			}
			for(int c=i+1; c< 2*n-2-i; c++) {
				System.out.print("*");
			}
		
		}
		

		
	}

}