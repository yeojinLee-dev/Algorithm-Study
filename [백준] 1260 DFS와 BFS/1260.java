import java.util.*;
import java.io.*;

class Main {
    static List<List<Integer>> map;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
    
        map = new ArrayList<>();
        
        for (int i = 0; i < N; i++) 
            map.add(new ArrayList<>());
        
        for (int i = 0; i < M; i++)  {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            map.get(x - 1).add(y - 1);
            map.get(y - 1).add(x - 1);
        }
        
        for (int i = 0; i < N; i++)
            Collections.sort(map.get(i));
        
        visited = new boolean[N];
        dfs(V - 1);
        
        sb.append("\n");
        
        visited = new boolean[N];
        bfs(V - 1);
        
        System.out.println(sb.toString());      
    }
    
    static private void dfs(int curNode) {        
        sb.append(Integer.toString(curNode + 1) + " ");
        visited[curNode] = true;

        for (int i = 0; i < map.get(curNode).size(); i++) {
            int nextNode = map.get(curNode).get(i);
            
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }
    
    static private void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        sb.append(Integer.toString(startNode + 1) + " ");
        visited[startNode] = true;
        
        while(!q.isEmpty()) {
            int curNode = q.poll();

            for (int i = 0; i < map.get(curNode).size(); i++) {
                int nextNode = map.get(curNode).get(i);
                
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    sb.append(Integer.toString(nextNode + 1) + " ");
                    q.add(nextNode);
                }
            }
        }
    }
}
