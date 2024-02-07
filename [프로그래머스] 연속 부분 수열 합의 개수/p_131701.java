import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int length = elements.length;
        Set<Integer> set = new HashSet<>();
        
        int window = 1;
        // window는 수열의 길이(1 ~ length)
        while (window <= length) {
            for (int i = 0; i < length; i++) {
                // i부터 j까지의 합을 이중 반복문을 통해 구함(window 사이즈만큼)
                int sum = 0;
                for (int j = i; j < i + window; j++) {
                    // 연속 부분이기 때문에 길이로 모듈라 계산한 인덱스의 값을 더함. 
                    sum += elements[j % length];
                }
                set.add(sum);
            }
            window++;
        }
        
        answer = set.size();
        return answer;
    }
}
