import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			if(str.contains("push")) {
				int n = Integer.parseInt(str.substring(5));
				stack.push(n);
			} else if(str.equals("pop")) {
				if(stack.size()!=0) {
					System.out.println(stack.pop());
				} else {
					System.out.println(-1);
				}
			} else if(str.equals("size")) {
				System.out.println(stack.size());
			} else if(str.equals("empty")) {
				if(stack.isEmpty() == true) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if(str.equals("top")) {
				if(stack.size() != 0) {
					System.out.println(stack.peek());
				} else {
					System.out.println(-1);
				}
				
			}
		}
	}

}