import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] input = new int[10];
		
		for(int i=0; i<10; i++) {
			input[i] = sc.nextInt() % 42;
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			if(!list.contains(input[i])) {
				list.add(input[i]);
			}
		}
		
		System.out.println(list.size());
		
		
		
		
	}
	

}