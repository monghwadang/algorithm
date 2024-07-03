import java.util.*;

class Solution {
    
    static int[] numbers;
    static int target, res;

    public int solution(int[] numbers, int target) {
        
        this.numbers = numbers;
        this.target = target;

        res = 0;
        dfs(0,0);

        int answer = res;
        return answer;
    }
    
    public void dfs(int idx, int sum){
        
        if(idx==numbers.length){
            if(sum == target){
                res++;
            }
            return;
        }
        
        dfs(idx+1, sum + numbers[idx]);
        dfs(idx+1, sum - numbers[idx]);
        
    }


}
