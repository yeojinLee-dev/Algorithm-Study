import java.util.*;
import java.io.*;

class Main {
    static int N, M, maxCnt = 0;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                t1(i, j);
                t2(i, j);
                t3(i, j);
                t4(i, j);
                t5(i, j);
            }
        }
        System.out.println(maxCnt);       
    }
    
    // ㅡ
    private static void t1(int x, int y) {
        int[][] dx = {{0, 0, 0, 0}, {0, 1, 2, 3}};
        int[][] dy = {{0, 1, 2, 3}, {0, 0, 0, 0}};
        
        for (int i = 0; i < 2; i++) {
            int cnt = 0;
            boolean isRight = true;
            for (int j = 0; j < 4; j++) {
                int xx = x + dx[i][j];
                int yy = y + dy[i][j];
                
                if (xx < N && yy < M) 
                    cnt += map[xx][yy];
                else {
                    isRight = false;
                    break;
                }
            }
            if (isRight) maxCnt = Math.max(maxCnt, cnt);
        }
    }    
    
    // ㅁ 
    private static void t2(int x, int y) {
        int cnt = 0;
        boolean isRight = true;
        
        int[] dx = {0, 0, 1, 1};
        int[] dy = {0, 1, 0, 1};
        
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            
            if (xx < N && yy < M)
                cnt += map[xx][yy];
            else {
                isRight = false;
                break;
            }
        }
        if (isRight) maxCnt = Math.max(maxCnt, cnt);
    }
    
    // ㄴ 
    private static void t3(int x, int y) {
        int[][] dx = {{0, 1, 2, 2}, {0, 1, 2, 2}, {0, 0, 1, 2}, {0, 0, 1, 2}, {0, 1, 1, 1}, {0, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};
        int[][] dy = {{0, 0, 0, 1}, {0, 0, 0, -1}, {0, -1, -1, -1}, {0, 1, 1, 1}, {0, 0, -1, -2}, {0, 0, 1, 2}, {0, 1, 2, 2}, {0, -1, -2, -2}};
        
        for (int i = 0; i < 8; i++) {
            int cnt = 0;
            boolean isRight = true;
            for (int j = 0; j < 4; j++) {
                int xx = x + dx[i][j];
                int yy = y + dy[i][j];
                
                if (xx < N && xx > -1 && yy < M && yy > -1) 
                    cnt += map[xx][yy];
                else {
                    isRight = false;
                    break;
                }
            }
            if (isRight) maxCnt = Math.max(maxCnt, cnt);
        }
    }
    
    // ㄹ 
    private static void t4(int x, int y) {
        int[][] dx = {{0, 1, 1, 2}, {0, 1, 1, 2}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        int[][] dy = {{0, 0, 1, 1}, {0, 0, -1, -1}, {0, -1, -1, -2}, {0, 1, 1, 2}};
        
        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            boolean isRight = true;
            for (int j = 0; j < 4; j++) {
                int xx = x + dx[i][j];
                int yy = y + dy[i][j];
                
                if (xx < N && xx > -1 && yy < M && yy > -1)  
                    cnt += map[xx][yy];
                else {
                    isRight = false;
                    break;
                }
            }
            if (isRight) maxCnt = Math.max(maxCnt, cnt);
        }
    }
    
    // ㅜ 
    private static void t5(int x, int y) {
        int[][] dx = {{0, 0, -1, 0}, {0, 0, 1, 0}, {0, 1, 1, 2}, {0, 1, 1, 2}};
        int[][] dy = {{0, 1, 1, 2}, {0, 1, 1, 2}, {0, 0, -1, 0}, {0, 0, 1, 0}};
        
        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            boolean isRight = true;
            for (int j = 0; j < 4; j++) {
                int xx = x + dx[i][j];
                int yy = y + dy[i][j];
                
                if (xx < N && xx > -1 && yy < M && yy > -1)   
                    cnt += map[xx][yy];
                else {
                    isRight = false;
                    break;
                }
            }
            if (isRight) maxCnt = Math.max(maxCnt, cnt);
        }
    }
}
