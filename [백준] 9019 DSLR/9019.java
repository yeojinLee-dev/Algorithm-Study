import java.util.*;
import java.io.*;

class Main {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            String s = bfs(A, B);            
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
    
    private static String bfs(int A, int B) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(A, ""));
        visited = new boolean[10000];
        visited[A] = true;
        
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            String s = pair.s;
            
            if (x == B) 
                return s;               
            
            int dx, sx, lx, rx;

            dx = (x * 2 <= 9999) ? x * 2 : x * 2 % 10000;
            if (!visited[dx]) {
                q.add(new Pair(dx, s + "D"));
                visited[dx] = true;
            }

            sx = (x != 0) ? x - 1 : 9999;
            if (!visited[sx]) {
                q.add(new Pair(sx, s + "S"));
                visited[sx] = true;
            }
            
            
            int r = x / 1000;
            lx = (x - r * 1000) * 10 + r;
            if (!visited[lx]) {
                q.add(new Pair(lx, s + "L"));
                visited[lx] = true;
            }
            
            r = x % 10;
            rx = (x - r) / 10 + r * 1000;
            if (!visited[rx]) {
                q.add(new Pair(rx, s + "R"));
                visited[rx] = true;
            }
        }

        return "-1";
    }
    
    private static class Pair {
        int x;
        String s;
        
        public Pair(int x, String s) {
            this.x = x;
            this.s = s;
        }
    }
}
