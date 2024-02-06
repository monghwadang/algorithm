import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {

			String str = br.readLine();
			if(str.equals(".")) break; // 마지막 입력 조건
			Map<Character, Character> map = new HashMap<>();
			map.put(')', '(');
			map.put(']', '[');
			
			Stack<Character> st = new Stack<>(); // stack 통일
			boolean isTrue = true; // 괄호 없으면 true이므로 default가 true
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(c=='(' || c=='[') { // 여는 괄호면 push
					st.push(c);
				} else if(c==')' || c==']'){ // 닫는 괄호일 때
					if(!st.isEmpty() && st.peek() == map.get(c)) { // st이 비어있지 않고 top이 여는 괄호이면 pop
						st.pop();
					} else { // st가 비어있으면 잘못된 것
						isTrue = false;
						break;
					}
				} 
			}
			
			if(isTrue && st.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}

}