import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			
			String str = br.readLine();
			
			if(str.charAt(0)=='1') {
				int num = Integer.parseInt(str.substring(2));
				stack.push(num);
			} else if(str.charAt(0)=='2') {
				sb.append(stack.isEmpty()? -1 : stack.pop()).append('\n');
			} else if(str.charAt(0)=='3') {
				sb.append(stack.size()).append('\n');
			} else if(str.charAt(0)=='4') {
				sb.append(stack.isEmpty()? 1 : 0).append('\n');
			} else if(str.charAt(0)=='5') {
				sb.append(stack.isEmpty()? -1 : stack.peek()).append('\n');
			}

			
		}
		System.out.println(sb);
	}

}