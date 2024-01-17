import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char [][] arr = new char[5][15];
		
		
		for(int r=0; r<5; r++) {
			String line = sc.nextLine();
			
			for(int c=0; c<line.length(); c++) {
				
				arr[r][c] = line.charAt(c);
				
			}
		}
		
		for(int c=0; c<15; c++) {
			for(int r=0; r<5; r++) {
				
				if(arr[r][c]=='\0') {
					continue;
				}
				
				System.out.print(arr[r][c]);
				
			}
		}

		
		
	}

}