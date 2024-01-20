import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int r=0; r<N-1; r++) {
			for(int c=0; c<N-r; c++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("*");
		
		
	}

}