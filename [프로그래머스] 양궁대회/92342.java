import java.util.*;

class Solution {
    List<Integer> answer = new ArrayList<>();
    String maxInfo = "";
    int maxDiff = 0;
    
    public List<Integer> solution(int n, int[] info) {
        bfs(n, info);

        if (answer.size() == 0 || maxDiff == 0) 
            answer.add(-1);
        
        return answer;
    }
    
    private void bfs(int n, int[] info) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n, 10, "0"));        // 10 - 10 = 0점부터 탐색, 0점은 아예 쏘지 않음. 
        
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            
            int curN = pair.n;              // 현재 남은 화살 갯수
            int k = pair.k;                 // 현재 탐색 중인 점수 (10 - k점 탐색 중)
            String lionInfo = pair.info;    // 라이언 점수표 (왼쪽부터 0점 ~ 10점)
            
            // 10점까지 탐색했을 때 각자의 점수 확인 후 경우에 따라 answer 갱신
            // 10점까지 탐색했는데 화살이 남을 경우는 0점에 때려넣기
            if (k == 0) { 
                int[] aryLionInfo = new int[11];
                
                for (int i = 10; i > -1; i--) 
                    aryLionInfo[i] = lionInfo.charAt(10 - i) - '0';
                
                if (curN > 0) 
                    aryLionInfo[10] = curN;
                
                int diff = calScore(info, aryLionInfo);
                if (diff >= maxDiff && diff != 0) {     // diff가 0이면 비긴 것이므로 고려하지 않음.               
                    maxInfo = lionInfo;
                    maxDiff = diff;
                    
                    answer.clear();
                    
                    for (int i : aryLionInfo) 
                        answer.add(i);
                }
            }
            
            if (k > 0) {
                // 라이언이 k + 1점을 얻지 않을 경우
                String newLionInfo1 = lionInfo;
                newLionInfo1 += "0";
                q.add(new Pair(curN, k - 1, newLionInfo1));

                // 라이언이 k + 1점을 얻을 경우
                String newLionInfo2 = lionInfo;
                newLionInfo2 += Integer.toString(info[k - 1] + 1);

                int nn = curN - (info[k - 1] + 1);
                if (nn >= 0) q.add(new Pair(nn, k - 1, newLionInfo2));   
            }
        }
    }
    
    private class Pair {
        int n, k;       // 남은 화살 갯수, 0 ~ 10점 중 현재 탐색 중인 점수
        String info;    // 점수표
        
        public Pair(int n, int k, String info) {
            this.n = n;
            this.k = k;
            this.info = info;
        }
    }
    
    // lion 점수 - apeach 점수를 구한다. 
    private int calScore(int[] apeachInfo, int[] lionInfo) {
        int apeach = 0, lion = 0;
                
        for (int i = 0; i < 10; i++) {
            if (apeachInfo[i] == 0 && lionInfo[i] == 0) continue;
            
            if (apeachInfo[i] >= lionInfo[i]) 
                apeach += 10 - i;
            else
                lion += 10 - i;
        }        
        return lion - apeach;
    }
}
