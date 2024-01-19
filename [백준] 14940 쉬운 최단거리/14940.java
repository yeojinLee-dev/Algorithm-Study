import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static int[][] answer;
    static boolean[][] visited;
    static int n, m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        answer = new int[n][m];
        map = new int[n][m];
        visited = new boolean[n][m];
        Pair pair = new Pair(0, 0, 0);
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] == 2) {
                    pair.x = i;
                    pair.y = j;
                }
            }
        }

        bfs(pair);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (answer[i][j] == 0 && map[i][j] == 1)
                    bw.write("-1 ");
                else bw.write(Integer.toString(answer[i][j]) + " ");        
            }
                
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
    }
    
    private static void bfs(Pair p) {
        Queue<Pair> q = new LinkedList<>();
        q.add(p);
        visited[p.x][p.y] = true;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            
            int x = pair.x;
            int y = pair.y;
            int cnt = pair.cnt;
            
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                
                if (xx > -1 && xx < n && yy > -1 && yy < m) {
                    if (!visited[xx][yy] && map[xx][yy] == 1) {
                        visited[xx][yy] = true;
                        answer[xx][yy] = cnt + 1;
                        q.add(new Pair(xx, yy, cnt + 1));
                    }
                }
            }
        }
    }
    
    private static class Pair {
        int x, y, cnt;
        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
