import java.util.*;

class Solution {
    Set<String> visited = new HashSet<>();
    int cnt;
    
    public int solution(String dirs) {
        bfs(0, 0, dirs);
        
        return cnt;
    }
    
    private void bfs(int a, int b, String dirs) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(a, b, -1));
            
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            
            int x = pair.x;
            int y = pair.y;
            int i = pair.i;
            
            if (i == dirs.length() - 1)
                return; 
            
            for (int j = 1; i + j < dirs.length(); j++) {
                int xx = x, yy = y;
                char dir = dirs.charAt(i + j);

                if (dir == 'U') {
                    yy += 1;
                } else if (dir == 'D') {
                    yy -= 1;
                } else if (dir == 'L') {
                    xx -= 1;
                } else if (dir == 'R') {
                    xx += 1;
                }

                if (xx > -6 && xx < 6 && yy > -6 && yy < 6) {
                    String s1 = Integer.toString(x) + " " + Integer.toString(y) + " " + Integer.toString(xx) + " " + Integer.toString(yy);
                    String s2 = Integer.toString(xx) + " " + Integer.toString(yy) + " " + Integer.toString(x) + " " + Integer.toString(y);

                    if (!visited.contains(s1) && !visited.contains(s2)) { 
                        visited.add(s1);
                        visited.add(s2);
                        cnt++;
                    }
                    
                    q.add(new Pair(xx, yy, i + j));   
                    break;
                }
            }
        }
    }
    
    private class Pair {
        int x, y, i;
        public Pair(int x, int y, int i) {
            this.x = x;
            this.y = y;
            this.i = i;
        }
    }
}
