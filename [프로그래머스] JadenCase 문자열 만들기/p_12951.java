import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirst = true;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);    
            
            if (c == ' ') {
                answer += " "; 
                isFirst = true;
            } else {
                if (isFirst) {
                    answer += Character.toString(c).toUpperCase();
                    isFirst = false;
                } else
                    answer += Character.toString(c).toLowerCase();
            }
        }
        
        return answer;
    }
}
