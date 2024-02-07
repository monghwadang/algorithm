import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		Map<Character, Integer> map = new HashMap<>();
		map.put('(', 0);
		map.put('*', 2);
		map.put('/', 2);
		map.put('+', 1);
		map.put('-', 1);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		Stack<Character> stack = new Stack<>();
		String postfix = ""; // 후위 표기식을 담을 문자열 변수 선언

		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);

			if (c == '(') {
				stack.push(c);
			} else if(c>='A'&& c<='Z') { // 피연산자는 postfix에 넣기
				postfix += c;
			} else if (c == ')') {
				while (stack.peek() != '(') {
					postfix += stack.pop();
				}
				stack.pop();
			} else { // 사칙연산
				if(stack.isEmpty()) {
					stack.push(c);
				} else {	
					while(!stack.isEmpty() && map.get(stack.peek()) >= map.get(c)) {
					postfix += stack.pop();
				}
				stack.push(c);
					
				}
			}

		}
		
		while(!stack.isEmpty()) {
			postfix += stack.pop();
		}

		System.out.println(postfix);

	}

}