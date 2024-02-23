import java.io.*;
import java.util.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int N, M, K;
    static boolean[] visited;
    static int[] rail;    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        rail = new int[N];
        visited = new boolean[N];
        
        for (int i = 0; i < N; i++) 
            rail[i] = sc.nextInt();
        
        List<Integer> list = new ArrayList<>();
        dfs(list, 0);
            
        System.out.println(answer);        
    }

    private static void dfs(List<Integer> list, int depth) {
        if (depth == N) {
            int weight = getWeight(list);
            answer = Math.min(weight, answer);

            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(rail[i]);
                
                dfs(list, depth + 1);
                
								visited[i] = false;
                list.remove(list.indexOf(rail[i]));
            }
        }
    }

    private static int getWeight(List<Integer> list) {
        int weight = 0;
        int cnt = 0;    // 시행 횟수
        int curRail = 0;
        
        while (cnt < K) {
            int w = 0;
            
            while (true) {
                w += list.get(curRail);
                
                if (w > M) {
                    w -= list.get(curRail);
                    break;
                } else {
                    curRail++;   
                    
                    if (curRail == N)
                        curRail = 0;
                }
            }
            weight += w;
            cnt++;
        }
        return weight;
    }
}
