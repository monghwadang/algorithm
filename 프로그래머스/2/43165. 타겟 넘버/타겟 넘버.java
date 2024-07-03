import java.util.*;

class Solution {
    
    static int res;
    static boolean[] visited;
    
    public int solution(int[] numbers, int target) {
        
        int sum = 0; // 숫자 배열의 합
        for(int i=0; i<numbers.length; i++){
            sum += numbers[i];
        }
        
        // 부분집합
        visited = new boolean[numbers.length];
        res = 0;
        powerset(0, numbers, sum, target);
        
        int answer = res;
        return answer;
    }
    
    public void powerset(int idx, int[] numbers, int sum, int target) {
        if(idx>=numbers.length){
            if(sum == target) res++;
            return;
        }
        
        visited[idx] = true;
        powerset(idx+1, numbers, sum  - 2 * numbers[idx], target);
        
        visited[idx] = false;
        powerset(idx+1, numbers, sum, target);
    }
}