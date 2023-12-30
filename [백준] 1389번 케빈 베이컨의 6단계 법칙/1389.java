import java.util.*;
import java.io.*;

class Main {
    static List<List<Integer>> map;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int minCnt = Integer.MAX_VALUE;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        map = new ArrayList<>();
        for (int i = 0; i < N; i++) 
            map.add(new ArrayList<>());
        
				// 인접 행렬로 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            
            map.get(x).add(y);
            map.get(y).add(x);
        }
        
				// 한 사람씩 bfs 돌면서 케빈 베이컨 수 구함.
        for (int i = 0; i < N; i++) {
            int cnt = bfs(i, N);

						// i번 유저의 케빈 베이컨 수와 현재의 최소 케빈 베이컨 수 비교
						// 만약 i번 유저의 케빈 베이컨 수가 더 작다면 answer을 i번 유저로 갱신
            answer = (minCnt > cnt) ? i + 1 : answer;

						// 최소 케빈 베이컨 수 갱신
            minCnt = Math.min(minCnt, cnt);
        }
        
        System.out.println(answer);
    }
    
    static private int bfs(int user, int N) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(user, 1));
        
        int totalCnt = 0;
        boolean[] visited = new boolean[N];
        visited[user] = true;
        
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int curUser = pair.x;
            int cnt = pair.cnt;
            
            for (int i = 0; i < map.get(curUser).size(); i++) {
                int nextUser = map.get(curUser).get(i);
                
                if (!visited[nextUser]) {
                    visited[nextUser] = true;
										// user의 케빈 베이컨 수를 구하기 위해 nextUser와의 단계 더함.
                    totalCnt += cnt;
                    q.add(new Pair(nextUser, cnt + 1));
                }
            }
        }
        
        return totalCnt;
    }
    
    static private class Pair {
        int x, cnt;    // 유저 번호, 타겟 유저와의 단계
        
        public Pair(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}
