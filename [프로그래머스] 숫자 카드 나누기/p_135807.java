import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int length = arrayA.length;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        // 최대공약수 구하기 (3개 이상의 수들의 최대공약수)
        for (int i = 1; i < length; i++) {
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }
        
        if (!canDivide(arrayB, gcdA)) {
            answer = gcdA;
        }
        
        if (!canDivide(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }
        
        return answer;
    }
    
    // a > b
    private int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
    
    private boolean canDivide(int[] array, int gcd) {       
        for (int n : array) {
            if (n % gcd == 0) {
                return true;
            }
        }
        return false;        
    }
}


