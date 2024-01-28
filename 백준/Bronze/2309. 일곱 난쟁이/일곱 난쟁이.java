import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Integer> d = new ArrayList<>();
 		int sum = 0;
		
		for(int i=0; i<9; i++) {
			d.add(sc.nextInt());
			sum += d.get(i);
		}
		

		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if((d.get(i)+d.get(j) == sum - 100) && (i > j)) {
					d.remove(i);
					d.remove(j);
					break;
				}
			}
			if(d.size()==7) break;
		}
		
		Collections.sort(d);
		
		for(int i=0; i<7; i++) {
			System.out.println(d.get(i));
		}
		
	}

}