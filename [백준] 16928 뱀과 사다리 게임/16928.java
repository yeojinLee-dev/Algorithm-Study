import java.util.*;

class Main {
    static int[] game = new int[101];
    static boolean[] visited = new boolean[101];
    static int answer;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        for (int i = 0; i < N + M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            game[x] = y;
        }
        
        bfs();
        System.out.println(answer);        
    }
    
    private static void bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, 0));
        
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            
            int x = pair.x;
            int cnt = pair.cnt;
            
            if (x == 100) {
                answer = cnt;
                break;
            }
            
            for (int i = 1; i < 7; i++) {
                int xx = x + i;
                
                if (xx <= 100) {
                    if (game[xx] != 0) {
                        if (!visited[game[xx]]) {
                            visited[game[xx]] = true;
                            q.add(new Pair(game[xx], cnt + 1));    
                        }
                    } else {
                        if (!visited[xx]) {
                            visited[xx] = true;
                            q.add(new Pair(xx, cnt + 1));    
                        }
                    }        
                }
            }
        }
    }
    
    private static class Pair {
        int x, cnt;
        public Pair(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
