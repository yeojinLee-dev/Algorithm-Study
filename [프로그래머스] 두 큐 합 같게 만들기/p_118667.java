class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        // p1, p2는 각각 queue1, queue2의 첫 번째 인덱스를 가리킴.
        int p1 = 0, p2 = 0;
        long sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        int n = queue1.length;
        // 두 큐의 누적합을 비교해가며 더 큰 누적합을 가진 큐에서 pop연산을 함. 
        while (sum1 != sum2 && p1 < 2 * n && p2 < 2 * n) {
            if (sum1 > sum2) {
                if (p1 < n) {
                    sum1 -= queue1[p1];
                    sum2 += queue1[p1++];     
                } else {
                    sum1 -= queue2[p1 % n];
                    sum2 += queue2[p1++ % n];
                }
                
            } else if (sum1 < sum2) {
                if (p2 < n) {
                    sum2 -= queue2[p2];
                    sum1 += queue2[p2++];        
                } else {
                    sum2 -= queue1[p2 % n];
                    sum1 -= queue1[p2++ % n];
                }
            }
            
            // System.out.println(sum1 + " " + sum2);
            answer++;
        }
        
        if (sum1 != sum2) answer = -1;
        return answer;
    }
}
