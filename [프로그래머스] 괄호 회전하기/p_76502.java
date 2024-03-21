import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> q = new LinkedList<>();
        
        for (int i = 0; i < s.length(); i++) 
            q.add(s.charAt(i));
        
        for (int i = 0; i < s.length(); i++) {
            String ss = "";
            
            Iterator iter = q.iterator();
            while(iter.hasNext()) 
                ss += iter.next();
            
            if (checkBracket(ss))
                answer++;

            q.add(q.poll());
        }      
        
        return answer;
    }
    
    private boolean checkBracket(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
                
            if (c == '{' || c == '[' || c == '(') 
                stack.push(c);
            else {
                if (!stack.isEmpty()) {
                    char c2 = stack.pop();
                    
                    if (c == '}' && c2 != '{' ) return false;
                    else if (c == ']' && c2 != '[') return false;
                    else if (c == ')' && c2 != '(') return false;
                    
                } else return false;
            }
        }
        
        if (!stack.isEmpty()) 
            return false;
        else 
            return true;
    }
}


