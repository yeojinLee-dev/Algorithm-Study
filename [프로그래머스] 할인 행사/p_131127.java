import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();        
        
        // 처음 열흘 간 할인 목록 및 각 제품별 수량
        for (int i = 0; i < 9; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        // 할인 스케줄을 10일씩 확인해보며 원하는 모든 제품의 수량을 만족하는지 확인
        int i = 0; 
        while (i + 9 < discount.length) {
            boolean allExist = true;
            map.put(discount[i + 9], map.getOrDefault(discount[i + 9], 0) + 1);

            for (int j = 0; j < want.length; j++) {
                if (number[j] != map.getOrDefault(want[j], 0)) {
                    allExist = false;
                    break;
                }
            }
            
            if (allExist) answer++;

            map.put(discount[i], map.get(discount[i++]) - 1);
        }
        
        return answer;
    }
}
