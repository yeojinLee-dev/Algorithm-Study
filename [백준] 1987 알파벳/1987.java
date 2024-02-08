import java.util.*;
import java.io.*;

class Main {
    static int R, C, cnt = 0;
    static int[][] map;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = (int)s.charAt(j) - 65;
            }
        }
        visited[map[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(cnt);        
    }
    
    private static void dfs(int x, int y, int count) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        cnt = Math.max(cnt, count);
        
        for (int i = 0; i < 4; i++) {
            int xx = x + dx[i];
            int yy = y + dy[i];
            
            if (xx > -1 && xx < R && yy > -1 && yy < C) {
                int alpha = map[xx][yy];
                if (!visited[alpha]) {
                    visited[alpha] = true;
                    dfs(xx, yy, count + 1);
                    visited[alpha] = false;
                }
            }
        }
    }
}
