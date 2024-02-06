import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        // 1. key : 몸무게, value : 해당 몸무게를 가진 사람의 수
        for (int i = 0; i < weights.length; i++) 
            map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
        
        
        // 2. 최대공약수를 이용해 몸무게 비율을 구한다.
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            long cnt1 = map.get(list.get(i));
            
						// 같은 몸무게를 가진 사람이 1명 이상이면 해당 쌍을 카운트해준다. 
            if (cnt1 > 1) 
                answer += cnt1 * (cnt1 - 1) / 2;
              
            for (int j = i + 1; j < list.size(); j++) {
                long cnt2 = map.get(list.get(j));
                int gcd = gcd(list.get(j), list.get(i));
                
                int x = list.get(i) / gcd;
                int y = list.get(j) / gcd;
                
                if (x == 1 && y == 2) answer += cnt1 * cnt2;
                else if (x == 2 && y == 3) answer += cnt1 * cnt2;
                else if (x == 3 && y == 4) answer += cnt1 * cnt2;
            }
        }
        
        return answer;
    }
    
		// 유클리드 호제법을 이용한 최대공약수 도출
    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
