import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] mario = new int[10];
		
		for(int i=0; i<10; i++) {
			
			mario[i] = sc.nextInt();
			
		}
		
		int[] sum = new int[10];
		int[] abs = new int[10];
		sum[0] = mario[0];
		
		for(int i=1; i<10; i++) {
			sum[i] = sum[i-1] + mario[i]; 
		}
		
		int min = Integer.MAX_VALUE;
		int output = 0;
		
		for(int i=9; i>=0; i--) {
			abs[i] = Math.abs(sum[i]-100);
		
			if(min > abs[i]) {
				min = abs[i];
				output = sum[i];
			}
		}
		
		System.out.println(output);
		
		}


}