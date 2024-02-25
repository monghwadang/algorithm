import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Stack<Character> str = new Stack<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) { // 알파벳이나 숫자일 때 stack에 쌓기
				str.push(c);
			}else if(c==' ') { // 공백이면 stack 출력
				while(!str.isEmpty()) {
					sb.append(str.pop());
				}
				sb.append(c);
			}else if(c=='<') {
				if(!str.isEmpty()) {
					while(!str.isEmpty()) {
						sb.append(str.pop());
					}
				}
				sb.append(c);
				while(true) {
					i++;
					if(input.charAt(i)=='>') {
						sb.append(input.charAt(i));
						break;
					}
					sb.append(input.charAt(i));
				}
			}

		}
		
		while(!str.isEmpty()) {
			sb.append(str.pop());
		}
		
		System.out.println(sb);

	}

}