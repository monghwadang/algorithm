import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr1 = new int[] {1, 1, 2, 2, 2, 8};
		int[] arr2 = new int[6];
		int[] arr3 = new int[6];
		
		for(int i=0; i<6; i++) {
			arr2[i]= sc.nextInt();
		}
		
		for(int i=0; i<6; i++) {
			arr3[i]= arr1[i]-arr2[i];
		}
		
		for(int i=0; i<6; i++) {
			System.out.print(arr3[i]+" ");
		}
		
	}

}