import java.util.*;

class Solution {
    int[][] ary;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int num = 1;
        
        ary = new int[rows][columns];
        
        // rows * columns 크기의 배열을 만든다. 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                ary[i][j] = num++;
        }
        
        for (int i = 0; i < queries.length; i++) {
            int min = turnAry(queries[i]);
            answer[i] = min;
        }
        
        return answer;
    }
    
    private int turnAry(int[] query) {
        int min = Integer.MAX_VALUE;
        
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        
        // 기존 행렬 테두리의 수를 리스트에 저장하고, 이 과정에서 최솟값을 찾아 저장한다. 
        int pastVal = ary[x1 + 1][y1];                  // 이전 값을 저장한다.       
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        int x = x1, y = y1;
        for (int i = 0; i < 4; i++) {
            // 두 번째 변(첫 번째 변은 윗변)부터는 첫 번째 ary[x][y]가 바로 이전 변의 마지막 값(= 모서리 값) 
						// 즉 중복값이므로 그 다음 값부터 탐색하도록 한다. 
						if (i > 0) {
                x = x + d[i][0];
                y = y + d[i][1];
            }
            
            while (x >= x1 && y >= y1 && x <= x2 && y <= y2) {
                int tmp = ary[x][y];
                ary[x][y] = pastVal;
                pastVal = tmp;
                
                min = Math.min(min, ary[x][y]);
            
                x = x + d[i][0];
                y = y + d[i][1];
            }
						// 범위를 넘어간 값이 되어 while문을 빠져나왔으므로 바로 그 전값으로 되돌려준다. 
            x = x - d[i][0];
            y = y - d[i][1];
        }
        return min;
    }
}
