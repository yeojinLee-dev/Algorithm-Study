import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 토핑별 갯수를 map에 저장
        Map<Integer, Integer> right = new HashMap<>();
        for (int i : topping) 
            right.put(i, right.getOrDefault(i, 0) + 1);
        
        // 왼쪽, 오른쪽 롤케이크에 있는 토핑 종류의 갯수를 카운트
        int leftCnt = 0, rightCnt = right.size();
        
        // 왼쪽 롤케이크에 있는 토핑의 종류를 저장하는 map
        Set<Integer> left = new HashSet<>();
        
        // 현재 인덱스를 기준으로 롤케이크를 반으로 나눈다. 0 ~ i-1번째까지가 왼편
        for (int i = 1; i < topping.length; i++) {
            int curTopping = topping[i - 1];
            
            // 만약 왼편 롤케이크에 없던 토핑이면
            if (!left.contains(curTopping)) {
                leftCnt += 1;
                left.add(curTopping);
            }
            
            right.put(curTopping, right.get(curTopping) - 1);
            
            // 오른편에 해당 토핑의 수가 0이 되면 오른편 롤케이크의 토핑 종류의 수를 -1 한다.
            if (right.get(curTopping) < 1) 
                rightCnt -= 1;
            
            if (leftCnt == rightCnt)
                answer += 1;
        }

        return answer;
    }
}
