class Solution {
    int cnt0 = 0, cnt1 = 0;
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int size = arr.length;
        
        partition(0, 0, size, arr);
        
        answer[0] = cnt0;
        answer[1] = cnt1;
        
        return answer;
    }
    
    private void partition(int row, int col, int size, int[][] arr) {
        // 만약 모두 같은 수로 되어있으면
        if (check(row, col, size, arr)) {
            if (arr[row][col] == 0) cnt0 += 1;
            else cnt1 += 1;
            
            return;
        }
        
        // 모두 같은 수로 되어있지 않으면
        int newSize = size / 2; 
        int[] dx = {0, 0, newSize, newSize};
        int[] dy = {0, newSize, 0, newSize};
        
        for (int i = 0; i < 4; i++) {
            int rr = row + dx[i];
            int cc = col + dy[i];
            
            partition(rr, cc, newSize, arr);
        }
        
    }
    
    private boolean check(int row, int col, int size, int[][] arr) {
        int cur = arr[row][col];
        
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != cur) return false;
            }
        }
        return true;
    }
}
