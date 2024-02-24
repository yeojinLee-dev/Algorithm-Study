import java.util.*;

class Solution {
    int count = -1;
    boolean[] visited;
    
    public int solution(int x, int y, int n) {
        visited = new boolean[y + 1];
        bfs(x, y, n);
        
        return count;
    }
    
    private void bfs(int a, int y, int n) {
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(a, 0));
        
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            
            int x = pair.x;
            int cnt = pair.cnt;
            
            if (x == y) {
                count = cnt;
                return;
            }
            
            int xx = x + n;
            if (xx <= y && !visited[xx]) {
                q.add(new Pair(xx, cnt + 1));
                visited[xx] = true;
            }
            
            xx = x * 2;
            if (xx <= y && !visited[xx]) {
                q.add(new Pair(xx, cnt + 1));
                visited[xx] = true;
            }
            
            xx = x * 3;
            if (xx <= y && !visited[xx]) {
                q.add(new Pair(xx, cnt + 1));
                visited[xx] = true;
            }
        }
    }
    
    private class Pair {
        int x, cnt;
        public Pair(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
