import java.util.*;
import java.io.*;

class Main {
    static char[][] map;
    static int N;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        // 적록색약 : 빨간색 = 초록색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        int cnt1 = 0, cnt2 = 0;
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
        }
        
        // 적록색약 아닐 때
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    bfs1(i, j);
                    cnt1 += 1;                    
                }
            }
        }
        
        // 적록색약 일 때
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    bfs2(i, j);
                    cnt2 += 1;                    
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }
    
    private static void bfs1(int a, int b) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a, b));
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0 ,1, -1};
        
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;
            
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                
                if (xx > -1 && xx < N && yy > -1 && yy < N) {
                    if (!visited[xx][yy] && map[xx][yy] == map[a][b]) {
                        visited[xx][yy] = true;
                        q.add(new Pair(xx, yy));
                    }
                }
            }
        }
    }
    
    private static void bfs2(int a, int b) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a, b));
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;
            
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                
                if (xx > -1 && xx < N && yy > -1 && yy < N) {
                    if (!visited[xx][yy]) {
                        if (map[a][b] == map[xx][yy] || (map[a][b] == 'R' && map[xx][yy] == 'G') || (map[a][b] == 'G' && map[xx][yy] == 'R')) {
                            visited[xx][yy] = true;
                            q.add(new Pair(xx, yy));
                        }
                    }
                }
            }
        }
    }

    static private class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
}
