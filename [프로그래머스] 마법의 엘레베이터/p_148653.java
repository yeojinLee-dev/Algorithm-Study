class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            // 가장 작은 자리수부터 확인
            int digit = storey % 10;
            // storey 갱신 -> 마지막 수 제거
            storey /= 10;
            
            // 만약 현재 자리의 수가 5일 때는 다음 자리수를 확인해야함. 
            if (digit == 5) {
                // 다음 앞자리의 수가 5이상이면 앞자리 수를 1 늘려준다. 
                if (storey % 10 >= 5) {
                    answer += (10 - digit);
                    storey++;
                } else {
                    answer += digit;
                }
            } else if (digit > 5) {
                // 현재 자리수가 5이상이면 10을 만들어주는 게 빠르다. 그리고 다음 앞자리를 1 올려준다. 
                answer += (10 - digit);
                storey++;
            } else {
								// 현재 자리수가 5미만이면 0으로 만들어주는 게 빠르다. 
                answer += digit;
            }
        }
        
        return answer;
    }
}
