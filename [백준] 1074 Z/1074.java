import java.util.*;

class Main {
    static int N, r, c;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        
        int size = (int)Math.pow(2, N);
        partition(size, 0, 0);
    }
    
    // r행 c열이 포함된 가장 작은 z를 재귀적으로 찾기
    // 현재 사이즈, 시작점(row, col)를 파라미터로 갖는다. 
    static private void partition(int size, int row, int col) {
        int newSize = size / 2;
        int[] dx = {0, 0, newSize, newSize};
        int[] dy = {0, newSize, 0, newSize};
        
        for (int i = 0; i < 4; i++) {
            int rr = row + dx[i];
            int cc = col + dy[i];
            
            // r행 c열이 포함된 z인지 판별
            if (r >= rr && r <= rr + newSize && c >= cc && c <= cc + newSize) {
                // 포함되었다면 가장 작은 z인지 판별
                if (newSize == 1) {
                    // rr행 cc열이 r행 c열과 일치하는지 판별
                    if (rr == r && cc == c) {
                        System.out.println(cnt);
                        return;
                    } 
                    cnt++;
                } else {
                    partition(newSize, rr, cc);
                }
            }
            else cnt += newSize * newSize;
        }
    }
}
