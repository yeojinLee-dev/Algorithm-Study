import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Vector<String> v = new Vector<>();
        int answer = 0;      
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            
            if (!v.contains(city)) {
                // 만약 벡터의 크기가 캐시 사이즈보다 크면 가장 오래된 값을 삭제한다. 
                if (v.size() >= cacheSize && !v.isEmpty()) 
                    v.remove(0);
                
                if (cacheSize > 0) 
                    v.add(city);
                
                answer += 5;
            } else {
                answer += 1;
                v.remove(city);
                v.add(city);
            }
        }

        return answer;
    }
}
