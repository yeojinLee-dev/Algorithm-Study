import java.util.*;
import java.io.*;

class Main {
    static int n;
    static List<Map<Integer, Integer>> graph = new ArrayList<>();
    static int maxNode, maxWeight = 0;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) graph.add(new HashMap<>());
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            
            graph.get(x).put(y, w);
            graph.get(y).put(x, w);
        }
        
        visited = new boolean[n];
        visited[0] = true;
        dfs(0, 0);
        
        visited = new boolean[n];
        visited[maxNode] = true;
        dfs(maxNode, 0);
        
        System.out.println(maxWeight);              
    }
    
    private static void dfs(int n, int w) {       
        Map<Integer, Integer> node = graph.get(n);
        
        if (maxWeight < w) {
            maxNode = n;
            maxWeight = w;
        }
        
        for (int i : node.keySet()) {
            if (!visited[i]) {
                visited[i] = true;
                int ww = w + node.get(i);
                dfs(i, ww);
            }
        }
    }
}
