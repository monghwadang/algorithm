import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num != 0) {
				stack.push(num);
			} else if(num == 0 && stack.size()!=0){
				stack.pop();
			}
		}
		
		int sum = 0;
		for(int c : stack) {
			sum += c;
		}
		
		System.out.print(sum);
		

	}

}