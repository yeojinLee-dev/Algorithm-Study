import java.util.*;

class Solution {
    public long solution(long k, long d) {
        long answer = 0;
        
        for (long x = 0; x <= d; x += k) {
            long value = (long)Math.sqrt(d * d - x * x); 
            answer += value / k + 1;
        }

        return answer;
    }
}
