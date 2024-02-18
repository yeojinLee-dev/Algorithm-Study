import java.util.*;

class Solution {    
    public int solution(int n, int k) {
        int answer = 0;
        
        // k진수로 변환한다. 
        String binary = change(n, k);
        // 0을 만날 때까지의 수를 구해서 소수인지 판별
        int i = binary.length() - 1;
        while (i >= 0) {
            String sub = "";
            
            while (true) {
                sub += binary.charAt(i--);
                if (i < 0 || binary.charAt(i) == '0') break;
            }
            
            if (!sub.equals("") && isPrime(Long.parseLong(sub))) 
                answer++;       
        }
        
        return answer;
    }
    
    private String change(int num, int k) {
        String result = "";
        
        while (num > 0) {
            int value = num / k;
            result += Integer.toString(num % k);
            num = value;
        }
        return result;
    }
    
    private boolean isPrime(long n){
        if(n <= 1) return false;
        for(long i = 2; i*i <= n; i++)
            if(n % i == 0) return false;
        return true;
    }
}
