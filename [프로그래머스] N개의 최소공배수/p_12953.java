import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
         
        for (int i = 1; i < arr.length; i++) 
            answer = answer * arr[i] / gcd(Math.max(answer, arr[i]), Math.min(answer, arr[i]));

        return answer;
    }
    
    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
