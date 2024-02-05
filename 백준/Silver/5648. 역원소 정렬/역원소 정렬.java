import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		Long[] sortedArr = new Long[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Long.toString(sc.nextLong());
			sortedArr[i] = reverse(arr[i]);
		}
		
		Arrays.sort(sortedArr);
		
		for(Long c : sortedArr) {
			System.out.println(c);
		}
		
	}
	
	public static Long reverse(String str) {
		
		char[] charArr = str.toCharArray();
		String c = "";
		
		for(int i=0; i<charArr.length/2; i++) {
			
			char tmp = charArr[i];
			charArr[i] = charArr[charArr.length-1-i];
			charArr[charArr.length-1-i] = tmp;

		}

		for(int i=0; i<charArr.length; i++) {
			c += charArr[i];
		}

		return Long.parseLong(c);
		
	}
}