import java.util.*;
import java.io.*;

class Main {
    static List<List<Integer>> input = new ArrayList<>();
    static int[][] map;
    static boolean[] visited;
    static int N; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for (int i = 0; i < N; i++) 
            input.add(new ArrayList<>());
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                
                if (x == 1) {
                    input.get(i).add(j);
                }
            }
        }
				
				// 각 노드를 시작점으로 하고 dfs를 이용해 탐색한다. 
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, i);
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(Integer.toString(map[i][j]) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    
    private static void dfs(int cur, int x) {
        List<Integer> list = input.get(x);
        
        for (int i = 0; i < list.size(); i++) {
            int y = list.get(i);
            
            if (!visited[y]) {
                visited[y] = true;
                map[cur][y] = 1;
                dfs(cur, y);
            }
        }
    }
}
