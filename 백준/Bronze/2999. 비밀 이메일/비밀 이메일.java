import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sang = sc.next();
		int L = sang.length();
		int r = 1;
		int c = 0;
		

		for(int i=L; i>=1; i--) {
			
			if(L % i == 0 && i != L) {
				r = i;
				c = L / r ;
			}
			
			if(r<=c) break;
			
		}
		
		
		char[][] arr = new char[r][c];
		int k = 0;
	
		for(int i=0; i<c; i++) {
			for(int j=0; j<r; j++) {
				arr[j][i] = sang.charAt(k++);
			}
			
		}
			
		
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(arr[i][j]);
			}
		}

	}

}