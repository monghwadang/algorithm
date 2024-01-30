import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String vocab = sc.next().toUpperCase();
		
		int[] arr = new int[26];
		
		for(int i=0; i<vocab.length(); i++) {
			
			int num = vocab.charAt(i)-'A';
			arr[num]++;
			
		}
		
		char ch = '?';
		int m = Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > m) {
				m = arr[i];
				ch = (char)(i+65);
			} else if(arr[i] == m) {
				ch = '?';
			}
		}
		
		System.out.println(ch);
		
		
		
	}

}