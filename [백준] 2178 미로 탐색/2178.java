import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N][M];
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        
        bfs();
        System.out.println(cnt);
    }
    
    static int N, M, cnt = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;    
    private static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;
            int count = pair.count;
            
            if (x == N - 1 && y == M - 1) {
                cnt = Math.min(cnt, count);
            }
                
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                
                if (xx > -1 && xx < N && yy > -1 && yy < M) {
                    if (!visited[xx][yy] && map[xx][yy] == 1)  {
                        visited[xx][yy] = true;
                        q.add(new Pair(xx, yy, count + 1));
                    }
                }
            }
        }
    }
    
    private static class Pair {
        int x, y;
        int count;
        
        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
