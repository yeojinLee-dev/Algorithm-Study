import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> q = new PriorityQueue<>();   
        int sum = 0, i = 0;
        
        while (i < enemy.length) {
            if (i < k) {
                q.add(enemy[i]);
            } else {
                if (enemy[i] > q.peek()) {
                    sum = sum + q.poll();
                    q.add(enemy[i]);
                } else {
                    sum = sum + enemy[i];
                } 
            }
            
            if (sum > n) {
                break;
            } else i++;
        }
        
        return i;
    }
}
