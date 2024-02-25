import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] stick = sc.next().split("");

		int cnt = 0;
		int stickCnt = 0;
		for (int i = 0; i < stick.length; i++) {
			if (stick[i].equals("(")) {
				cnt++;
			} else {
				if (stick[i - 1].equals("(")) {
					cnt--;
					stickCnt += cnt;
				} else {
					cnt--;
					stickCnt++;
				}
			}
		}
		
		System.out.println(stickCnt);
	}

}