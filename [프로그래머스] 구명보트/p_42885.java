import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0, cnt = people.length, p = 0;
        boolean[] escape = new boolean[cnt];
        
        Arrays.sort(people);
        
        for (int i = cnt - 1; i > -1 && !escape[i]; i--) {
            int w1 = people[i];
            int w2 = Integer.MAX_VALUE;
            
            for (int j = p; j < i; j++) {
                if (!escape[j]) {
                    w2 = people[j];  
                    p = j;
                    
                    break;
                }
            }
            
            if (w1 + w2 <= limit) {
                escape[i] = true;
                escape[p] = true;
            } else {
                escape[i] = true;
            }
            
            answer++;           
        }
        
        return answer;
    }
}
