import java.util.*;
import java.io.*;

class Main {
    static int M, N, answer, notRipen = 0;
    static int[][] tomato;
    static boolean[][] visited;
    static Queue<Tomato> q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        tomato = new int[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();
        
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                tomato[n][m] = Integer.parseInt(st.nextToken());
                
                if (tomato[n][m] == 0) 
                    notRipen += 1;
                
                if (tomato[n][m] == 1) 
                    q.add(new Tomato(n, m, 0));
            }
        }
        
        bfs();
        System.out.println(notRipen == 0 ? answer : -1);        
    }
    
    private static void bfs() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            Tomato t = q.poll();
            int x = t.x;
            int y = t.y;
            int cnt = t.cnt;
            
            answer = Math.max(answer, cnt);
            
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                
                if (xx > -1 && xx < N && yy > -1 && yy < M) {
                    if (!visited[xx][yy] && tomato[xx][yy] == 0) {
                        visited[xx][yy] = true;
                        q.add(new Tomato(xx, yy, cnt + 1));
                        notRipen -= 1;
                    }
                }
            }
        }
    }
    
    private static class Tomato {
        int x, y, cnt;
        public Tomato(int x, int y, int cnt) {
            this.x = x ;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
