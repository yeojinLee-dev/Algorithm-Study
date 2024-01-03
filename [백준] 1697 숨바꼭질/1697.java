import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        
        visited = new boolean[100001];
        bfs();
        System.out.println(answer);
    }
    
    static int N, K, answer = Integer.MAX_VALUE;
    static boolean[] visited;
    
    private static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(N, 0));
        
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int cnt = pair.cnt;
            
            if (x == K) {
                answer = cnt;
                return;
            }
            
            if (isValid(x - 1)) {
                visited[x - 1] = true;
                q.add(new Pair(x - 1, cnt + 1));
            }
            if (isValid(x + 1)) {
                visited[x + 1] = true;
                q.add(new Pair(x + 1, cnt + 1));
            }
            if (isValid(x * 2)) {
                visited[x * 2] = true;
                q.add(new Pair(x * 2, cnt + 1));
            }
        }
    }
    
    private static boolean isValid(int x) {
        if (x < 0 || x > 100000 || visited[x])
            return false;
        else 
            return true;       
    }

    private static class Pair {
        int x, cnt;
        public Pair(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
