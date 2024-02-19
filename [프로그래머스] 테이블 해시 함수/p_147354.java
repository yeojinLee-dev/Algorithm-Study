import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = -1;
        
        // o1[col] = data[o1][col]
        Arrays.sort(data, (o1, o2) -> {
            // 값이 동일하면 기본키인 첫 번째 컬럼의 값으로 내림차순
            if (o1[col-1] == o2[col-1]) return o2[0] - o1[0];
            // col번째 컬럼의 값을 기준으로 오름차순
            return o1[col-1] - o2[col-1];
        });
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j] % (i + 1);
            }
            answer = (answer != -1) ? answer^sum : sum;
        }                   
        return answer;
    }
}
