import java.util.*;

class Solution {
    
    static int n;
    static int[][] computers;
    static int[] p;
    
    public int solution(int n, int[][] computers) {
        
        this.n = n;
        this.computers = computers;
        
        p = new int[n];
        
        // make-set
        for(int i=0; i<n; i++){
            p[i] = i;
        }
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                
                if(computers[i][j] == 1){
                    union(i,j);
                }
                
            }
        }
        
        Set<Integer> networkSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            networkSet.add(findset(i));
        }

        int answer = networkSet.size();
        
        return answer;
    }
    
    public int findset(int i){
        
        if(i!=p[i]){
            p[i] = findset(p[i]);
        }
        
        return p[i];
        
    }
    
    public void union(int i, int j){
        if(findset(i) != findset(j)){
            p[findset(j)] = findset(i); 
        }

    }

}