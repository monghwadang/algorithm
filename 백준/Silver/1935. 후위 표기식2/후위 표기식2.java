import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        String exp = br.readLine();

	        Stack<Double> st = new Stack<>(); // 실수를 담기 위한 stack

	        Map<Character, Double> values = new HashMap<>(); // 변수에 대응하는 값을 저장할 map

	        for (int i = 0; i < N; i++) {
	            values.put((char) ('A' + i), Double.parseDouble(br.readLine()));
	        }

	        for (int i = 0; i < exp.length(); i++) {
	            char c = exp.charAt(i);

	            if (c >= 'A' && c <= 'Z') {
	                st.push(values.get(c));
	            } else {
	                // 연산자인 경우
	                double b = st.pop();
	                double a = st.pop();

	                switch (c) {
	                    case '+':
	                        st.push(a + b);
	                        break;
	                    case '-':
	                        st.push(a - b);
	                        break;
	                    case '*':
	                        st.push(a * b);
	                        break;
	                    case '/':
	                        st.push(a / b);
	                        break;
	                }
	            }
	        }

	        double output = st.peek();
	        System.out.printf("%.2f", output);
	}

}