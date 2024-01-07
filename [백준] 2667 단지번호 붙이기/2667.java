import java.util.*;
import java.io.*;

class Main {
    static int[][] map;
    static int N;
    static boolean[][] visited;
    static List<Integer> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        Collections.sort(list);
        for (int i : list) bw.write(Integer.toString(i) + "\n");
        
        System.out.println(cnt);
        bw.flush();
        bw.close();
    }
    
    private static void bfs(int a, int b) throws IOException {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a, b));
        int cnt = 1;
        
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
                    if (!visited[xx][yy] && map[xx][yy] == 1) {
                        visited[xx][yy] = true;
                        q.add(new Pair(xx, yy));
                        cnt++;
                    }
                }
            }
        }
        list.add(cnt);
    }
    
    private static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
