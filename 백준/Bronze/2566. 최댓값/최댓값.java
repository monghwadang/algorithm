import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[9][9];
		
		
		int max = Integer.MIN_VALUE;
		
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				
				arr[r][c] = sc.nextInt();
				
				if(arr[r][c]>max) max = arr[r][c];
				
			}
			
		}
		System.out.println(max);
		
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				if(arr[r][c]==max) {
					System.out.println((r+1) +" "+ (c+1));
					break;
				}
			}
		}
	}

}