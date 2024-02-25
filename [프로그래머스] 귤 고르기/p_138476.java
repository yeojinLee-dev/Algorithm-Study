import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> Integer.valueOf(map.get(o2)).compareTo(map.get(o1)));
        
        int cnt = 0; 
        for (int i : list) {
            cnt += map.get(i);    
            answer++;
            
            if (cnt >= k) break;
        }
        
        return answer;
    }
}
