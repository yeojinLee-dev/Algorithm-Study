import java.util.*;
import java.io.*;

class Main {
    static int N, M, cnt = 0;
    static List<List<Integer>> map = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++)
            map.add(new ArrayList<>());
        
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            
            map.get(x).add(y);
            map.get(y).add(x);
        }
        
        visited = new boolean[N];
        visited[0] = true;

        bfs();
        System.out.println(cnt);        
    }
    
    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while (!q.isEmpty()) {
            int x = q.poll();
            List<Integer> list = map.get(x); 
            
            for (int i = 0; i < list.size(); i++) {
                int y = list.get(i);
                if (!visited[y]) {
                    visited[y] = true;
                    q.add(y);
                    cnt++;
                }
            }
        }
    }
}
