import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int N = sc.nextInt();
        
        int[] cake = new int[L+1];
        int[] exp = new int[N+1];
        int[] output = new int[N+1];

        
        for(int i=1; i<=N; i++) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            
            exp[i] = q-p;
            
            for(int j=p; j<=q; j++) {
                if(cake[j]==0) {
                    cake[j]=1;
                    output[i]+=1;
                }
            }
        }
        
        
        int x1 = 0;
        int x2 = 0;
    	int m1 = Integer.MIN_VALUE;
    	int m2 = Integer.MIN_VALUE;
        
        for(int i=1; i<=N; i++) {

            if(exp[i] > m1) {
                m1 = exp[i];
    			x1 = i;
            }
            if(output[i]>m2) {
                m2 = output[i];
                x2 = i;
            }

        }
        
        System.out.println(x1);
        System.out.println(x2);
        

    }

}