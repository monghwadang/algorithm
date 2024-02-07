import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class User {
		int age;
		String name;
		
		public User(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		User[] user = new User[N];
		
		for(int r=0; r<user.length; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			user[r] = new User(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(user, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				if(o1.age == o2.age) {
					return 0;
				}
				
				return o1.age - o2.age;
			}
		});
		

		for(int r=0; r<user.length; r++) {
			System.out.println(user[r].age + " " + user[r].name);
		}
	}

}