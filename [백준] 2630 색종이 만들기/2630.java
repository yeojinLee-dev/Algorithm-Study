import java.util.*;
import java.io.*;

class Main {
    static int N, wCnt, bCnt;
    static int[][] paper;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int k = 0;
            for (int j = 0; j < N * 2; j+=2) {
                paper[i][k++] = s.charAt(j) - '0';
            }
        }

        partition(0, 0, N);
        System.out.println(wCnt + "\n" + bCnt);
    }
    
    private static void partition(int row, int col, int size) {
        int[] dx = {0, 0, size, size};
        int[] dy = {0, size, 0, size};
        
        for (int i = 0; i < 4; i++) {
            int rr = row + dx[i];
            int cc = col + dy[i];
            
            if (rr < N && cc < N) {
                if (isDiffer(rr, cc, size)) {
                    partition(rr, cc, size / 2);     
                } else { 
                    if (paper[rr][cc] == 0) wCnt += 1;
                    else bCnt += 1;
                }
            }
        }
    }
    
    private static boolean isDiffer(int row, int col, int size) {
        int color = paper[row][col];
        
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != paper[i][j]) 
                    return true;
            }
        }
        return false;
    }
}
