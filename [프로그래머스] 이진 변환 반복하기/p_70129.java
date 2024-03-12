import java.util.*;
import java.math.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int change = 0, cntZero = 0;
        BigInteger bi = new BigInteger(s);

        while (!s.equals("1")) {
            change++;
            int cnt = s.replace("1", "").length();
            
            cntZero += cnt;
            bi = new BigInteger(Integer.toString(s.length() - cnt));   // 길이
            s = bi.toString(2);
        }
        
        answer[0] = change;
        answer[1] = cntZero;
        
        return answer;
    }
}
