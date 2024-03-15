class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int cntO = 0, cntX = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') 
                    cntO++;
                else if (board[i].charAt(j) == 'X')
                    cntX++;
                    
            }
        }
        
        boolean isSuccessO = false, isSuccessX = false;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) != '.') {
                   if (isSuccess(i, j, board)) {
                       if (board[i].charAt(j) == 'O') isSuccessO = true;
                       else isSuccessX = true;
                   } 
                }
            }
        }
        
        if (isSuccessO && cntO - cntX == 1) answer = 1;
        if (isSuccessX && cntO == cntX) answer = 1;
        if (!isSuccessO && !isSuccessX && (cntO - cntX == 0 || cntO - cntX == 1)) answer = 1;
        if (isSuccessO && isSuccessX) answer = 0;
        
        return answer;
    }
    
    private boolean isSuccess(int x, int y, String[] board) {
        char cur = board[x].charAt(y);
        boolean isSuccess = true;
        
        for (int i = 0; i < 3; i++) {
            if (board[x].charAt(i) != cur) {
                isSuccess = false;
                break;
            }
        }       
        if (isSuccess) return true;
        
        isSuccess = true;
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(y) != cur) {
                isSuccess = false;
                break;
            }
        }
        if (isSuccess) return true;
        
        if (x == y) {
            isSuccess = true;
            for (int i = 0; i < 3; i++) {
                if (board[i].charAt(i) != cur) {
                    isSuccess = false;
                    break;
                }
            }
        }
        if (isSuccess) return true;
        
        if (x + y == 2) {
            isSuccess = true;
            for (int i = 0; i < 3; i++) {
                if (board[i].charAt(2 - i) != cur) {
                    isSuccess = false;
                    break;
                }
            }   
        }
        
        return (isSuccess) ? true : false;
     }
}
