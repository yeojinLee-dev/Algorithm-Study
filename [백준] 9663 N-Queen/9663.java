import java.util.*;

class Main {
    static int N;
    static int[] board;
    static int cnt = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N];
        
        backTracking(0);
       
        System.out.println(cnt);    
    }
    
		// depth = 현재 탐색 중인 행
    private static void backTracking(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            board[depth] = i;     

						// depth행 i번째 칸에 퀸을 두는 것이 가능한지 확인      
            if (valid(depth))     
                backTracking(depth + 1); // 가능하면 다음 행을 탐색한다.
        }
    }
    
    private static boolean valid(int i) {
        for (int j = 0; j < i; j++) {
						// 0부터 i-1번째 행까지 중 지금 퀸을 두려고 하는 board[i]번째 칸에 이미 퀸이 있는지 여부 확인 (중복된 열인지 확인)
            if (board[i] == board[j]) return false;
						// 두 점 (x1, y1), (x2, y2)가 같은 대각선에 있으면 |x1 - x2| = |y1 - y2|이다. 
            if (Math.abs(i - j) == Math.abs(board[i] - board[j])) return false;
        }
        return true;
    }
}
