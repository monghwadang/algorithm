import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String ppl = sc.next();
		
		char[] arr = new char[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = ppl.charAt(i);
		}
		
		int scount = 0;
		int lcount = 0;
		
		for(int i=0; i<N; i++) {
			if(arr[i]=='S') {
				scount++;
			}
			if(arr[i]=='L') {
				lcount++;
			}
		}
		
		if(lcount==0) {
			System.out.println(scount);
		} else {
			System.out.println(scount + lcount / 2 + 1);
		}
		
	}

}