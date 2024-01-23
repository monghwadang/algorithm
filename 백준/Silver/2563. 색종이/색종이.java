import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] paper = new int[100][100];
		
	
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int r=x; r<x+10; r++) {
				for(int c=y; c<y+10; c++) {
					paper[r][c] = 1;
				}
			}

		}
		
		int sum = 0;
		
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				sum += paper[r][c];
			}
		}
		
		System.out.println(sum);

		
	}

}