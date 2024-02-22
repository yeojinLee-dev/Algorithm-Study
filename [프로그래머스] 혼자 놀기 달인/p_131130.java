import java.util.*;

class Solution {
    int[] parents;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        parents = cards;
        int n = cards.length;
        
        // key : 부모 노드 번호, value : 같은 그룹의 노드 갯수
        Map<Integer, Integer> counts = new HashMap<>();
        
				// cards[i]는 i + 1번 상자에 담긴 카드에 적힌 숫자이므로 0부터 시작되는 배열과 맞춰주기 위해 1 감소
        for (int i = 0; i < n; i++) 
            parents[i]--;
        
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int num = 0;
            
            // i를 방문하지 않았다면 i의 부모 노드를 구하고 map을 이용해 카운트한다.
            if (!visited[i]) {
                num = find(i, visited);
            } else {
                num = parents[i];
            }
            
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        // 그룹이 1개 이하이면 0점
        if (counts.size() < 2) {
            answer = 0;
        } else {
            List<Integer> vals = new ArrayList<>();
            for (int v : counts.values()) {
                vals.add(v);
            }
            
            // 노드 수가 가장 많은 두 그룹의 노드 수를 곱한다.
            vals.sort((o1, o2) -> o2 - o1);
            answer = (vals.get(0) * vals.get(1));
        }
        
        return answer;
    }
    
    int find(int a, boolean[] visited) {
        if (a == parents[a] || visited[a]) {
            return a;
        }
        visited[a] = true;
        
        return parents[a] = find(parents[a], visited);
    }
}
